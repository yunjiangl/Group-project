/**
* ajax异步请求方法
* @param type 请求的类型
* @param url 请求的地址
* @param data 请求发送的数据
* @param seccessMethod 请求成功之后的执行的方法
*
* @author 芸江
* @data 2017年10月16日15:17:05
*
**/
function ajaxRequest(type, url, data, seccessMethod) {
	$.ajax({
		type : type,
		url : url,
		data : data,
		success : seccessMethod,
		error : function() {
			alert("出错咯");
		}
	})
}

/**
 * 获取项目路径
 * 
 * @return projectName 带"/"的项目名
 * 
 * @author 芸江
 * @data 2017年10月16日15:17:05
 **/
function getRootPath_web() {
	//获取带"/"的项目名
	var projectName = window.document.location.pathname.substring(0, window.document.location.pathname.substr(1).indexOf('/') + 1);
	return projectName;
}

/**
 * 切换到编辑页面
 * 
 * @author 芸江
 * @data 2017年10月16日19:06:03
 **/
function formMenu(bill_id, bill_pay_type, bill_money) {
	$("#contentDiv").remove();
	ajaxRequest("POST", getRootPath_web() + "/formMenu.html", null, function(data) {
		$("#bigDiv").append(data);
		$("input[name='bill_id']").val(bill_id);
		$("input[name='bill_pay_type']").val(bill_pay_type);
		$("input[name='bill_money']").val(bill_money);
		
		// 提交表单
		$("#form_bill").submit(function() {
			console.log($("input[name='bill_id']").val() == "");
			if ($("input[name='bill_id']").val() == "") {
				addBill($("input[name='bill_pay_type']").val(), $("input[name='bill_money']").val());
				return false;
			} else {
				
				compileBill($("input[name='bill_id']").val(), $("input[name='bill_pay_type']").val(), $("input[name='bill_money']").val());
				
				return false;
			}
			return false;
		});
	});
}

/**
 * 切换到统计页面
 * 
 * @author 芸江
 * @data 2017年10月16日19:20:04
 **/
function analyze() {
	$("#contentDiv").remove();
	ajaxRequest("POST", getRootPath_web() + "/analyze.html", null, function(data) {
		$("#bigDiv").append(data);

		var pieData; // 饼图数据

		// 加载饼图后台数据
		ajaxRequest("POST", getRootPath_web() + "/bill_queryBillAllMoney", null, function(billMoney) {
			pieData = JSON.parse(billMoney);
			// 收支分析图:饼图
			var ctx = $("#pie").get(0).getContext("2d");

			var data = {
				datasets : [ {
					data : [ pieData[1], Math.abs(pieData[0]) ],
					backgroundColor : [
						'red',
						'blue'
					]
				} ],
				labels : [
					'收入',
					'支出'
				]
			};

			var myPieChart = new Chart(ctx, {
				type : 'pie',
				data : data,
				options : {
					title : {
						display : true,
						text : '收支比例分析图'
					}
				}
			});
		});



		var incomeDate; // 收入曲线图date数据

		var incomeMoeny; // 收入曲线图money数据

		// 加载后台收入曲线图date数据
		ajaxRequest("POST", getRootPath_web() + "/bill_queryBillCreateDate", "incomeOrExpend=0", function(billDate) {
			incomeDate = JSON.parse(billDate);

			// 加载后台收入曲线图money数据
			ajaxRequest("POST", getRootPath_web() + "/bill_queryBillMoney", "incomeOrExpend=0", function(billMoney) {
				incomeMoeny = JSON.parse(billMoney);
				// 收入曲线图
				var ctx1 = $("#lineIncome").get(0).getContext("2d");

				var data1 = {
					labels : incomeDate,
					datasets : [ {
						label : "金额",
						fillColor : "rgba(220,220,220,0.5)",
						strokeColor : "rgba(220,220,220,1)",
						pointColor : "rgba(220,220,220,1)",
						pointStrokeColor : "#fff",
						data : incomeMoeny
					} ]
				}

				var stackedLine = new Chart(ctx1, {
					type : 'line',
					data : data1,
					options : {
						scales : {
							yAxes : [ {
								stacked : true
							} ]
						},
						title : {
							display : true,
							text : '收入金额曲线图'
						}
					}
				});
			});
		});





		var payDate; // 支出曲线图date数据

		var payMoeny; // 支出曲线图money数据

		// 加载后台支出曲线图date数据
		ajaxRequest("POST", getRootPath_web() + "/bill_queryBillCreateDate", "incomeOrExpend=1", function(billDate) {
			payDate = JSON.parse(billDate);
			// 加载后台支出曲线图money数据
			ajaxRequest("POST", getRootPath_web() + "/bill_queryBillMoney", "incomeOrExpend=1", function(billMoney) {
				payMoeny = JSON.parse(billMoney);
				$.each(payMoeny, function(i) {
					payMoeny[i] = Math.abs(payMoeny[i]);
				});

				//支出曲线图
				var ctx2 = $("#linePay").get(0).getContext("2d");

				var data2 = {
					labels : payDate,
					datasets : [ {
						label : "金额",
						fillColor : "rgba(220,220,220,0.5)",
						strokeColor : "rgba(220,220,220,1)",
						pointColor : "rgba(220,220,220,1)",
						pointStrokeColor : "#fff",
						data : payMoeny
					} ]
				}

				var stackedLine = new Chart(ctx2, {
					type : 'line',
					data : data2,
					options : {
						scales : {
							yAxes : [ {
								stacked : true
							} ]
						},
						title : {
							display : true,
							text : '支出金额曲线图'
						}
					}
				});
			});
		});

	});
}

