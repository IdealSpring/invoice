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
    <title>导入进项数据</title>
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
  <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 数据导入 <span class="c-gray en">&gt;</span> 进销数据 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
  <div class="page-container indexPosotion">
	  <div class="cl pd-5 bg-1 bk-gray mt-20">
		  <span class="l">
			  <a href="javascript:;" onclick="downloading()" class="btn btn-primary radius">
				  <i class="Hui-iconfont">&#xe640;</i> 下载模板
			  </a>
			  <a href="javascript:;" onclick="dataDdd('添加进销项数据','jsps/indata/add_data.jsp','400','360')" class="btn btn-primary radius">
				  <i class="Hui-iconfont">&#xe640;</i> 单条导入
			  </a>
			  <a href="javascript:;" onclick="dataDdd('Excel批量导入','jsps/indata/batch_data.jsp','350','170')" class="btn btn-primary radius">
				  <i class="Hui-iconfont">&#xe640;</i> 批量导入
			  </a>
			  <a href="javascript:;" id="downloadByBatch-btn" class="btn btn-primary radius">
				  <i class="Hui-iconfont">&#xe640;</i> 批量下载
			  </a>

		  </span> <span class="r">第<strong>${pageBean.pageCode}</strong>页/共<strong>${pageBean.totalPage}</strong>页</span> </div>
	  <div class="mt-20">

		  <form id="downloadByBatch" action="<c:url value="/indata/downloadByBatch"/>" method="post">
		  <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			  <thead>
			  <tr class="text-c">
				  <th width="25"></th>
				  <th width="150">发票编号</th>
				  <th width="200">发票名称</th>
				  <th width="80">种类</th>
				  <th width="150">金额</th>
				  <th width="120">发票时间</th>
				  <th width="120">导入时间</th>
				  <th width="120">操作</th>
			  </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${pageBean.list}" var="value">
			  <tr class="text-c">
				  <td><input type="checkbox" value="${value.iid}" name="iid"></td>
				  <td>${value.number}</td>
				  <td>${value.name}</td>
				  <c:choose>
					  <c:when test="${value.kind == true}">
						  <td>进项数据</td>
					  </c:when>
					  <c:otherwise>
						  <td>销项数据</td>
					  </c:otherwise>
				  </c:choose>
				  <td>${value.money}</td>
				  <td><fmt:formatDate value="${value.date}" pattern="yyyy-MM-dd"/></td>
				  <td><fmt:formatDate value="${value.inputdate}" pattern="yyyy-MM-dd HH-mm-ss"/></td>
				  <td class="f-14 td-manage">
					  <%--jsps/indata/updata_data.jsp--%>
                      <a style="text-decoration:none" class="ml-5" onClick="dataDdd('修改数据','<c:url value="/indata/selectOneRecord"/>?iid=${value.iid}','400','360')" href="javascript:;" title="编辑">
                          <i class="Hui-iconfont">&#xe6df;</i>
                      </a>
                      <a style="text-decoration:none" class="ml-5" onClick="article_del(this,'${value.iid}')" href="javascript:;" title="删除">
                          <i class="Hui-iconfont">&#xe6e2;</i>
                      </a>
                  </td>
			  </tr>
			  </c:forEach>
			  </tbody>
		  </table>
		  </form>

		  <div class="pageDiv">
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
		  </div>

	  </div>
  </div>
  <!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="static/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="static/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="static/My97DatePicker/4.8/WdatePicker.js"></script>
<script src="static/assets/js/amazeui.min.js"></script>
<%--<script type="text/javascript" src="static/datatables/1.10.0/jquery.dataTables.min.js"></script>--%>
<script type="text/javascript" src="static/myscript/data_js.js"></script>
<script type="text/javascript">

	$(document).ready(function () {
		$("#downloadByBatch-btn").bind("click", function () {
		    $("#downloadByBatch").submit();
			/*$("#downloadByBatch").ajaxSubmit({
				success:function () {

                },
				error:function () {
					alert("下载失败")
                }
			});*/
        });
    });

    function article_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type: 'POST',
                url: '<c:url value="/indata/deleteOneRecord"/>?iid=' + id,
                success: function(data){
                    alert(data);
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    location.replace(location.href);

                },
                error:function(data) {
                    alert("失败！");
                },
            });
        });
    }
</script>
  </body>
</html>