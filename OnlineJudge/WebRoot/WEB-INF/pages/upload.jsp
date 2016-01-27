<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
      <head>
        <base href="<%=basePath%>">
        <title>Uploadify</title>
        <link href="css/default.css" rel="stylesheet" type="text/css" />
        <link href="css/uploadify.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="js/swfobject.js"></script>
        <script type="text/javascript" src="js/jquery.uploadify.v2.1.0.min.js"></script>
        <script type="text/javascript">
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
    </head>
    <body>
        <div id="fileQueue"></div>
        <input type="file" name="uploadify" id="uploadify" />
        <p>
        <a href="javascript:jQuery('#uploadify').uploadifyUpload()">开始上传</a>&nbsp;
        <a href="javascript:jQuery('#uploadify').uploadifyClearQueue()">取消所有上传</a>
        </p>
    </body>
</html>