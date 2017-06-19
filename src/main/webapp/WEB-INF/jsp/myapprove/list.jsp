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
<form action="">
	<table cellspacing="1" cellpadding="0" border="0" width="100%"
		class="pn-ltable">
		<thead class="pn-lthead">
			<tr>
				<th>申请类型</th>
				<th>申请单号</th>
				<th>申请摘要</th>
				<th>申请时间</th>
				<th>申请人</th>
				<th>审批结果</th>
			</tr>
		</thead>
		<tbody class="pn-ltbody">

			<c:forEach items="${approves}" var="approve">
				<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'"
					onmouseover="this.bgColor='#eeeeee'">
					<td><input type="checkbox" value="8" name="ids" /></td>
					<td align="center">${approve.id }</td>
					<td align="center">${approve.number }</td>
					<td align="center"><img width="40" height="40"
						src="/res/img/pic/ppp.jpg" /></td>
					<td align="center"></td>
					<td align="center">${brand.sort }</td>
					<td align="center"><c:if test="${brand.isDisplay == 1 }">是</c:if>
						<c:if test="${brand.isDisplay == 0 }">否</c:if></td>
					<td align="center"><a class="pn-opt" href="#">修改</a> | <a
						class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}"
						href="#">删除</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</form>
</body>
</html>