<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>bootstrapLearn</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/hyattoj.css" rel="stylesheet">
<script src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/hyattoj.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--[if It IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<style type="text/css">
.answerlist {
	height: 60px;
	line-height: 60px;
	color: #999;
	font-size: 18px;
	margin-left: 30px;
}
</style>
</head>

<body>
	<!-- 网页主体开始-->
	<div class="main">
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
									href="http://localhost:8080/OnlineJudge/infomationPanel">查看资料</a></li>
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

		<!-- 主体内容部分开始-->
		<div class="content">
			<div class="container">
				<div class="row">
					<div class="span12">
						<ul class="nav nav-tabs">
							<li class="text-center active"><a href="#week1"
								data-toggle="tab">第一周</a></li>
							<li class="text-center"><a href="#week2" data-toggle="tab">第二周</a></li>
							<li class="text-center"><a href="#week3" data-toggle="tab">第一周</a></li>
							<li class="text-center"><a href="#week4" data-toggle="tab">第一周</a></li>
							<li class="text-center"><a href="#week5" data-toggle="tab">第一周</a></li>
							<li class="text-center"><a href="#week6" data-toggle="tab">第一周</a></li>
						</ul>

						<div class="tab-content">
							<!--week1-->
							<div class="tab-pane active" id="week1">
								<div class="accordion accordion-group">
									<div class="accordion-heading">
										<h4>答案列表1</h4>
									</div>
									<div class="accordion-inner">
										<ol>
											<li class="answerlist">hehehehheh</li>
											<li class="answerlist">hehehehheh</li>
											<li class="answerlist">hehehehheh</li>
											<li class="answerlist">hehehehheh</li>
											<li class="answerlist">hehehehheh</li>
										</ol>
									</div>
								</div>
							</div>
							<!--week2-->
							<div class="tab-pane" id="week2">
								<div class="accordion accordion-group">
									<div class="accordion-heading">
										<h4>答案列表2</h4>
									</div>
									<div class="accordion-inner">
										<ol>
											<li class="answerlist">hehehehheh</li>
											<li class="answerlist">hehehehheh</li>
											<li class="answerlist">hehehehheh</li>
											<li class="answerlist">hehehehheh</li>
											<li class="answerlist">hehehehheh</li>
										</ol>
									</div>
								</div>
							</div>
							<!--week3-->
							<div class="tab-pane" id="week3">
								<div class="accordion accordion-group">
									<div class="accordion-heading">
										<h4>答案列表3</h4>
									</div>
									<div class="accordion-inner">
										<ol>
											<li class="answerlist">hehehehheh</li>
											<li class="answerlist">hehehehheh</li>
											<li class="answerlist">hehehehheh</li>
											<li class="answerlist">hehehehheh</li>
											<li class="answerlist">hehehehheh</li>
										</ol>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 主体内容部分结束-->

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

		<!--登录表单-->
		<div class="modal hide fade" id="login">
			<div class="modal-header">
				<a href="#" class="close" data-dismiss="modal">×</a>
				<h4>用户登录</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<label class="control-label"></label>
					<div class="input-prepend">
						<i class="add-on icon-user"></i> <input type="text" id="username">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">登录</button>
			</div>
		</div>
	</div>
	<!-- 网页主体结束-->

	<script src="js/bootstrap.min.js"></script>
</body>
</html>
