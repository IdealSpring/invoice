<%--
  Created by IntelliJ IDEA.
  User: Mr.Robot
  Date: 2018/2/5
  Time: 13:52
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
    <title>税金统计结果</title>
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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 增值税计算<span class="c-gray en">&gt;</span> 税金统计结果 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

<div class="page-container indexPosotion">
    <div class="cl pd-5 bg-1 bk-gray mt-20" style="height: 42px;">
        <div class="text-c"> 日期范围：
            <input name="startDate" type="text" id="datemin" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" class="input-text Wdate" style="width:120px;">
            -
            <input name="endDate" type="text" id="datemax" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" class="input-text Wdate" style="width:120px;">
            <input name="query" type="text" class="input-text" style="width:250px" placeholder="名称" id="" >
            <button type="button" onclick="submitQuery()" class="btn btn-success radius"  name="" ><i class="Hui-iconfont">&#xe665;</i> 搜索</button>


            <%--<span class="r">第<strong><span id="spanId-1"></span></strong>页/共<strong id="spanId-2"><span></span></strong>页</span>--%> </div>
    </div>

    <div class="mt-20">
        <form name="addedTaxList" action="${pageContext.request.contextPath }/addedtax/taxStatistics" method="post">
            <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
                <thead>
                <tr class="text-c">
                    <th width="90">选择</th>
                    <th width="240">月份</th>
                    <th >发票商品</th>
                    <th width="240">增值税金额</th>
                    <th width="240">此月详情</th>
                </tr>
                </thead>
                <c:forEach items="${addedTaxList}" var="addedTax">
                <tr class="text-c">
                    <td  width="90"><input type="checkbox" name="" value="${addedTax.iid}"/></td>
                    <td width="240"><fmt:formatDate value="${addedTax.date}" pattern="yyyy-MM"/></td>
                    <td >${addedTax.name}</td>
                    <td width="240">${addedTax.money}</td>
                    <td width="240"><a href="${pageContext.request.contextPath}/addedtax/taxStatisticsDetailQuery?date=${addedTax.date}">进销项信息</a></td>
                </tr>
                </c:forEach>
            </table>
        </form>

       <%-- <div class="pageDiv">
            <ul data-am-widget="pagination"
                class="am-pagination am-pagination-default">
                <li class="am-pagination-first">
                    <a href="<c:url value="/indata/pageRecord?pageCode=1"/>" class="am-btn-xs">首页</a>
                </li>
                <c:if test="${pageBean.pageCode > 1}">
                    <li class="am-pagination-prev">
                        <a href="<c:url value="/indata/pageRecord?pageCode=${pageBean.pageCode - 1}"/>" class="am-btn-xs">上一页</a>
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
                        <a href="<c:url value="/indata/pageRecord?pageCode=${i}"/>" class="am-btn-xs">${i}</a>
                    </li>
                </c:forEach>

                <c:if test="${pageBean.pageCode < pageBean.totalPage}">
                    <li class="am-pagination-next">
                        <a href="<c:url value="/indata/pageRecord?pageCode=${pageBean.pageCode + 1}"/>" class="am-btn-xs">下一页</a>
                    </li>
                </c:if>
                <li class="am-pagination-last am-btn-xs">
                    <a href="<c:url value="/indata/pageRecord?pageCode=${pageBean.totalPage}"/>" class="am-btn-xs">尾页</a>
                </li>
            </ul>
        </div>--%>
        
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
    function submitQuery() {
        document.addedTaxList.action="${pageContext.request.contextPath }/addedtax/taxStatistics";
        document.addedTaxList.submit();
    }
</script>

</body>
</html>
