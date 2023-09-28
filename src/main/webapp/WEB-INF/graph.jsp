<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Graph
    </jsp:attribute>

    <jsp:attribute name="footer">

        <p class="bold" style="text-align: center">All data is provided by yr via:  <a href="https://www.yr.no">https://www.yr.no</a>.</p>

    </jsp:attribute>

    <jsp:body>

        <h1>Temperature over time</h1>

        <!-- Load the Google Charts library -->
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            // Load the Visualization API and set a callback function
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {

                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Date');
                data.addColumn('number', 'Temperature');

                var jsonArray = '${requestScope.json}';

                // Parse the JSON data
                var jsonData = JSON.parse(jsonArray);
                console.log(jsonData);

                // Add data rows to the DataTable
                for (var i = 0; i < jsonData.length; i++) {
                    data.addRow([jsonData[i].time, jsonData[i].temp]);
                }

                var options = {
                    title: 'Weather',
                    curveType: 'function',
                    legend: { position: 'bottom' }
                };

                var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
                chart.draw(data, options);
            }
        </script>

        <!-- HTML element to display the chart -->
        <div id="chart_div" style="width: 800px; height: 400px;"></div>

        <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);
        </script>

    </jsp:body>

</t:pagetemplate>
