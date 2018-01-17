<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
	<link href="static/h-ui.admin/css/H-ui.regist.css" rel="stylesheet" type="text/css" />
	<link href="static/h-ui.admin/css/registstyle.css" rel="stylesheet" type="text/css" />
	<link href="static/h-ui.admin/css/regist.css" rel="stylesheet" type="text/css" />
	<link href="static/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />

</head>
<body>
  	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="header"></div>
	<div class="loginWraper">
		<c:if test="${msg != null }">
			<div class="msgerror">${msg}</div>
		</c:if>
  		<div id="loginform" class="loginBox">
    		<form class="form form-horizontal" action="<c:url value='/user/regist'/>" method="post" id="submitbtn">
      			<div class="row cl">
        		<label class="form-label col-xs-3" id="label"><i class="Hui-iconfont">&#xe60d;</i></label>
        		<div class="formControls col-xs-8" id="div">
          			<input id="username" onblur="checkUsername()" name="name" value="${userCustom.name }" type="text" placeholder="用户名(长度在2~10位之间)" class="input-text size-L">
          			<i class="Hui-iconfont" id="usernameerror"></i>
        		</div>
      			</div>
      			<div class="row cl">
					<label class="form-label col-xs-3" id="label"><i class="Hui-iconfont">&#xe60e;</i></label>
        			<div class="formControls col-xs-8" id="div">
          				<input id="password1" onblur="checkpassword()" value="${userCustom.password }" name="password" type="password" placeholder="密码(长度在10~16位之间)" class="input-text size-L">
          				<i class="Hui-iconfont" id="passworderror"></i>
        			</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3" id="label"><i class="Hui-iconfont">&#xe63f;</i></label>
        			<div class="formControls col-xs-8" id="div">
          				<input id="password2" onkeyup="confirmpassword()" name="" value="${userCustom.password }" type="password" placeholder="确认密码" class="input-text size-L">
        				<i class="Hui-iconfont" id="confirmerror"></i>
        			</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3" id="label"><i class="Hui-iconfont">&#xe704;</i></label>
        			<div class="formControls col-xs-8" id="div">
          				<input id="email" onblur="checkemail()" name="email" value="${userCustom.email }" type="text" placeholder="邮箱" class="input-text size-L">
        				<i class="Hui-iconfont" id="emailerror"></i>
        			</div>
				</div>
      			<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3"  id="div">
          				<input class="input-text size-L" type="text" name="verifyCode" value="${userCustom.verifyCode }" placeholder="验证码" style="width:150px;">
          				<a id="kanbuq" href="javascript:_change()"><img alt="" id="verfyimage" src="<c:url value='/user/verifyCode'/>"/></a>
          				<i class="Hui-iconfont" id="emailerror">
          				<font size="3" color="red">${error }</font></i> 
          			</div>
      			</div>
      			<div class="row cl">
        			<div class="formControls col-xs-8 col-xs-offset-3">
        				<input onclick="regist()" type="button" class="btn btn-success radius size-L" value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;">
        				<input type="reset" onclick="login()" class="btn btn-default radius size-L" value="&nbsp;去&nbsp;&nbsp;登&nbsp;&nbsp;陆&nbsp;">
        		</div>
			</div>
    	</form>
	</div>
</div>
<div class="footer">CCUT</div>
<script type="text/javascript" src="static/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/myscript/registscript.js"></script>
<script type="text/javascript">
/*改变验证码,这个只能放在这里需要c标签解析*/
function _change() {
	var verfyimage = document.getElementById("verfyimage");
	verfyimage.src = "<c:url value='/user/verifyCode'/>?image=" + new Date().getTime();
}
/* 跳转登陆界面 */
function login() {
	window.location.href ="<c:url value='/user/redirectLogin'/>";
}
</script>
</body>
</html>
