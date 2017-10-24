$(function() {
	var passwordIsTrue = false;
	var usernameRepeat = false;

	//注册表单提交
	$("#register_form").submit(function() {

		if ($("#usernameInput").val().length < 6 || $("#passwordInput").val().length < 6 || $("#repetitionPw").val().length < 6 || $("#emailInput").val().length == 0) {
			alert("请完善用户信息！");

		} else if (passwordIsTrue && usernameRepeat) {
			doRegister($("#usernameInput").val(), $("#repetitionPw").val(), $("#emailInput").val(), $("input[name='account_gender']").val(), $("#account_career").val(), $("#account_hobbies").val());

		}
		return false;
	});
	
	//返回登录页面
	$("#loginBack").click(function(){
		$(window).attr("location","login.html");
	});

	// 用户名有效验证
	$("#usernameInput").blur(function() {
		if ($("#usernameInput").val().length < 6 && $("#usernameInput").val().length > 0) {
			$("#userVerify").css("color", "red");
			$("#userVerify").text("用户名不得少于6位！");
		} else if ($("#usernameInput").val().length == 0) {
			$("#userVerify").css("color", "red");
			$("#userVerify").text("用户名不能为空！");
		} else {
			ajaxRequest("GET", getRootPath_web() + "/user_usernameIsRepeat", "account.account_username=" + $(this).val(), function(data) {
				if (data == "yes") {
					$("#userVerify").css("color", "green");
					$("#userVerify").text("账号可用");
					usernameRepeat = true;
				} else {
					$("#userVerify").css("color", "red");
					$("#userVerify").text("账号已经被注册了");
				}
			})
		}


	});


	// 密码有效验证
	$("#passwordInput").blur(function() {
		if ($("#passwordInput").val().length < 6 && $("#passwordInput").val().length > 0) {
			$("#passwordVerify").css("color", "red");
			$("#passwordVerify").text("密码不得少于6位！");
		} else if ($("#passwordInput").val().length == 0) {
			$("#passwordVerify").css("color", "red");
			$("#passwordVerify").text("密码不能为空！");
		} else {
			$("#passwordVerify").css("color", "green");
			$("#passwordVerify").text("密码可用！");
		}
	});

	// 重复密码有效验证
	$("#repetitionPw").blur(function() {
		if ($("#repetitionPw").val().length == 0) {
			$("#repetitionPwVerify").css("color", "red");
			$("#repetitionPwVerify").text("请确认您的密码！");

		} else {
			if ($("#repetitionPw").val() != $("#passwordInput").val()) {
				$("#repetitionPwVerify").css("color", "red")
				$("#repetitionPwVerify").text("两次输入的密码不一致！");
			} else {
				$("#repetitionPwVerify").css("color", "green")
				$("#repetitionPwVerify").text("两次输入的密码一致！");
				passwordIsTrue = true;
			}
		}
	});
})