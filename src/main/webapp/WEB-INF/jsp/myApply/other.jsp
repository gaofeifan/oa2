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
	src="${pageContext.request.contextPath }/res/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/res/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/res/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/res/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/res/css/default.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/res/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/res/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/res/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/res/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/res/js/jquery.ocupload-1.1.2.js"></script>
<script type="text/javascript">
	function findName(username){
		alert();
		var url_2 = "${pageContext.request.contextPath }/user/findUserByUsername.do" ;
		$.post(url_2,{"username":("#username")},function(data){
		
		}
	)
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/apply/saveOther.do" method="post">
		姓名 ： <input type="text" name="username" />
		<script type="text/javascript">
			$(function(){
				//为上面的输入框绑定离焦事件
				$("input[name=username]").blur(function(){
					var typeUserName = this.value;
					//发送ajax请求，提交输入的手机号
					var url = "${pageContext.request.contextPath}/user/findUserByUsername.do";
					$.post(url,{"username":typeUserName},function(data){
						alert(data.user.companyid);
						
						if(data != null){
							//查询到了客户信息，可以回显
							$("option[value=dempid]").val(data.dempid);
							$("option[value=postid]").val(data.postid);
							$("option[value=companyid]").val(data.companyid);
						}else{
							//没有查询到客户信息
							$("option[value=dempid]").val("");
							$("option[value=postid]").val("");
							$("option[value=companyid]").val("");
						}
					});
				});
			});
		</script>  
		部门 ： 	
			<select  name="dempid">
				<option  value="" >请选择</option>
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
		公司  :
			<select name="companyid">
				<option value="" >请选择</option>
					<c:forEach items="${companys }" var="company">
						<option value="${ company.id}" >${company.name }</option>
					</c:forEach>
			</select> 
		<br/>
		模板	 ：	
			<input type="file" name="">		
				<input type="submit" value="提交"/>
	</form>
</body>
</html>