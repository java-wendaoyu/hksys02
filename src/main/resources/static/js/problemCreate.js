$().ready(function () {
    var url = decodeURI(window.location.search);
    var paperId = parseInt(url.split("&")[0].split("=")[1]);
    var courseId = parseInt(url.split("&")[1].split("=")[1]);
    var className = url.split("&")[2].split("=")[1];
    var courseName = url.split("&")[3].split("=")[1];
    var program = {
        paperName: "",
        startTime: "",
        endTime: "",
        score: 0,
        headline:"",
        problemScore:0,
        problemType:"",
        answer:"",
        title:"",
        queryPaper: function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../paper/findPaper",
                dataType: 'json',
                async: false,
                data: {
                    "paperId": paperId
                },
                success: function (result) {
                   program.paperName = result.data.paperName;
                   program.score = result.data.score;
                   program.startTime = result.data.createTime;
                   program.endTime = result.data.endTime;
                }
            });
        },
        addProblem:function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../problem/addProblem",
                dataType: 'json',
                async: false,
                data: {
                    "paperId": paperId,
                    "score":program.problemScore,
                    "headline":program.headline,
                    "answer":program.answer,
                    "title":program.title,
                    "problemType":program.problemType
                },
                success: function (result) {
                  program.showMessage(result.code, result.message)
                }
            });
        },
        showMessage: function (code, message) {
            alert(message)
        }
    };
    program.queryPaper();
    $("#title").text("试题:" +program.paperName);
    $("#course").text("课程:" + courseName);
    $("#allScore").text("总分:" + program.score);
    $("#startTime").text("开始时间:" + program.startTime);
    $("#endTime").text("结束时间:" + program.endTime);
    $("#course").click(function () {
        window.location.href = "course.html?courseId=" + courseId;
    });
    $("#paperList").click(function () {
        window.location.href = "paperList.html?courseId="
            + courseId + "&className=" + courseName + "&courseName=" + courseName;
    });
    $("#save").click(function () {
        var options = $("#question-type option:selected");
        program.problemType = options.text();
        program.title = $("#proTitle").val();
        program.problemScore= $("#proScore").val();
        program.headline = $("#headline").val();
        program.answer = $("#answer").val();
        program.addProblem();
        window.location.href = "paperList.html?courseId="
            + courseId + "&className=" + courseName + "&courseName=" + courseName;
    });
    $("#saveAndAdd").click(function () {
        var options = $("#question-type option:selected");
        program.problemType = options.text();
        program.title = $("#proTitle").val();
        program.problemScore= $("#proScore").val();
        program.headline = $("#headline").val();
        program.answer = $("#answer").val();
        program.addProblem();
        location.reload()
    });
    $("#cancel").click(function () {
        window.location.href = "paperList.html?courseId="
            + courseId + "&className=" + courseName + "&courseName=" + courseName;
    });

});