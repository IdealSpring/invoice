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
    <title>导入进项数据</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="static/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
  </head>
  <body>
  <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 数据导入 <span class="c-gray en">&gt;</span> 进销数据 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
  <div class="page-container">
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

		  </span> <span class="r">共有数据：<strong>54</strong> 条</span> </div>
	  <div class="mt-20">
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
			  <tr class="text-c">
				  <td><input type="checkbox" value="" name=""></td>
				  <td>201802180000001</td>
				  <td>大豆</td>
				  <td>进项数据</td>
				  <td>2600万</td>
				  <td>2014-6-11 11:11:42</td>
				  <td>2014-6-11 11:11:42</td>
				  <td class="f-14 td-manage"> <a style="text-decoration:none" class="ml-5" onClick="article_edit('资讯编辑','article-add.html','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="article_del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
			  </tr>
			  <tr class="text-c">
				  <td><input type="checkbox" value="" name=""></td>
				  <td>201802180000001</td>
				  <td>大豆</td>
				  <td>进项数据</td>
				  <td>2600万</td>
				  <td>2014-6-11 11:11:42</td>
				  <td>2014-6-11 11:11:42</td>
				  <td class="f-14 td-manage"> <a style="text-decoration:none" class="ml-5" onClick="article_edit('资讯编辑','article-add.html','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="article_del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
			  </tr>
			  </tbody>
		  </table>
	  </div>
  </div>
  <!--_footer 作为公共模版分离出去-->
  <script type="text/javascript" src="static/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" src="static/layer/2.4/layer.js"></script>
  <script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
  <script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

  <!--请在下方写此页面业务相关的脚本-->
  <script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
  <script type="text/javascript" src="static/datatables/1.10.0/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="static/myscript/data_js.js"></script>

  </body>
</html>