
var flag_username = false;
var flag_password = false;
var flag_password2 = false;
var flag_email = false;
/* 检查用户名 */
function checkUsername() {
	var username = document.getElementById("username");
	var usernameerror = document.getElementById("usernameerror");
	var vaule = username.value;
	var len = vaule.length;
	if (len < 2) {
		usernameerror.innerHTML = '<font size="3" color="red">&#xe60b;位数不足</font>';
	} else if (len > 10) {
		usernameerror.innerHTML = '<font size="3" color="red">&#xe60b;位数过长</font>';
	} else {
		usernameerror.innerHTML = '<font size="3" color="green">&#xe676;</font>';
		flag_username = true;
	}
}
/* 检查密码位数 */
var password = null;
function checkpassword() {
	var password1 = document.getElementById("password1");
	var passworderror = document.getElementById("passworderror");
	var vaule = password1.value;
	password = vaule;
	var len = vaule.length;
	if (len < 10) {
		passworderror.innerHTML = '<font size="3" color="red">&#xe60b;位数不足</font>';
	} else if (len > 16) {
		passworderror.innerHTML = '<font size="3" color="red">&#xe60b;位数过长</font>';
	} else {
		passworderror.innerHTML = '<font size="3" color="green">&#xe676;</font>';
		flag_password = true;
	}
	confirmpassword()
}
/* 检查密码前后是否一致 */
function confirmpassword() {
	var password1 = document.getElementById("password2");
	var confirmerror = document.getElementById("confirmerror");
	var vaule = password1.value;
	if (vaule == "" ) {
		confirmerror.innerHTML = '<font size="3" color="red">&#xe60b;不能为空</font>';
	} else if(vaule != password) {
		confirmerror.innerHTML = '<font size="3" color="red">&#xe60b;不一致</font>';
	} else {
		confirmerror.innerHTML = '<font size="3" color="green">&#xe676;</font>';
		flag_password2 = true;
	}
}
/*检查邮箱*/
function checkemail(){
	var email = document.getElementById("email");
	var emailerror = document.getElementById("emailerror");
	var emailtVal =email.value;
	var reg=/^\w{1,15}@\w{2,5}(\.\w{2,5})+$/;
	if(reg.test(emailtVal)){
		emailerror.innerHTML = '<font size="3" color="green">&#xe676;</font>';
		flag_email = true;
	}else if(emailtVal == ""){
		emailerror.innerHTML = '<font size="3" color="red">&#xe60b;不能为空</font>';
	}else{
		emailerror.innerHTML = '<font size="3" color="red">&#xe60b;格式错误</font>';
	}
}

/*检查提交情况*/
function regist() {
	var submitbtn = document.getElementById("submitbtn");
	if(flag_username && flag_password &&flag_password2 &&flag_email) {
		submitbtn.submit();
	} else {
		alert("有非法输入项，无法提交！");
	}
}


//回调
window.onload = function() {
	var username = document.getElementById("username");
	var vaule1 = username.value;
	if(vaule1 != '') {
		checkUsername();
	}
	var password1 = document.getElementById("password1");
	var vaule2 = password1.value;
	if(vaule2 != '') {
		checkpassword();
	}
	var password2 = document.getElementById("password2");
	var vaule3 = password2.value;
	if(vaule3 != '') {
		checkpassword();
	}
	var email = document.getElementById("email");
	var emailtVal =email.value;
	if(emailtVal != '') {
		checkemail();
	}
	
}












