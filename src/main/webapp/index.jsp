<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>
<link rel="stylesheet" type="text/css" href="css/style.css" media=”screen” />

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to data!
    </jsp:attribute>

    <jsp:attribute name="footer">

        <p style="text-align: center">All data is provided by yr via:  <a href="https://www.yr.no">https://www.yr.no</a>.</p>

    </jsp:attribute>

    <jsp:body>

        <div class="row mt-2">
            <div class="col">
                <h2>Get weather by city</h2>

                <div class="row">
                    <div class="col">
                        <form action="cityservlet" method="post">
                            <input type="number" hidden name="cityId" value="1">
                            <input type="text" hidden name="city" value="København">
                            <input type="submit" class="btn btn-primary" value="København" />
                        </form>
                    </div>
                </div>

                <div class="row mt-2">
                    <div class="col">
                        <form action="cityservlet" method="post">
                            <input type="number" hidden name="cityId" value="2">
                            <input type="text" hidden name="city" value="Odense">
                            <input type="submit" class="btn btn-primary" value="Odense" />
                        </form>
                    </div>
                </div>

                <div class="row mt-2">
                    <div class="col">
                        <form action="cityservlet" method="post">
                            <input type="number" hidden name="cityId" value="3">
                            <input type="text" hidden name="city" value="Esbjerg">
                            <input type="submit" class="btn btn-primary" value="Esbjerg" />
                        </form>
                    </div>
                </div>

                <div class="row mt-2">
                    <div class="col">
                        <form action="cityservlet" method="post">
                            <input type="number" hidden name="cityId" value="4">
                            <input type="text" hidden name="city" value="Rønne">
                            <input type="submit" class="btn btn-primary" value="Rønne" />
                        </form>
                    </div>
                </div>

                <div class="row mt-2">
                    <div class="col">
                        <form action="cityservlet" method="post">
                            <input type="number" hidden name="cityId" value="5">
                            <input type="text" hidden name="city" value="Skagen">
                            <input type="submit" class="btn btn-primary" value="Skagen" />
                        </form>
                    </div>
                </div>

                <div class="row mt-2">
                    <div class="col">
                        <form action="cityservlet" method="post">
                            <input type="number" hidden name="cityId" value="6">
                            <input type="text" hidden name="city" value="Gedser">
                            <input type="submit" class="btn btn-primary" value="Gedser" />
                        </form>
                    </div>
                </div>

                <div class="row mt-2">
                    <div class="col">
                        <form action="cityservlet" method="post">
                            <input type="number" hidden name="cityId" value="7">
                            <input type="text" hidden name="city" value="Gilleleje">
                            <input type="submit" class="btn btn-primary" value="Gilleleje" />
                        </form>
                    </div>
                </div>
            </div>


            <%-- Average weather --%>
            <div class="col">
                <h2>Average weather</h2>
                <c:if test="${requestScope.temp != null}">
                    <p>Temperature: ${requestScope.temp} °C</p>
                    <p>Humid: ${requestScope.humid} %</p>
                    <p>Wind: ${requestScope.wind} m/s</p>
                    <p>Precipitation: ${requestScope.precip} mm</p>
                </c:if>

                <form action="redirectindexservlet" method="post">

                    <input type="submit" class="btn btn-primary" value="Get avg weather" />
                </form>
            </div>
        </div>


    </jsp:body>

</t:pagetemplate>