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

        }
    }
}();
 