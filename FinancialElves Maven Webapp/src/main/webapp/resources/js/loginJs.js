$(function() {

    // 提交登录表单
    $("form").submit(function() {
        if ($("#usernameInput").val().length < 6 || $("#passwordInput").val().length < 6) {
            alert("请完善登录信息！");
            return false;
        }
        return true;
    });

    // 用户名有效验证
    $("#usernameInput").blur(function() {
        if ($("#usernameInput").val().length < 6 && $("#usernameInput").val().length > 0) {
            $("#usernameError").text("用户名不能小于6位！");
        } else if ($("#usernameInput").val().length == 0) {
            $("#usernameError").text("用户名不能为空！");
        }
    });
    // 登录密码有效验证
    $("#passwordInput").blur(function() {
        if ($("#passwordInput").val().length < 6 && $("#passwordInput").val().length > 0) {
            $("#passwordError").text("用户名不能小于6位！");
        } else if ($("#passwordInput").val().length == 0) {
            $("#passwordError").text("密码不能为空！");
        }
    });
    // 获得焦点清空验证警告
    $("#usernameInput").focus(function() {
        $("#usernameError").text("");
    });
    $("#passwordInput").focus(function() {
        $("#passwordError").text("");
    });

    // 注册链接
    $("#registerLinkDiv").click(function() {
        $(window).attr('location', 'register.html');
    });
});