<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <title>Charts Example</title>
    <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages':['corechart', 'bar', 'line', 'geochart']});
        google.charts.setOnLoadCallback(drawCharts);

        function drawCharts() {
            fetch('${path2}/chart/chart-data')
                .then(response => response.json())
                .then(data => {
                    drawLineChart(data.lineChart);
                    drawBarChart(data.barChart);
                    drawColumnChart(data.columnChart);
                    drawPieChart(data.pieChart);
                    drawRadarChart(data.radarChart);
                    drawScatterChart(data.scatterChart);
                    drawMapChart(data.mapChart);
                });
        }

        function drawLineChart(data) {
            var dataTable = new google.visualization.DataTable();
            dataTable.addColumn('number', 'X');
            dataTable.addColumn('number', 'Values');
            data.forEach((value, index) => dataTable.addRow([index + 1, value]));

            var options = {
                title: 'Line Chart',
                curveType: 'function',
                legend: { position: 'bottom' }
            };

            var chart = new google.visualization.LineChart(document.getElementById('line_chart'));
            chart.draw(dataTable, options);
        }

        function drawBarChart(data) {
            var dataTable = new google.visualization.DataTable();
            dataTable.addColumn('string', 'X');
            dataTable.addColumn('number', 'Values');
            data.forEach((value, index) => dataTable.addRow([`Category ${index + 1}`, value]));

            var options = {
                title: 'Bar Chart',
                legend: { position: 'bottom' }
            };

            var chart = new google.visualization.BarChart(document.getElementById('bar_chart'));
            chart.draw(dataTable, options);
        }

        function drawColumnChart(data) {
            var dataTable = new google.visualization.DataTable();
            dataTable.addColumn('string', 'X');
            dataTable.addColumn('number', 'Values');
            data.forEach((value, index) => dataTable.addRow([`Category ${index + 1}`, value]));

            var options = {
                title: 'Column Chart',
                legend: { position: 'bottom' }
            };

            var chart = new google.visualization.ColumnChart(document.getElementById('column_chart'));
            chart.draw(dataTable, options);
        }

        function drawPieChart(data) {
            var dataTable = new google.visualization.DataTable();
            dataTable.addColumn('string', 'Category');
            dataTable.addColumn('number', 'Values');
            data.forEach((value, index) => dataTable.addRow([`Category ${index + 1}`, value]));

            var options = {
                title: 'Pie Chart',
                legend: { position: 'bottom' }
            };

            var chart = new google.visualization.PieChart(document.getElementById('pie_chart'));
            chart.draw(dataTable, options);
        }

        function drawRadarChart(data) {
            var ctx = document.getElementById('radar_chart').getContext('2d');
            new Chart(ctx, {
                type: 'radar',
                data: {
                    labels: ['A', 'B', 'C', 'D', 'E', 'F'],
                    datasets: [{
                        label: 'Radar Chart',
                        data: data,
                        backgroundColor: 'rgba(54, 162, 235, 0.2)',
                        borderColor: 'rgba(54, 162, 235, 1)'
                    }]
                },
                options: {
                    responsive: true,
                    scales: {
                        r: {
                            beginAtZero: true
                        }
                    }
                }
            });
        }

        function drawScatterChart(data) {
            var dataTable = new google.visualization.DataTable();
            dataTable.addColumn('number', 'X');
            dataTable.addColumn('number', 'Y');
            data.forEach(point => dataTable.addRow(point));

            var options = {
                title: 'Scatter Chart',
                legend: { position: 'bottom' }
            };

            var chart = new google.visualization.ScatterChart(document.getElementById('scatter_chart'));
            chart.draw(dataTable, options);
        }

        function drawMapChart(data) {
            console.log('Map Chart Data:', data);
            var dataTable = new google.visualization.DataTable();
            dataTable.addColumn('string', 'City');
            dataTable.addColumn('number', 'Population');
            dataTable.addRows(data);

            var options = {
                region: 'KR',
                displayMode: 'markers',
                colorAxis: {colors: ['green', 'blue']}
            };

            var chart = new google.visualization.GeoChart(document.getElementById('map_chart'));
            chart.draw(dataTable, options);
        }
    </script>
</head>
<body>
    <h1>Google Charts</h1>
    <hr>
    <div id="line_chart" style="width: 900px; height: 500px;"></div>
    <div id="bar_chart" style="width: 900px; height: 500px;"></div>
    <div id="column_chart" style="width: 900px; height: 500px;"></div>
    <div id="pie_chart" style="width: 900px; height: 500px;"></div>
    <div id="radar" style="width:900px;">
        <canvas id="radar_chart" style="width: 900px; height: 500px;" style="max-width:900px;"></canvas>
    </div>    
    <div id="scatter_chart" style="width: 900px; height: 500px;"></div>
    <div id="map_chart" style="width: 900px; height: 500px;"></div>
</body>
</html>