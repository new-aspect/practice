/**
 * arm.modal
 * @authors Nat Liu (natcube@gmail.com)
 * @date    2015-11-30 09:29:49
 * @version 2015-11-30 09:29:49
 */

;!function($,A) {
	var modalNameSpace = "arm.modal";
	var modalActions = ["close","open","toggle"];
    A._modalBuild = $._modalBuild = function (element, defaults, option, template, plugin, pluginName, method) {

    var $this= element;
    var settings = $.isPlainObject(option) ? option : {};
    var _defaults = defaults || {};
    var isFromTpl = typeof $this === "object"&&$this.selector ? false : true;
    if(/string|number/i.test(typeof option)){
    	settings = {content: option};
    	if(typeof method!=="string"){
    		method = option;
    	}
    }
    var _method = method || _defaults.initMethod || (isFromTpl ? "open" : "close");
   	settings.initMethod = $.inArray(_method, modalActions)!==-1 ? _method : "toggle";
    var template =  template || "";
    settings = $.extend(true, {}, _defaults, settings);
    settings.parent = $(settings.parent || 'body')[0];
    // 来自模板HTML，DOM操作
    if(isFromTpl){
    	$this = $(A.tpl(template).render(settings));
    	if(settings.hooks&&typeof settings.hooks._insertDom === "function"){
    		settings.hooks._insertDom.call($this, settings);
    	}else{
    		$this.appendTo(settings.parent);
    	}
    }
    var object = [];
    $this.each(function (index) {
      var el = $(this);
      // 读取对象缓存
      var data  = el.data(modalNameSpace);
      if (!data){
      	if(!this.id)
      		this.id = A.utils.generateGUID("arm-modal");
        el.data(modalNameSpace, (data = new plugin(this, settings, isFromTpl, pluginName)));
      }else{
        data[settings.initMethod]();
      }
      object[index] = data;
    });
    $this[pluginName] = object;
    return $this;
  }

  // 外部方法
  function _modalMethod(method, ani, speed){
  		if(!this.length)
  			return this;
  		$.each(this, function(index, modal) {
	  		modal[method](ani, speed);
	  	});
	  	return this;
  }

  function _getModal($elem, id){
  	var $el = $($elem);
  	var _this = this;
  	if(!$el.length)
  		return _this;
	$.each($el, function(index, el) {
	  	var modal = $(el).data(modalNameSpace);
	  	if(modal){
	  	  if(id===index||id===el.id){
	  	  	 _this[0] = modal;
	  	  	 _this.length = 1;
	  	  	 _this.index = id;
	  	  	 return false;
	  	  }else{
	  	  	_this[index] = modal;
	  	  	_this.length = index+1;
	  	  }
	  	}
	});
	return _this;
  }
  _getModal.prototype.close = function(ani, speed){
  	return _modalMethod.call(this, "close", ani, speed);
  }
  _getModal.prototype.open = function( ani, speed){
  	return _modalMethod.call(this, "open", ani, speed );
  }
  _getModal.prototype.toggle = function( ani, speed){
  	return _modalMethod.call(this, "toggle", ani, speed );
  }
  A.getModal = function($elem, id){
  	  return new _getModal($elem, id);
  }
  // 初始索引
  A.getModal.openIndex = 19880815;

}(JQUERY, window.arm);

