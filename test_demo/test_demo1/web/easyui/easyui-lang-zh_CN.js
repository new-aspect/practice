if ($.fn.pagination){
	$.fn.pagination.defaults.beforePageText = '每页';
	$.fn.pagination.defaults.afterPageText = '共{pages}页';
	$.fn.pagination.defaults.displayMsg = '项结果&nbsp;&nbsp;显示第 {from} 至  {to} 项 , 共 {total} 项';
	$.fn.pagination.defaults.layout = ['list','prev','links','next','info'];
	$.extend($.fn.pagination.methods, {
		links: function(jq){
			return jq.each(function(){
				var t = $(this);
				var opts = t.pagination('options');
				t.find(".pagination-page-list").before("每页");
				t.find(".pagination-info").after('<div class="pagination-linkcon"><div class="pagination-link-con" ></div></div>');
				t.find("td").each(function(i,el){
					if(i != 0){
						t.find(".pagination-link-con").append($(this));
					}
				});
			});
		}
	});
	
}
if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = '正在处理，请稍待。。。';
}
if ($.fn.treegrid && $.fn.datagrid){
	$.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg;
}
if ($.messager){
	$.messager.defaults.ok = '确 定';
	$.messager.defaults.cancel = '取 消';
	$.messager.defaults.width = '260';
	$.messager.defaults.height = '150';
	
}
$.map(['validatebox','textbox','passwordbox','filebox','searchbox',
		'combo','combobox','combogrid','combotree',
		'datebox','datetimebox','numberbox',
		'spinner','numberspinner','timespinner','datetimespinner'], function(plugin){
	if ($.fn[plugin]){
		$.fn[plugin].defaults.missingMessage = '该输入项为必输项';
	}
});
if ($.fn.validatebox){
	$.fn.validatebox.defaults.rules.email.message = '请输入有效的电子邮件地址';
	$.fn.validatebox.defaults.rules.url.message = '请输入有效的URL地址';
	$.fn.validatebox.defaults.rules.length.message = '输入内容长度必须介于{0}和{1}之间';
	$.fn.validatebox.defaults.rules.remote.message = '请修正该字段';
}
if ($.fn.calendar){
	$.fn.calendar.defaults.weeks = ['日','一','二','三','四','五','六'];
	$.fn.calendar.defaults.months = ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'];
}
if ($.fn.datebox){
	$.fn.datebox.defaults.currentText = '今天';
	$.fn.datebox.defaults.closeText = '关闭';
	$.fn.datebox.defaults.okText = '确定';
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	};
	$.fn.datebox.defaults.parser = function(s){
		if (!s) return new Date();
		var ss = s.split('-');
		var y = parseInt(ss[0],10);
		var m = parseInt(ss[1],10);
		var d = parseInt(ss[2],10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
			return new Date(y,m-1,d);
		} else {
			return new Date();
		}
	};
		
	
}
if ($.fn.datetimebox && $.fn.datebox){
	$.extend($.fn.datetimebox.defaults,{
		currentText: $.fn.datebox.defaults.currentText,
		closeText: $.fn.datebox.defaults.closeText,
		okText: $.fn.datebox.defaults.okText
	});
}
if ($.fn.datetimespinner){
	$.fn.datetimespinner.defaults.selections = [[0,4],[5,7],[8,10],[11,13],[14,16],[17,19]]
}

if ($.fn.textbox){
	$.extend($.fn.textbox.methods, {
		addClearBtn: function(jq, iconCls){
			return jq.each(function(){
				var t = $(this);
				var opts = t.textbox('options');
				opts.icons = opts.icons || [];
				opts.icons.unshift({
					iconCls: iconCls,
					handler: function(e){
						$(e.data.target).textbox('clear').textbox('textbox').focus();
						$(this).css('visibility','hidden');
					}
				});
				t.textbox();
				if (!t.textbox('getText')){
					t.textbox('getIcon',0).css('visibility','hidden');
				}
				t.textbox('textbox').bind('keyup', function(){
					var icon = t.textbox('getIcon',0);
					if ($(this).val()){
						icon.css('visibility','visible');
					} else {
						icon.css('visibility','hidden');
					}
				});
			});
		}
	});
}

$.extend($.fn.datagrid.methods, {
    fixRownumber : function (jq) {
        return jq.each(function () {
            var panel = $(this).datagrid("getPanel");
            //获取最后一行的number容器,并拷贝一份
            var clone = $(".datagrid-cell-rownumber", panel).last().clone();
            //由于在某些浏览器里面,是不支持获取隐藏元素的宽度,所以取巧一下
            clone.css({
                "position" : "absolute",
                left : -1000
            }).appendTo("body");
            var width = clone.width("auto").width();
            //默认宽度是25,所以只有大于25的时候才进行fix
            if (width > 25) {
                //多加5个像素,保持一点边距
                $(".datagrid-header-rownumber,.datagrid-cell-rownumber", panel).width(width + 5);
                //修改了宽度之后,需要对容器进行重新计算,所以调用resize
                $(this).datagrid("resize");
                //一些清理工作
                clone.remove();
                clone = null;
            } else {
                //还原成默认状态
                $(".datagrid-header-rownumber,.datagrid-cell-rownumber", panel).removeAttr("style");
            }
        });
    }
});




