;
(function() {

    var Login = function(option) {
        var defaults = {
            url: "",
            types: "get",
            href: "index.html"
        };
        var setting = $.extend({}, defaults, option);
        this.userlogin(setting);
    }

    Login.prototype = {
        userlogin: function(opt) {
            var $name = $("#username");
            var $pwd = $("#pwd");
            var $validateCode = $("#validateCode");
            if ($name.val() === "") {
                $.poptips({tipLevel: "error", stayTime: 2000, tipIsColor: true, tipIsBlock: true, tipNoIcon: false, content: "用户名不能为空"});
                return;
            } else {
                var checkSuccess = /^[\w]+$/.test($name.val());
                if (!checkSuccess) {
                    $.poptips({tipLevel: "error", tipIsColor: true, tipIsBlock: true, tipNoIcon: false, content: "登录名由英文字母、数字及下划线组合!"});
                    return;
                }
            }
            if ($pwd.val() === "") {
                $.poptips({tipLevel: "error", tipIsColor: true, tipIsBlock: true, tipNoIcon: false, content: "密码不能为空!"});
                return;
            } else {
                var value = $pwd.val();
                var checkSuccess = /(?=.*[0-9])((?=.*[A-Z])|(?=.*[a-z])).*/.test(value);
                if (!checkSuccess) {
                    $.poptips({tipLevel: "error", tipIsColor: true, tipIsBlock: true, tipNoIcon: false, content: "密码至少包含一个数字和字母!"});
                    return;
                } else if (value.length < 6 || value.length > 50) {
                    $.poptips({tipLevel: "error", tipIsColor: true, tipIsBlock: true, tipNoIcon: false, content: "密码必须为六至五十位!"});
                    return;
                }

            }
            if ($validateCode.val() === "") {
                $.poptips({tipLevel: "error", tipIsColor: true, tipIsBlock: true, tipNoIcon: false, content: "验证码不能为空!"});
                return;
            }

            var preloading = $.loading()['loading'];
            $.ajax({
                url: opt.url,
                dataType: 'json',
                type: "post",
                async: false,
                data: {
                    "username": $name.val(),
                    "pwd": $pwd.val(),
                    "validateCode": $validateCode.val()
                },
                success: function(response) {
                    // 请求成功
                    if (response.result === "success") {
                        // 登录成功
                        if (response.state === "1") {
                            window.location.href = opt.href;
                        } else {
                            $.poptips({
                                content: response.reason,
                                tipNoIcon: 1
                            });
                        }
                    } else {
                        $.poptips({
                            content: response.reason,
                            tipNoIcon: 1
                        });
                    }
                },
                error: function() {
//                    $.poptips({
//                        content: "请求错误，请稍候重试",
//                        tipNoIcon: 1
//                    });
                    $.poptips({tipLevel: "error", tipIsColor: true, tipIsBlock: true, tipNoIcon: false, content: "请求错误，请稍候重试!"});
                    $name.val("");
                    $pwd.val("");
                },
                complete: function() {
                    preloading[0].close();
                }
            });

        }
    }

    $.longins = function(option) {
        return new Login(option);
    }

})();