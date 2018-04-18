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
        headline: "",
        problemScore: 0,
        problemType: "",
        answer: "",
        title: "",
        problemId: 0,
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
        queryPaperDetail: function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../paper/paperDetail",
                dataType: 'json',
                async: false,
                data: {
                    "paperId": paperId
                },
                success: function (result) {
                    var problemlist = result.data.problems;
                    var html = ""
                    for (var i = 0; i < problemlist.length; i++) {
                        var problem = problemlist[i];
                        problem.updateId = problem.problemId;
                        problem.canceId = problem.problemId;
                        html += template('paperDetail', problem)
                    }
                    document.getElementById('content').innerHTML = html;
                }
            });
        },
        updateProblem: function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../problem/alterProblem",
                dataType: 'json',
                async: false,
                data: {
                    "problemId": program.problemId,
                    "paperId": paperId,
                    "score": program.problemScore,
                    "headline": program.headline,
                    "answer": program.answer,
                    "title": program.title,
                    "problemType": program.problemType
                },
                success: function (result) {
                    program.showMessage(result.code, result.message)
                }
            });
        },
        deleteProblemById: function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../problem/deleteProblem",
                dataType: 'json',
                async: false,
                data: {
                    "problemId": program.problemId
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
    program.queryPaperDetail();
    $("#title").text("试题:" + program.paperName);
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
    $('.update').click(function () {
        program.problemId = this.id;
        var options = $("#question-type" + program.problemId + " option:selected");
        program.problemType = options.text();
        program.title = $("#title" + program.problemId).val();
        program.problemScore = $("#score" + program.problemId).val();
        program.headline = $("#headline" + program.problemId).val();
        program.answer = $("#answer" + program.problemId).val();
        program.updateProblem();
        location.reload();
    });
    $('.deleteProblem').click(function () {
        program.problemId = this.id;
        program.deleteProblemById();
        location.reload();
    });
});