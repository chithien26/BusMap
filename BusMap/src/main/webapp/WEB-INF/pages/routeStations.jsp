<%-- 
    Document   : routeStations
    Created on : Sep 4, 2024, 9:16:00 AM
    Author     : lechi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/list.css"/>

<c:url value="/route_stations" var="action"/>


<div class="container">
    <h2>Quản trị Tuyến Đường</h2>
    <form action="${action}" method="get" class="search-form">
        <div class="search-input-container">
            <span class="search-icon">🔍</span>
            <input type="text" id="keyword" name="kw" placeholder="Nhập tên tuyến đường...">
            <input type="submit" value="Tìm kiếm">
        </div>

    </form>

    <!-- Bảng danh sách tuyến đường -->
    <div class="route-list">
        <table class="route-table">
            <thead>
                <tr>
                    <th>Mã số tuyến</th>
                    
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="routeStation" items="${routeStations}">
                    <tr>
                        <td style="text-align: center">${routeStation.id}</td>
                        
                        <td>
                            <div class="action-buttons">
                                <a href="<c:url value='/route_stations/${routeStation.id}' />" class="btn-edit">Sửa</a>
                                <a href="<c:url value='/route_stations/${routeStation.id}/delete' />"  class="btn-delete" >Xóa</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


    
    
</div>