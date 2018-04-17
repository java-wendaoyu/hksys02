$().ready(function () {
    var  program = {
        userName: "",
        email: "",
        stuNumber: "",
        gender: 0,
        isTeacher: 0,
        school:"",
        className:"",
        userId:0,
        imgPath:"",
        discription:"",
        passwd :"",
        userDetail: function () {
            $.ajax({
                type: "get",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../user/userDetail",
                dataType: 'json',
                async: false,
                data: {},
                success: function (result) {
                    program.userName = result.data.userName;
                    program.school = result.data.school;
                    program.className = result.data.className;
                    program.discription = result.data.discription;
                    program.email = result.data.email;
                    program.isTeacher = result.data.isTeacher;
                    program.imgPath = result.data.imgPath;
                    program.stuNumber = result.data.stuNum;
                    program.userId = result.data.userId;
                    program.gender = result.data.gender;
                    program.passwd = result.data.passwd;
                }
            });
        },
        updateUser:function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../user/updateUser",
                dataType: 'json',
                async: false,
                data: {
                    "userName": program.userName,
                    "stuNum": program.stuNumber,
                    "gender": program.gender,
                    "email": program.email,
                    "isTeacher": program.isTeacher,
                    "school": program.school,
                    "className":program.className,
                    "discription":program.discription,
                    "userId":program.userId,
                    "imgPath":program.imgPath,
                    "passwd":program.passwd
                },
                success: function (result) {
                    if(result.code == 0){
                        program.showMessage(result.code, result.message)
                        location.reload();
                    }else {
                        program.showMessage(result.code, result.message)
                    }
                }
            });
        },
        logout:function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../user/logout",
                dataType: 'json',
                async: false,
                data: {},
                success: function (result) {
                    program.showMessage(result.code, result.message)
                    window.location.href="index.html";
                }
            });
        },
        showMessage: function (code, message) {
            alert(message)
        }
    }
    program.userDetail();
    $("#userProfile").click(function () {
        $("#username").val(program.userName);
        $("#imgPath").val(program.imgPath);
        $("#email").val(program.email);
        $("#Id").val(program.stuNumber);
        $("#school").val(program.school);
        $("#className").val(program.className);
        $("#passwd").val(program.passwd);
        if(program.gender == 0){
            $("#sex").val("男");
        }else{
            $("#sex").val("女");
        }
        if(program.isTeacher == 0){
            $("#role").val("学生");
        }else{
            $("#role").val("老师");
        }
        $("#discip").val(program.discription);
    });

    $("#updateInfo").click(function () {
        program.userName =  $("#username").val();
        program.school =  $("#school").val();
        program.className =  $("#className").val();
        program.discription =  $("#discip").val();
        program.email = $("#email").val();
        program.passwd = $("#passwd").val();
        var teach = $("#role").val()
        if(teach == "老师"){
            program.isTeacher = 1
        }else{
            program.isTeacher = 0
        }
        program.imgPath = $("#imgPath").val();
        program.stuNumber = $("#Id").val();
        program.updateUser();
    });
    $("#dropdownMenuButton").text(program.userName + ", 你好");

    $("#logout").click(function () {
        program.logout();
    });
})