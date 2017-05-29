<%--
  Created by IntelliJ IDEA.
  User: Dintama
  Date: 2017/5/26
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>注册</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
  <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
  <%@ include file="include/includes.jsp"%>
  <script src="/static/js/login/login.js"></script>

</head>
<body class="style-3">

<div id="alertBox" class="text-center" style="position: absolute; z-index: 5555; right:20px; top:20px;"></div>

<div class="container">
  <div class="row">
    <div class="col-md-4 col-md-push-8">


      <!-- Start Sign In Form -->
      <form action="#" class="fh5co-form animate-box" data-animate-effect="fadeInRight">
        <h2>注册</h2>
        <div class="form-group">
          <label for="name" class="sr-only">昵称</label>
          <input type="text" class="form-control" id="name" placeholder="昵称" autocomplete="off">
        </div>
        <div class="form-group">
          <label for="email" class="sr-only">邮箱</label>
          <input type="email" class="form-control" id="email" placeholder="邮箱" autocomplete="off">
        </div>
        <div class="form-group">
          <label for="password" class="sr-only">密码</label>
          <input type="password" class="form-control" id="password" placeholder="密码" autocomplete="off">
        </div>
        <div class="form-group">
          <label for="re-password" class="sr-only">再次输入密码</label>
          <input type="password" class="form-control" id="re-password" placeholder="再次输入密码" autocomplete="off">
        </div>
        <div class="form-group">
          <p>已经注册？ <a href="/login">登陆</a></p>
        </div>
        <div class="form-group">
          <input type="submit" value="注册" class="btn btn-primary" onclick="login.signUp()">
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

