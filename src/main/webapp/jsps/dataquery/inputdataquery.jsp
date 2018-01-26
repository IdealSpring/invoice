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
    <title>进项数据查询</title>
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
  <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 数据查询 <span class="c-gray en">&gt;</span> 进项数据查询 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
  <div class="page-container indexPosotion">
	  <div class="cl pd-5 bg-1 bk-gray mt-20" style="height: 42px;">
		  <div class="text-c"> 日期范围：
			  <input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:120px;">
			  -
			  <input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;">
			  <input type="text" class="input-text" style="width:250px" placeholder="输入会员名称、电话、邮箱" id="" name="">
			  <button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜索</button>

              
			  <span class="r">第<strong><span id="spanId-1"></span></strong>页/共<strong id="spanId-2"><span></span></strong>页</span> </div>
		  </div>

	  <div class="mt-20">

		  <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			  <thead>
			  <tr class="text-c">
				  <th width="25"></th>
				  <th width="170">发票编号</th>
				  <th >发票名称</th>
				  <th width="170">种类</th>
				  <th width="170">金额</th>
				  <th width="170">发票时间</th>
				  <th width="170">导入时间</th>
			  </tr>
			  </thead>
			  <tbody id="tbodyId"></tbody>
		  </table>

		  <div class="pageDiv" id="ulId"></div>

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
    //格式化时间函数
    Date.prototype.Format = function (fmt) {
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }

    var pageCode = 1;
    var totalRecord = null;
    var totalPage = null;
    var pageSize = null;
    var begin = null;
    var end = null;
    var tableValue = '';
    var ulValue = '';

    function pageData(param) {
        if(param == null) {
            urlValue = '<c:url value="/query/queryAllinputData"/>';
        } else {
            urlValue = '<c:url value="/query/queryAllinputData"/>?pageCode=' + param;
        }
        var div = document.getElementById("tbodyId");

        $.ajax({
            type:'POST',
            url:urlValue,
            success:function(pageBean) {
                pageCode = pageBean.pageCode;
                totalPage = pageBean.totalPage;
                totalRecord = pageBean.totalRecord;
                pageSize = pageBean.pageSize;

                for(var i = 0; i < pageBean.list.length; i++) {
                    tableValue += '<tr class="text-c">';
                    tableValue += '<td><input type="checkbox" value="' + pageBean.list[i].iid + '" name="iid"></td>';
                    tableValue += '<td>' + pageBean.list[i].number + '</td>';
                    tableValue += '<td>' + pageBean.list[i].name + '</td>';
                    if(pageBean.list[i].kind == true) {
                        tableValue += '<td>进项数据</td>';
                    } else {
                        tableValue += '<td>销项数据</td>';
                    }
                    tableValue += '<td>' + pageBean.list[i].money + '</td>';
                    tableValue += '<td>' + new Date(pageBean.list[i].date).Format("yyyy-MM-dd") + '</td>';
                    tableValue += '<td>' + new Date(pageBean.list[i].inputdate).Format("yyyy-MM-dd hh:mm:ss") + '</td>';
                    tableValue += '</tr>';
                }

                document.getElementById("tbodyId").innerHTML = tableValue;
                tableValue = '';

                ulValue += '<ul data-am-widget="pagination" class="am-pagination am-pagination-default">';
                ulValue += '<li class="am-pagination-first">';
                ulValue += '<a class="am-btn-xs" id="firstPage">首页</a>';
                ulValue += '</li>';

                if(pageCode > 1) {
                    ulValue += '<li class="am-pagination-prev">';
                    ulValue += '<a class="am-btn-xs" id="upPage">上一页</a>';
                    ulValue += '</li>';
                }


                if(totalPage <= 10) {
                    begin = 1;
                    end = totalPage;
                } else {
                    begin = pageCode - 5;
                    end = pageCode + 4;
                }

                if(begin < 1) {
                    begin = 1;
                    end = 10;
                }

                if(end > totalPage) {
                    begin = totalPage - 9;
                    end = totalPage;
                }

                for(var i = begin; i <= end; i++) {
                    ulValue += '<li>';
                    ulValue += '<a class="am-btn-xs" id="newPage_' + i + '" onclick="javascript:pageData(' + i + ');">' + i + '</a>';
                    ulValue += '</li>';
                }

                if(pageCode < totalPage) {
                    ulValue += '<li class="am-pagination-next">';
                    ulValue += '<a class="am-btn-xs" id="downPage">下一页</a>';
                    ulValue += '</li>';
                }

                ulValue += '<li class="am-pagination-last am-btn-xs">';
                ulValue += '<a class="am-btn-xs" id="endPage">尾页</a>';
                ulValue += '</li>';
                ulValue += '</ul>';

                document.getElementById("ulId").innerHTML = ulValue;

                bindAtion();

                ulValue = '';

                document.getElementById("spanId-1").innerHTML = pageCode;
                document.getElementById("spanId-2").innerHTML = totalPage;
            },
            error:function() {
                alert("数据加载错误");
            }
        });
        return pageCode, totalPage, totalRecord, pageSize;
    }

    pageData();

    //绑定事件
    function bindAtion() {
        //'首页'事件
        $("#firstPage").bind("click", function() {
            pageData(1);
        });

        //'上一页'事件
        $("#upPage").bind("click", function() {
            pageData(--pageCode);
        });

        //'页码跳转'事件--->


        //'下一页'事件
        $("#downPage").bind("click", function() {
            pageData(++pageCode);
        });

        //'尾页'事件
        $("#endPage").bind("click", function() {
            pageData(totalPage);
        });

    }


    function printf() {
        alert("1"+"--->"+pageCode+"---"+totalPage+"---"+totalRecord+"---"+pageSize);
    }



</script>
  </body>
</html>