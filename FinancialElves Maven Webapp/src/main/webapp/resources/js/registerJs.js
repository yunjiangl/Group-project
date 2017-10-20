$(function() {
    //注册表单提交
    $("#register_form").submit(function() {
        if ($("#usernameInput").val().length < 6 || $("#passwordInput").val().length < 6 || $("#repetitionPw").val().length < 6 || $("#emailInput").val().length == 0) {
            alert("请完善用户信息！");
            return false;
        }
        return true;
    });

    // 获得焦点取消验证
    $("#usernameInput").focus(function() {
        $("#userVerify").text("");
    });
    $("#passwordInput").focus(function() {
        $("#passwordVerify").text("");
    });
    $("#repetitionPw").focus(function() {
        $("#repetitionPwVerify").text("");
    });
    $("#emailInput").focus(function() {
        $("#emailVerify").text("");
    });

    // 用户名有效验证
    $("#usernameInput").blur(function() {
        if ($("#usernameInput").val().length < 6 && $("#usernameInput").val().length > 0) {
            $("#userVerify").text("用户名不得少于6位！");
        } else if ($("#usernameInput").val().length == 0) {
            $("#userVerify").text("用户名不能为空！");
        }
    });

    // 密码有效验证
    $("#passwordInput").blur(function() {
        if ($("#passwordInput").val().length < 6 && $("#passwordInput").val().length > 0) {
            $("#passwordVerify").text("密码不得少于6位！");
        } else if ($("#passwordInput").val().length == 0) {
            $("#passwordVerify").text("密码不能为空！");
        }
    });

    // 重复密码有效验证
    $("#repetitionPw").blur(function() {
        if ($("#repetitionPw").val().length == 0) {
            $("#repetitionPwVerify").text("请确认您的密码！");
        } else {
            if ($("#repetitionPw").val() != $("#repetitionPw").val()) {
                $("#repetitionPwVerify").text("两次输入的密码不一致！");
            }
        }
    });

    $("#emailInput").blur(function() {
        var email = $("#emailInput").val();
        var atpos = email.indexOf("@")
        var dotops = email.lastIndexOf(".");
        if (atpos < 1 || dotops < atpos + 2 || dotops + 2 >= email.length) {
            $("#emailVerify").text("请输入有效的E-mail地址！");
        }
    });
});