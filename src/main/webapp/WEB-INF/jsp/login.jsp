<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>欢迎进入秒杀系统</title>
    <link rel="stylesheet" media="screen" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/reset.css"/>
</head>
<body>
<div id="particles-js">
    <div class="login">
        <div class="login-top">
            管理员登录
        </div>
        <div class="login-center clearfix">
            <div class="login-center-img"><img src="/resources/img/name.png"/></div>
            <div class="login-center-input">
                <input type="text" name="manager_name" id="manager_name" value="" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
                <div class="login-center-input-text">用户名</div>
            </div>
        </div>
        <div class="login-center clearfix">
            <div class="login-center-img"><img src="/resources/img/password.png"/></div>
            <div class="login-center-input">
                <input type="password" name="manager_pwd" id="manager_pwd" value="" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
                <div class="login-center-input-text">密码</div>
            </div>
        </div>
        <div class="login-button" id="login-btn" >
            登录
        </div>
        <div align="center" colot="blue">
            <a href="/seckill/list"><br>用户入口</a>
        </div>
    </div>
    <div class="sk-rotating-plane"></div>
</div>

<!-- scripts -->
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="/resources/js/particles.min.js"></script>
<script src="/resources/js/app.js"></script>
<script>
    /*function login() {
        var managerName = $('#manager_name').val();
        var managerPwd = $('#manager_pwd').val();
        if(managerName==null||managerPwd==null||managerName==""||managerPwd==""){
            alert("用户名或密码为空，请重新输入");
        }else {
            $.post(('/seckill/' + managerName + '/' + managerPwd + '/checklogin'), {}, function (result) {
                if (result && result['state']) {
                    window.location.href = "/seckill/list";
                } else {
                    alert("用户名或密码错误");
                }
            })
        }
    }*/
    $(function () {
        $(document).keydown(function(event){
            if(event.keyCode==13){
                $("#login-btn").click();
            }
        });
        $('#login-btn').click(function () {
            $.ajax({
                type:"POST",
                dataType:"json",
                data:{
                    manager_name :$('#manager_name').val(),
                    manager_pwd : $('#manager_pwd').val()
                },
                url:"/seckill/checklogin",
                success:function (result) {
                    if(result && result.state){
                        window.location.href = "/seckill/manager";

                    }else{
                        alert("用户名或密码错误");
                    }
                }
            })
        })
    })
</script>
</body>
</html>