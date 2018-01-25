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
    <script src="<c:url value="/static/jquery/jquery-form.js"/>"></script>
</head>
<body>
    <div id="line" style="width: 1000px; height: 450px; position: relative; top: 60px; left: 60px;"></div>
    <div style="position: absolute; top:100px; left: 1000px;">
        <form id="form-id" action="<c:url value="/statistics/onloadLineChart"/>" method="post">
            <select id="selectId" name="year" onchange="mySbumit()">
            </select>
        </form>
    </div>
    <script>
        var myChart = echarts.init(document.getElementById("line"));
        // 初始化两个数组，盛装从数据库中获取到的数据
        var inputDates = new Array(), outputDates = new Array();
        var years = new Array();
        var newYear;

        $.ajax({
            type:'POST',
            url:'<c:url value="/statistics/onloadLineChart"/>',
            success:function (data) {
                var str = '';
                for(var i = 0; i < data.years.length; i++) {
                    str += '<option value="' + data.years[i] + '">' + data.years[i] + '</option>';
                }
                document.getElementById("selectId").innerHTML = str;
                for(var i = 0 ; i < data.inputDate.length; i++){
                    inputDates.push(data.inputDate[i]);
                    outputDates.push(data.outputDate[i]);
                }
                myChart.setOption({
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
                        data:['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series:[
                        {
                            name:'进项数据',
                            type:'line',
                            stack: '总量',
                            data:inputDates
                        },
                        {
                            name:'销项数据',
                            type:'line',
                            stack: '总量',
                            data:outputDates
                        }
                    ]
                });

                inputDates = [], outputDates = [];
            }
        });

        function mySbumit() {
            var selectVal = $("#selectId").val();
            $.ajax({
                type:'POST',
                url:'<c:url value="/statistics/onloadLineChart"/>?year=' + $("#selectId").val(),
                success:function (data) {

                    for(var i = 0 ; i < data.inputDate.length; i++){
                        inputDates.push(data.inputDate[i]);
                        outputDates.push(data.outputDate[i]);
                    }
                    myChart.setOption({
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
                            data:['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
                        },
                        yAxis: {
                            type: 'value'
                        },
                        series:[
                            {
                                name:'进项数据',
                                type:'line',
                                stack: '总量',
                                data:inputDates
                            },
                            {
                                name:'销项数据',
                                type:'line',
                                stack: '总量',
                                data:outputDates
                            }
                        ]
                    });

                    inputDates = [], outputDates = [];
                }
            });
        }

        //执行异步请求
        //getusers();

/*        var option = {
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
                data:['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
            },
            yAxis: {
                type: 'value'
            },
            series:[
                {
                    name:'进项数据',
                    type:'line',
                    stack: '总量',
                    data:inputDates
                },
                {
                    name:'销项数据',
                    type:'line',
                    stack: '总量',
                    data:outputDates
                }
            ]
        };

        myChart.setOption(option);*/

        /*var myChart = echarts.init(document.getElementById("line"));

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
                data:['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
            },
            yAxis: {
                type: 'value'
            },
            series:[
                {
                    name:'进项数据',
                    type:'line',
                    stack: '总量',
                    data:[
                    <c:forEach items="${queryVo.inputDate}" var="inputDate">
                        ${inputDate},
                    </c:forEach>
                    ]
                },
                {
                    name:'销项数据',
                    type:'line',
                    stack: '总量',
                    data:[
                        <c:forEach items="${queryVo.outputDate}" var="outputDate">
                        ${outputDate},
                        </c:forEach>
                    ]
                }
            ]
        };
        myChart.setOption(option);

        function mySbumit() {
            $("#form-id").ajaxSubmit({
                clearForm: true,
                success:function() {
                    location.replace(location.href);
                },
                error:function () {

                }
            });
        }*/
    </script>
</body>
</html>
