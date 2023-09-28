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

        <h1>HEJ!</h1>

        <input type="button" onclick="createGraph()">

        <script>
            function createGraph(){
                let data = '${requestScope.json}';
                console.log(data);
                console.log(typeof data)
            }
        </script>

    </jsp:body>

</t:pagetemplate>
