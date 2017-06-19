<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/com.js"/>
<title>Insert title here</title>
</head>
<body>

<button onclick="sendJson()" >发送json数据</button>
<button onclick="findJson()" >回现部门</button>
<script type="text/javascript">
	function sendJson(){
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath }/oa/demp/save.do",
			contentType:"application/json;charset=utf-8",
			data:'{"name":"财务部","number":"CW123"}'
		})
	}
	function findJson(){
		$.ajax({
			type:"get",
			url:"${pageContext.request.contextPath }/oa/demp/find.do?id="+1,
			contentType:"application/json;charset=utf-8"
		})
	}
</script>
</body>
</html>