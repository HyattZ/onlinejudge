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
<script type="text/javascript">
	
	$(document).ready(function(e) {
        //网页准备好之后加载排行榜
		loadRank();
		loadNotice();
    });
</script>
	
</head>

<body>
<!-- 网页主体开始-->
<div class="main"> 
  <!-- 导航栏开始 -->
  <div class="navbar navbar-static-top">
    <div class="navbar-inner">
      <div class="container"> <a class="brand" href="http://localhost:8080/OnlineJudge/">HITWH-CTF</a>
        <ul class="nav">
          <li><a href="http://localhost:8080/OnlineJudge/">首页</a></li>
          <li><a href="http://localhost:8080/OnlineJudge/problemList">题目</a></li>
          <li><a href="http://localhost:8080/OnlineJudge/showAnswers">答案公布</a></li>
        </ul>
        <s:if test="#session.isLogin">
      	<ul class="nav pull-right">
        <li><a href="#login" data-toggle="modal">登录</a></li>
        <li class="divider-vertical"></li>
        <li><a href="http://localhost:8080/OnlineJudge/registerPage">注册</a></li>
      	</ul>
      </s:if>
      <s:else>
      <div class="nav pull-right">
		<a class="dropdown-toggle navbar-text" data-toggle="dropdown" href="#"><i class="icon-user"></i>Hyatt</a>
        <ul class="dropdown-menu">
        	<li><a>查看资料</a></li>
            <li><a>退出</a></li>
        </ul>
      </div>
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
          <ul class="breadcrumb">
            <li><a href="#">首页</a> <span class="divider">>></span></li>
            <li class="active"><a href="#">排行榜</a></li>
          </ul>
          <table class="table table-striped" id="rank">
            
            <th> 
              <td>排名</td>
              <td>昵称</td>
              <td>分数</td>
            </th>
          
          </table>
          <div class="pagination pagination-centered">
            <ul class="pager">
              <li><a href="#"> 前一页  </a></li>
            </ul>
            <ul>
              <li><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li><a href="#">3</a></li>
              <li><a href="#">4</a></li>
            </ul>
            <ul class="pager">
              <li><a href="#">后一页</a></li>
            </ul>
          </div>
        </div>
        
        <!-- 展示公告板 -->
        <div class="span5 board">
          <div class=" accordion accordion-group">
            <div class="accordion-heading">
              <h4>公告板</h4>
            </div>
            <div class="accordion-inner" style="height:250px;"> 
            	<div id="noticetitle">开会通知</div>
              	<div id="noticecontent">今晚十点开会！</div>
              	<div id="posttime"><p class="pull-right">2015-05-08 14:20:10</p></div>
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
      <p class="muted credit">Example courtesy <a href="http://martinbean.co.uk">Martin Bean</a> and <a href="http://ryanfait.com/sticky-footer/">Ryan Fait</a>.</p>
    </div>
  </div>
  <!-- 底部结束 --> 
  
  <!--登录表单-->
  <div class="modal hide fade" id="login">
    <div class="modal-header"> <a href="#" class="close" data-dismiss="modal">×</a>
      <h4>用户登录</h4>
    </div>
    <div class="modal-body">
      <form class="form-horizontal">
     
          <label class="control-label"></label>
          <div class="input-prepend">
            	<i class="add-on icon-user"></i><input type="text" id="username">
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

