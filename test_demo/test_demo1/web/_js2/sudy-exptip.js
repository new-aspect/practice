function exptip(operMsg) {
    var msg = fetchMsg(operMsg);
    $.blockUI({         
        message:  msg,
        overlayCSS: { 
            backgroundColor: '#ccc' 
        },
        css: {            
            border: 'none',           
            padding: '15px',         
            backgroundColor: '#000',   
            '-webkit-border-radius': '10px',   
            '-moz-border-radius': '10px',      
            opacity: .5,          
            color: '#fff'                                
        }        
    }); 
}

function exptipWithTimeOut(operMsg, timeout) {
    var msg = fetchMsg(operMsg);
    $.blockUI({         
        message:  msg,
        overlayCSS: { 
            backgroundColor: '#ccc' 
        },
        css: {            
            border: 'none',           
            padding: '15px',         
            backgroundColor: '#000',   
            '-webkit-border-radius': '10px',   
            '-moz-border-radius': '10px',      
            opacity: .5,          
            color: '#fff'                                
        },
        timeout : 5000
    }); 
}

function fetchMsg(operMsg) {
    //图片需要改用样式，否则路径难以控制
    var msg ='<table border="0"><tr><td valign="top" width="30px"><img src="_images/index/waiting.gif"></td><td align="left">'+ operMsg + '</td></tr></table>';
    return msg
}