$().ready(function () {
    function dialog(){
        $("#mymodal").modal("toggle");
    };
    var program = {
        userName: "",
        password: "",
        email: "",
        stuNumber: "",
        sex: 0,
        isTeacher: 0,
        school:"",
        registAccount: function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../user/regist",
                dataType: 'json',
                async: false,
                data: {
                    "userName": program.userName,
                    "passwd": program.password,
                    "stuNum": program.stuNumber,
                    "gender": program.sex,
                    "email": program.email,
                    "isTeacher": program.isTeacher,
                    "school": program.school
                },
                success: function (result) {
                    if(result.code == 0){
                        program.showMessage(result.code, result.message)
                        window.location.href = "index.html";
                    }else {
                        program.showMessage(result.code, result.message)
                    }
                }
            });
        },
        login:function () {
            $.ajax({
                type: "post",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "../user/login",
                dataType: 'json',
                async: false,
                data: {
                    "userName": program.userName,
                    "passwd": program.password,
                },
                success: function (result) {
                    console.log(result)
                    if(result.code == 0){
                        if(result.data.isTeacher == 1){
                            window.location.href = "teach.html";
                        }else{
                            window.location.href = "student.html";
                        }
                    }else {
                        program.showMessage(result.code, result.message)
                    }
                }
            });
        },
        showMessage: function (code, message) {
            alert(message)
        }
    };

    $('#regist').click(function () {
        program.userName = $('#username').val();
        program.password = $('#passwd').val();
        program.stuNumber = $('#Id').val();
        program.email = $('#email').val();
        program.school = $('#school').val();
        program.sex = $("input[name='sex']:checked").val();
        program.isTeacher = $("input[name='role']:checked").val();
        program.registAccount();
    });
    $('#login').click(function () {
        program.userName = $('#loginName').val();
        program.password = $('#loginPasswd').val();
        program.login();
    })
});