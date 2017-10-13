$(function() {
    // 账单类型
    var $input0 = $("input:eq(0)");
    var $warningDiv0 = $(".warningDiv:eq(0)");
    // 账单金额
    var $input1 = $("input:eq(1)");
    var $warningDiv1 = $(".warningDiv:eq(1)");
    // 提交表单
    $("form").submit(function() {
        return true;
    });

    // 界面切换
    $("#formMenu").click(function() {
        $(window).attr('location', 'form.html');
    });
    $("#queryMenu").click(function() {
        $(location).attr('href', 'list.html');
    });
    $("#analizeMenu").click(function() {
        $(window).attr('location', 'analyze.html');
    });

    // 编辑页面跳转
    $(".compileDiv").click(function() {
        $(window).attr('location', 'form.html');
    });

    // 收入查询or支出查询切换
    $("#payIncome_Select").click(function() {
        if ($(this).val() == "收入查询") {
            $("#payIncome_show").text("收入记录");
        } else {
            $("#payIncome_show").text("支出记录");
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

    // 收支分析图:饼图
    var ctx = $("#pie").get(0).getContext("2d");

    var data = {
        datasets: [{
            data: [20, 15],
            backgroundColor: [
                'red',
                'blue'
            ]
        }],
        labels: [
            '收入',
            '支出'
        ],
    };

    var myPieChart = new Chart(ctx, {
        type: 'pie',
        data: data,
        options: null
    });



    // 收入曲线图
    var ctx1 = $("#lineIncome").get(0).getContext("2d");

    var data1 = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [{
            fillColor: "rgba(220,220,220,0.5)",
            strokeColor: "rgba(220,220,220,1)",
            pointColor: "rgba(220,220,220,1)",
            pointStrokeColor: "#fff",
            data: [65, 59, 90, 81, 56, 55, 40]
        }]
    }

    var stackedLine = new Chart(ctx1, {
        type: 'line',
        data: data1,
        options: {
            scales: {
                yAxes: [{
                    stacked: true
                }]
            }
        }
    });


    //支出曲线图
    var ctx2 = $("#linePay").get(0).getContext("2d");

    var data2 = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [{
            fillColor: "rgba(220,220,220,0.5)",
            strokeColor: "rgba(220,220,220,1)",
            pointColor: "rgba(220,220,220,1)",
            pointStrokeColor: "#fff",
            data: [20, 90, 93, 35, 40, 55, 82]
        }]
    }

    var stackedLine = new Chart(ctx2, {
        type: 'line',
        data: data2,
        options: {
            scales: {
                yAxes: [{
                    stacked: true
                }]
            }
        }
    });
});