<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>登陆</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
  <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />

  <%@ include file="include/includes.jsp"%>
  <script src="/js/login/login.js"></script>
  
</head>
<body class="style-3">

<div id="alertBox" class="text-center" style="position: absolute; z-index: 5555; right:20px; top:20px;"></div>

<div class="container">
  <div class="row">
    <div class="col-md-4 col-md-push-8">


      <!-- Start Sign In Form -->
      <form action="#" class="fh5co-form animate-box" data-animate-effect="fadeInRight">
        <h2>用户登录</h2>
        <div class="form-group">
          <label for="username" class="sr-only">邮箱</label>
          <input type="text" class="form-control" id="username" placeholder="邮箱" autocomplete="off">
        </div>
        <div class="form-group">
          <label for="password" class="sr-only">密码</label>
          <input type="password" class="form-control" id="password" placeholder="密码" autocomplete="off">
        </div>
        <div class="form-group">
          <p>没有账号? <a href="/signUp">注册一个</a></p>
        </div>
        <div class="form-group">
          <input type="submit" value="登陆" class="btn btn-primary" onclick="login.login()">
        </div>
      </form>
      <!-- END Sign In Form -->


    </div>
  </div>
  <div class="row" style="padding-top: 60px; clear: both;">
    <div class="col-md-12 text-center"><p><small>&copy; Dintama </small></p></div>
  </div>
</div>



</body>
</html>




