<%@ page contentType="text/html;charset=UTF-8" %>
<t:pagetemplate>
    <!DOCTYPE html>
    <html>
    <head>
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

                    data.addRows([
                        ['2018', 1000],
                        ['2019', 1170],
                        ['2020', 660],
                        ['2021', 1030]
                    ]);


                var options = {
                title: 'Weather',
                curveType: 'function',
                legend: { position: 'bottom' }
            };

                var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
                chart.draw(data, options);
        }
        </script>

        </script>
        <title></title>
    </head>
    <body>
    <!-- HTML element to display the chart -->
    <div id="chart_div" style="width: 800px; height: 400px;"></div>

    <script type="text/javascript">
        google.charts.load('current', {'packages': ['corechart']});
        google.charts.setOnLoadCallback(drawChart);
    </script>

    </body>
    </html>
</t:pagetemplate>
