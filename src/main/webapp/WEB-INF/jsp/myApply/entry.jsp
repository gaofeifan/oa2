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
	<form action="${pageContext.request.contextPath }/apply/saveEntry.do" method="post">
		姓名 ： <input type="text" name="username"/>  
		性别 ：
			<select name="sex">
				<option value="男" >男</option>
				<option value="女" >女</option>
			</select><br/>
		部门 ： 	
			<select name="dempid">
				<option value="" >请选择</option>
					<c:forEach items="${demps }" var="demp">
						<option value="${ demp.id}" >${demp.name }</option>
					</c:forEach>
			</select>   
		岗位 ： 
			<select name="postid">
				<option value="" >请选择</option>
					<c:forEach items="${posts }" var="post">
						<option value="${ post.id}" >${post.name }</option>
					</c:forEach>
			</select> 
		<br/>  
		公司 ： 
			<select name="companyId">
				<option value="" >请选择</option>
					<c:forEach items="${companys }" var="company">
						<option value="${ company.id}" >${company.name }</option>
					</c:forEach>
			</select> 
		<br/>  
		公司 ： 
			<c:forEach items="${companys }" var="company">
				<c:if test="${company.id == user.companyid }">${company.name }</c:if>
			</c:forEach>
		<br/>  
		入职时间 ：<input type="text" name="hiredate"/>
		直接上级 ：<input type="text" name="dempUseruserName"/>
		<br/>		
				<input type="submit" value="提交"/>
	</form>
	
</body>
</html>