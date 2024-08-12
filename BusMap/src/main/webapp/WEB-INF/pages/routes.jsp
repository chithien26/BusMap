<%-- 
    Document   : search
    Created on : Aug 8, 2024, 3:52:59 AM
    Author     : lechi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>products</title>
    </head>
    <body>
        <h1>List routes</h1>
        <form action="/BusMap/routes" method="get">
        <label for="keyword">Tìm kiếm:</label>
        <input type="text" id="keyword" name="kw" placeholder="Nhập tên tuyến đường...">
        <input type="submit" value="Tìm kiếm">
    </form>

    <!-- Hiển thị danh sách các tuyến đường -->
    <%--<c:if test="${route != null}">--%>
        <ul>
            <c:forEach var="route" items="${routes}">
                <li>${route.name}</li>
            </c:forEach>
        </ul>
    <%--</c:if>--%>
    </body>
</html>
