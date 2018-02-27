<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script
	src="${pageContext.request.contextPath }/res/common/js/jquery.form.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/res/common/js/jquery.js"
	type="text/javascript"></script>
<script type="text/javascript">
	// 附件上传
	function uploadPic() {
		var options = {
			url : "192.168.4.213:8081/oa/upload/uploadPic.do",
			type : "post",
			dataType : "json",
			success : function(data) {
				$("#iconurl").val(data); // 设置图片的url隐藏域，用于保存到数据库中。
			}
		}
		$("#jvForm").ajaxSubmit(options); // jquery.form.js提价
	}

	$(function() {
		$('#fileupload').fileupload({
			dataType : 'json',
			done : function(e, data) {
				$.each(data.result.files, function(index, file) {
					$('<p/>').text(file.name).appendTo(document.body);
				});
			}
		});
	});
</script>
</head>
<body>
	<form id="jvForm" action="" method="post" enctype="multipart/form-data">
		<!-- <input type="file" onchange="uploadPic();" name="filePic" id="fileupload" /> -->
		<div id="fileupload">上传附件</div>
	</form>


</body>
<script type="text/javascript">
$(document).ready(function() {

    $("#fileuploader").uploadFile({
        url:"", //后台处理方法
        fileName:"files",   //文件的名称，此处是变量名称，不是文件的原名称只是后台接收的参数
        dragDrop:true,  //可以取消
        abortStr:"取消",
        sequential:true,  //按顺序上传
        sequentialCount:1,  //按顺序上传
        autoSubmit :"false",  //取消自动上传
        dragDropStr: "<span><b>附件拖放于此</b></span>",
        showFileCounter:false,
        returnType:"json",  //返回数据格式为json
        onSuccess:function(files,data,xhr,pd)  //上传成功事件，data为后台返回数据
        {
            //将返回的上传文件id动态加入的表单中，用于提交表单时返回给后台。
            var newsform = $("#jvForm");
           if( data.status==1){
                for( var i=0;i<data.data.length;i++){
                    var inputNode='<input type="hidden" id="'+data.data[i].fileId+'" name="fileIds" value="'+data.data[i].fileId+'" >';
                    newsform.append(inputNode);
                }
            }else{
                alert("上传失败");
            } 
        },
        showDelete: true,//删除按钮
        statusBarWidth:600,
        dragdropWidth:600,
            //删除按钮执行的方法
        deleteCallback: function (data, pd) {
             var fileId=data.data[0].fileId;
             $.post("control/news/deleteFile.action", {fileId:fileId},
                    function (resp,textStatus, jqXHR) {
                        alert("delete ok");
                        //alert(textSatus);
              }); 
            //删除input标签
            $("#"+fileId).remove();
            pd.statusbar.hide(); //You choice.
        }
    });
});
</script>
</html>