/**
 *  新增账单
 * 
 *  @param bill_pay_type 账单的消费类型
 *  @param bill_money 消费的金额
 *  
 *  @author 芸江
 *  @data 2017年10月16日17:19:23
 **/
function addBill(bill_pay_type, bill_money) {
	
	ajaxRequest("POST", getRootPath_web() + "/bill_addAccountBillInfo", "bill.bill_pay_type=" + bill_pay_type + "&bill.bill_money=" + bill_money, function() {
		alert("新增成功！");
	$(location).attr('href', 'list.html');
	});
}

/**
 * 编辑账单 
 * 
 * @param bill_id 账单的id
 * @param bill_pay_type 账单的消费类型
 * @param bill_money 账单的金额
 * 
 * @author 芸江
 * @data 2017年10月16日16:46:34
 **/
function compileBill(bill_id, bill_pay_type, bill_money) {
	// 更新
	ajaxRequest("POST", getRootPath_web() + "/bill_updateAccountBillInfo", "bill.bill_id=" + bill_id + "&bill.bill_pay_type=" + bill_pay_type + "&bill.bill_money=" + bill_money, function(msg) {
		alert(msg);
		$(location).attr('href', 'list.html');
	});


}

/**
 *  删除账单
 * 
 *  @param bill_id 账单id
 *  
 *  @author 芸江
 *  @data 2017年10月16日16:50:22
 **/
function deleteBill(bill_id) {
	if (confirm("您确定删除吗？")) {
		ajaxRequest("POST", getRootPath_web() + "/bill_deleteAccountBillInfo", "bill.bill_id=" + bill_id, function() {
			alert("删除成功！");
			$(location).attr('href', 'list.html');
		});
	}
}

// 以下是查询----------------



/**
 * 在表格中显示数据
 * 
 * @param data 将要显示的json格式数据
 * 
 * @author 芸江
 * @date 2017年10月16日20:48:53
 * 
 */
function showInfoOnTable(data) {
	$.each(data, function(i) {
		$("tbody").append("<tr><td>" +
			data[i].bill_pay_type +
			"</td><td>" +
			data[i].bill_money +
			"</td><td>" +
			data[i].bill_caertedate +
			"</td><td>" +
			data[i].bill_modifydate +
			"</td><td><input class='id_list' value=" +
			data[i].bill_id +
			">" +
			"</input><div class='compileDiv'>编辑</div><div class='deleteDiv'>删除</div></td></tr>");
	});
}


/**
 * 删除或编辑用户信息点击事件绑定
 * 
 * @author 芸江
 * @date 2017年10月16日20:48:47
 */
