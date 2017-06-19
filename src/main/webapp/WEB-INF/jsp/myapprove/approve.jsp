<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>区域设置</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.ocupload-1.1.2.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath }/myApprove/editOpinion.do" method="post">
		单号：<input type="text" name="number" value="${ entry.number}"/>
		姓名 ： <input type="text" name="username" value="entry.name"/>  
		性别 ：
			<select name="sex">
				<option value="男" >男</option>
				<option value="女" >女</option>
			</select><br/>
		部门 ： 	
			<input name="dempid" value="entry.dempName">
		岗位 ： 
			<input name="postid" value="entry.postName">
		<br/>  
		职级 ： 
			<input name="postId" value="entry.positionName">
		<br/>  
		入职时间 ：<input type="text" name="entry.hiredate"/>
		<br/>
		<c:forEach items="${entry.approves }" var="approve">
				<input name="" value="${approve.approveUserName }     "/><br/>
				<input name="" value="${approve.approvePositionName } "/><br/>
				<input name="" value="${ approve.checkstatus}     "/><br/>
				<input name="" value="${ approve.handleidea}      "/><br/>
				<input name="" value="${ approve.handledate}      "/><br/>
		</c:forEach>
			同意   	:	<input type="radio" name="isOpinion" value="1"/>	
			不同意  	:	<input type="radio" name="isOpinion" value="2"/>	
			驳回上一级:	<input type="radio" name="isOpinion" value="3"/>	
			<br/>
			意见:		<input type="text" name="handleidea" value="">
				<input type="submit" value="提交"/>
	</form>
</body>
</html>