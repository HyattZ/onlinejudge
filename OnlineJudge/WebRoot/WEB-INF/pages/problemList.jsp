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
<script src="css/hyattoj.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--[if It IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

</head>

<body>
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
					<div class="span8 offset2">
						<ul class="breadcrumb">
							<li><a href="#">首页</a> <span class="divider">>></span></li>
							<li class="active"><a href="#">问题列表</a></li>
						</ul>
						<hr>


						<s:if test="#session.isLogin">
							<table class="table table-striped">
								<thead>
									<th>题目编号</th>
									<th>题目</th>
									<th>题目分数</th>
									<th>状态</th>
									<th>剩余次数</th>
								</thead>
								<tbody>
									<s:iterator value="#request.problemListItems">
										<tr>
											<td><s:property value="problemid" /></td>
											<td><a class="navbar-link" href="<%=basePath%>submitFlagPage?problemid=<s:property value="problemid" />"><s:property value="problemtitle" /></a></td>
											<td><s:property value="mark" /></td>
											<td>
												<s:if test="isComplete==1">
													<span><i class="icon-ok"></i></span>
												</s:if>
												<s:elseif test="isComplete==-1">
													<span><i class="icon-remove"></i></span>
												</s:elseif>
											</td>
											<td>
												<s:if test="submitTimes==-1">
													<span>-</span>
												</s:if>
												<s:else>
													<span><s:property value="submitTimes" /></span>
												</s:else>
											</td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</s:if>
						<s:else>
							<table class="table table-striped">
								<thead>
									<th>题目编号</th>
									<th>题目</th>
									<th>题目分数</th>
								</thead>
								<tbody>
									<s:iterator value="#request.problemListItems">
										<tr>
											<td><s:property value="problemid" /></td>
											<td><a class="navbar-link" href="<%=basePath%>submitFlagPage?problemid=<s:property value="problemid" />"><s:property value="problemtitle" /></a></td>
											<td><s:property value="mark" /></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</s:else>


						<%-- <div class="pagination pagination-centered">
							<ul class="pager">
								<li><a
									href="<%=basePath%>problemList?problemPage=${param.problemPage-1}">
										前一页 </a></li>
							</ul>
							<ul>

								<c:forEach var="item" varStatus="status"
									begin="${requestScope.beginIndex}"
									end="${requestScope.endIndex}">
									<li><a
										href="<%=basePath%>problemList?problemPage=${status.index}">${status.index}</a></li>
								</c:forEach>

							</ul>
							<ul class="pager">
								<li><a
									href="<%=basePath%>problemList?problemPage=${param.problemPage+1}">后一页</a></li>
							</ul>
						</div>
 --%>
						<hr>
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
	</div>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>