function editOrDelete() {

	// 编辑
	$(".compileDiv").click(function() {
		formMenu($(this).parent().find("input").val(), $(this).parent().parent().find("td:eq(0)").text(), $(this).parent().parent().find("td:eq(1)").text());
	});

	// 删除
	$(".deleteDiv").click(function() {
		deleteBill($(this).parent().find("input").val());
	});
}

var flag = true; //页面加载完成时加载数据
var page; // 当前页码
var pages; // 总页数

/**
 * 获取页面总数,并加载第一页数据
 * 
 * @param url 请求地址
 * @param bill_pay_type 账单消费类型
 * 
 * @author 芸江
 * @data 2017年10月16日21:42:04
 * 
 **/
function countForPagesAndFirstData(url, bill_pay_type, incomeOrExpend) {
	var queryUrl = getRootPath_web() + url;
	var nextUrl;
	ajaxRequest("POST", queryUrl, "bill.bill_pay_type=" + bill_pay_type + "&incomeOrExpend=" + incomeOrExpend, function(data) {
		pages = data;

		$(".pages").remove();

		if (pages == 1) {
			$("#next").attr("disabled", "disabled");
			$("#last").attr("disabled", "disabled");
			$("#first").attr("disabled", "disabled");
			$("#previous").attr("disabled", "disabled");
		} else {
			$("#next").removeAttr("disabled");
			$("#last").removeAttr("disabled");
		}

		for (i = 0; i < pages; i++) {
			$("#next").before("<div class='pagingButton pages'>" + (i + 1) + "</div>");
		}

		var incomeOrExpend1;

		if ($("#searchInput").val() != "") {
			nextUrl = getRootPath_web() + "/bill_fuzzyQueryBillInfo";
			if ($("#payIncome_Select").val() == "收入查询") {
				incomeOrExpend1 = 0;
			} else {
				incomeOrExpend1 = 1;
			}
		} else {
			nextUrl = getRootPath_web() + "/bill_queryAccountBillInfo";
			if ($("#payIncome_Select").val() == "收入查询") {
				incomeOrExpend1 = 0;
			} else {
				incomeOrExpend1 = 1;
			}
		}

		// 点击页数按钮
		$(".pages").click(function() {
			var nextPage = $(this).html();


			ajaxRequest('POST', nextUrl, "page=" + nextPage + "&incomeOrExpend=" + incomeOrExpend1 + "&bill.bill_pay_type=" + $("#searchInput").val(), function(data) {
				page = nextPage;
				var res = JSON.parse(data);
				$("tbody tr").remove();

				showInfoOnTable(res);
				editOrDelete();

			});

			$(".pages").css({
				"background-color" : "#F0F8FF",
				"color" : "black",
				"width" : "1.5em",
				"text-align" : "center"
			});

			$(this).css({
				"background-color" : "rgb(77,152,193)",
				"color" : "#FFF"
			});

			if ($(this).html() == pages) {
				$("#next").attr("disabled", "disabled");
				$("#last").attr("disabled", "disabled");
			} else {
				$("#next").removeAttr("disabled");
				$("#last").removeAttr("disabled");
			}

			if ($(this).html() == 1) {
				$("#previous").attr("disabled", "disabled");
				$("#first").attr("disabled", "disabled");
			} else {
				$("#previous").removeAttr("disabled");
				$("#first").removeAttr("disabled");
			}
		});

		// 加载第一页数据
		ajaxRequest("POST", nextUrl, "page=1" + "&incomeOrExpend=" + incomeOrExpend + "&bill.bill_pay_type=" + bill_pay_type, function(data) {
			$("tbody tr").remove();
			var res = JSON.parse(data);
			page = 1;
			showInfoOnTable(res);
			editOrDelete();
		})
	});
}

/*以下是账户*/


/**
 * 用户注册
 * 
 *  @author 芸江
 *  @date 2017年10月19日15:21:11
 **/
function doRegister(username, password, email, gender, career, hobbies) {
	var data = "account.account_username=" + username +
		"&account.account_password=" + password +
		"&account.account_email=" + email +
		"&account.account_gender=" + gender +
		"&account.account_career=" + career +
		"&account.account_hobbies=" + hobbies;

	ajaxRequest("POST", getRootPath_web() + "/user_doRegistered", data, function() {
		alert("注册成功！");
	//$(location).attr('href', 'login.html'); // 跳转到登录页面
	})
}