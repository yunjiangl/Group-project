$(function() {

	// 界面切换
	$("#formMenu").click(function() {
		formMenu(null, null, null);
		
	});

	// 查询
	$("#queryMenu").click(function() {
		$(location).attr('href', 'list.html');
	});

	// 统计分析
	$("#analizeMenu").click(function() {

		analyze();
	});

	if (flag) {
		flag = false;
		countForPagesAndFirstData("/bill_queryAccountBillPages", null, 0);
	}

	// 收入查询or支出查询切换
	$("#payIncome_Select").click(function() {
		var incomeOrExpend;
		if ($(this).val() == "收入查询") {
			$("#payIncome_show").text("收入记录");
			incomeOrExpend = 0;
		} else {
			$("#payIncome_show").text("支出记录");
			incomeOrExpend = 1;
		}
		countForPagesAndFirstData("/bill_queryAccountBillPages", null, incomeOrExpend);
	});


	// 模糊查询
	$("#searchButton").click(function() {
		
		var type = $.trim($("#searchInput").val())
		if (type == "") {
			alert("请输入查询关键字！")
		} else {
			var incomeOrExpend;
			if ($("#payIncome_Select").val() == "收入查询") {
				incomeOrExpend = 0;
			} else {
				incomeOrExpend = 1;
			}
			countForPagesAndFirstData("/bill_fuzzyQueryBillPages", type, incomeOrExpend);
		}

	});

	// 窗口宽度自适应
	$(window).resize(function() {
		$("#bigDiv").css("width", "100%");
		$("#contentDiv").css("width", "88%");
	});

	// 窗口高度自适应:初始值
	$("#bigDiv").css("height", $(window).height());
	$("#menuDiv").css("height", $("#bigDiv").height() - 70);
	$("#contentDiv").css("height", $("#bigDiv").height() - 70);
	$("#imgDiv").css("margin-top", $("#menuDiv").height() - 226);

	// 窗口高度自适应：改变窗口大小的时候
	$(window).resize(function() {
		$("#bigDiv").css("height", $(window).height());
		$("#menuDiv").css("height", $("#bigDiv").height() - 70);
		$("#contentDiv").css("height", $("#bigDiv").height() - 70);
		$("#imgDiv").css("margin-top", $("#menuDiv").height() - 226);
	});

	/**
	 * 下一页数据 
	 **/
	$("#next").click(function() {

		$(".pages").eq(page).trigger("click");
	});

	/**
	 * 首页数据 
	 **/
	$("#first").click(function() {

		$(".pages").eq(0).trigger("click");
	});

	/**
	 * 尾页数据 
	 **/
	$("#last").click(function() {

		$(".pages").eq(pages - 1).trigger("click");
	});

	/**
	 * 上一页数据 
	 **/
	$("#previous").click(function() {
		$(".pages").eq(page - 2).trigger("click");
	});

	
	$("#logoutDiv").click(function(){
		loginOut();
	});

});