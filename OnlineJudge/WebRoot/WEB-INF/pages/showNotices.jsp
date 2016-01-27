<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>公告</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/hyattoj.css" rel="stylesheet">
<script src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/hyattoj.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--[if It IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script type="text/javascript">
	$(document).ready(function(e) {
		loadNoticeList(1);	
    });
</script>
</head>

<body>
	<!-- 网页主体开始-->
	<div class="main">
		<!-- 导航栏开始 -->
		<div class="navbar navbar-static-top">
			<div class="navbar-inner">
				<div class="container">
					<a class="brand" href="<%=basePath%>">在线答题</a>
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

		<!-- 主体内容部分开始-->

		<div class="content">
			<div class="container">
				<div class="row span10 offset1" id="notices">
					
				</div>
				<div class="pagination pagination-centered">
						<ul class="pager">
							<li><a id="prevNoticePage"> 前一页 </a></li>
						</ul>
						<ul id="noticePagination">

						</ul>
						<ul class="pager">
							<li><a id="nextNoticePage">后一页</a></li>
						</ul>
					</div>
			</div>
		</div>
	</div>
	<!-- 主体内容部分结束-->

	<script src="js/bootstrap.min.js"></script>
</body>
</html>
