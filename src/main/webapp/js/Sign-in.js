/*光标的显示和隐藏 add*/
var oMail=document.getElementById('mail');
var oPass=document.getElementById('pass');

oMail.onfocus=function(){
	this.value='';
};


oMail.onblur=function(){
	if(this.value==''){
		this.value='企业邮箱';
	}else{
		this.value==this.value;
	}
	
};

oPass.onfocus=function(){
	this.value='';
	this.type='password';
};


oPass.onblur=function(){
	this.type='text';
	if(this.value==''){
		this.value='密码';
	}else{
		this.value==this.value;
		this.type='password';
	}
	
};

/*光标的显示和隐藏 end*/




















