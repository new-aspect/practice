;(function($){

	var defaults = {
		buttons:[],
		maxBtns:2,
		moreButtonsText:"...."
	};

	$.tableButtons = function(element, options){
		var options = $.extend(true, {}, defaults, options);
		
		var actBtns = options.buttons;
		if( actBtns.length > options.maxBtns ){
			actBtns.splice(options.maxBtns-1, 0, {
				text: options.moreButtonsText,
				type:"more"
			});
		}
		var $btngroup = $('<div class="table-buttons-group dropdown"></div>');
		for (var i = 0; i < actBtns.length; i++) {
			var btn = actBtns[i], type = btn.type || "normal";
			if(i < options.maxBtns){
				var $btn = $('<a>'+btn.text+'</a>');
				$btn.addClass('btn');
				$btn.toggleClass('btn-danger', type == "delete");
				$btn.toggleClass('btn-more dropdown-toggle', type == "more");
				if(type=="more"){
					$btn.attr('data-toggle', "dropdown");
				}
				$btn.toggleClass('btn-default', !type || type!=="delete");
				$btn.addClass('btn-xs');
			}else{
				var $btn = $('<li class="table-buttons-menu"><a>'+btn.text+'</a></li>');
			}
			if(/modify|delete/i.test(type) && options.actionId!==undefined ){
				$btn.attr("data-"+type, options.actionId);
			}
			$btn.attr('data-buttontype', type);
			$btn.addClass('table-button-'+type);
			$btngroup.append($btn);
			typeof btn.onRender === "function" && btn.onRender($btn, i);
		}

		$('.table-buttons-menu', $btngroup).wrapAll('<ul class="table-buttons-menu-wrapper dropdown-menu"></ul>');
		//$('.dropdown-toggle', $btngroup).dropdown();
		$(element).html($btngroup).addClass('table-buttons');
		$(".table-button-delete", $btngroup).appendTo('.table-buttons-menu-wrapper', $btngroup);
		$(".table-button-delete", $btngroup).before('<li role="separator" class="divider"></li>');
		typeof options.callback === "function" && options.callback.call(element, $btngroup);
		return element;
	}

	$.fn.tableButtons = function(options){
		var opt = $.extend(true, {}, options);
		this.each(function(index, el) {
			$.tableButtons(el, options);
		});
		return this;
	}
})(window.jQuery);