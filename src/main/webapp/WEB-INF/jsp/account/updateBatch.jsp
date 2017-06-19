<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量修改密码</title>
<script type="text/javascript">
function updateBatch(){
	var de = document.getElementById("itemsForm");
	de.action="${pageContext.request.contextPath }/account/saveBatch";
	de.submit();
}
</script>
	

</head>
<body>
	<form id="itemsForm" 
		action="${pageContext.request.contextPath }/account/saveBatch"
		method="post">
	
		新密码:
		<table width="100%" border=1>
			<tr>
			<c:forEach items="${ids }" var="item" >
				<td><input type="hidden" name="ids" value="${item.idss}"/>
				
			</c:forEach>
			
			</tr>
			<tr>
				<td><input type="text" name="newPassword" value="" /></td>
			</tr>

			<tr>
				<td colspan="4" align="center"><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>

</html>