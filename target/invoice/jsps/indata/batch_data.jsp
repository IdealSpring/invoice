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
    <form enctype="multipart/form-data" action="<c:url value="/indata/insertBatchRecord"/>" method="post" class="form form-horizontal" id="submit">
        <div class="row cl">
            选择文件:<input type="file" id="excelPath"  name="file">
            <%--${sessionScope.roleID}--%>
            <input type="hidden" name="uid" value="10"/>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" id="importBuildInfo" type="button" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
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
    /*关闭窗口*/
    function myClose() {
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    }

    /*重要，明天练习*/
    $(document).ready(function(){
        $("#importBuildInfo").bind("click",function(){
            var excelPath = $("#excelPath").val();
            if(excelPath == null || excelPath == ''){
                alert("请选择要上传的Excel文件");
                return;
            }else{
                var fileExtend = excelPath.substring(excelPath.lastIndexOf('.')).toLowerCase();
                if(fileExtend == '.xls'){
                    $("#submit").ajaxSubmit({
                        success: function(data) {
                            alert(data);
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                        } ,
                        error:function(){
                            alert("上传失败");
                        }
                    });
                }else{
                    alert("文件格式需为'.xls'格式");
                    return;
                }
            }
        });
    });


</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>