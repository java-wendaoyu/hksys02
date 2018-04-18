$().ready(function () {
    var url = decodeURI(window.location.search);
    var courseId = parseInt(url.split("&")[0].split("=")[1]);
    var className = url.split("&")[1].split("=")[1];
    var courseName = url.split("&")[2].split("=")[1];
    var program = {
        paperName: "",
        score: 0,
        startTime: "",
        endTime: "",
        paperId: 0,
        queryPaperByCourse: function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../paper/paperList",
                dataType: 'json',
                async: false,
                data: {
                    "courseId": courseId
                },
                success: function (result) {
                    var html = ""
                    for (var i = 0; i < result.data.length; i++) {
                        var paperInfo = result.data[i];
                        paperInfo.className = className;
                        paperInfo.detailId = paperInfo.paperId;
                        paperInfo.createId = paperInfo.paperId;
                        html += template('papers', paperInfo)
                    }
                    document.getElementById('content').innerHTML = html;
                }
            });
        },
        savePaper: function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../paper/addPaper",
                dataType: 'json',
                async: false,
                data: {
                    "courseId": courseId,
                    "paperName": program.paperName,
                    "score": program.score,
                    "createTime": program.startTime,
                    "endTime": program.endTime
                },
                success: function (result) {
                    if (result.code == 0) {
                        location.reload();
                    } else {
                        program.showMessage(result.code, result.message);
                    }
                }
            });
        },
        deletePaper: function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../paper/deletePaper",
                dataType: 'json',
                async: false,
                data: {
                    "paperId": program.paperId
                },
                success: function (result) {
                    program.showMessage(result.code, result.message);
                    location.reload();
                }
            });
        },
        showMessage: function (code, message) {
            alert(message)
        }
    }
    $("#lastPage").text("课程: " + courseName);
    $("#lastPage").click(function () {
        window.location.href = "course.html?courseId=" + courseId;
    })
    program.queryPaperByCourse();
    $("#savePaper").click(function () {
        program.endTime = $("#endTime").val();
        program.startTime = $("#startTime").val();
        program.score = $("#score").val();
        program.paperName = $("#paperName").val();
        console.log(program.endTime);
        console.log(program.startTime);
        program.savePaper();
    });
    $(".delete").click(function () {
        program.paperId = this.id;
        program.deletePaper();
    });
    $('.createProblem').click(function () {
        window.location.href = "problemCreate.html?paperId=" + this.id
            +"&courseId="+courseId+"&className="+className
        +"&courseName=" + courseName
    });
    $('.paperDetail').click(function () {
        window.location.href = "paperDetail.html?paperId="+this.id
            +"&courseId="+courseId+"&className="+className
            +"&courseName=" + courseName
    });
});