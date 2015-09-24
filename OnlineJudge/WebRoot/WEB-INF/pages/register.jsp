<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>bootstrapLearn</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/hyattoj.css" rel="stylesheet">
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/hyattoj.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--[if It IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script type="text/javascript" language="javascript">
	$(document).ready(function(e) {
        $("#passwordAgain").blur(function(e) {
            if (!checkPasswordAgain()){
				$("#passwordRepeatError").attr("class","text-error");
				}else{
				$("#passwordRepeatError").attr("class","text-error hide");	
				}
        });
		$("#stuid").blur(function(e) {
			
            if (!checkStuid()){
				$("#stuidError").attr("class","text-error");
			}else{
				$("#stuidError").attr("class","text-error hide");
			}
        });
		$("#username").blur(function(e) {
            if (!checkUsername()){
				$("#UsernameError").attr("class","text-error");
			}else{
				$("#UsernameError").attr("class","text-error hide");
			}
        });
		$("#email").blur(function(e) {
            if (!checkEmail()){
				$("#EmailError").attr("class","text-error");
			}else{
				$("#EmailError").attr("class","text-error hide");
			}
        });
        $("#realname").blur(function(e) {
        
            if (!checkRealname()){
				$("#RealnameError").attr("class","text-error");
			}else{
				$("#RealnameError").attr("class","text-error hide");
			}
        });
		$("#password").blur(function(e) {
            if (!checkPassword()){
				$("#PasswordError").attr("class","text-error");
			}else{
				$("#PasswordError").attr("class","text-error hide");
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
				<a class="brand" href="http://localhost:8080/OnlineJudge/">HITWH-CTF</a>
				<ul class="nav">
					<li><a href="http://localhost:8080/OnlineJudge/">首页</a></li>
					<li><a href="http://localhost:8080/OnlineJudge/problemList">题目</a></li>
					<li><a href="http://localhost:8080/OnlineJudge/showAnswers">答案公布</a></li>
				</ul>
				<s:if test="#session.isLogin">
					<div class="nav pull-right">
						<a class="dropdown-toggle navbar-text" data-toggle="dropdown"
							href="#"><i class="icon-user"></i>Hyatt</a>
						<ul class="dropdown-menu">
							<li><a
								href="http://localhost:8080/OnlineJudge/informationPanel">查看资料</a></li>
							<li><a href="http://localhost:8080/OnlineJudge/logout">退出</a></li>
						</ul>
					</div>
				</s:if>
				<s:else>
					<ul class="nav pull-right">
						<li><a href="http://localhost:8080/OnlineJudge/loginPage"
							data-toggle="modal">登录</a></li>
						<li class="divider-vertical"></li>
						<li><a href="http://localhost:8080/OnlineJudge/registerPage">注册</a></li>
					</ul>

				</s:else>
			</div>
		</div>
	</div>
	<!-- 导航栏结束 -->
	<div>
		<div class="container">
			<div class="row">
				<form class="form-horizontal" action="register" method="post">
					<div class="modal" id="login" style="margin-top:-15px;">
						<div class="modal-header">
							<h4>用户注册</h4>
						</div>
						<div class="modal-body">
							<div class="control-group">
								<div class="controls">
									<input type="text" id="stuid" name="stuid"
										placeholder="请输入学号"><span id="stuidError"
										class="text-error hide"><i class="icon-remove"></i>手机号格式错误！</span>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input type="text" id="username" name="username"
										placeholder="请输入用户名"><span id="UsernameError"
										class="text-error hide"><i class="icon-remove"></i>用户名非法！</span>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input type="text" id="realname" name="realname"
										placeholder="请输入真实姓名"><span id="RealnameError"
										class="text-error hide"><i class="icon-remove"></i>姓名非法！</span>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input type="password" id="password" name="password"
										placeholder="请输入密码"><span id="PasswordError"
										class="text-error hide"><i class="icon-remove"></i>密码格式错误！</span>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input type="password" id="passwordAgain" name="passwordAgain"
										placeholder="请重复输入密码"><span id="passwordRepeatError"
										class="text-error hide"><i class="icon-remove"></i>两次密码不同!</span>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input type="text" id="email" name="email" placeholder="请输入邮箱"><span
										id="EmailError" class="text-error hide"><i
										class="icon-remove"></i>邮箱格式错误！</span>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input type="text" id="authCode" placeholder="验证码"
										name="authCode" style="width:100px;"> <img
										src="http://localhost:8080/OnlineJudge/getAuthCode"
										class="authCodeStyle" id="authCodeImg"> <a
										href="javascript:void(0)" onClick="getAuthCodeAgain()">看不清</a>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">登录</button>
						</div>
					</div>
				</form>
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

	</div>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
