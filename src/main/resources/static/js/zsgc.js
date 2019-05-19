var httpUrl = "http://localhost:8080";
//    发送get请求
function testRestfulGet() {
    $.ajax({
        type: "GET",
        url: httpUrl + "/testRest/11",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        success: function (result) {
            console.log(result);
        },
        error: function () {
            console.log('错误')
        }
    })
}
//发送post请求
function testRestfulPost(){
    var datas = {id:"123456"};
    $.ajax({
        type: "POST",
        url: httpUrl + "/testRest",
        dataType:"json",
        data: JSON.stringify(datas),
        contentType:"application/json;charset=utf-8",
        success: function (result) {
            console.log(result);
        },
        error:function () {
            console.log('错误')
        }
    })
}
//发送delete请求
function testRestfulDelete(){
    var datas = {id:"123456"};
    $.ajax({
        type: "DELETE",
        url: httpUrl + "/testRest",
        dataType:"json",
        data:JSON.stringify(datas),
        contentType:"application/json;charset=utf-8",
        success: function (result) {
            console.log(result);
        },
        error:function () {
            console.log('错误')
        }
    })
}
//发送put请求
function testRestfulPut(){
    var datas = {id:"123456"};
    $.ajax({
        type: "PUT",
        url: httpUrl + "/testRest",
        dataType:"json",
        data:JSON.stringify(datas),
        contentType:"application/json;charset=utf-8",
        success: function (result) {
            console.log(result);
        },
        error:function () {
            console.log('错误')
        }
    })
}

$(function(){
    $("[name='uname']").blur(function(){
        $.ajax({
            method:"post",
            data:"uname="+$(this).val(),
            url:"<%=request.getContextPath()%>/user.action?act=queryByUname",
            success : function(data) {
                //alert("data=" + data);
                if (data == "true") {//重复
                    $("#unameSpan").css("color","red");
                    $("#unameSpan").html("用户名已经被使用，请修改。");
                    $("[type='submit']").attr("disabled", "true"); //禁用按钮
                } else {
                    $("#unameSpan").css("color","green");
                    $("#unameSpan").html("用户名可以使用。");
                    $("[type='submit']").removeAttr("disabled"); //启用按钮
                }
            }
        });
    });
})