// Modal
;!function($, A){
    // 默认参数
    var defaults = {
        
        durationIn: 200,
        durationOut: 150,
        modalClassName:"ui-modal",
        modalClassTypes:[],
        activeClass: "show",
        animateInClass:"ani-zoomin",
        animateOutClass:"ani-zoomout",
        closeOnConfirm: true,
        closeOnCancel: true,
        closeOnButton: true,
        stayTime:0,
        mask:{},
        closeOnMask:true,
        scrollable: false,
        cssFix:$.noop,
        beforeOpen: $.noop,
        afterClose: $.noop,
        hooks: {
        	_init: $.noop,
        	_insertDom: $.noop
        }
    }
    // 注册默认事件
    var events = ['init','action','cancel','confirm','open','opened','close', 'closed'];
    $.each(events, function(index, _event) {
    	defaults[A.toHump("on "+_event)] = defaults.hooks["_"+_event] = $.noop;
    });

	// 构造函数
    function Modal(el, option, isFromTpl, type) {
        this.option = $.extend(true, {}, defaults, option || {});
        this.target = el;
        this._isFromTpl = isFromTpl;
        this.type = type || "";
        this.modalId = this.target.id;
        this.transitionEnd = A.support.transition&&A.support.transition.end,
        this.active = this.transitioning = 0;
        this._init();
    }

    Modal.prototype={
        _event: function(eventType){
            if($.inArray(eventType, events)!==-1){
                return this.type + ":" + eventType;
            }else{
                return this.type + ":" + events.join(" "+this.type + ":");
            }
        },
        _init:function(){
            var self=this;
            var classes = self.option.modalClassName;
            $.each(self.option.modalClassTypes,function(index, type){
            	className = " " + self.option.modalClassName + "-"+ type;
            	classes += className;
            });
            $(self.target).addClass(classes);
            self.option.cssFix.call(self, self.option);
            var $close = $(self.target).find("[data-modal-close]")
            var $buttons = $(self.target).find('[data-role="button"]');
            var $cancel = $(self.target).find('[data-modal-cancel]');
            var $confirm = $(self.target).find('[data-modal-confirm]');
            // 绑定默认事件
            $.each(events, function(index, _event) {
            	 $(self.target).on(self._event(_event), function(e) {
            	 	self.option.hooks["_"+_event].call(self, e); // 事件钩子
	                self.option[A.toHump("on "+_event)].call(this, e, self);
	            })
            });

            $buttons.tap(function(e){
            	e.preventDefault();
                $(self.target).trigger($.Event(self._event("action"), {relatedTarget: this}), [self]);
                self.option.closeOnButton && self.close();
            });

            $cancel.tap(function(e){
            	e.preventDefault();
                $(self.target).trigger($.Event(self._event("cancel"), {relatedTarget: this}), [self]);
                self.option.closeOnCancel && self.close();
            });
            $confirm.tap(function(e){
            	e.preventDefault();
                $(self.target).trigger($.Event(self._event("confirm"), {relatedTarget: this}), [self]);
                self.option.closeOnConfirm && self.close();
            });

            $close.tap(function(e) {
            	e.preventDefault();
                self.close();
            });
            if(self.option.clickClose){
            	$(self.target).tap(function(e){
            		e.preventDefault();
            		self.close();
            	})
            }
            // 初始化钩子
            $(self.target).trigger($.Event(self._event("init")), [self]);
            self[self.option.initMethod]();
        },
        _complete: function(state){
            var self = this;
            var e = self._event(state==="open" ? "opened" :"closed");
            $(self.target).trigger($.Event(e), [self]);
    		self.transitioning = 0;
    		if(state==="close"){
    			$(self.target).removeClass(self.option.activeClass);
                self._isFromTpl&&$(self.target).remove();
                if(self.mask){
                	self.mask.remove(self.openid);
                	self.mask = false;
                }
                self.option.afterClose.call(self);
    		}else{
    			if(self.option.stayTime>0&&!self.closeTimer){
    				self.closeTimer = setTimeout(function(){
    					self.close();
    				},this.option.stayTime);
    			}
    		}
        },
        toggle: function(ani, speed){
            var self = this;
            if(self.active){
                self.close(ani,speed);
            }else{
                self.open(ani,speed);
            }
        },
        open:function(ani, speed){
            var self = this;
            if(self.active)
                return;
            self.openid = A.getModal.openIndex++;
            self.option.beforeOpen.call(self);
            self.active = true;
            self.transitioning = 1;
            self.target.style[A.utils.prefixStyle('animationDuration')] = "";
            $(self.target).removeClass(A.utils.getClassFn("ani-[\\S]+"));
            if(self.option.mask&&!self.mask)self.mask = A.mask($.extend(true, {
            	zIndex: self.openid
            }, self.option.mask), self.option.parent);
            $(self.target).trigger($.Event(self._event("open")), [self]).css("z-index", A.getModal.openIndex++);
            if(self._isFromTpl&&self.option.parent&&!/body/i.test(self.option.parent.tagName))$(self.target).css("position","absolute");
            if(self.option.closeOnMask&&self.mask){
                self.mask.masklayer.tap(function(e) {
                    e.preventDefault();
                    self.close();
                });
            }
            if(!/ani-[\S]+in/gi.test(ani)){
            	if(typeof ani === "number"&& typeof speed !=="number"){
            		speed = ani;
            	}
            	ani = self.option.animateInClass;
            }
            if(typeof speed!=="number")
            	speed = self.option.durationIn;
            self.target.style[A.utils.prefixStyle('animationDuration')] =  speed + "ms";
            $(self.target).addClass(ani+" "+self.option.activeClass);
            if(self.transitionEnd){
                $(self.target).one(self.transitionEnd, function(){
                	self._complete("open");
                }).emulateTransitionEnd(speed);
            }else{
            	self._complete("open");
            }
        },
        close :function (ani, speed) {
            var self=this;
            if(!self.active)
            	return;
            self.active = false;
            self.transitioning = 1;
            self.target.style[A.utils.prefixStyle('animationDuration')] = "";
            $(self.target).removeClass(A.utils.getClassFn("ani-[\\S]+"));
            $(self.target).trigger($.Event(self._event("close")), [self]);
            if(!/ani-[\S]+out/gi.test(ani)){
            	if(typeof ani === "number"&& typeof speed !=="number"){
            		speed = ani;
            	}
            	ani = self.option.animateOutClass;
            }
            if(typeof speed!=="number")
            	speed = self.option.durationOut;
            self.target.style[A.utils.prefixStyle('animationDuration')] = speed + "ms";
           	$(self.target).addClass(ani);
            if(self.transitionEnd){
                $(self.target).one(self.transitionEnd, function(){
                	self._complete("close");
                }).emulateTransitionEnd(speed);
            }else{
            	self._complete("close");
            }
        }
    }

    // 对外提供扩展方法
    A._modalRegister = function(name, _default, _modalTpl, single){
    	A[name] = $[name] = function(option, method){
    		return A._modalBuild(this, _default, option, _modalTpl, Modal, name, method);
    	}
    	if(!single)
    		A.pt[name] = $.fn[name] = function(option, method){
    			return A._modalBuild(this.$ || this, _default, option, _modalTpl, Modal, name, method);
    		}
    }

    // 默认模板
    var _modalTpl = '<div class="ui-modal ui-page">'+
		            '<div class="ui-modal-cnt">'+
		                '<header class="ui-modal-hd ui-border-b">'+
		                    '<h3 class="ui-modal-title"><%d.title%></h3>'+
		                    '<i class="ui-modal-close" data-modal-close></i>'+
		                '</header>'+
                        '<div class="ui-modal-bd">'+
                            '<div><%d.content%></div>'+
                        '</div>'+
		            '</div>'+ 
		        '</div>';
    var _default = {
        title:"新窗口",
        content:"",
        modalClassName:"ui-page"
    };

    // 注册默认modal
    A._modalRegister("modal", _default, _modalTpl);

}(JQUERY, window.arm);

