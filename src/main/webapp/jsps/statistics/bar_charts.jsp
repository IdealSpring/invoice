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
    <title>柱状图</title>
    <script src="<c:url value="/static/echarts/echarts.js"/>"></script>
    <script src="<c:url value="/static/jquery/1.9.1/jquery.js"/>"></script>
    <script src="<c:url value="/static/jquery/jquery-form.js"/>"></script>
</head>
<body>
    <div id="line" style="width: 1000px; height: 450px; position: relative; top: 60px; left: 60px;"></div>
    <div style="position: absolute; top:100px; left: 1000px;">
        <select id="selectId" onchange="updateData()">
        </select>
    </div>
    <script>
        var myChart = echarts.init(document.getElementById("line"));
        //初始化两个数组，存放数据
        var inputDatas = new Array(), outputDates = new Array();

        //计数器
        var count = 0;

        function onloadData(year) {
            if(year == null) {
                var urlVal = '<c:url value="/statistics/onloadLineChart"/>';
            } else {
                var urlVal = '<c:url value="/statistics/onloadLineChart"/>?year=' + year;
            }
            $.ajax({
                type:'POST',
                url:urlVal,
                success:function(data) {
                    if(count++ < 1) {
                        var str = '';
                        for(var i = 0; i < data.years.length; i++) {
                            str += '<option value="' + data.years[i] + '">' + data.years[i] + '</option>';
                        }
                        document.getElementById("selectId").innerHTML = str;
                    }

                    for(var i = 0 ; i < data.inputDate.length; i++){
                        inputDatas.push(data.inputDate[i]);
                        outputDates.push(data.outputDate[i]);
                    }

                    myChart.setOption({
                        tooltip : {
                            trigger: 'axis',

                        },
                        legend: {
                            data:['进项数据','销项数据']
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        xAxis : [
                            {
                                type : 'category',
                                data : ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
                            }
                        ],
                        yAxis : [
                            {
                                type : 'value'
                            }
                        ],
                        series : [
                            {
                                name:'进项数据',
                                type:'bar',
                                data:inputDatas
                            },
                            {
                                name:'销项数据',
                                type:'bar',
                                data:outputDates
                            }
                        ]
                    });

                    inputDates = new Array(), outputDates = new Array();
                }
            });
        }

        onloadData();

        function updateData() {
            onloadData($("#selectId").val());
        }
    </script>
</body>
</html>
