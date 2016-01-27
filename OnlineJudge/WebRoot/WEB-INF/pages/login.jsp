<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>bootstrapLearn</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="css/bootstrap-responsive.min.css" rel="stylesheet"> -->
<link href="css/hyattoj.css" rel="stylesheet">
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/hyattoj.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--[if It IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script type="text/javascript" language="javascript">
		function getAuthCodeAgain() {
		$("#authCodeImg").attr(
				"src",
				"<%=basePath%>getAuthCode?zxt="
						+ Math.random());
		}
	$(document).ready(function(e) {
		
		$("#email").blur(function(e) {
		
            if (checkEmail()){
				$("#EmailError").attr("class","text-error");
			}else{
				$("#EmailError").attr("class","text-error hide");
			}
			});
			
			$("#submitButton").click(function(e) {
	            if (!checkEmail() &&  $("#password").val() != "" && $("#authCode").val()!=""){
						//这是提交表单
						$("#loginForm").submit();
					}else{
						alert('请填写用户名密码再登录！');
					}
       	 });
	});
</script>
</head>

<body>
	<!-- 导航栏开始 -->
	<div class="navbar navbar-static-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="<%=basePath%>">HITWH-CTF</a>
				<ul class="nav">
					<li><a href="<%=basePath%>">首页</a></li>
					<li><a href="<%=basePath%>problemList">题目</a></li>
					<li><a href="<%=basePath%>showAnswers">答案公布</a></li>
					<s:if test="#session.isLogin">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">我的分数<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="javascript:void(0)">总分:<s:property
											value="#session.score" /></a></li>
								<li><a href="javascript:void(0)">周总分:<s:property
											value="#session.weeklyScore" /></a></li>
							</ul></li>
					</s:if>
				</ul>
				<s:if test="#session.isLogin">
					<div class="nav pull-right">
						<a class="dropdown-toggle navbar-text" data-toggle="dropdown"
							href="#"><i class="icon-user"></i> <s:property
								value="#session.username" /></a>
						<ul class="dropdown-menu">
							<li><a href="<%=basePath%>informationPanel">查看资料</a></li>
							<li><a href="<%=basePath%>logout">退出</a></li>
						</ul>
					</div>
				</s:if>
				<s:else>
					<ul class="nav pull-right">
						<li><a href="<%=basePath%>loginPage">登录</a></li>
						<li class="divider-vertical"></li>
						<li><a href="<%=basePath%>registerPage">注册</a></li>
					</ul>
				</s:else>
			</div>
		</div>
	</div>
	<!-- 导航栏结束 -->
	<div class="content">
		<div class="container">
			<div class="row">

				<div class="modal" id="login" style="margin-top:50px;">
					<div class="modal-header">
						<h4>用户登录</h4>
					</div>
					<form class="form-horizontal" action="login" id="loginForm"
						method="post">
						<div class="modal-body">
							<div class="control-group">
								<div class="controls">
									<div class="input-prepend">
										<span class="add-on"><i class="icon-user"></i></span> <input
											type="text" id="email" name="email" placeholder="请输入邮箱">

									</div>
									<span id="EmailError" class="text-error hide"><i
										class="icon-remove"></i>邮箱不存在！</span>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<div class="input-prepend">
										<span class="add-on"><i class="icon-lock"></i></span> <input
											type="password" id="password" name="password"
											placeholder="请输入密码">
									</div>
								</div>
							</div>

							<div class="control-group">
								<div class="controls">
									<input type="text" id="authCode" placeholder="验证码"
										name="authCode" style="width:100px;"> <img
										src="<%=basePath%>getAuthCode" class="authCodeStyle"
										id="authCodeImg"> <a href="javascript:void(0)"
										onClick="getAuthCodeAgain()">看不清</a>
								</div>
							</div>
						</div>
					</form>
					<div class="modal-footer">
						<button class="btn btn-primary" id="submitButton">登录</button>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- 底部开始 -->
	<div class="navbar navbar-fixed-bottom footer">
		<div class="container">
			<p class="muted credit">
				Example courtesy <a href="http://martinbean.co.uk">Martin Bean</a>
				and <a href="http://ryanfait.com/sticky-footer/">Ryan Fait</a>.
			</p>
		</div>
	</div>
	<!-- 底部结束 -->

	<script src="js/bootstrap.min.js"></script>
</body>
</html>
