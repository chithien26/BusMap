<%-- 
    Document   : stationDetails
    Created on : Aug 24, 2024, 6:06:44 PM
    Author     : lechi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<link rel="stylesheet" href="${pageContext.request.contextPath}/css/details.css"/>

<c:url value="/stations/${station.id}" var="action"/>
<div class="container">
    <h2>Chi Tiết Trạm dừng</h2>
    <form:form action="${action}" method="post" modelAttribute="station" >
        <div class="form-group">
            <label for="id">Mã trạm dừng</label>
            <form:input type="number" path="id" id="id" name="id" value="${station.id}" readonly="true"/>
        </div>

        <div class="form-group">
            <label for="name">Tên trạm dừng</label>
            <form:input type="text" path="name" id="name" value="${station.name}" />
        </div>

        <div class="form-group">
            <label for="address">Địa chỉ</label>
            <form:input type="text" path="address" id="address" value="${station.address}" />
        </div>
        <div class="form-group">
            <label for="longitude">Kinh độ</label>
            <form:input type="text" path="longitude" id="longitude" value="${station.longitude}" />
        </div>
        <div class="form-group">
            <label for="latitude">Vĩ độ</label>
            <form:input type="text" path="latitude" id="latitude" value="${station.latitude}" />
        </div>

        <div class="action-buttons">
            <button type="submit" class="btn-update bt">Cập Nhật</button>
            <a type="button" class="btn-delete bt" href="<c:url value="/stations/${stationId}/delete" />">Xóa Tuyến</a>
            <a type="button" class="btn-back bt" href="<c:url value="/stations" />">Quay Lại</a>
        </div>
    </form:form>
</div>