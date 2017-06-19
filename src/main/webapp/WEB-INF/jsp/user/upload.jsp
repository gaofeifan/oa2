<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/head.jsp"%>

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
<script type="text/javascript">
	function uploadPic() {
		var options = {
			url : "/user/uploadExcle.do",
			type : "post",
			dataType : "json",
			success : function(data) {
				if (date == 1) {
					alert("导入成功")
				} else {
					alert("导入失败")
				}
			}
		}
		$("#jvForm").ajaxSubmit(options); // jquery.form.js提价
	}
</script>
</head>
<body>
	<form id="jvForm" action="o_save.shtml" method="post" enctype="multipart/form-data">
		<input type="file" onchange="uploadPic()" name="userImport" />
		<tr>
			<td class="pn-fbutton" colspan="2"><input type="submit"
				class="submit" value="提交" /> &nbsp; <input type="reset"
				class="reset" value="重置" /></td>
		</tr>
	</form>
</body>
</html>