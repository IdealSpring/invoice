<%--
  Created by IntelliJ IDEA.
  User: zhipeng-Tong
  Date: 2018/1/29
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    日志管理
    <span class="c-gray en">&gt;</span>
    登录日志
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray">
        <span class="l">
            <a class="btn btn-primary radius" href="javascript:;" onclick="admin_role_add(this)">
                <i class="Hui-iconfont">&#xe600;</i>清空日志
            </a>
        </span>
        <span class="r">
            第<strong>${logPage.pageCode}</strong>
            页/共<strong>${logPage.totalPage}</strong>页
        </span>
    </div>
    <table class="table table-border table-bordered table-hover table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="6">角色管理</th>
        </tr>
        <tr class="text-c">
            <th width="200">用户名</th>
            <th width="200">ip地址</th>
            <th>登陆时间</th>
            <th width="300">登出时间</th>
            <th width="70">操作</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${logPage.list}" var="value">
                <tr class="text-c">
                    <td>${value.username}</td>
                    <td>${value.ip}</td>
                    <td><fmt:formatDate value="${value.createdate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                    <td><fmt:formatDate value="${value.deletedate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                    <td class="f-14">
                        <a title="删除" href="javascript:;" onclick="admin_role_del(this, ${value.lid})" class="ml-5" style="text-decoration:none">
                            <i class="Hui-iconfont">&#xe6e2;</i>
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
            <c:if test="${logPage.pageCode > 1}">
                <li class="am-pagination-prev">
                    <a href="<c:url value="/usermanagement/userList?nowPageCode=${logPage.pageCode - 1}"/>" class="am-btn-xs">上一页</a>
                </li>
            </c:if>

            <c:choose>
                <c:when test="${logPage.totalPage <= 10}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="${logPage.totalPage}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${logPage.pageCode - 5}"/>
                    <c:set var="end" value="${logPage.pageCode + 4}"/>
                    <c:if test="${begin < 1}">
                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="10"/>
                    </c:if>
                    <c:if test="${end > logPage.totalPage}">
                        <c:set var="begin" value="${logPage.totalPage - 9}"/>
                        <c:set var="end" value="${logPage.totalPage}"/>
                    </c:if>
                </c:otherwise>
            </c:choose>
            <c:forEach var="i" begin="${begin}" end="${end}">
                <li class="">
                    <a href="<c:url value="/usermanagement/userList?nowPageCode=${i}"/>" class="am-btn-xs">${i}</a>
                </li>
            </c:forEach>

            <c:if test="${logPage.pageCode < logPage.totalPage}">
                <li class="am-pagination-next">
                    <a href="<c:url value="/usermanagement/userList?nowPageCode=${logPage.pageCode + 1}"/>" class="am-btn-xs">下一页</a>
                </li>
            </c:if>
            <li class="am-pagination-last am-btn-xs">
                <a href="<c:url value="/usermanagement/userList?nowPageCode=${logPage.totalPage}"/>" class="am-btn-xs">尾页</a>
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
    /*管理员-角色-添加*/
    function admin_role_add(obj,id){
        layer.confirm('清空日志须谨慎，确认要删除吗？',function(){
            var urlValue = '<c:url value="/log/delectAllLog"/>';
            $.ajax({
                type: 'POST',
                url: urlValue,
                success: function(){
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!',{icon:1,time:1000});
                    location.replace(location.href);
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }
    /*管理员-角色-删除*/
    function admin_role_del(obj,id){
        layer.confirm('日志删除须谨慎，确认要删除吗？',function(){
            var urlValue = '<c:url value="/log/delectLog"/>?lid=' + id;
            $.ajax({
                type: 'POST',
                url: urlValue,
                success: function(){
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!',{icon:1,time:1000});
                    location.replace(location.href);
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }
</script>
</body>
</html>
