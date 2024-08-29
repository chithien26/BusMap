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

<c:url value="/stations" var="station"/>

<div class="container">
    <h2>Chi Tiết Trạm Dừng</h2>
    <form:form action="${station}" method="post">
        <div class="form-group">
            <label for="id">Mã Trạm Dừng</label>
            <form:input type="text" path="id" id="id" value="" />
        </div>

        <div class="form-group">
            <label for="stationName">Tên Trạm Dừng</label>
            <form:input type="text" path="name" id="stationName" value="" />
        </div>



        <div class="action-buttons">
            <button type="submit" class="btn-update bt">Cập Nhật</button>
            <button type="button" class="btn-delete bt" onclick="#">Xóa Trạm</button>
            <button type="button" class="btn-back bt" onclick="#">Quay Lại</button>
        </div>
    </form:form>
</div>
