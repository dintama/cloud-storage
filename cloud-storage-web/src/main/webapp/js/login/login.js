var login = function () {


    return {
        login: function () {
            var email = $("#username").val();
            var password = $("#password").val();

            $.ajax({
                url: "validate/login",
                dataType: "json",
                data: {
                    email: email,
                    password: password
                },
                type: "POST",
                success: function (res) {
                    if (res === true) {
                        $.msgUtil.successMsg("登陆成功！", "");
                        window.location.href = "/index";
                    } else {
                        $.msgUtil.errorMsg("登陆失败", "账号或密码错误");
                    }
                }
            });

        },
        signUp: function(){
            var nickName = $("#name").val();
            var email = $("#email").val();
            var password = $("#password").val();
            var rePassword = $("#re-password").val();

            if(nickName === ""){
                $.msgUtil.errorMsg("注册失败!", "昵称不能为空");
                $("#name").parent().addClass("has-error");
                return;
            }
            $("#name").parent().removeClass("has-error");
            if(email === ""){
                $.msgUtil.errorMsg("注册失败!", "邮箱不能为空");
                $("#email").parent().addClass("has-error");
                return;
            }
            $("#email").parent().removeClass("has-error");
            if(password === ""){
                $.msgUtil.errorMsg("注册失败!", "密码不能为空");
                $("#password").parent().addClass("has-error");
                return;
            }
            $("#password").parent().removeClass("has-error");
            if(rePassword === ""){
                $.msgUtil.errorMsg("注册失败!", "确认密码不能为空");
                $("#re-password").parent().addClass("has-error");
                return;
            }
            $("#re-password").parent().removeClass("has-error");

            if(password != rePassword){
                $.msgUtil.errorMsg("注册失败!", "两次输入密码不同");
                $("#password").parent().addClass("has-error");
                $("#re-password").parent().addClass("has-error");
                return;
            }
            $("#password").parent().removeClass("has-error");
            $("#re-password").parent().removeClass("has-error");

            var flag = true;
            $.ajax({
                url: "validate/signUp",
                dataType: "json",
                data: {
                    email: email
                },
                type: "POST",
                async:false,
                success: function (res) {
                    if (res === false) {
                        $.msgUtil.errorMsg("注册失败！", "该邮箱已被使用");
                        flag = false;
                    }
                }
            });

            if(flag === false){
                return;
            }

            $.ajax({
                url: "register",
                dataType: "text",
                data: {
                    nickname: nickName,
                    email: email,
                    password: password
                },
                type: "POST",
                success: function (res) {
                    $.msgUtil.successMsg("注册成功！", "");
                    window.location.href = "/login";
                }
            });

        }
    }
}();
 