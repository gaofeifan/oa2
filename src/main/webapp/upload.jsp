<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<script src="/res/common/js/jquery.form.js" type="text/javascript"></script>
<script type="text/javascript">
	// 附件上传
	function uploadPic(){
		var options = {
				url:"http://10.0.0.127:8080/oa/upload/uploadPic.do",
				type:"post",
				dataType:"json",
				success:function(data){
					$("#iconurl").val(data); // 设置图片的url隐藏域，用于保存到数据库中。
				}
		}
		$("#jvForm").ajaxSubmit(options); // jquery.form.js提价
	}
</script>

</head>
<body>
	</h3>
	<form id="jvForm" action="http://10.0.0.208:8080/oa/upload/uploadPic.do" method="post" enctype="multipart/form-data">
		<input type="file" name="filePic"></input><br/>
		<input type="file" name="filePic"></input><br/>
		 <input type="submit" value="上传文件"></input><br/>
	</form>
	<a href="http://10.0.0.18:8081/oa/upload/download.do?fileName=盘江物流集团员工手册.docx">点我</a>
</body>
</html>