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
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
	<link href="static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
	<link href="static/h-ui.admin/css/login.css" rel="stylesheet" type="text/css" />
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
    		<form class="form form-horizontal" action="<c:url value='/user/login'/>" method="post">
      			<div class="row cl">
        		<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        		<div class="formControls col-xs-8">
          			<input id="" name="email" type="text" value="${userCustom.email}" placeholder="邮箱" class="input-text size-L">
        		</div>
      			</div>
      			<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        			<div class="formControls col-xs-8">
          				<input id="" name="password"  value="${userCustom.password }" type="password" placeholder="密码" class="input-text size-L">
        			</div>
				</div>
      			<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input class="input-text size-L" type="text" name="verifyCode" value="" placeholder="验证码" style="width:150px;">
          				<a id="kanbuq" href="javascript:_change()"><img alt="" id="verfyimage" src="<c:url value='/user/loginCode'/>"/></a>
          				<font size="3" color="red">${error }</font></i> 
          			</div>
      			</div>
      			<div class="row cl">
        			<div class="formControls col-xs-8 col-xs-offset-3">
	          			<label for="online"><input type="checkbox" name="record" id="online" value="">记住密码</label>
        			</div>
      			</div>
      			<div class="row cl">
        			<div class="formControls col-xs-8 col-xs-offset-3">
        				<input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
        				<input name="" type="reset" onclick="regist()" class="btn btn-default radius size-L" value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;">
        		</div>
			</div>
    	</form>
	</div>
</div>
<div class="footer">CCUT</div>
<script type="text/javascript" src="static/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript">
function regist() {
	window.location.href="<c:url value='/user/redirectRegist'/>";
}
/*改变验证码,这个只能放在这里需要c标签解析*/
function _change() {
	var verfyimage = document.getElementById("verfyimage");
	verfyimage.src = "<c:url value='/user/loginCode'/>?image=" + new Date().getTime();
}

</script>
</body>
</html>
