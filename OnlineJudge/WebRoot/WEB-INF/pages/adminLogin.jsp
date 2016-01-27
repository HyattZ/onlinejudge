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
<title>管理员登录</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="css/bootstrap-responsive.min.css" rel="stylesheet"> -->
<link href="css/hyattoj.css" rel="stylesheet">
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/hyattoj.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--[if It IE 9]
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	[endif]-->
	
	<script type="text/javascript">
		function getAuthCodeAgain() {
		$("#authCodeImg").attr(
				"src",
				"<%=basePath%>getAuthCode?zxt="
						+ Math.random());
		}
		$(document).ready(function(e) {
			$("#submitButton").click(function(e) {
	            if ($("#adminname").val() != ""&&  $("#adminpassword").val() != "" && $("#authCode").val()!=""){
						//这是提交表单
						$("#adminLoginForm").submit();
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
				<a class="brand" href="<%=basePath%>">HITWH-CTF管理员登录界面</a>
			</div>
		</div>
	</div>
	<!-- 导航栏结束 -->
	<div class="content">
		<div class="container">
			<div class="row">

				<div class="modal" id="adminLogin" style="margin-top:50px;">
					<div class="modal-header">
						<h4>管理员登录</h4>
					</div>
					<form class="form-horizontal" action="adminLogin" id="adminLoginForm" method="post">
						<div class="modal-body">
							<div class="control-group">
								<div class="controls">
									<div class="input-prepend">
										<span class="add-on"><i class="icon-user"></i></span> <input
											type="text" id="adminname" name="adminname"
											placeholder="请输入用户名">

									</div>

								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<div class="input-prepend">
										<span class="add-on"><i class="icon-lock"></i></span> <input
											type="password" id="adminpassword" name="adminpassword"
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
