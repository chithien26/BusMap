<%-- 
    Document   : station
    Created on : Aug 12, 2024, 10:27:56 AM
    Author     : lechi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tram dung</title>
    </head>
    <body>
        <h1>Stations</h1>
        <ul>
            <c:forEach var="s" items="${stations}">
                <li>${s.name}</li>
            </c:forEach>
        </ul>
    </body>
</html>
