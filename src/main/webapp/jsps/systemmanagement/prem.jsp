<%--
  Created by IntelliJ IDEA.
  User: zhipeng-Tong
  Date: 2018/1/29
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>信息管理</title>
    <link rel="stylesheet" href="<c:url value="/static/assets/css/amazeui.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/app.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/h-ui/css/H-ui.min.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/h-ui.admin/css/H-ui.admin.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/Hui-iconfont/1.0.8/iconfont.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/h-ui.admin/skin/default/skin.css"/>" id="skin" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/h-ui.admin/css/style.css"/>" />

</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span>
    系统管理
    <span class="c-gray en">&gt;</span>
    权限管理
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray">
        <span class="r">
            第<strong>${adminPage.pageCode}</strong>
            页/共<strong>${adminPage.totalPage}</strong>页
        </span>
    </div>
    <table class="table table-border table-bordered table-hover table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="6">角色管理</th>
        </tr>
        <tr class="text-c">
            <th width="25"><input type="checkbox" value="" name=""></th>
            <th width="200">用户名</th>
            <th>邮箱</th>
            <th width="300">密码</th>
            <th width="70">更改权限</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${adminPage.list}" var="value">
                <tr class="text-c">
                    <td><input type="checkbox" value="${value.uid}" name="uid"></td>
                    <td>${value.name}</td>
                    <td>${value.email}</td>
                    <td>${value.password}</td>
                    <td class="f-14">
                        <a title="编辑" href="javascript:;" onclick="admin_role_edit('更改权限 ','<c:url value="/adminManagement/proPermissions"/>?uid=${value.uid}','330','220')" style="text-decoration:none">
                            <i class="Hui-iconfont">&#xe6df;</i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="pageDiv">
        <ul data-am-widget="pagination"
            class="am-pagination am-pagination-default">
            <li class="am-pagination-first">
                <a href="<c:url value="/usermanagement/userList?nowPageCode=1"/>" class="am-btn-xs">首页</a>
            </li>
            <c:if test="${adminPage.pageCode > 1}">
                <li class="am-pagination-prev">
                    <a href="<c:url value="/usermanagement/userList?nowPageCode=${userPage.pageCode - 1}"/>" class="am-btn-xs">上一页</a>
                </li>
            </c:if>

            <c:choose>
                <c:when test="${adminPage.totalPage <= 10}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="${adminPage.totalPage}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${adminPage.pageCode - 5}"/>
                    <c:set var="end" value="${adminPage.pageCode + 4}"/>
                    <c:if test="${begin < 1}">
                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="10"/>
                    </c:if>
                    <c:if test="${end > adminPage.totalPage}">
                        <c:set var="begin" value="${adminPage.totalPage - 9}"/>
                        <c:set var="end" value="${adminPage.totalPage}"/>
                    </c:if>
                </c:otherwise>
            </c:choose>
            <c:forEach var="i" begin="${begin}" end="${end}">
                <li class="">
                    <a href="<c:url value="/usermanagement/userList?nowPageCode=${i}"/>" class="am-btn-xs">${i}</a>
                </li>
            </c:forEach>

            <c:if test="${adminPage.pageCode < adminPage.totalPage}">
                <li class="am-pagination-next">
                    <a href="<c:url value="/usermanagement/userList?nowPageCode=${adminPage.pageCode + 1}"/>" class="am-btn-xs">下一页</a>
                </li>
            </c:if>
            <li class="am-pagination-last am-btn-xs">
                <a href="<c:url value="/usermanagement/userList?nowPageCode=${adminPage.totalPage}"/>" class="am-btn-xs">尾页</a>
            </li>
        </ul>
    </div>


</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<c:url value="/static/jquery/1.9.1/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/jquery/jquery-form.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/layer/2.4/layer.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/h-ui/js/H-ui.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/h-ui.admin/js/H-ui.admin.js"/>"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
    /*管理员-角色-编辑*/
    function admin_role_edit(title,url,w,h){
        layer_show(title,url,w,h);
    }

</script>
</body>
</html>
