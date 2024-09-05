<%-- 
    Document   : busTrips
    Created on : Sep 3, 2024, 1:52:46 PM
    Author     : lechi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/list.css"/>


<c:url value="/bus_trips" var="action"/>


<div class="container">
    <h2>Quản trị Chuyến Xe</h2>
    <form action="${action}" method="get" class="search-form">
        <div class="search-input-container">
            <span class="search-icon">🔍</span>
            <input type="text" id="keyword" name="kw" placeholder="Nhập tên chuyến xe...">
            <input type="submit" value="Tìm kiếm">
        </div>

    </form>

    <div class="route-list">
        <table class="route-table">
            <thead>
                <tr>
                    <th>Mã số chuyến</th>
                    <th>Số thứ tự chuyến</th>
                    <th>Thời gian khởi hành</th>
                    <th>Mã tuyến</th>
                    <th>Mã xe</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="busTrip" items="${busTrips}">
                <tr>
                    <td style="text-align: center">${busTrip.id}</td>
                    <td>${busTrip.tripNumber}</td>
                    <td>${busTrip.departureTime}</td>
                    <td>${busTrip.routeId}</td>
                    <td>${busTrip.vehicleId}</td>

                    <td>
                        <div class="action-buttons">
                            <a href="<c:url value='/bus_trips/${busTrip.id}' />" class="btn-edit">Sửa</a>
                            <a href="<c:url value='/bus_trips/${busTrip.id}/delete' />"  class="btn-delete" >Xóa</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


    <div class="create-route-form">
        <h4>Tạo Mới Chuyến Xe</h4>
        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
        <form:form method="post" action="${action}" modelAttribute="busTrip">
            <label for="tripNumber">Số thứ tự chuyến:</label>
            <form:input path="tripNumber" type="number" id="tripNumber" placeholder="Nhập số chuyến xe..." name="tripNumber" />
            <label for="departureTime">Giờ khởi hành:</label>
            <form:input path="departureTime" type="time" id="departureTime" name="departureTime" />
            <label for="routeId">Tuyến xe:</label>
            <form:input path="routeId" type="number" id="routeId" name="routeId" placeholder="Nhập mã tuyến xe..."/>
            <label for="vehicleId" >Xe:</label>
            <form:input path="vehicleId" type="number" id="vehicleId" placeholder="Nhập mã xe..." name="vehicleId" />
            <button type="submit">Thêm chuyến xe</button>
        </form:form>
    </div>
</div>
