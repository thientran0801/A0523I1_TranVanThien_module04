<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Condiment</title>
</head>
    <body>
    <h1>Sandwich Condiments</h1>
    <hr>
    <c:forEach items="${condiment}" var="c" varStatus="loop">
        <span>${loop.count}: <strong>${c}</strong></span>
        <br>
    </c:forEach>
    </body>
</html>
