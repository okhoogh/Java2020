window.onload = function () {
    if(document.getElementById("name"))
        document.getElementById("name").onblur = checkUsername;
    if(document.getElementById("age"))
        document.getElementById("age").onblur = checkAge;
    if(document.getElementById("reset"))
        document.getElementById("reset").onclick = resetState;
    if(document.getElementById("formAdd")) {
        document.getElementById("formAdd").onsubmit = function () {
            return checkUsername() && checkAge();
        }
    }
    if(document.getElementById("formUpdate")) {
        document.getElementById("formUpdate").onsubmit = function () {
            return checkAge();
        }
    }
    if (document.getElementById("btnBack")) {
        document.getElementById("btnBack").onclick = function () {
            history.back();
        }
    }
}

function resetState() {
    document.getElementById("nameDiv").setAttribute("class", "form-group");
    document.getElementById("nameSpan").setAttribute("class", "");
    document.getElementById("ageDiv").setAttribute("class", "form-group");
    document.getElementById("ageSpan").setAttribute("class", "");
}

function checkUsername() {
    // 1.获取用户名
    var name = document.getElementById("name");
    // 2.定义正则表达式
    var reg_name = /^\w{2,12}$/;
    // 3.判断用户名是否符合正则表达式
    var flag = reg_name.test(name.value);
    // 4.处理结果
    if (flag) {
        document.getElementById("nameDiv").setAttribute("class", "form-group has-success has-feedback");
        document.getElementById("nameSpan").setAttribute("class", " glyphicon glyphicon-ok form-control-feedback");
    } else {
        document.getElementById("nameDiv").setAttribute("class", "form-group has-error has-feedback");
        document.getElementById("nameSpan").setAttribute("class", " glyphicon glyphicon-remove form-control-feedback");
    }
    return flag;
}

function checkAge() {
    // 1.获取年龄
    var age = document.getElementById("age");
    // 2.定义正则表达式
    var reg_age = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
    // 3.判断年龄是否符合正则表达式
    var flag = reg_age.test(age.value);
    // 4.处理结果
    if (flag) {
        document.getElementById("ageDiv").setAttribute("class", " has-success has-feedback");
        document.getElementById("ageSpan").setAttribute("class", " glyphicon glyphicon-ok form-control-feedback");
    } else {
        document.getElementById("ageDiv").setAttribute("class", " has-error has-feedback");
        document.getElementById("ageSpan").setAttribute("class", " glyphicon glyphicon-remove form-control-feedback");
    }
    return flag;
}
