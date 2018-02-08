<%--
  Created by IntelliJ IDEA.
  User: Mr.Robot
  Date: 2018/2/5
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>税金详情</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="static/assets/css/amazeui.min.css">
    <link rel="stylesheet" href="static/assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="static/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 增值税计算<span class="c-gray en">&gt;</span> 税金详情 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

<div class="mt-20">

    <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
        <thead>
        <tr class="text-c">
            <th width="25"></th>
            <th width="170">发票编号</th>
            <th >发票名称</th>
            <th width="170">种类</th>
            <th width="170">金额</th>
            <th width="200">发票时间</th>
            <th width="200">导入时间</th>
        </tr>
        </thead>
        <c:forEach items="${pageBean.list}" var="addedTax">
            <tr class="text-c">
                <td width="25"><input type="checkbox" name="iid" value="${addedTax.iid}"/></td>
                <td width="170">${addedTax.number}</td>
                <td >${addedTax.name}</td>
                <c:choose>
                    <c:when test="${addedTax.kind == 1}">
                        <td width="170">进项数据</td>
                    </c:when>
                    <c:when test="${addedTax.kind == 0}">
                        <td width="170">销项数据</td>
                    </c:when>
                </c:choose>
                <td width="170">${addedTax.money}</td>
                <td width="200"><fmt:formatDate value="${addedTax.date}" pattern="yyyy-MM-dd"/></td>
                <td width="200"><fmt:formatDate value="${addedTax.inputdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
        </c:forEach>
    </table>

     <div class="pageDiv">
            <ul data-am-widget="pagination"
                class="am-pagination am-pagination-default">
                <li class="am-pagination-first">
                    <a href="<c:url value="/addedtax/taxStatisticsDetail?pageCode=1"/>" class="am-btn-xs">首页</a>
                </li>
                <c:if test="${pageBean.pageCode > 1}">
                    <li class="am-pagination-prev">
                        <a href="<c:url value="/addedtax/taxStatisticsDetail?pageCode=${pageBean.pageCode - 1}"/>" class="am-btn-xs">上一页</a>
                    </li>
                </c:if>

                <c:choose>
                    <c:when test="${pageBean.totalPage <= 10}">
                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="${pageBean.totalPage}"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="begin" value="${pageBean.pageCode - 5}"/>
                        <c:set var="end" value="${pageBean.pageCode + 4}"/>
                        <c:if test="${begin < 1}">
                            <c:set var="begin" value="1"/>
                            <c:set var="end" value="10"/>
                        </c:if>
                        <c:if test="${end > pageBean.totalPage}">
                            <c:set var="begin" value="${pageBean.totalPage - 9}"/>
                            <c:set var="end" value="${pageBean.totalPage}"/>
                        </c:if>
                    </c:otherwise>
                </c:choose>

                <c:forEach var="i" begin="${begin}" end="${end}">
                    <li class="">
                        <a href="<c:url value="/addedtax/taxStatisticsDetail?pageCode=${i}"/>" class="am-btn-xs">${i}</a>
                    </li>
                </c:forEach>

                <c:if test="${pageBean.pageCode < pageBean.totalPage}">
                    <li class="am-pagination-next">
                        <a href="<c:url value="/addedtax/taxStatisticsDetail?pageCode=${pageBean.pageCode + 1}"/>" class="am-btn-xs">下一页</a>
                    </li>
                </c:if>
                <li class="am-pagination-last am-btn-xs">
                    <a href="<c:url value="/addedtax/taxStatisticsDetail?pageCode=${pageBean.totalPage}"/>" class="am-btn-xs">尾页</a>
                </li>
            </ul>
        </div>
</div>


<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="static/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="static/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<c:url value="/static/My97DatePicker/4.8/WdatePicker.js"/>"></script>
<script type="text/javascript" src="static/assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="static/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="static/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="static/myscript/data_js.js"></script>
<script type="text/javascript">

</script>

</body>
</html>
