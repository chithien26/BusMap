<%-- 
    Document   : station
    Created on : Aug 12, 2024, 10:27:56 AM
    Author     : lechi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/admin/stations" var="station"/>
<h1 class="text-center"><spring:message code="lable.quanlytramdung"/></h1>
<form action="${station}" method="get" style="margin: 20px">
    <label for="keyword">Tìm kiếm:</label>
    <input type="text" id="keyword" name="kw" placeholder="Nhập tên trạm dừng...">
    <input type="submit" value="Tìm kiếm">
</form>

<ul class="bContainer">
    <c:forEach var="route" items="${stations}">
        <li>
            <a href="#" style="text-decoration: none; color: black">
                <div class="bItem">
                    <h4 class="bId" > ${route.id}</h4>
                    <h5 class="bName">${route.name}</h5>   
                </div>
            </a>
        </li>
    </c:forEach>
</ul>

