<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>个人资料</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/hyattoj.css" rel="stylesheet">
<script src="js/jquery-1.11.3.min.js"></script>
<script src="css/hyattoj.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--[if It IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

</head>

<body>
	<!-- 导航栏开始 -->
<div class="navbar navbar-static-top">
  <div class="navbar-inner">
    <div class="container"> <a class="brand" href="#">HITWH-CTF</a>
      <ul class="nav">
        <li><a href="#">首页</a></li>
        <li><a href="#">题目</a></li>
        <li><a href="#">答案公布</a></li>
      </ul>
      <div class="nav pull-right"> <a class="dropdown-toggle navbar-text" data-toggle="dropdown" href="#"><i class="icon-user"></i>Hyatt</a>
        <ul class="dropdown-menu">
          <li><a>我的资料</a></li>
          <li><a>查看排名</a></li>
          <li><a>退出</a></li>
        </ul>
      </div>
      <!--<ul class="nav pull-right">
        <li><a href="#login" data-toggle="modal">登录</a></li>
        <li class="divider-vertical"></li>
        <li><a href="http://localhost:8080/OnlineJudge/registerPage">注册</a></li>
      </ul>--> 
    </div>
  </div>
</div>
<!-- 导航栏结束 -->
<div>
  <div class="container">
    <div class="row">
    	<div class="modal">
    		<div class="modal-header">
            	<h4>个人资料<span class="pull-right"><a href="http://localhost:8080/updateInfo">完善资料</a></span></h4>
            </div>
            <div class="modal-body">
            	<div class="styleprogress">
        			<span>&nbsp;&nbsp;完善度&nbsp;&nbsp;</span><span class="green" style="width: 60%;"><span>60%</span></span>
        		</div>
                <div class="informationItem" style="height:110px;">
                	<div class="informationLabel">
                    	<span>头像</span>
                    </div>
                    <div class="informationContent" style=" height:110px; line-height:110px;">
                    	<span><img src="img/100x100.png"/></span>
                    </div>
                </div>
                <div class="informationItem">
                	<div class="informationLabel">
                    	<span>用户名</span>
                    </div>
                    <div class="informationContent">
                    	<span>赵笑天</span>
                    </div>
                </div>
                 <div class="informationItem">
                	<div class="informationLabel">
                    	<span>昵称</span>
                    </div>
                    <div class="informationContent">
                    	<span>Hyatt</span>
                    </div>
                </div>
                 <div class="informationItem">
                	<div class="informationLabel">
                    	<span>QQ</span>
                    </div>
                    <div class="informationContent">
                    	<span>393504144</span>
                    </div>
                </div>
                 <div class="informationItem">
                	<div class="informationLabel">
                    	<span>邮箱</span>
                    </div>
                    <div class="informationContent">
                    	<span>393504144@qq.com</span>
                    </div>
                </div>
                 <div class="informationItem">
                	<div class="informationLabel">
                    	<span>手机号码</span>
                    </div>
                    <div class="informationContent">
                    	<span>18463102201</span>
                    </div>
                </div>
            </div>
        </div>	
    	
    </div>
  </div>
  
  <!-- 底部开始 -->
  <div class="navbar navbar-fixed-bottom footer">
    <div class="container">
      <p class="muted credit"> Example courtesy <a href="http://martinbean.co.uk">Martin Bean</a> and <a href="http://ryanfait.com/sticky-footer/">Ryan Fait</a>. </p>
    </div>
  </div>
  <!-- 底部结束 --> 
  
</div>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
