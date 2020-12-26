(function () {

	// 拦截测试数据
	var _intercept = {
		"sitePubInfo": [
			{				"siteName": "关键词：",				"publishNum": "152"			},
			{				"siteName": "身份证：",				"publishNum": "135"			},
			{				"siteName": "手机：",				"publishNum": "88"			},
			{				"siteName": "银行卡：",				"publishNum": "37"			},
			{				"siteName": "文件URL：",				"publishNum": "75"			},
			{				"siteName": "自定义：",				"publishNum": "119"			}
		]
	};
	
	
	
	// 拦截图表
	function setInterceptChart(_intercept) {
		var data = [], categories = [];
		var temp = _intercept.sitePubInfo;
		temp.reverse();
		for(var index = 0; index < temp.length; index++) {
			var d = temp[index];
			data.push(d.publishNum * 1);
			categories.push(d.siteName);
		}
		console.log(data);
		console.log(categories);
        var option = {
            backgroundColor: "transparent",
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            grid: {
                left: 57,
                top: 48,
                right: 57,
                bottom: 120,
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
                    fontSize: 16,
                    color: "#fff"
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
                            fontSize: 14
                        }
                    },
                    barWidth: 13,
                    barGap: "40%",
                    barCategoryGap: "30%",
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(
                                    0, 0, 1, 0,
                                    [
                                        {offset: 0, color: '#04b7e7'},
                                        {offset: 0.5, color: '#03bc91'},
                                        {offset: 1, color: '#23b58e'}
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
        this.siteEchart = echarts.init(document.getElementById('sjzlzzt'));
        this.siteEchart.setOption(option);
    }

	
	// 调用方法
	$(function(){
		setInterceptChart(_intercept);
	})
	
})();