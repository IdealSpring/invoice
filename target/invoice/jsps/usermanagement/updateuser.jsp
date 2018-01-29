<%--
  Created by IntelliJ IDEA.
  User: zhipeng-Tong
  Date: 2018/1/29
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加用户</title>
    <link rel="stylesheet" href="<c:url value="/static/assets/css/amazeui.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/app.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/h-ui/css/H-ui.min.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/h-ui.admin/css/H-ui.admin.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/Hui-iconfont/1.0.8/iconfont.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/h-ui.admin/skin/default/skin.css"/>" id="skin" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/h-ui.admin/css/style.css"/>" />
</head>
<body>
<article class="page-container">
    <form action="<c:url value="/usermanagement/editUser"/>" method="post" class="form form-horizontal" id="submit-id">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="hidden" name="uid" value="${userManagement.uid}">
                <input type="text" class="input-text" value="${userManagement.name}" placeholder=""  name="name">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${userManagement.email}" name="email">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="password" class="input-text" value="${userManagement.password}" name="password">
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <button onclick="mySubmit()" type="button" class="btn btn-success radius" name="admin-role-save"><i class="icon-ok"></i> 确定</button>
                <button onclick="myClose()" type="button" class="btn btn-success radius" name="admin-role-save"><i class="icon-ok"></i> 取消</button>
            </div>
        </div>
    </form>
</article>

<script type="text/javascript" src="<c:url value="/static/jquery/1.9.1/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/jquery/jquery-form.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/layer/2.4/layer.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/h-ui/js/H-ui.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/h-ui.admin/js/H-ui.admin.js"/>"></script>
<script>
    function mySubmit() {
        $("#submit-id").ajaxSubmit({
            success:function (data) {
                alert(data);
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
                location.replace(location.href);
            },
            error:function () {
                alert("添加失败");
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }
        });
    }
    function myClose() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }
</script>
</body>
</html>
