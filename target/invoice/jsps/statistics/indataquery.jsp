<%--
  Created by IntelliJ IDEA.
  User: zhipeng-Tong
  Date: 2018/1/23
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="<c:url value="/static/echarts/echarts.js"/>"></script>
    <script src="<c:url value="/static/jquery/1.9.1/jquery.js"/>"></script>

</head>
<body>
    <%--为echarts准备div--%>
    <div id="main" style="width: 600px; height: 400px;"></div>
    <button id="btn-1" type="button">请求是json</button>
    <button id="btn-2" type="button">相应是json</button>
    <script>


        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById("main"));
        //指定图标的配置的项和数据
        var option = {
            title:{
                text:'echarts入门'
            },
            tooltip:{},
            legend:{
                data:['销量']
            },
            xAxis:{
                data:["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            },
            yAxis:{},
            series:[{
                name:'销量',
                type:'bar',
                data:[5, 20, 36, 10, 10, 20]
            }]
        };

        $(document).ready(function() {
            $("#btn-1").bind("click", function() {
                $.ajax({
                    type:'POST',
                    url:'<c:url value="/queryCharts/jsonTest"/>',
                    contentType:'application/json; charset=utf-8',
                    data:'{"name":"phone"}',
                    success:function(data) {
                        alert(data);
                    }
                });
            });
            $("#btn-2").bind("click", function() {
                $.ajax({
                    type:'POST',
                    url:'<c:url value="/queryCharts/jsonTest2"/>',
                    /*contentType:'application/json; charset=utf-8',*/
                    /*data:'name=手机',*/
                    success:function(data) {
                        myChart.setOption(option);
                    }
                });
            });
        });
        // 使用刚指定的配置项和数据显示图表
        //myChart.setOption(option);
        /*myChart.setOption({
            series:[{
                name:'访问数据',
                type:'pie',
                radius:'55%',
                data:[
                    {value:200,name:'爱好'},
                    {value:100,name:'盘谷歌'},
                    {value:100,name:'你闺蜜鞥'},
                    {value:100,name:'李恒'}
                ]
            }]
        });*/
    </script>
</body>
</html>
