(function () {
	
	// 性能测试数据
	var _performance =  {
		"disk": "7",
		"performance": 7,
		"memory": "14",
		"netWork": 66
	};

	
	// 已占空间图表
	function setMemoryChart(_performance) {
        var memoryVal =  _performance.memory;
        var memoryData = [
            {value: memoryVal, name: '已占空间'}
        ];

        var memoryOption = {
            tooltip: {
                formatter: "{a} <br/>{b} : {c}%"
            },
            grid: {
                left: 0,
                top: 0,
                right: 0,
                bottom: 0,
                containLabel: true
            },
            backgroundColor: "transparent",
            series: [
                {
                    name: '当前指数',
                    type: 'gauge',
                    radius: "85%",
                    detail: {
                        formatter: '{value}GB',
                        color: "#ffffff",
						fontWeight: "bold",
                        fontSize: 23,
						offsetCenter: ['0', '-10%']
                    },
                    title: {
                        color: "#ffffff",
                        fontSize: 15,
                        offsetCenter: ['0', '13%']
                    },
                    axisLine: {
                        lineStyle: {
                            width: 20,
                            color: [
                                [memoryVal / 100, "#0cc3ed"], [1, "#62859d"]
                            ]
                        }
                    },
                    splitLine: {
                        show: false
                    },
                    axisLabel: {
                        show: false
                    },
                    axisTick: {
                        show: false
                    },
                    pointer: {
                        show: false
                    },
                    data: memoryData
                }
            ]
        };

        if (this.memoryChart) {
            this.memoryChart.dispose();
        }
        this.memoryChart = echarts.init(document.getElementById('backupCenter-tjh-room'));
        this.memoryChart.setOption(memoryOption);
    }
	
	
	
	//备份详情数据
//	var _detailData = [{"Status": 0, "CheckTime": "2020-04-13-172455", "Size": 0.1},{"Status": 0, "CheckTime": "2020-04-13-172455", "Size": 0.1},{"Status": 0, "CheckTime": "2020-04-13-172455", "Size": 0.1}]
	
	
	
	
	//备份详情
	function setBarChart(_detailData) {
//		var _dateData=_detailData.CheckTime;
//		var _roomDate=_detailData.Size;
		var _rightRoom=[],_errRoom=[],_dateData=[];
		for(var i=0;i<_detailData.length;i++)
		{
			if(_detailData[i].Status == 1){
				_dateData.push('' + _detailData[i].CheckTime);
				_rightRoom.push(''+_detailData[i].Size);
				_errRoom.push('-');
			}else{
				_dateData.push('' + _detailData[i].CheckTime);
				_errRoom.push(''+_detailData[i].Size);
				_rightRoom.push('-');
			}
		}
		
	    var	option = {
            textStyle:
            {
                fontSize:'15',
                color:'#fff',
                lineHeight:'36',
                align:'center',
            },
            backgroundColor: "transparent",
            color:['#2ea4ca','#ed7c50'],
            
            xAxis: {
                type: 'category',
                data: _dateData,
                
                axisLine:
                {
                    show : true,
                    onZero:false,
                    lineStyle:
                    {
                        color:'#779dc4',
                    }
                },
                axisTick :
                {
                    show:false,
                }
                
            },
            grid: 
            {
                left: 20,
                top: 50,
                right: 20,
                bottom: 10,
                containLabel: true
            },
            yAxis: {
                type: 'value',
                scale:false,
                splitLine:false,
                axisLabel:false,
                axisLine:
                {
                    show : false,
                    onZero:false,
                },
                axisTick :
                {
                    show:false,
                }
            },
            series: [
            {
                name: '正常',
                stack: '总量',
                data: _rightRoom,
                type: 'bar',
				avoidLabelOverlap: false,
                barWidth :_detailData.length * 10 + '%',
                legendHoverLink :false,
                label:
                {   
                    show: true,
                    position: 'top',
                    distance: '10',
                    formatter: '{c}G\n{a}',
                    fontSize:'18',
                    color:'#009eaa'
                },
                
            },
            {
                name: '异常',
                stack: '总量',
                type: 'bar',
				avoidLabelOverlap: false,
                label: {
                    show: true,
                    position: 'top',
                    distance: '10',
                    formatter: '{c}G\n{a}',
                    fontSize:'18',
                    color:'#ed7c50',
                }, 
                data: _errRoom
            }]
        };

		
        if (this.detailChart) {
            this.detailChart.dispose();
        }
        this.detailChart = echarts.init(document.getElementById('backupCenter-bfxq-detail'));
        this.detailChart.setOption(option);


	}

	function loadDate(backupMode){
		$.ajax({
            url: 'api/backupList.rst?_p=YXM9MSZwPTEmbT1OJg__',
            type: 'POST',
            data:{"backupMode":backupMode},
            success: function(result) {
            	result = JSON.parse(result);
            	if (result.errMsg == "success") {
                	setBarChart(result.result.data);
                	setMemoryChart(result.result);
                	loadOperate(result.result.data);
                } else {
                	$.messager.alert("提示", result.errMsg, "warning");
                }
            }
        });
	}
	
	function loadOperate(data){
		var html = "";
		var totalWidth = $("#backdetail").width();
		for(var i=0;i<data.length;i++)
		{
			var width = parseInt((totalWidth - (data.length * 180)) / (data.length * 2));
			html += "<div style='float:left;margin-left:"+ width +"px;margin-right:" + width + "px;'>";
			html += "<a href='javascript:void(0);' class='l-btn-small border-radius' >还原</a>";
			html += "<a href='javascript:void(0);' class='l-btn-small border-radius' onclick='downloadbackup(\"" + data[i].CheckTime + "\");'>下载</a>";
			html += "<a href='javascript:void(0);' class='l-btn-small border-radius' onclick='del(\"" + data[i].CheckTime + "\");'>删除</a>";
			html += "</div>";
		}
		$("#backdetail").html(html);
	}
	
	// 调用方法
	$(function(){
//		setMemoryChart(_performance);
		loadDate("");
		//setBarChart(_detailData);
		//loadOperate(_detailData);
	})
	
	
	
})();