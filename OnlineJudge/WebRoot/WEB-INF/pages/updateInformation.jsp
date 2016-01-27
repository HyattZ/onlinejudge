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
	function updateUserInfo(){
		if(checkUsername() && checkRealname() && checkQQ() && checkPhonenum()){
			$.ajax({
				url:'<%=basePath%>updateUserInfo',
				type:"post",
				dataType:"json",
				data:$("#userInfo").serialize(),
				error: function(){
						alert('更新信息失败！');
					},
				success: function(data){
					data = $.parseJSON(data);
					alert('更新信息成功！');
					}
				});
			}else{
				alert('参数非法');
			}
	}
	
	function updatePassword(){
		if (checkPassword() && checkPasswordAgain() && $("oripassword").val != ""){
			$.ajax({
				url:'<%=basePath%>updatePassword',
				type:"post",
				dataType:"json",
				data:$("#passwordInfo").serialize(),
				error: function(){
						alert('更新密码失败！');
					},
				success: function(data){
					data = $.parseJSON(data);
					if (data.status){
						alert('更新密码成功！');
					}else{
						alert('更新密码失败:'+data.message);
					}
					}
				});
			}else{
				alert('参数错误');
			}
	}
	
	$(document).ready(function(e) {
		$("#passwordAgain").blur(function(e) {
			if (!checkPasswordAgain()) {
				$("#passwordRepeatError").attr("class", "text-error");
			} else {
				$("#passwordRepeatError").attr("class", "text-error hide");
			}
		});

		$("#username").blur(function(e) {
			if (!checkUsername()) {
				$("#UsernameError").attr("class", "text-error");
			} else {
				$("#UsernameError").attr("class", "text-error hide");
			}
		});

		$("#realname").blur(function(e) {

			if (!checkRealname()) {
				$("#RealnameError").attr("class", "text-error");
			} else {
				$("#RealnameError").attr("class", "text-error hide");
			}
		});
		$("#password").blur(function(e) {
			if (!checkPassword()) {
				$("#PasswordError").attr("class", "text-error");
			} else {
				$("#PasswordError").attr("class", "text-error hide");
			}
		});
		$("#phonenum").blur(function(e) {
			if (!checkPhonenum()) {
				$("#phonenumError").attr("class", "text-error");
			} else {
				$("#phonenumError").attr("class", "text-error hide");
			}
		});
		$("#qq").blur(function(e) {
			if (!checkQQ()) {
				$("#qqError").attr("class", "text-error");
			} else {
				$("#qqError").attr("class", "text-error hide");
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
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">我的分数<span class="caret"></span></a>
                        	<ul class="dropdown-menu">
                            	<li><a href="javascript:void(0)">总分:<s:property value="#session.score"/></a></li>
                                <li><a href="javascript:void(0)">周总分:<s:property value="#session.weeklyScore"/></a></li>
                            </ul>
                        </li>
                        </s:if>
					</ul>
					<s:if test="#session.isLogin">
						<div class="nav pull-right">						
							<a class="dropdown-toggle navbar-text" data-toggle="dropdown"
								href="#"><i class="icon-user"></i>
							<s:property value="#session.username" /></a>
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
				<div class="span7 offset2">
					<!--表头-->
					<ul class="nav nav-tabs">
						<li class="active"><a href="#updateInfo" data-toggle="tab">更改资料</a></li>
						<li><a href="#updatePassword" data-toggle="tab">更改密码</a></li>
					</ul>

					<div class="tab-content">
						<!--更改资料-->
						<div class="tab-pane active" id="updateInfo">
							<form class="form-horizontal" id="userInfo">
								<div class="control-group">
									<label class="control-label" for="username">用户名</label>
									<div class="controls">
										<input type="text" id="username" name="username"
											value="<s:property value="#request.user.username"/>"
											placeholder="请输入用户名"><span id="UsernameError"
											class="text-error hide"><i class="icon-remove"></i>用户名非法！</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="realname">真实姓名</label>
									<div class="controls">
										<input type="text" id="realname" name="realname"
											value="<s:property value="#request.user.realname"/>"
											placeholder="请输入真实姓名"><span id="RealnameError"
											class="text-error hide"><i class="icon-remove"></i>姓名非法！</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="qq">QQ</label>
									<div class="controls">
										<input type="text" id="qq" name="qq" placeholder="请输入qq"
											value="<s:property value="#request.user.qq"/>"><span
											id="qqError" class="text-error hide"><i
											class="icon-remove"></i>QQ格式错误！</span>
									</div>
								</div>
								<div class="control-group">
								<label class="control-label" for="phonenum">手机号</label>
									<div class="controls">
										<input type="text" id="phonenum" name="phonenum"
											placeholder="请输入手机号"
											value="<s:property value="#request.user.phonenum"/>"><span
											id="phonenumError" class="text-error hide"><i
											class="icon-remove"></i>手机号格式错误！</span>
									</div>
								</div>
							</form>
							<div class="modal-footer">
								<button onClick="updateUserInfo()" class="btn btn-primary">更改资料</button>
							</div>

						</div>
						<!--更改密码-->
						<div class="tab-pane" id="updatePassword">
							<form class="form-horizontal" id="passwordInfo">
								<div class="control-group">
									<label class="control-label" for="oripassword">原密码</label>
									<div class="controls">
										<input type="password" id="oripassword" name="oripassword"
											placeholder="请输入原始密码">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="password">新密码</label>
									<div class="controls">
										<input type="password" id="password" name="password"
											placeholder="请输入密码"><span id="PasswordError"
											class="text-error hide"><i class="icon-remove"></i>密码格式错误！</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="passwordAgain">重复新密码</label>
									<div class="controls">
										<input type="password" id="passwordAgain" name="passwordAgain"
											placeholder="请重复输入密码"><span id="passwordRepeatError"
											class="text-error hide"><i class="icon-remove"></i>两次密码不同!</span>
									</div>
								</div>
							</form>
							<div class="modal-footer">
								<button onClick="updatePassword()" class="btn btn-primary">更改密码</button>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/bootstrap.min.js"></script>
</body>
</html>
