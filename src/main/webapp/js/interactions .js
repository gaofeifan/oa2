// dev
// var oaPathUrl = '10.0.0.18:8081';
// var ssoPathUrl = '10.0.0.18:8082';
// dev_n
//   var oaPathUrl = '10.0.0.18:8083';
var ssoPathUrl = '10.0.0.18:8085';

var oaPathUrl = '192.168.4.203:8081';
	/*登录*/
$.ajax({
	type:'get',
	url:'http://'+ssoPathUrl+'/sso/user/rememberme',
	crossDomain: true,//支持跨域发送cookie
	dataType:'jsonp',
	data:{
			flag:$("input[name='flag']").val()
	},
	success:function(data){
		if(data.status==200){
			$('#mail').val(data.email);
			$('#pass').val(data.password);
			$('#flag').val(data.flag)
		}
		if(data.flag==1){
			$('#flag').attr('checked','true');
		}else{
			$('#flag').removeAttr('checked');
			/*$('#mail').val('企业邮箱');*/
			/*$('#pass').val('密码');*/
		}

		/*if($('#flag').val()==0){
			$('.center .password').html('<span></span><input id="pass" name="password" type="text" value="密码"/>')
		}	*/
	},
	error:function(){

	}
});

$('#flag').on('click',function(){
	if($(this).attr('checked')=='checked'){
		$(this).val(1)
	}else{
		$(this).val(0)
		/*$('#pass').val('');*/
	}
});
$('#btn').on('click',function(){
	$.ajax({
		type:'get',
		url:'http://'+ssoPathUrl+'/sso/user/dologin',
		async:false,
		data:{username:$("input[name='username']").val(),
			  password:$("input[name='password']").val(),
			  flag:$("input[name='flag']").val(),
		},
		xhrFields:{
	        withCredentials: true
	    },//支持跨域发送cookie
	    crossDomain: true,
		dataType:'jsonp',
		jsonp: 'callback',
		success:function(data){
			//密码正确的时候登录成功
			if(data.status==200){
				alert(data);
				window.location.href="http://10.0.0.18:8083/www/Sign-in.html";
				$.cookie('item','Mywork');
			}
			//密码或者账号输入错误的时候
			if(data.status==404){
				alert(data.error)
			}
		},
		error:function(){

		}
	})
});
$(function () {
    document.onkeydown = function (event) {
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if (e && e.keyCode == 13) {
            $('#btn').trigger('click');
        }
    };
});


/*退出
	/*点击显示*/
$('.right .out').on('click',function(){
	$('.content .revised-out').css('display','block');
});
	/*点击取消*/
$('.content .revised-out i').on('click',function(){
	$('.content .revised-out').css('display','none'); 
})
	/*点击确认请求ajax*/
$('.content .revised-out b').on('click',function(){
	$.ajax({
		type:'get',
		url:'http://'+ssoPathUrl+'/sso/user/loginout',
		crossDomain: true,//支持跨域发送cookie
		dataType:'jsonp',
		success:function(data){
			if(data.status==200){
				window.location.href="../Sign-in.html";
				$.cookie('item',null);
			}
		},
		error:function(){

		}
	})
});



















