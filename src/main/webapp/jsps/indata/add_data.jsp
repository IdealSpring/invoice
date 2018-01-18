<%--
  Created by IntelliJ IDEA.
  User: zhipeng-Tong
  Date: 2018/1/18
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加进销项数据</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="/invoice/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="/invoice/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="/invoice/static/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/invoice/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="/invoice/static/h-ui.admin/css/style.css" />
</head>
<body>
<article class="page-container page-index">
    <form action="" method="post" class="form form-horizontal" id="form-member-add">
        <div class="row cl">

            <div class="formControls col-xs-8 col-sm-9">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>发票编号：</label>
                <input type="text" class="input-text" value="" placeholder="" id="username" name="username">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>发票名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="username" name="username">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">种类：</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="city">
					<option value="" selected>请选择城市</option>
					<option value="1">北京</option>
					<option value="2">上海</option>
					<option value="3">广州</option>
				</select>
				</span> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>金额：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="username" name="username">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>发票时间：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="username" name="username">
            </div>
        </div>

        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/invoice/static/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/invoice/static/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/invoice/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/invoice/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<script type="text/javascript">
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#form-member-add").validate({
            rules:{
                username:{
                    required:true,
                    minlength:2,
                    maxlength:16
                },
                sex:{
                    required:true,
                },
                mobile:{
                    required:true,
                    isMobile:true,
                },
                email:{
                    required:true,
                    email:true,
                },
                uploadfile:{
                    required:true,
                },

            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                //$(form).ajaxSubmit();
                var index = parent.layer.getFrameIndex(window.name);
                //parent.$('.btn-refresh').click();
                parent.layer.close(index);
            }
        });
    });
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
