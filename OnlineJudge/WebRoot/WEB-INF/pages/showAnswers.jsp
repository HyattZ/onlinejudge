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

		<!-- 主体内容部分开始-->
		<div class="content">
			<div class="container">
				<div class="row">
					<div class="span12">
						<ul class="nav nav-tabs">
							<c:forEach var="num"  begin="${requestScope.beginWeek }" end="${requestScope.weekNum }"  varStatus="status">						
							<c:choose>
							<c:when test="${status.first==true}">
								<li class="text-center active"><a href="#week${num }"
									data-toggle="tab">第${num }周</a></li>
							</c:when>
								<c:otherwise>
									<li class="text-center"><a href="#week${num }"
										data-toggle="tab">第${num }周</a></li>
								</c:otherwise>
							</c:choose>

							
							</c:forEach>
						</ul>

						<div class="tab-content">
							<s:iterator value="#request.problemIdMap" id="problemIdMap" status="status">
									<s:if test="#status.first">
									<div class="tab-pane active" id="<s:property value="key"/>">
										<div class="accordion accordion-group">
											<div class="accordion-heading">
												<h4>答案列表</h4>
											</div>
											<div class="accordion-inner">
												<ol>
													<s:iterator value="value">
														<li class="answerlist"><a class="answerlist"
															href="<%=basePath%>showAnswer?problemid=<s:property value="problemid"/>"><s:property
																	value="problemtitle" /></a></li>
													</s:iterator>

												</ol>
											</div>
										</div>
									</div>
									</s:if>
									<s:else>
										<div class="tab-pane" id="<s:property value="key"/>">
										<div class="accordion accordion-group">
											<div class="accordion-heading">
												<h4>答案列表</h4>
											</div>
											<div class="accordion-inner">
												<ol>
													<s:iterator value="value">
														<li class="answerlist"><a class="answerlist"
															href="<%=basePath%>showAnswer?problemid=<s:property value="problemid"/>"><s:property
																	value="problemtitle" /></a></li>
													</s:iterator>

												</ol>
											</div>
										</div>
									</div>
									</s:else>
									</s:iterator>
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
