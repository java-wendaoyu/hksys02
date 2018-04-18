$().ready(function () {
    var url = window.location.search;
    var courseId = parseInt(url.split("=")[1]);
    var program = {
        courseName: "",
        discription: "",
        teacherId: "",
        className: "",
        term: "",
        means: "",
        teacherName: "",
        start: 0,
        rows: 20,
        courseDetail: function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../course/courseDetail",
                dataType: 'json',
                async: false,
                data: {
                    "courseId": courseId
                },
                success: function (result) {
                    program.courseName = result.data.courseName;
                    program.discription = result.data.discription;
                    program.teacherId = result.data.teacherId;
                    program.className = result.data.className;
                    program.term = result.data.term;
                    program.means = result.data.means;
                    program.teacherName = result.data.teacherName;
                }
            });
        },
        queryUserByCourse:function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../user/queryByCourse",
                dataType: 'json',
                async: false,
                data: {
                    "courseId": courseId
                },
                success: function (result) {
                    var html = "";
                    for (var i = 0; i < result.data.length; i++) {
                        var userInfo = result.data[i];
                        userInfo.index = i+1;
                        if(userInfo.gender == 0){
                            userInfo.sex = "男";
                        }else{
                            userInfo.sex = "女";
                        }
                        html += template('users',userInfo)
                    }
                    document.getElementById('content').innerHTML = html;
                }
            });
        }
    }
    program.courseDetail();
    $('.active').text("课程: " + program.courseName);
    $('.h4').text(program.courseName);
    $("#teacher").text ("授课教师: " + program.teacherName);
    $("#class").text ("班级: " + program.className);
    $('.info').text("课程描述: " + program.discription);
    $("#showUser").click(function () {
        program.queryUserByCourse();
    })
    $("#paperList").click(function () {
        window.location.href = "paperList.html?courseId="+courseId+"&className="+program.className +"&courseName=" +program.courseName;
    });
});