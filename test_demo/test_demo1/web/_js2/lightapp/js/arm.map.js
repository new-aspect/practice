/**
 *
 * @authors Nat Liu (natcube@gmail.com)
 * @date    2015-09-09 10:08:19
 * @version 2015-09-09 10:08:19
 */

;
(function($, A) {
	var config = {
		api: 'http://api.map.baidu.com/',
		v: '2.0',
		ak: A.config('BMapKey') || 'YN79qK7VCGEOBTNzFEX0v5ej',
		paths: {
			map: 'getscript',
			locationIp: 'location/ip',
			staticimage: 'staticimage',
			geoconv: 'geoconv/v1/'
		}
	}

	var _default = {
		coord: '118.783681,31.981661'
	}

	function API(api) {
		return config.api + config.paths[api];
	}

	function pointToCoord(point) {
		if ($.isPlainObject(point))
			return point.x + "," + point.y;
	}

	function coordToPoint(coord) {
		if (/^(\s+)?\d+(\.\d+)?\D+\d+(\.\d+)?(\s+)?$/.test(coord)) {
			var point = $.trim(coord).split(/\D+/);
			return {
				x: Number(point[0]),
				y: Number(point[1])
			}
		}
	}

	var BMapAPI = API('map') + "?v=" + config.v + "&ak=" + config.ak;



	var Map = {
		version: config.v,
		api: "baidu",
		pointToCoord: pointToCoord,
		coordToPoint: coordToPoint
	}

	Map.geoconv = function(args, success, error) {
		if (typeof args === "string") {
			args = {
				coords: args
			};
		}
		args = $.extend(true, {
			ak: config.ak,
			from: 1,
			to: 5
		}, args);
		success = $.isFunction(success) ? success : $.noop;
		error = $.isFunction(error) ? error : $.noop;
		$.ajax({
			url: API('geoconv'),
			dataType: 'jsonp',
			data: args,
			success: function(response) {
				if (response.status) {
					error(response);
				} else {
					success(response);
				}
			},
			error: function(xhr, errorType, err) {
				error({
					status: errorType,
					error: err
				});
			}
		});
	}

	Map.getCoord = function(point, success, error) {

		if ($.isPlainObject(point)) {
			var args = {
				coords: pointToCoord(point),
				from: point.type
			}
		}
		success = $.isFunction(success) ? success : $.noop;
		error = $.isFunction(error) ? error : $.noop;
		if (args && args.type === 5) {
			return success(coordToPoint(args.coords));
		}
		Map.geoconv(args, function(data) {
			success(data.result[0]);
		}, error);
	}

	Map.getLocationByIp = function(ip, success, error) {
		if ($.isFunction(ip)) {
			error = success;
			success = ip;
			ip = "";
		}
		var options = {
			ak: config.ak,
			coor: 'bd09ll',
			ip: ip
		};
		success = $.isFunction(success) ? success : $.noop;
		error = $.isFunction(error) ? error : $.noop;
		$.ajax({
			url: API('locationIp'),
			dataType: 'jsonp',
			data: options,
			success: function(response) {
				if (response.status) {
					error(response);
				} else {
					success(response);
				}
			},
			error: function(xhr, errorType, error) {
				error({
					status: errorType,
					error: error
				});
			}
		});
	}

	Map.getPosition = function(success, error, args) {
		success = $.isFunction(success) ? success : $.noop;
		error = $.isFunction(error) ? error : $.noop;
		args = $.extend(true, {
			enableHighAccuracy: true,
			timeout: 20000
		}, args);
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				position.content = {
					point: {
						x: position.coords.longitude,
						y: position.coords.latitude,
						type: 1
					}
				}
				success(position);
			}, error, args);
		} else {
			getLocationByIp(success, error);
		}
	}

	Map.staticimage = function(args, single) {
		if (args === true)
			single = true;
		args = $.extend(true, {
			zoom: 17,
			scale: 2,
			width: 400,
			height: 300,
			copyright: 1,
			center: _default.coord
		}, args);
		if (pointToCoord(args.center))
			args.center = pointToCoord(args.center);
		this.src = API('staticimage') + "?" + $.param(args);
		return single ? this.src : '<img width="' + args.width + '" height="' + args.height + '" src="' + this.src + '">';
	}

	Map.staticimage.prototype.creatTo = function(selector) {
		var $img = $('<img src="' + this.src + '">');
		$(selector).html($img);
		return $img;
	}

	Map.creatMap = function(element, args) {
		A.use([BMapAPI], function() {
			$element = $(element);
			if (!$element.length || !$element[0].nodeType)
				return A.console().warn('dom is needed to creat a map!');

			var elem = $element[0];
			$(elem).addClass('ui-map-holder');
			if (typeof args === "string")
				args = {
					center: args
				};
			var options = $.extend(true, {
				center: _default.coord,
				mapOptions: {
					enableHighResolution: true
				},
				navigationControl: true,
				geolocationControl: true,
				locationSuccess: $.noop,
				locationError: $.noop,
				onCreated: $.noop,
				mapTypeControl: false
			}, args);
			var map = {};
			map.Map = new BMap.Map(elem, options.mapOptions);
			map.Map.addEventListener("tilesloaded", options.onRender);
			map.Point = options.center;
			if (pointToCoord(options.center)) {
				map.Point = new BMap.Point(options.center.x, options.center.y);
			}
			map.Zoom = options.zoom;
			map.Map.centerAndZoom(map.Point, map.Zoom);

			// 添加带有定位的导航控件
			if (options.navigationControl) {
				map.navigationControl = new BMap.NavigationControl($.extend(true, {
					// 靠右上角位置
					anchor: BMAP_ANCHOR_TOP_RIGHT,
					// SMALL类型
					type: BMAP_NAVIGATION_CONTROL_SMALL
				}, options.navigationControl));
				map.Map.addControl(map.navigationControl);
			}
			if (options.geolocationControl) {
				map.geolocationControl = new BMap.GeolocationControl($.extend(true, {}, options.geolocationControl));
				map.geolocationControl.addEventListener("locationSuccess", function(e) {
					options.locationSuccess.call(map, e);
				});
				map.geolocationControl.addEventListener("locationError", function(e) {
					options.locationError.call(map, e);
				});
				map.Map.addControl(map.geolocationControl);
			}

			if (options.mapTypeControl) {
				map.mapTypeControl = new BMap.MapTypeControl($.extend(true, {
					// 靠左上角位置
					anchor: BMAP_ANCHOR_TOP_LEFT,
					mapTypes: [BMAP_NORMAL_MAP, BMAP_SATELLITE_MAP, BMAP_HYBRID_MAP]
				}, options.mapTypeControl));
				map.Map.addControl(map.mapTypeControl);
			}
			options.onCreated.call(map);
			return map;
		})
	}

	A.map = Map;

})(JQUERY, window.arm)
