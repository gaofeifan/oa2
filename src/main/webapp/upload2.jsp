<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="${pageContext.request.contextPath }/res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/res/common/js/jquery.js" type="text/javascript"></script>
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
	<form id="jvForm" action="" method="post" enctype="multipart/form-data">
		<input type="file" onchange="uploadPic();" name="filePic"/>
	</form>
	
	
</body>
</html>