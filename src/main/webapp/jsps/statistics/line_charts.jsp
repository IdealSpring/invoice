<%--
  Created by IntelliJ IDEA.
  User: zhipeng-Tong
  Date: 2018/1/24
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>折线图</title>
    <script src="<c:url value="/static/echarts/echarts.js"/>"></script>
    <script src="<c:url value="/static/jquery/1.9.1/jquery.js"/>"></script>
</head>
<body>
    <div id="line" style="width: 1000px; height: 450px; position: relative; top: 60px; left: 60px;"></div>
    <div style="position: absolute; top:100px; left: 1000px;">
        <select>
            <option>2017</option>
            <option>2018</option>
        </select>
    </div>
    <script>
        var myChart = echarts.init(document.getElementById("line"));

        var option = {
            title:{
                text:'进销项数据对比折线图'
            },
            tooltip:{
                trigger: 'axis'
            },
            legend:{
                data:['进项数据', '销项数据']
            },
            grid:{
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
            },
            xAxis:{
                type:'category',
                boundaryGap: false,
                data:['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月', ]
            },
            yAxis: {
                type: 'value'
            },
            series:[
                {
                    name:'进项数据',
                    type:'line',
                    stack: '总量',
                    data:[120, 132, 101, 134, 90, 230, 210, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'销项数据',
                    type:'line',
                    stack: '总量',
                    data:[220, 182, 191, 234, 290, 330, 310, 132, 101, 134, 90, 230, 210]
                }
            ]
        };
        myChart.setOption(option);
    </script>
</body>
</html>