/**
 * arm.modal.actionsheet
 * @authors Nat Liu (natcube@gmail.com)
 * @date    2015-11-30 09:33:20
 * @version 2015-11-30 09:33:20
 */

;!function($, A){
    // 默认模板
    var _actionsheetTpl= '<div class="ui-actionsheet">'+
                '<div class="ui-actionsheet-cnt">'+
                    '<%# if(d.title){ %>'+
                    '<h4><%d.title%></h4>'+
                    '<%# } %>'+
                    '<%# if(d.buttons&&d.buttons.length){ %>'+
                        '<%# for (var i = 0; i < d.buttons.length; i++) { %>' +
                        '<%# if (i == d.btnSelect) { %>' +
                        '<button type="button" data-role="button" class="select"<%# if(i===d.buttons.length-1){%> data-modal-confirm<%#}%>><%d.buttons[i]%></button>' +
                        '<%# } else { %>' +
                        '<button type="button" data-role="button"<%# if(i===d.buttons.length-1){%> data-modal-confirm<%#}%>><%d.buttons[i]%>' +
                        '<%# } %>' +
                        '<%# } %>' +
                    '<%# } %>'+
                    '<button type="button" data-modal-cancel>取消</button>'+
                '</div>'       
            '</div>';

    // 默认参数
    var _default = {
        title:'您将要做什么操作？',
        buttons:['<span class="ui-txt-red">删除</span>'],
        btnSelect:0,
        modalClassName:"ui-actionsheet",
        animateInClass:"ani-fadeinB",
        animateOutClass:"ani-fadeoutB",
        durationIn:250,
        durationOut:150
    };
    // 注册actionsheet
    A._modalRegister("actionsheet", _default, _actionsheetTpl);
}(JQUERY, window.arm)

