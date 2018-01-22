<%--
  Created by IntelliJ IDEA.
  User: zhipeng-Tong
  Date: 2018/1/18
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>添加进销项数据</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="/invoice/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/invoice/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="/invoice/static/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="/invoice/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="/invoice/static/h-ui.admin/css/style.css"/>
</head>
<body>
<article class="page-container page-index">
    <form action="<c:url value="/indata/updateOneRecord"/>" method="post" class="form form-horizontal" id="form-submit">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>发票编号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="hidden" name="iid" value="${invoice.iid}">
                <input value="${invoice.number}" type="text" class="input-text" id="numberid" onblur="checknumber()" placeholder="最多不超过15位"  name="number">
                <span class="c-red" style="position: absolute; top: 5px; right: 20px; display: none;" id="error_number"><i class="Hui-iconfont">&#xe6dd;</i></span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>发票名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input value="${invoice.name}" type="text" class="input-text" id="nameid" onblur="checkName()" placeholder="最多不超过30位" name="name">
                <span class="c-red" style="position: absolute; top: 5px; right: 20px; display: none;" id="error_name"><i class="Hui-iconfont">&#xe6dd;</i></span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>种类：</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="kind">
					<option value="true">进项数据</option>
					<option value="false">销项数据</option>
				</select>
                </span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>金额：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input value="${invoice.money}" type="text" class="input-text" placeholder="" name="money">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>发票时间：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" id="dataid" onkeyup="checkData()" value="<fmt:formatDate value="${invoice.date}" pattern="yyyy-MM-dd"/>" placeholder="格式：2018-01-01" name="date">
                <span class="c-red" style="position: absolute; top: 5px; right: 20px; display: none;" id="error_data"><i class="Hui-iconfont">&#xe6dd;</i></span>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="button" id="submitid" onclick="myWaiteClose()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
                <input class="btn btn-defaul radius" type="button" onclick="myClose()" value="&nbsp;&nbsp;退出&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/invoice/static/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/invoice/static/jquery/jquery-form.js"></script>
<script type="text/javascript" src="/invoice/static/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/invoice/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/invoice/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<script type="text/javascript">
    var flagNumber = false;
    var flagName = false;
    var flagData = false;

    function checkData() {
        var value = document.getElementById("dataid").value;
        var error = document.getElementById("error_data");
        var reg = /^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$/;
        if(reg.test(value)) {
            error.style.display = 'none';
            flagData = true;
        } else {
            error.style.display = "";
        }
    }

    function checknumber() {
        var value = document.getElementById("numberid").value;
        var length = value.length;
        var error = document.getElementById("error_number");
        if(length > 15) {
            error.style.display = "";
        } else {
            error.style.display = 'none';
            flagNumber = true;
        }
    }

    function checkName() {
        var val = document.getElementById("nameid").value;
        var length = val.length;
        var error = document.getElementById("error_name");
        if(length > 30) {
            error.style.display = "";
        } else {
            error.style.display = 'none';
            flagName = true;
        }
    }
    
    $(document).ready(function () {
        $("#submitid").bind("click", function () {
            checkData();
            checknumber();
            checkName();
            if(flagNumber && flagName && flagData) {
                $("#form-submit").ajaxSubmit({
                    type: 'POST',
                    url: '<c:url value="/indata/updateOneRecord"/>',
                    success:function(data){
                        alert(data);
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                        window.onload();
                    },
                    error:function() {
                        alert("修改失败！");
                    }
                });
            } else {
                alert("请按要求填入信息");
            }
        });
    });

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>