$().ready(function () {
    var program = {
        courseId: 0,
        courseName: "",
        discription: "",
        teacherId: "",
        className: "",
        term: "",
        means: "",
        start: 0,
        rows: 20,
        queryCourse: function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../course/queryCourseByUser",
                dataType: 'json',
                async: false,
                data: {},
                success: function (result) {
                    var html = " <div class=\"card card-block text-center\" style=\"float: left;width: 33.33%;\">\n" +
                        "            <button type=\"button\" class=\"btn btn-light\" data-toggle=\"modal\" data-target=\"#addLesson\">\n" +
                        "                <div class=\"add\">添加课程</div>\n" +
                        "            </button>\n" +
                        "        </div>"
                    for (var i = 0; i < result.data.length; i++) {
                       html += template('course', result.data[i])
                    }
                    document.getElementById('content').innerHTML = html;
                    $(".divClick").click(function () {
                        var id = this.id;
                        window.location.href = "course.html?courseId="+id;
                    })
                }
            });
        },
        courseSave: function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../course/addCourse",
                dataType: 'json',
                async: false,
                data: {
                    courseName: program.courseName,
                    discription: program.discription,
                    className: program.className,
                    term: program.term,
                    means: program.means
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
        showMessage: function (code, message) {
            alert(message)
        }
    };
    program.queryCourse();
    $("#courseSave").click(function () {
        program.courseName = $("#courseName").val();
        program.discription = $("#discr").val();
        program.className = $("#grade").val();
        program.term = $("#term").val();
        program.means = $("#courseMeans").val();
        program.courseSave();
    });
})