/**
 * arm.modal.alert
 * @authors Nat Liu (natcube@gmail.com)
 * @date    2015-11-30 09:31:23
 * @version 2015-11-30 09:31:23
 */

;!function($, A){

	// 默认模板
	var _alertTpl = '<div class="ui-modal">'+
		            '<div class="ui-modal-cnt">'+
                        '<%# if(d.buttons&&d.buttons.length){ %>'+
		                '<div class="ui-modal-ft ui-btn-group ui-border-t">'+
		                    '<%# for (var i = 0; i < d.buttons.length; i++) { %>' +
		                    '<%# if (i == d.btnSelect) { %>' +
		                    '<button type="button" data-role="button" class="select"<%# if(i===d.buttons.length-1){%> data-modal-confirm<%#}%>><%d.buttons[i]%></button>' +
		                    '<%# } else { %>' +
		                    '<button type="button" data-role="button"<%# if(i===d.buttons.length-1){%> data-modal-confirm<%#}%>><%d.buttons[i]%>' +
		                    '<%# } %>' +
		                    '<%# } %>' +
		                '</div>'+
		                '<%# } %>'+   
                        '<div class="ui-modal-bd">'+
                            '<h4><%d.title%></h4>'+
                            '<div><%d.content%></div>'+
                        '</div>'+
		            '</div>'+ 
		        '</div>';

    // 默认参数
    var _default = {
    		modalClassName:"ui-alert",
    		title:"提示",
			content:"Alert",
            buttons:['确定'],
            btnSelect: 0
    };
    // 注册alert
    A._modalRegister("alert", _default, _alertTpl);
}(JQUERY, window.arm)

/**
 * arm.modal.dialog
 * @authors Nat Liu (natcube@gmail.com)
 * @date    2015-11-30 09:30:16
 * @version 2015-11-30 09:30:16
 */
