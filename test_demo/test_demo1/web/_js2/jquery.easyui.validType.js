/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *自定义的校验方法(校验两次密码是否相同) 
 * @param param为传入第一次输入的密码框的id 
 * @call repeat['#id'] 
 */  
$.extend($.fn.textbox.defaults.rules,{
    reapet: {
        validator: function(value, param){
            var pwd = $(param[0]).val();
            if(pwd != value){
                return false;
            }else{
                return true;
            }
           
        },
        message: '{1}'
    }
});

//唯一性校验
$.extend($.fn.textbox.defaults.rules,{
    unique: {
        validator: function(value, param){
            value = $('#'+param[1]).attr('value');
            $('#'+param[1]).load(param[0]+"?"+param[2]+"="+value,
                function(responseText, textStatus, XMLHttpRequest){
                    if(responseText) //后台返回true或者false
                        return true;
                });
            return false;
        },
        message: '{1}'
    }
});

$.extend($.fn.textbox.defaults.rules,{
    int: {
        validator: function(value,param){
            var regu =/^\d+$/;
            var re = new RegExp(regu);
            if (!re.test(value)){
                return false;
            }else if (value<param[0]||value>param[1]){
                return false;
            }else{
                return true;
            }
        }
    }
});
$.extend($.fn.textbox.defaults.rules,{
    datetime: {
        validator:function(value){
            var reg3 = /^\d{4}-\d{1,2}-\d{1,2}$/;
            var re3 = new RegExp(reg3);
            if(re3.test(value)){
                return true;
            }else{
                return false;
            }
        },
        message:'长度不够,格式:YYYY-MM-DD'
    }
});

/**
 * 必须选择一项
 * hsguo
 */
$.extend($.fn.textbox.defaults.rules,{
    selectOne: {
        validator:function(value){
            if("" == value || "请选择" == value){
                return false;
            }else{
                return true;
            }
        },
        message:'请先选择一项!'
    }
});

$.extend($.fn.textbox.defaults.rules, {
    QQ:{
        validator: function (value, param) {
            return /^[1-9]\d{4,10}$/.test(value);
        },
        message: 'QQ号码不正确'
    },
    mobile: {
        validator: function (value, param) {
            return /^[1-9]\d{4,10}$/.test(value);
        },
        message: '手机号码不正确'
    },
    idcard: {
        validator: function (value, param) {
            return idCard(value);
        },
        message:'请输入正确的身份证号码'
    },
    ZIP: {
        validator: function (value, param) {
            return /^[1-9]\d{5}$/.test(value);
        },
        message: '邮政编码不存在'
    },
    loginName: {
        validator: function (value,param) {
            return /^[\w]+$/.test(value);
        },
        message: '用户名由英文字母、<br>数字及下划线组合'
    },
    IDName: {
        validator: function (value,param) {
            return /^[A-Za-z0-9]+$/.test(value);
        },
        message: '请输入英文字母或数字'
    }, 
    urlLogin:{
        validator:function(value,param){
            var regexp = new RegExp("^(http|ftp|https):\\/\\/[\\w\-_]+(\\.[\\w\-_]+)+([\\w\-\.,@?^=%&amp;:/~\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?", "gi");
            var v = value.match(regexp);
            if(v != null){
                return true;
            }
            regexp = new RegExp("^(/[\\w-])+", "gi");
            v = value.match(regexp);
            if(v != null){
                return true;
            }
            regexp = new RegExp("^([\\w-])+(/[\\w-])+", "gi");
            v = value.match(regexp);
            if(v != null){
                return true;
            }
            return false;
        },
        message:"请输入正确的URL规则"
    },
    CHS: {
        validator: function (value, param) {
            return /^[\u0391-\uFFE5]+$/.test(value);
        },
        message: '请输入汉字'
    },
    phone: {
        validator: function (value, param) {
            return /^0(((\d{2,3})-(\d){7,8})|(\d{2,3}(\d){7,8}))$/.test(value);
        },
        message: '电话号码不正确'
    },
    telephone: {
        validator: function (value, param) {
            if(value=="格式：02585034082或13387723412"){
                return true;
            } else {
                return /^((0(((\d{2,3})-(\d){7,8})|(\d{2,3}(\d){7,8})))|([1-9]\d{4,10}))$/.test(value);
            }
        },
        message: '联系电话不正确'
    },
    password: {
        validator: function (value, param) {
            var checkSuccess = /(?=.*[0-9])((?=.*[A-Z])|(?=.*[a-z])).*/.test(value);
            if(!checkSuccess){
                $.fn.validatebox.defaults.rules.password.message = '密码至少包含一个数字和字母';
                return false;
            }else if(value.length < 6 || value.length > 20){
                $.fn.validatebox.defaults.rules.password.message = '密码必须为六至二十位！';
                return false;
            }
            return true;
        }
    }
});
    
