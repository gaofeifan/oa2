<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>OA修改账号</title>
<script type="text/javascript">

	function getTableForm() {
		return document.getElementById('tableForm');
	}
	
	 
	
function changePageNo(){
	$("input[name='pageNo']").val(1);
}
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置:修改账号</div>
	<div class="clear"></div>
</div>
	<form id="ggggg" action="${pageContext.request.contextPath }/account/update" method="post" >
		<input type="hidden" name="id" value="${user.id }" /> 修改账号信息：
		<table width="100%" border=1>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" value="${user.username}" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="text" name="sex" value="${user.sex}" /></td>
			</tr>
			<tr>
				<td>公司</td>
				<td><input type="text" name="company" value = "${companyp.name	} "/>
				</td>
			</tr>
			<tr>
				<td>部门</td>
				<td><input type="text" name="company" value = "${demp.name	} "/>
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" value = ""/>
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="newPassword" value = ""/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
			<tr>
				<td><button onclick="">返回</button></td>
		
			</tr>
		</table>
	</form>
</body>
</html>