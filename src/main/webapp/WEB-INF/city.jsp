<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Weather forecast for ${requestScope.cityName}
    </jsp:attribute>

    <jsp:attribute name="footer">

        <p class="bold" style="text-align: center">All data is provided by yr via:  <a href="https://www.yr.no">https://www.yr.no</a>.</p>

    </jsp:attribute>

    <jsp:body>

        <div class="mt-2">

            <table class="table table-dark table-striped">
                <tr>
                    <th>Humid</th>
                    <th>Precipitation</th>
                    <th>SkyText</th>
                    <th>Temperature</th>
                    <th>Time</th>
                    <th>Wind</th>
                </tr>

                <c:forEach var="weather" items="${requestScope.weatherList}">
                <tr>
                    <td>${weather.humid}</td>
                    <td>${weather.precipitation}</td>
                    <td>${weather.skyText}</td>
                    <td>${weather.temperature}</td>
                    <td>${weather.time}</td>
                    <td>${weather.wind}</td>
                </tr>
                </c:forEach>
            </table>
        </div>

    </jsp:body>

</t:pagetemplate>