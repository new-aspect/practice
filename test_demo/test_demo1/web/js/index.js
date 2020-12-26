(function () {

	// 拦截测试数据
	var _intercept = {
		"sitePubInfo": [
			{				"siteName": "地域分布",				"publishNum": "1150"			},
			{				"siteName": "数据库",				"publishNum": "491"			},
			{				"siteName": "环境",				"publishNum": "289"			},
			{				"siteName": "可靠",				"publishNum": "150"			},
			{				"siteName": "体会",				"publishNum": "136"			},
			{				"siteName": "简介",				"publishNum": "98"			},
			{				"siteName": "数据库",				"publishNum": "491"			},
			{				"siteName": "环境",				"publishNum": "289"			},
			{				"siteName": "可靠",				"publishNum": "150"			},
			{				"siteName": "体会",				"publishNum": "136"			},
			{				"siteName": "简介",				"publishNum": "98"			}
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