/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


sudyAdaptiveUtil = {};
sudyAdaptiveUtil.util = function(o) {
    defaults = $.extend({}, 0);
};
$.extend(sudyAdaptiveUtil.util, {
    pageSizeHeight: 38.5, //每行的高度
    contentmarginHeight: 0, //下面的空白高度
    /*
     * 初始化pagesize thePageSize:true 根据pagesize计算  false 根据屏幕计算
     */
    reset: function(thePageSize) {
        if ($(".dg_foot_button_advance")) {
            $(".dg_foot_button_advance").css("position", "static");
        }
        //alert($(window).height() );
        var _contentHeight = $(window).height() - 40 - 48 - 40 - sudyAdaptiveUtil.util.contentmarginHeight;
        var contentHeight = $(".datagrid-header").height() + $(".pagination").height();
        var _height = $.fn.datagrid.defaults.pageSize*38.7+contentHeight;
        //alert(_height);
        if(_height>_contentHeight){
			_height = _contentHeight;
        }
        //alert(_height);
        $(".dg_content").height(_height);
        $(".datagrid-wrap").height(_height);
        if ($(".dg_foot_button_advance")) {
            $(".dg_foot_button_advance").css("position", "absolute");
        }
    },
    /*
     * 初始化pagesize
     */
    initPageSize: function() {
        $.fn.datagrid.defaults.pageSize = this.getPageSize();
        $.fn.datagrid.defaults.pageList = [10, 15, 20, 25, 30, 35, 40, 45, 50];
    },
    /*
     * 获取列表页高度
     */
    getAdaptiveHeight: function(initObj, thePageSize) {
    	alert($(window).height());
        var contentHeight = $(window).height() - $(".dg_search").height() - $(".dg_foot").height() - $(".dg_head").height();
        var height;
        if (thePageSize) {
            height = $.fn.datagrid.defaults.pageSize * 38.5 + 60;
        } else {
            height = contentHeight - sudyAdaptiveUtil.util.contentmarginHeight;
        }
        if (initObj) {
            $(initObj).height(height);
        }
        return height;
    },
    /*
     * 获取合适的每页条数
     */
    getPageSize: function(id) {
        var contentHeight = $(window).height() - 40 - 48 - 70 - sudyAdaptiveUtil.util.contentmarginHeight;
        var pageSizeSum = parseInt(contentHeight / (sudyAdaptiveUtil.util.pageSizeHeight * 5));//240是5行
        var pageSize = pageSizeSum * 5;
        if (pageSize < 10) {
            pageSize = 10;
        } else if (pageSize > 50) {
            pageSize = 50;
        }
        return pageSize;
    }
});
sudyAdaptiveUtil.util.initPageSize();