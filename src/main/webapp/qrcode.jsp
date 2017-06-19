<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>显示页面</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        .box{width:400px;height:300px;margin:0 auto;
        border:1px solid #39b2e2;text-align:center;
        color:red;}
    </style>
  </head>
  <body>
    <div class="box">
        <h2>扫一扫开启爱的密码</h2>
        <img src="http://10.0.0.127:8086/oa/PrintTwoBarCodeServlet?code=http://blog.csdn.net/lmb55">
    </div>
  </body>
</html>
