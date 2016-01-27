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
<link href="css/hyattoj.css" rel="stylesheet">
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link href="css/uploadify.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<script type="text/javascript" src="js/jquery.uploadify.v2.1.0.min.js"></script>
<script src="js/hyattoj.js"></script>
<script type="text/javascript">

	function submitNotice(){
		$.ajax({
			url:'<%=basePath%>addNotice',
			type:"post",
			dataType:"json",
			data:$("#notice").serialize(),
			error: function(){
					alert('添加公告失败！');
				},
			success: function(data){
				//这里一定要把data转换成json格式之后再使用，否则会出错
				data = $.parseJSON(data);
				alert('添加公告成功！');
				}
			});
	}
	
	function submitProblem(){
		$.ajax({
			url:'<%=basePath%>addProblem',
			type:"post",
			dataType:"json",
			data:$("#problem").serialize(),
			error: function(){
					alert('添加问题失败！');
				},
			success: function(data){
				data = $.parseJSON(data);
				alert('添加问题成功！');
				}
			});
	}
	
	function submitRound(){
		$.ajax({
			url:'<%=basePath%>setRound',
			type:"post",
			dataType:"json",
			data:$("#round").serialize(),
			error: function(){
					alert('设置轮数失败！');
				},
			success: function(data){
				data = $.parseJSON(data);
				alert("设置轮数成功！");
				}
			});
	}

        $(document).ready(function() {
            $("#uploadify").uploadify({
                'uploader'       : 'uploadify.swf',
                'fileDataName' : "docs",
                'script'         : 'testUpload',
                'cancelImg'      : 'img/cancel.png',
                'queueID'        : 'fileQueue',
                'auto'           : false,
                'multi'          : true,
                folder			 : 'uploads/',
                'simUploadLimit' : 2,
                'buttonText'     : 'ChooseFile'
            });
        });

        </script>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--[if It IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<body>
	<!-- 导航栏开始 -->
	<div class="navbar navbar-static-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="<%=basePath%>">管理界面</a>
				<s:if test="#session.isLogin">
					<div class="nav pull-right">
						<a class="dropdown-toggle navbar-text" data-toggle="dropdown"
							href="#"><i class="icon-user"></i> <s:property
								value="#session.username" /> </a>
						<ul class="dropdown-menu">
							<li><a href="<%=basePath%>informationPanel">查看资料</a></li>
							<li><a href="<%=basePath%>logout">退出</a></li>
						</ul>
					</div>
				</s:if>
				<s:else>
				</s:else>
			</div>
		</div>
	</div>
	<!-- 导航栏结束 -->

	<div class="content">
		<div class="row">
			<div class="container">

				<div class="accordion accordion-group">
					<form class="form-horizontal" id="round">
						<div class="accordion-heading">
							<h4>轮数管理</h4>
						</div>
						<div class="accordion-inner">
							<div class="control-group">
								<label class="control-label" for="noticetitle">轮数</label>
								<div class="controls">
									<input type="text" name="round" id="round"
										placeholder="请输入当前轮数">
								</div>
							</div>
							<p class="text-success hide" style="font-size:14px;">
								<i class="icon-ok-sign"></i>恭喜，问题发布成功
							</p>
							<p class="text-error hide" style="font-size:14px;">
								<i class="icon-remove-circle"></i>问题发布失败，请重新发布！
							</p>
						</div>
					</form>
					<div class="modal-footer">
						<button class="btn btn-primary" onClick="submitRound()">设置轮数</button>
					</div>
				</div>

			</div>
		</div>
	</div>
	
	<div class="content">
		<div class="row">
			<div class="container">

				<div class="accordion accordion-group">
					<form class="form-horizontal" id="notice">
						<div class="accordion-heading">
							<h4>公告板管理</h4>
						</div>
						<div class="accordion-inner">
							<div class="control-group">
								<label class="control-label" for="noticetitle">公告标题</label>
								<div class="controls">
									<input type="text" name="noticetitle" id="noticetitle"
										placeholder="请输入公告标题">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="noticecontent">公告内容</label>
								<div class="controls">
									<textarea name="noticecontent" id="noticecontent"
										placeholder="请输入公告内容"
										style="height:150px; width:300px; resize:none;"></textarea>
								</div>
							</div>
							<p class="text-success hide" style="font-size:14px;">
								<i class="icon-ok-sign"></i>恭喜，问题发布成功
							</p>
							<p class="text-error hide" style="font-size:14px;">
								<i class="icon-remove-circle"></i>问题发布失败，请重新发布！
							</p>
						</div>
					</form>
					<div class="modal-footer">
						<button class="btn btn-primary" onClick="submitNotice()">发布公告</button>
					</div>
				</div>

			</div>
		</div>

		<div class="row">
			<div class="container">
				<div class="accordion accordion-group">
					<div class="accordion-heading">
						<h4>答案管理</h4>
					</div>
					<div class="accordion-inner text-center">
						<div id="fileQueue" style="margin-right:auto; margin-left:auto;"></div>
						<div>
							<input type="file" name="uploadify" id="uploadify" /> <a
								class="btn btn-inverse" style="margin-bottom:25px;"
								href="javascript:jQuery('#uploadify').uploadifyUpload()">开始上传</a>&nbsp;
							<a class="btn btn-inverse" style="margin-bottom:25px;"
								href="javascript:jQuery('#uploadify').uploadifyClearQueue()">取消所有上传</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="container">

				<div class="accordion accordion-group">

					<div class="accordion-heading">
						<h4>题目管理</h4>
					</div>

					<div class="accordion-inner">
						<form class="form-horizontal" id="problem">
							<div class="control-group">
								<label class="control-label" for="round">题目轮数</label>
								<div class="controls">
									<input type="text" name="round" id="round" placeholder="请输入轮数">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="mark">题目分数</label>
								<div class="controls">
									<input type="text" name="mark" id="mark" placeholder="请输入分数">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="problemtitle">题目标题</label>
								<div class="controls">
									<input type="text" name="problemtitle" id="problemtitle"
										placeholder="请输入题目标题">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="problemcontent">题目内容</label>
								<div class="controls">
									<textarea name="problemcontent" id="problemcontent"
										placeholder="请输入题目内容"
										style="height:150px; width:300px; resize:none;"></textarea>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="flag">题目FLAG</label>
								<div class="controls">
									<input type="text" name="flag" id="flag"
										placeholder="请输入题目FLAG">
								</div>
							</div>

							<p class="text-success hide" style="font-size:14px;">
								<i class="icon-ok-sign"></i>恭喜，公告发布成功
							</p>
							<p class="text-error hide" style="font-size:14px;">
								<i class="icon-remove-circle"></i>公告发布失败，请重新发布！
							</p>
						</form>
					</div>
					<div class="modal-footer">
						<button class="btn btn-primary" onClick="submitProblem()">发表题目</button>
					</div>
				</div>

			</div>
		</div>

	</div>


	<script src="js/bootstrap.min.js"></script>
</body>
</html>