;!function($, A){

    // 默认模板
    var _dialogTpl= '<div class="ui-modal">'+
                    '<div class="ui-modal-cnt">'+
                        '<header class="ui-modal-hd ui-border-b">'+
                            '<h3 class="ui-modal-title"><%d.title%></h3>'+
                            '<i class="ui-modal-close" data-modal-close></i>'+
                        '</header>'+
                        '<%# if(d.buttons&&d.buttons.length){ %>'+
                        '<div class="ui-modal-ft ui-border-t ui-btn-group">'+
                            '<%# for (var i = 0; i < d.buttons.length; i++) { %>' +
                            '<%# if (i == d.btnSelect) { %>' +
                            '<button type="button" data-role="button" class="select"<%# if(i===d.buttons.length-1){%> data-modal-confirm<%#}%>><%d.buttons[i]%></button>' +
                            '<%# } else { %>' +
                            '<button type="button" data-role="button"<%# if(i===d.buttons.length-1){%> data-modal-confirm<%#}%>><%d.buttons[i]%>' +
                            '<%# } %>' +
                            '<%# } %>' +
                        '</div>'+
                        '<%# } %>'+
                        '<div class="ui-modal-bd">'+
                            '<div><%d.content%></div>'+
                        '</div>'+
                    '</div>'+ 
                '</div>';

    // 默认参数
    var _default = {
            modalClassName:"ui-dialog",
            title:"新会话",
            content:"Dialog is a type of Modal.",
            buttons:['取消','确定'],
            btnSelect: 0
    };
    // 注册dialog
    A._modalRegister("dialog", _default, _dialogTpl);
}(JQUERY, window.arm)

/**
 * arm.modal.iframe
 * @authors Nat Liu (natcube@gmail.com)
 * @date    2015-11-30 09:34:09
 * @version 2015-11-30 09:34:09
 */

;!function($, A){
	var _iframeTpl = '<div class="ui-modal">'+
		            '<div class="ui-modal-cnt">'+
		                '<header class="ui-modal-hd ui-border-b">'+
		                    '<h3 class="ui-modal-title"><%d.title%></h3>'+
		                    '<i class="ui-modal-close" data-modal-close></i>'+
		                '</header>'+
                        '<div class="ui-modal-ft ui-btn-group ui-border-t">'+
                             '<button onclick="history.back()"><i class="ui-icon-prev"></i></button>'+
                             '<button data-iframe-action="reload"><i class="ui-icon-refresh"></i></button>'+
                             '<button onclick="history.forward()"><i class="ui-icon-next"></i></button>'+
                        '</div>'+
                        '<div class="ui-modal-bd">'+
                            '<iframe width="100%" height="100%" marginheight="0" marginwidth="0" frameborder="0" scrolling="yes"></iframe>'+
                        '</div>'+
		            '</div>'+ 
		        '</div>';

	function modalIframe($iframe, $reload, src, debug){
		if(!$reload.hasClass('ani-loading')){
			$reload.addClass('ani-loading');
			$iframe.one('load', function(event) {
				$reload.removeClass('ani-loading');
			});
			$iframe[0].src = src;
		}
	}
	var _default = {
		title:"新页面",
		modalClassName:"ui-iframe",
		animateInClass:"ani-fadeinB",
        animateOutClass:"ani-fadeoutB",
        durationIn:150,
        durationOut:100,
        hooks:{
        	_init: function(){
        		var _this = this,
        			$iframe = $("iframe", _this.target),
        			$reload = $('.ui-icon-refresh',_this.target);
        		modalIframe($iframe, $reload, _this.option.content);
        		$("[data-iframe-action]", _this.target).tap(function(){
        			var action = $(this).attr("data-iframe-action");
        			var url = $iframe[0].src;
        			if(action==="reload"){
        				modalIframe($iframe, $reload, url);
        			}
        		});
        	}
        }
	}
	// 注册iframeView
    A._modalRegister("iframe", _default, _iframeTpl);
}(JQUERY, window.arm)

/**
 * arm.modal.loading
 * @authors Nat Liu (natcube@gmail.com)
 * @date    2015-11-30 09:31:54
 * @version 2015-11-30 09:31:54
 */
