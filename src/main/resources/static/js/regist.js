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
                    "isTeacher": program.isTeacher
                },
                success: function (result) {
                     if(result.code == 0){
                         document.getElementById("dialogs").innerHTML='<h3>' + result.message + '</h3>';
                         dialog();
                         window.location.href = "login.html";
                     }else {
                         document.getElementById("dialogs").innerHTML='<h3>' + result.message + '</h3>';
                         dialog();
                     }
                }
            });
        },
    };

    $('#regist').click(function () {
        program.userName = $('#username').val();
        program.password = $('#password').val();
        program.stuNumber = $('#idnumber').val();
        program.sex = $("input[name='sex']:checked").val();
        program.email = $('#email').val();
        program.isTeacher = $("input[name='role']:checked").val();
        program.registAccount();
    });

});