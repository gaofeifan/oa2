<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-list</title>
<script type="text/javascript">

	function getTableForm() {
		return document.getElementById('tableForm');
	}
	function isShow() {
		if(Pn.checkedCount('ids')<=0) {
			alert("请至少选择一个!");
			return;
		}
		if(!confirm("确定上架吗?")) {
			return;
		}
		var f = getTableForm();
		f.action="/product/isShow.do";
		f.submit();
	}
	
	
function changePageNo(){
	$("input[name='pageNo']").val(1);
}
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 商品管理 - 列表</div>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="/oa/user/list.do" method="post" style="padding-top:5px;">
	姓名: <input type="text" name="username" value="${username }"/>
	<select name="companyid">
		<option value="">请选择公司</option>
		<c:forEach items="${companys }" var="company">
			<option value="${company.id }" <c:if test="${company.id == companyid}">selected="selected"</c:if>>${company.name }</option>
		</c:forEach>
	</select>
	<select name="dempid">
		<option value="">请选择部门</option>
		<c:forEach items="${demps }" var="demp">
			<option value="${demp.id }" <c:if test="${demp.id == dempid}">selected="selected"</c:if>>${demp.name }</option>
		</c:forEach>
	</select>
	<select name="isstatus">
		<option  value="1" <c:if test="${isstatus == 1 }">selected="selected"</c:if>>激活</option>
		<option value="0" <c:if test="${isstatus == 0 }">selected="selected"</c:if>>离职</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
<form method="post" id="tableForm">
<table cellspacing="1" cellpadding="0" width="100%" border="0" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
			<th>用户id</th>
			<th>用户名称</th>
			<th>是否激活</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
		<c:forEach items="${pagination.list }" var="user">
			<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
				<td><input type="checkbox" name="ids" value="${user.id }"/></td>
				<td>${user.id }</td>
				<td align="center">${user.username }</td>
				<td align="center">
					<c:if test="${user.isstatus == 1 }">激活</c:if>
					<c:if test="${user.isstatus == 2 }">离职</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class="page pb15">
	<span class="r inb_a page_b">
		<c:forEach items="${pagination.pageView }" var="page">
			${page }
		</c:forEach>
	</span>
</div>
</form>
</div>
</body>
</html>