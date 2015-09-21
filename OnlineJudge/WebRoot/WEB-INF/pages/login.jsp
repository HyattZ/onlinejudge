<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>bootstrapLearn</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="css/bootstrap-responsive.min.css" rel="stylesheet"> -->
<link href="css/hyattoj.css" rel="stylesheet">
<script src="js/jquery-1.11.3.min.js"></script>
<script src="css/hyattoj.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--[if It IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script type="text/javascript" language="javascript">
	function getAuthCodeAgain() {
		$("#authCodeImg").attr(
				"src",
				"http://localhost:8080/OnlineJudge/getAuthCode?zxt="
						+ Math.random());
	}
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
					<li><a href="#">题目</a></li>
					<li><a href="#">答案公布</a></li>
				</ul>
				<ul class="nav pull-right">
					<li><a href="http://localhost:8080/OnlineJudge/loginPage"
						data-toggle="modal">登录</a></li>
					<li class="divider-vertical"></li>
					<li><a href="http://localhost:8080/OnlineJudge/registerPage">注册</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 导航栏结束 -->

	<div class="content">
		<div class="container">
			<div class="row">
				<form class="form-horizontal" action="login" method="post">
					<div class="modal" id="login" style="margin-top:50px;">
						<div class="modal-header">
							<h4>用户登录</h4>
						</div>
						<div class="modal-body">
							<div class="control-group">
								<div class="controls">
									<div class="input-prepend">
										<span class="add-on"><i class="icon-user"></i></span> <input
											type="text" id="username" name="username"
											placeholder="请输入用户名">
									</div>
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