$.extend($.fn.textbox.defaults.rules, {
    safepass:{
        validator: function (value, param) {
            return /^[a-zA-Z]\w{5,17}$/.test(value);
        },
        message: '密码由数字、字母或下划线组成，至少6位'
    },
    alphabet: {
        validator: function (value, param) {
            return /^[A-Za-z]+$/.test(value);
        },
        message: '请输入英文字母'
    }
});
    
$.extend($.fn.textbox.defaults.rules, {
    simpleName: {
        validator: function (value, param) {
            var re=/[\\*;?'$<>|]/;
            if(value.match(re)){
                return false;
            }
            return true;
        },
        message: '名称不能包含 \\ * ; ? $ \' < > | '
    },
    simpleTitle: {
        validator: function (value, param) {
            var re=/[\\$]/;
            if(value.match(re)){
                return false;
            }
            return true;
        },
        message: '名称不能包含 \\ $ '
    }
});
    
    
$.extend($.fn.textbox.defaults.rules, {
    ipvald: {
        validator: function (value, param) {
            var v4 = /((25[0-5]|2[0-4]\d|1?\d?\d)\.){3}(25[0-5]|2[0-4]\d|1?\d?\d)/;
            var v6= /^\s*((([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:))|(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}|((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){5}(((:[0-9A-Fa-f]{1,4}){1,2})|:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){4}(((:[0-9A-Fa-f]{1,4}){1,3})|((:[0-9A-Fa-f]{1,4})?:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){3}(((:[0-9A-Fa-f]{1,4}){1,4})|((:[0-9A-Fa-f]{1,4}){0,2}:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){2}(((:[0-9A-Fa-f]{1,4}){1,5})|((:[0-9A-Fa-f]{1,4}){0,3}:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){1}(((:[0-9A-Fa-f]{1,4}){1,6})|((:[0-9A-Fa-f]{1,4}){0,4}:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:))|(:(((:[0-9A-Fa-f]{1,4}){1,7})|((:[0-9A-Fa-f]{1,4}){0,5}:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:)))(%.+)?\s*$/;
            if(value.match(v4)||value.match(v6)){
                return true;
            }
            return false;
        },
        message: 'ip格式不正确请填写正确的IPv4或者IPv6地址!'
    }
});
    
$.extend($.fn.textbox.defaults.rules, {
    ipvFour: {
        validator: function (value, param) {
            var v4 = /((25[0-5]|2[0-4]\d|1?\d?\d)\.){3}(25[0-5]|2[0-4]\d|1?\d?\d)/;
            if(value.match(v4)){
                return true;
            }
            return false;
        },
        message: 'ip格式不正确请填写正确的IPv4地址!'
    }
});
    
$.extend($.fn.textbox.defaults.rules, {
    ipvSix: {
        validator: function (value, param) {
            var v6= /^\s*((([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:))|(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}|((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){5}(((:[0-9A-Fa-f]{1,4}){1,2})|:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){4}(((:[0-9A-Fa-f]{1,4}){1,3})|((:[0-9A-Fa-f]{1,4})?:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){3}(((:[0-9A-Fa-f]{1,4}){1,4})|((:[0-9A-Fa-f]{1,4}){0,2}:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){2}(((:[0-9A-Fa-f]{1,4}){1,5})|((:[0-9A-Fa-f]{1,4}){0,3}:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){1}(((:[0-9A-Fa-f]{1,4}){1,6})|((:[0-9A-Fa-f]{1,4}){0,4}:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:))|(:(((:[0-9A-Fa-f]{1,4}){1,7})|((:[0-9A-Fa-f]{1,4}){0,5}:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:)))(%.+)?\s*$/;
            if(value.match(v6)){
                return true;
            }
            return false;
        },
        message: 'ip格式不正确请填写正确的IPv6地址!'
    }
});

var idCard = function (value) {
    if (value.length == 15) return true;
    var number = value.toLowerCase();
    var d, sum = 0, v = '10x98765432', w = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2], a = '11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91';
    var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[x\d])))$/);
    if (re == null || a.indexOf(re[1]) < 0) return false;
    if (re[2].length == 9) {
        number = number.substr(0, 6) + '19' + number.substr(6);
        d = ['19' + re[4], re[5], re[6]].join('-');
    } else d = [re[9], re[10], re[11]].join('-');
    if (!isDateTime.call(d, 'yyyy-MM-dd')) return false;
    for (var i = 0; i < 17; i++) sum += number.charAt(i) * w[i];
    return (re[2].length == 9 || number.charAt(17) == v.charAt(sum % 11));
}

var isDateTime = function (format, reObj) {
    format = format || 'yyyy-MM-dd';
    var input = this, o = {}, d = new Date();
    var f1 = format.split(/[^a-z]+/gi), f2 = input.split(/\D+/g), f3 = format.split(/[a-z]+/gi), f4 = input.split(/\d+/g);
    var len = f1.length, len1 = f3.length;
    if (len != f2.length || len1 != f4.length) return false;
    for (var i = 0; i < len1; i++) if (f3[i] != f4[i]) return false;
    for (var i = 0; i < len; i++) o[f1[i]] = f2[i];
    o.yyyy = s(o.yyyy, o.yy, d.getFullYear(), 9999, 4);
    o.MM = s(o.MM, o.M, d.getMonth() + 1, 12);
    o.dd = s(o.dd, o.d, d.getDate(), 31);
    o.hh = s(o.hh, o.h, d.getHours(), 24);
    o.mm = s(o.mm, o.m, d.getMinutes());
    o.ss = s(o.ss, o.s, d.getSeconds());
    o.ms = s(o.ms, o.ms, d.getMilliseconds(), 999, 3);
    if (o.yyyy + o.MM + o.dd + o.hh + o.mm + o.ss + o.ms < 0) return false;
    if (o.yyyy < 100) o.yyyy += (o.yyyy > 30 ? 1900 : 2000);
    d = new Date(o.yyyy, o.MM - 1, o.dd, o.hh, o.mm, o.ss, o.ms);
    var reVal = d.getFullYear() == o.yyyy && d.getMonth() + 1 == o.MM && d.getDate() == o.dd && d.getHours() == o.hh && d.getMinutes() == o.mm && d.getSeconds() == o.ss && d.getMilliseconds() == o.ms;
    return reVal && reObj ? d : reVal;
    function s(s1, s2, s3, s4, s5) {
        s4 = s4 || 60, s5 = s5 || 2;
        var reVal = s3;
        if (s1 != undefined && s1 != '' || !isNaN(s1)) reVal = s1 * 1;
        if (s2 != undefined && s2 != '' && !isNaN(s2)) reVal = s2 * 1;
        return (reVal == s1 && s1.length != s5 || reVal > s4) ? -10000 : reVal;
    }
}; 

