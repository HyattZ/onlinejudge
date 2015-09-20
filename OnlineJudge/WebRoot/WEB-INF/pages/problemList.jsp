<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

</head>

<body>
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
<div class="content">
<div class="container">
	<div class="row">
    	<div class="span8 offset2">
    		<ul class="breadcrumb">
            <li><a href="#">首页</a> <span class="divider">>></span></li>
            <li class="active"><a href="#">问题列表</a></li>
          	</ul>
          	<hr>
        	<table class="table table-striped">
        		<thead>
                	<th>题目编号</th>
                    <th>题目</th>
                    <th>题目分数</th>
                </thead>
                <tbody>
                <s:iterator value="#request.problemList">
                	<tr>
    				<td><s:property value="problemid"/></td>
    				<td><s:property value="problemtitle"/></td>
    				<td><s:property value="mark"/></td>
    				</tr>
    			</s:iterator>
    			</tbody>
            </table>
            
           <div class="pagination pagination-centered">
            <ul class="pager">
              <li><a href="http://localhost:8080/OnlineJudge/problemList?problemPage=${param.problemPage-1}"> 前一页  </a></li>
            </ul>
            <ul>
            
            	<c:forEach var="item" varStatus="status" begin="${requestScope.beginIndex}" end="${requestScope.endIndex}">
            			<li><a  href="http://localhost:8080/OnlineJudge/problemList?problemPage=${status.index}">${status.index}</a></li>		
            	</c:forEach>

            </ul>
            <ul class="pager">
              <li><a href="http://localhost:8080/OnlineJudge/problemList?problemPage=${param.problemPage+1}">后一页</a></li>
            </ul>
          </div>
            
            <hr>
        </div>
    </div>
</div>
</div>
<!-- 底部开始 -->
<div class="navbar navbar-fixed-bottom footer">
  <div class="container">
    <p class="muted credit">Example courtesy <a href="http://martinbean.co.uk">Martin Bean</a> and <a href="http://ryanfait.com/sticky-footer/">Ryan Fait</a>.</p>
  </div>
</div>
<!-- 底部结束 --> 
</div>
<script src="js/bootstrap.min.js"></script>
</body>
</html>