;!function($, A){

	// 默认模板
	var _loadingTpl = '<div class="ui-loading-block">'+
                '<div class="ui-loading-cnt">'+
                		'<%# if(d.icon){ %>'+
	                    '<i class="<%d.icon%>"></i>'+
	                    '<%# } %>'+
	                    '<%# if(d.content){ %>'+
	                    '<p><%d.content%></p>'+
	                    '<%# } %>'+
                '</div>'+
            '</div>';

    // 默认参数
    var _default = {
    		modalClassName:"ui-modal-loading",
    		animateInClass:"ani-fadein",
			animateOutClass:"ani-fadeout",
			icon: "ui-loading-bright",
			inline: 0,
			afterIcon: 1,
			blank:0,
			content:'',
			hooks:{
				_init:function(){
						var option = this.option;
						if(option.theme)
							$(this.target).addClass('ui-loading-theme-'+option.theme);
						if(option.blank)
							$(this.target).addClass('ui-loading-blank');
						if(!option.afterIcon)
							$("p",this.target).prependTo($(".ui-loading-cnt", this.target));
						if(option.inline)
							$(this.target).addClass('ui-loading-inline');
				}
			}
    };
    // 注册loading
    A._modalRegister("loading", _default, _loadingTpl);
}(JQUERY, window.arm)

/**
 * arm.modal.poptips
 * @authors Nat Liu (natcube@gmail.com)
 * @date    2015-11-30 09:32:51
 * @version 2015-11-30 09:32:51
 */

;!function($, A){

    // 默认模板
    var _poptipsTpl='<div class="ui-poptips">'+
                    '<div class="ui-poptips-cnt">'+
                    '<i></i><%d.content%>'+
                    '</div>'+
                '</div>';

    // 默认参数
    var _default = {
    		content:'提示',
    		mask:false,
    		stayTime:2000,
			durationIn:200,
			durationOut:400,
			modalClassName:"ui-poptips",
			animateInClass:"ani-fadein",
			animateOutClass:"ani-fadeout",
			clickClose:true,
			tipIsColor:false,
            tipIsBlock: false,
			tipNoIcon:true,
			tipLevel:"primary",
			tipPosition: "center",
			hooks:{
				_init: function(){
					var classes = "",self = this, opt = self.option;
					if(opt.tipIsColor)classes += opt.modalClassName+"-color";
					if(opt.tipNoIcon)classes += " " + opt.modalClassName+"-noicon";
					if(opt.tipLevel)classes += " " + opt.modalClassName+"-"+opt.tipLevel;
					if(opt.tipPosition&&!opt.tipIsBlock)classes += " " + opt.modalClassName+"-"+opt.tipPosition;
	                if(opt.tipIsBlock)classes += " " + opt.modalClassName+"-block";
					$(self.target).addClass(classes);
				}
			}
    };

    // 注册poptips
    A._modalRegister("poptips", _default, _poptipsTpl);
}(JQUERY, window.arm)

/**
 * arm.modal.tips
 * @authors Nat Liu (natcube@gmail.com)
 * @date    2015-11-30 09:32:22
 * @version 2015-11-30 09:32:22
 */

;!function($, A){

    // 默认模板
    var _tipsTpl='<div class="ui-tips">'+
                    '<div class="ui-tips-cnt">'+
                    '<i></i><span><%d.content%></span>'+
                    '</div>'+
                '</div>';

    // 默认参数
    var _default = {
    	content:"请稍后...",
    	modalClassName:"ui-tips",
    	iconClass:"ui-icon-info",
    	textClass:"",
    	wrapper:".ui-container",
    	insertType:"html",
    	mask: false,
    	isBlock:false,
    	hooks:{
    		_insertDom: function(option){
	    		option.isBlock&&this.addClass(option.modalClassName+"-block");
	    		this.find("i").addClass(option.iconClass);
	    		this.find("span").addClass(option.textClass);
	    		$(option.wrapper)[option.insertType](this);
	    	}
	    }
    };

    // 注册tips
    A._modalRegister("tips", _default, _tipsTpl);
}(JQUERY, window.arm)