<%-- 
    Document   : search
    Created on : Aug 8, 2024, 3:52:59 AM
    Author     : lechi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/admin/routes" var="route"/>
<h1 class="text-center" style="padding: 10px"><spring:message code="lable.quanlytuyenduong"/></h1>
<form action="${route}" method="get" style="margin: 20px">
    <label for="keyword">Tìm kiếm:</label>
    <input type="text" id="keyword" name="kw" style="width: 230px" placeholder="Nhập mã số hoặc tên tuyến...">
    <input type="submit" value="Tìm kiếm">
</form>

<ul class="bContainer">
    <c:forEach var="route" items="${routes}">
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