    <%-- 
        Document   : newjsp
        Created on : Aug 24, 2024, 12:56:42 PM
        Author     : lechi
    --%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/details.css"/>

    <c:url value="/routes/${route.id}" var="action"/>
    <div class="container">
        <h2>Chi Tiết Tuyến Đường</h2>
        <form:form action="${action}" method="post" modelAttribute="route" >
            <div class="form-group">
                <label for="id">Mã Tuyến Đường</label>
                <form:input type="number" path="id" id="id" name="id" value="${route.id}" />
            </div>

            <div class="form-group">
                <label for="name">Tên Tuyến Đường</label>
                <form:input type="text" path="name" id="name" value="${route.name}" />
            </div>

            <div class="form-group">
                <label for="firstTrip">Chuyến đầu tiên</label>
                <form:input type="time" path="firstTrip" id="firstTrip" value="${route.firstTrip}" />
            </div>

            <div class="form-group">
                <label for="lastTrip">Chuyến cuối cùng</label>
                <form:input type="time" path="lastTrip" id="lastTrip" value="${route.lastTrip}" />
            </div>

            <div class="form-group">
                <label for="fare">Giá vé</label>
                <form:input type="number" path="fare" id="fare" value="${route.fare}" />
            </div>

            <div class="action-buttons">
                <button type="submit" class="btn-update bt">Cập Nhật</button>
                <a type="button" class="btn-delete bt" href="<c:url value="/routes/${routeId}/delete" />">Xóa Tuyến</a>
                <a type="button" class="btn-back bt" href="<c:url value="/routes" />">Quay Lại</a>
            </div>
        </form:form>
    </div>