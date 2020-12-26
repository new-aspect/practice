(function () {
	//获取弱密码库最新更新时间
	var _newerstUpdateTime = null;
	$.ajax({
    	url:'api/newerstUpdateTime.rst?_p=YXM9MSZwPTEmbT1OJg__',
    	type:'POST',
    	async: false,
    	success: function(result){
    		_newerstUpdateTime = JSON.parse(result);
    		var updateTime = _newerstUpdateTime.result[0].joinTime;
    		$("#thesaurus_update_time").html(updateTime.substr(0, updateTime.length -2));
    	}
    })
	//获取弱密码top10
	var _intercept = null;
	$.ajax({
    	url:'api/weakPasswordTop10.rst?_p=YXM9MSZwPTEmbT1OJg__',
    	type:'POST',
    	async: false,
    	success: function(result){
    		_intercept = JSON.parse(result);
    	}
    })
	
    //获取最新弱密码
    var _newWeakPasswords = null;
	$.ajax({
    	url:'api/newWeakPasswords.rst?_p=YXM9MSZwPTEmbT1OJg__',
    	type:'POST',
    	async: false,
    	success: function(result){
    		_newWeakPasswords = JSON.parse(result);
            var _html = '';
            $.each(_newWeakPasswords.result, function(index, el){
                _html += '<span class="b0'+ index +'">' + el.weakPassword + '</span>';
                //if(0 != index && index%3 == 2){
                //    _html += '<br/>';
                //}
            });

            $("#tagsList").html(_html);
    	}
    })
	// 拦截测试数据
//	var _intercept = {
//		"sitePubInfo": [
//			{				"siteName": "地域分布",				"publishNum": "1150"			},
//			{				"siteName": "数据库",				"publishNum": "491"			},
//			{				"siteName": "环境",				"publishNum": "289"			},
//			{				"siteName": "可靠",				"publishNum": "150"			},
//			{				"siteName": "体会",				"publishNum": "136"			},
//			{				"siteName": "简介",				"publishNum": "98"			},
//			{				"siteName": "数据库",				"publishNum": "491"			},
//			{				"siteName": "环境",				"publishNum": "289"			},
//			{				"siteName": "可靠",				"publishNum": "150"			},
//			{				"siteName": "体会",				"publishNum": "136"			},
//			{				"siteName": "简介",				"publishNum": "98"			}
//		]
//	};
	
	
	
	// 拦截图表
	function setInterceptChart(_intercept) {
		var data = [], categories = [];
		var temp = _intercept.result;
		temp.reverse();
		for(var index = 0; index < temp.length; index++) {
            $(".rmm #rmm-sites-count").height(temp.length * 45);
			var d = temp[index]; 
			data.push(d.count * 1);
			categories.push(d.weakPassword);
		}
        var option = {
            backgroundColor: "transparent",
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            grid: {
                left: 10,
                top: 20,
                right: 20,
                bottom: 20,
                containLabel: true
            },
            xAxis: {
                type: 'value',
                show: false
            },
            yAxis: {
                type: 'category',
                data: categories,
                boundaryGap: false,
                axisLine: {
                    show: false
                },
                splitLine: {
                    show: false
                },
                axisLabel: {
                    fontSize: 13,
                    color: "#ddd"
                },
                axisTick: {
                    show: false
                }
            },
            series: [
                {
                    type: 'bar',
                    data: data,
                    label: {
                        normal: {
                            show: true,
                            position: "right",
							color: "#ddd",
                            fontSize: 12
                        }
                    },
                    barWidth: 7,
                    barGap: "40%",
                    barCategoryGap: "30%",
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(
                                    0, 0, 1, 0,
                                    [
                                        {offset: 0, color: '#04b7e7'},
                                        {offset: 0.5, color: '#03bc91'},
                                        {offset: 1, color: '#03c13e'}
                                    ]
                            )
                        }
                    }
                }
            ]
        };
		
        if (this.siteEchart) {
            this.siteEchart.dispose();
            option.animation = false;
        }
        this.siteEchart = echarts.init(document.getElementById('rmm-sites-count'));
        this.siteEchart.setOption(option);
    }

	
	// 调用方法
	$(function(){
		setInterceptChart(_intercept);
	})
	
})();