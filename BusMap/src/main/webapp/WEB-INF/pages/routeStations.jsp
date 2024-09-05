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
            <input type="text" id="keyword" name="kw" placeholder="">
            <input type="submit" value="Tìm kiếm">
        </div>

    </form>

    <div class="route-list">
        <table class="route-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Mã số tuyến</th>
                    <th>Mã trạm</th>
                    <th>Số thứ tự</th>
                    <th>KC -> tram ke tiep</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="routeStation" items="${routeStations}">
                    <tr>
                        <td>${routeStation.id}</td>
                        <td style="text-align: center">${routeStation.routeId}</td>
                        <td>${routeStation.stationId}</td>
                        <td>${routeStation.order}</td>
                        <td>${routeStation.distFromPre}</td>
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

    <div class="create-route-form">
        <h4>Tạo Mới Tuyến - Trạm</h4>
        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
        <form:form method="post" action="${action}"  modelAttribute="routeStation">
            <label for="routeId">Mã số tuyến:</label>
            <form:input path="routeId" type="number" id="routeId" placeholder="Nhập mã số tuyến..." name="routeId" />
            <label for="stationId">Mã trạm:</label>
            <form:input path="stationId" type="number" id="stationId" placeholder="Nhập mã số trạm..." name="stationId" />
            <label for="order">Số thứ tự:</label>
            <form:input path="order" type="number" id="order" placeholder="Nhập số thứ tự..." name="order" />
            <label for="distFromPre">Khoảng cách đến trạm kế tiếp:</label>
            <form:input path="distFromPre" type="text" id="distFromPre" placeholder="Nhập khoảng cách đến trạm kế tiếp..." name="distFromPre" />
            
            <button type="submit">Thêm tuyến-trạm</button>
        </form:form>
    </div>


</div>