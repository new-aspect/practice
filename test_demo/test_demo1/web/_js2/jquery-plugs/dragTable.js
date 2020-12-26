/*
 * 拖动工具类
 */

var isMoved = false; //是否移动标志,只点击不移动为false，拖动为true
var dragObj; //拖拽对象
var dragTo; //拖拽到那个对象之后
var curr_callback = null;
/**
 * dragTRs 需要拖动的行
 * dragCol 指定可以拖动的列
 * url 请求的地址
 * leftPos 拖拽时，定位符居左位置
 */
function dragTable(gridName, dragTRs, dragCol, url, leftPos, callback) {
    var left = left || 0;
    var indicator = $('<div class="indicator"></div>').appendTo('body');
    $(dragTRs).draggable({
        revert: true,
        axis: 'v',
        handle: "td:nth-child(2)"

    }).droppable({
        accept: dragTRs,
        onDragOver: function(e, source) {
            indicator.css({
                display: 'block',
                top: $(this).offset().top + $(this).outerHeight() - 9,
                left: leftPos
            });
        },
        onDragLeave: function(e, source) {
            isMoved = true;
            indicator.hide();
        },
        onDrop: function(e, source) {
            if (isMoved) {
                dragObj = $(source).find(dragCol).text();
                dragTo = $(this).find(dragCol).text();
                $(source).insertAfter(this);
                isMoved = false;
                changeSort(gridName, url, callback);
            } else {
                $(source).insertBefore(this);
            }
            indicator.hide();
        }
    });
}


function changeSort(gridName, url, callback) {
    // alert("dragObj=" + dragObj+ ", dragTo="+dragTo);
    if (callback) {
        curr_callback = callback;
    } else {
        curr_callback = null;
    }

    $.post(url, {
        dragObj: dragObj,
        dragTo: dragTo
    }, function(result) {
        if (result == "success") {
            $(gridName).datagrid("reload");
            if (curr_callback != null) {
                curr_callback(result);
            }
        } else {
            alertMsg(result);
        }
    });
}
	