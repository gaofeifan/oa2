<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>OA账号管理</title>
<script type="text/javascript">
function updateBatch(){
	var de = document.getElementById("bb");
	de.action="${pageContext.request.contextPath }/account/goUpdate";
	de.submit();
}
	

function changePageNo(){
	$("input[name='pageNo']").val(1);
}
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 列表</div>
	<div class="clear"></div>
</div>
<div class="body-box">
<form id="aa" action="/oa/account/list" method="post" style="padding-top:5px;">
	姓名: <input type="text" name="username" value="${username }"/>
	<select name="companyid" >
		<option value="">请选择公司</option>
		<c:forEach items="${companylist  }" var="cl">
			<option value="${cl.id }" >${cl.name }</option>
		</c:forEach>
	</select>
	<select name="dempid">		
		<option value="">请选择部门</option>
		<c:forEach items="${demplist  }" var="dl">
			<option value="${dl.id}" >${dl.name}</option>
		</c:forEach>
	</select>
	
	<input type="submit" class="query" value="查询"/>
	<input type="button" value="批量更新" onclick="updateBatch()"/>
</form>
<form  id="bb"  method="post" id="tableForm">
<table cellspacing="1" cellpadding="0" width="100%" border="0" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<td>选择</td>
					<td>用户名</td>
					<td>ID</td>
					<td>姓别</td>
					<td>部门</td>
					<td>手机号</td>
					<td>邮箱</td>
					<td>公司</td>
					<td>操作</td>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
		<c:forEach items="${userpage.list }" var="it">
			<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'" id="box">
				<td><input type="checkbox" name="ids" value="${it.id }"/></td>
						<td>${it.username}</td>
						<td>${it.id}</td>
						<td>${it.sex}</td>
						<td>${it.dempname}</td>
						<td>${it.phone}</td>
						<td>${it.email}</td>
						<td>${it.companyname}</td>
						<td><a
							href="${pageContext.request.contextPath }/account/goEdit?id=${it.id}">修改</a>
						</td>
			</tr>
		</c:forEach>
		<tr>
		
		</tr>
	</tbody>
</table>
<div class="page pb15">
	<span class="r inb_a page_b">
		<c:forEach items="${userpage.pageView }" var="page">
			${page}
		</c:forEach>
	</span>
</div>
</form>
</div>
</body>
</html>