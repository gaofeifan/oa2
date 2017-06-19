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
	<form action="${pageContext.request.contextPath }/flow/save.do" method="post">
		编号 ： <input type="text" name="number"/><br/>
		名称 ： <input type="text" name="name"/><br/>
		节点 ：<input type="text" name="node" value="1"/><br/>
		<tr>
			<td>
				审批职位 ： 
				<select name="positionid">
						<option value="" >请选择</option>
					<c:forEach items="${positions }" var="position">
						<option value="${ position.id}" >${position.name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		</br>
		<tr>
			<td>
			审批结束 ： 
				<input type="checkbox" name="overnode" value="1" >
				<select name="overposition">
						<option value="" >请选择</option>
					<c:forEach items="${positions }" var="position">
						<option value="${position.id }">${position.name }</option> 					
					</c:forEach>
				</select>
			</td>
		</tr>
		</br>
		加签到人事 : <input type="radio" name="addpersonnel" value="1" /><br/>
		节点 ：<input type="text" name="node" value="2"/><br/>
		<tr>
			<td>
				审批职位 ： 
				<select name="positionid">
						<option value="" >请选择</option>
					<c:forEach items="${positions }" var="position">
						<option value="${ position.id}">${position.name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		</br>
		<tr>
			<td>
			审批结束 ： 
				<input type="checkbox" name="overnode" value="2"/>
				<select name="overposition">
						<option value="" >请选择</option>
					<c:forEach items="${positions }" var="position">
						<option value="${position.id }">${position.name }</option> 					
					</c:forEach>
				</select>
			</td>
		</tr>
		</br>
		加签到人事 : <input type="radio" name="addpersonnel" value="2"/><br/>

		节点 ：<input type="text" name="node" value="3"/><br/>
		<tr>
			<td>
				审批职位 ： 
				<select name="positionid">
						<option value="" >请选择</option>
					<c:forEach items="${positions }" var="position">
						<option value="${ position.id}">${position.name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		</br>
		<tr>
			<td>
			审批结束 ： 
				<input type="checkbox" name="overnode" value="3"/>
				<select name="overposition">
						<option value="" >请选择</option>
					<c:forEach items="${positions }" var="position">
						<option value="${position.id }">${position.name }</option> 					
					</c:forEach>
				</select>
			</td>
		</tr>
		</br>
		加签到人事 : <input type="radio" name="addpersonnel" value="3"/><br/>
		
		节点 ：<input type="text" name="node" value="4"/><br/>
		<tr>
			<td>
				审批职位 ： 
				<select name="positionid">
						<option value="" >请选择</option>
					<c:forEach items="${positions }" var="position">
						<option value="${ position.id}">${position.name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		</br>
		<tr>
			<td>
			审批结束 ： 
				<input type="checkbox" name="overnode" value="4"/>
				<select name="overposition">
						<option value="" >请选择</option>
					<c:forEach items="${positions }" var="position">
						<option value="${position.id }">${position.name }</option> 					
					</c:forEach>
				</select>
			</td>
		</tr>
		</br>
		加签到人事 : <input type="radio" name="addpersonnel" value="4"/><br/>
		节点 ：<input type="text" name="node" value="5"/><br/>
		<tr>
			<td>
				审批职位 ： 
				<select name="positionid">
						<option value="" >请选择</option>
					<c:forEach items="${positions }" var="position">
						<option value="${ position.id}">${position.name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		</br>
		<tr>
			<td>
			审批结束 ： 
				<input type="checkbox" name="overnode" value="5"/>
				<select name="overposition">
						<option value="" >请选择</option>
					<c:forEach items="${positions }" var="position">
						<option value="${position.id }">${position.name }</option> 					
					</c:forEach>
				</select>
			</td>
		</tr>
		</br>
		加签到人事 : <input type="radio" name="addpersonnel" value="5"/><br/>
		
		描述	：<input type="text" name="description"></br>
		适用公司	：
		<tr>
			<td>
				<select name="companys">
					<c:forEach items="${companys }" var="company">
						<option value="${company.id }">${company.name }</option> 
					</c:forEach>	
				</select>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="提交"/>
			</td>
		</tr>
	</form>
</body>
</html>