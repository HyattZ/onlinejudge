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
<!-- <link href="css/bootstrap-responsive.min.css" rel="stylesheet"> -->
<link href="css/hyattoj.css" rel="stylesheet">
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/hyattoj.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--[if It IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

</head>

<body>
	<div class="container">
		<iframe width="960px" height="750px;"
			src="<%=basePath %>/getPDF?problemid=${requestScope.problemid}"></iframe>
	</div>

	<script src="js/bootstrap.min.js"></script>
</body>
</html>
