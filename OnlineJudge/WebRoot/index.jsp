<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
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
<script type="text/javascript">
	
	$(document).ready(function(e) {
		
        //网页准备好之后加载排行榜
		loadRank(1);
		loadWeeklyRank(1);
		loadNotice();
    });
    
</script>
<style type="text/css">
	#noticetitle{
		font-size:16px;
		font-weight:bold;
		font-style:italic;
	}
	#noticecontent{
		font-size:14px;
		text-indent:2em;
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

		<!-- 主体内容部分开始-->
		<div class="content">
			<div class="container">
				<div class="row">
					<!-- 展示排行榜 -->
					<div class="span7">

						<ul class="nav nav-tabs">
							<li class="active"><a href="#TotalRank" data-toggle="tab">总榜</a></li>
							<li><a href="#WeekRank" data-toggle="tab">周榜</a></li>
						</ul>

						<div class="tab-content">

							<div class="tab-pane active" id="TotalRank">
								<table class="table table-striped" id="rank">

								</table>
								<div class="pagination pagination-centered">
									<ul class="pager">
										<li><a
											id="prevRankPage">
												前一页 </a></li>
									</ul>
									<ul id="rankPagination">

									</ul>
									<ul class="pager">
										<li><a id="nextRankPage">后一页</a></li>
									</ul>
								</div>
							</div>

							<div class="tab-pane" id="WeekRank">
								<table class="table table-striped" id="weeklyRank">
								</table>
								
							<div class="pagination pagination-centered">
									<ul class="pager">
										<li><a
											id="prevWeeklyRankPage">
												前一页 </a></li>
									</ul>
									<ul id="weeklyRankPagination">

									</ul>
									<ul class="pager">
										<li><a id="nextWeeklyRankPage">后一页</a></li>
									</ul>
								</div>
								
							</div>
						</div>
					</div>

					<!-- 展示公告板 -->
					<div class="span5 board">
						<div class=" accordion accordion-group">
							<div class="accordion-heading text-center">
								<h4>公告板</h4>
							</div>
							<div class="accordion-inner" style="height:220px;">
								<div id="noticetitle">
									<p>开会通知</p>
								</div>
								<div id="noticecontent" style="height:160px;">
									<p>今晚十点开会！</p>
								</div>
								<p class="pull-right" id="posttime">2015-05-08 14:20:10</p>
							</div>
							<div class="modal-footer">
								<a href="showNotices">查看更多公告>></a>
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
