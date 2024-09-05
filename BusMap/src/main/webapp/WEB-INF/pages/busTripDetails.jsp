<%-- 
    Document   : busTripDetails
    Created on : Sep 4, 2024, 7:34:10 PM
    Author     : lechi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<link rel="stylesheet" href="${pageContext.request.contextPath}/css/details.css"/>

<c:url value="/bus_trips/${busTrip.id}" var="action"/>
<div class="container">
    <h2>Chi Tiết Chuyến Xe</h2>
    <form:form action="${action}" method="post" modelAttribute="busTrip" >
        <div class="form-group">
            <label for="id">Mã số chuyến</label>
            <form:input type="number" path="id" id="id" name="id" value="${busTrip.id}" readonly="true"/>
        </div>

        <div class="form-group">
            <label for="tripNumber">Số thứ tự chuyến</label>
            <form:input type="number" path="tripNumber" id="tripNumber" value="${busTrip.tripNumber}" />
        </div>

        <div class="form-group">
            <label for="departureTime">Thời gian khởi hành</label>
            <form:input type="time" path="departureTime" id="departureTime" value="${busTrip.departureTime}" />
        </div>

        <div class="form-group">
            <label for="routeId">Mã tuyến</label>
            <form:input type="number" path="routeId" id="routeId" value="${busTrip.routeId}" />
        </div>

        <div class="form-group">
            <label for="vehicleId">Mã xe</label>
            <form:input type="number" path="vehicleId" id="vehicleId" value="${busTrip.vehicleId}" />
        </div>

        <div class="action-buttons">
            <button type="submit" class="btn-update bt">Cập Nhật</button>
            <a type="button" class="btn-delete bt" href="<c:url value="/bus_trips/${busTripId}/delete" />">Xóa chuyến</a>
            <a type="button" class="btn-back bt" href="<c:url value="/bus_trips" />">Quay Lại</a>
        </div>
    </form:form>
</div>