/*tree-menu*/
var currentPath='/_system/sudy-skins/_sui/skins/';
$(function(){
	/*获取url文件名前的信息*/
	var locationHref = window.location.href;
	var locationName = locationHref.substring(locationHref.lastIndexOf('/')+1);
	var locationUrl = locationHref.replace(locationName,"");
        
	$.extend({
		includePath:'',
		include: function(file) {
			var files = typeof file == "string" ? [file]:file;
			var head = document.getElementsByTagName("head");
			for (var i = 0; i < files.length; i++) {
				var name = files[i];
				var att = name.split('.');
				var ext = att[att.length - 1].toLowerCase();
				var isCSS = ext == "css";
				var tag = isCSS ? "link" : "script";
				var attr = isCSS ? " type='text/css' id='style' rel='stylesheet' " : " language='javascript' id='javascript' type='text/javascript' ";
				var link = (isCSS ? "href" : "src") + "='" + $.includePath + name + "'";
				if ($(tag + "[" + link + "]").length == 0){
					$(head[0]).append("<" + tag + attr + link + "></" + tag + ">");
				}
			}
		}
	});
	//使用方法
	$.includePath = currentPath;
	$.include(['skins-blue.css']);
	
	$(document).on('click','.tree-menu li a', function (e) {
		var $this = $(this);
		var checkElement = $this.next();
		if ((checkElement.is('.tree-menu')) && (checkElement.is(':visible'))) {
			checkElement.slideUp(100, function () {
				checkElement.removeClass('menu-open');
			});
			checkElement.parent("li").removeClass("active");
		}
		else if ((checkElement.is('.tree-menu')) && (!checkElement.is(':visible'))) {
			var parent = $this.parents('ul').first();
			var ul = parent.find('ul:visible').slideUp(100);
			ul.removeClass('menu-open');
			var parent_li = $this.parent("li");
			checkElement.slideDown(100, function () {
				checkElement.addClass('menu-open');
				parent.find('li.active').removeClass('active');
				parent_li.addClass('active');
			});
		}
		if (checkElement.is('.tree-menu')) {
			e.preventDefault();
		}
	});
	
	$(document).on('mouseover mouseout','.tree-menu li', function (event) {
		 if(event.type == "mouseover"){
			$(this).addClass("hover");
		 }else if(event.type == "mouseout"){
			$(this).removeClass("hover");
		 }
	});
	
	
	/*阻止事件冒泡*/
	$(".sudy-search-more,.combo-p,.searchbox,.menu").on("click",function(e){
		e.stopPropagation();
		return false;
	});	
	$(document).on('click','.easyui-linkbutton[data-search="more"]', function (e) {
		var $this = $(this);
		var checkElement = $this.next();
		if ((checkElement.is('.sudy-search-more')) && (checkElement.is(':visible'))) {
			checkElement.slideUp(100, function(){
			});
		}
		else if ((checkElement.is('.sudy-search-more')) && (!checkElement.is(':visible'))) {
			checkElement.slideDown(100, function(){
			});
		}
	});
	$("body,html").on("click",function(e){
		var $this = $(this);
		$this.find(".sudy-search-more").slideUp(100);
	});	
});

function loadCurrentPath(){
    var url;
    if(document.currentScript){
        url=document.currentScript.src;
    }else{
        var scripts=document.scripts;
        url = scripts[scripts.length - 1].src;
    }
    currentPath = url.replace(/\/js\/public\.js.*/,"/skins/");
}
loadCurrentPath();

/*日历时间选择方法*/
function timebox(id){
	var $dd = $(id);
	var timeData = new Date($dd.datetimebox('getValue'));
	$dd.datetimebox({
		onSelect: function(date){
			timeData = date;
			var d = $(this).datetimebox('getValue');
			var v = $(this).datetimebox('spinner').timespinner('getValue');
			$(this).datetimebox('setValue', date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+v);
		}
		
	});
        
        /*$dd.textbox('textbox').on('focusout', function(){  
		var v = $dd.datetimebox('spinner').timespinner('getValue');
		$dd.datetimebox('setValue', timeData.getFullYear()+"-"+(timeData.getMonth()+1)+"-"+timeData.getDate()+" "+v);
	});*/
            
	$dd.datetimebox('spinner').timespinner({
		onSpinUp:function(){
			var v = $(this).timespinner('getValue');
			$dd.datetimebox('setValue', timeData.getFullYear()+"-"+(timeData.getMonth()+1)+"-"+timeData.getDate()+" "+v);
		},
		onSpinDown:function(){
			var v = $(this).timespinner('getValue');
			$dd.datetimebox('setValue', timeData.getFullYear()+"-"+(timeData.getMonth()+1)+"-"+timeData.getDate()+" "+v);
		}
	});
}

/**
 * 为输入框添加样式
 * @param {type} id 输入框id 要加#
 * @param {type} className 添加的class
 * @returns {undefined}
 */
function toTextBoxAddClass(id, className) {
    var $textInput = $(id + '+span>input.textbox-text');
    $textInput.addClass(className);
}
/**
 * 为输入框绑定事件
 * @param {type} id 输入框id 要加#
 * @param {type} type 绑定的事件
 * @param {type} callback 回调函数
 * @returns {undefined}
 */
function toTextBoxAddEvent(id, type, callback) {
    var $textInput = $(id + '+span>input.textbox-text');
    $textInput.bind(type, callback);
}

/**
 * 为输入框绑定事件EasyUI1.5.2
 * @param {type} id 输入框id 要加#
 * @param {type} type 绑定的事件
 * @param {type} callback 回调函数
 * @returns {undefined}
 */
function addEventForTextBox(id, type, callback) {
    $(id).textbox('textbox').bind(type, callback);
}