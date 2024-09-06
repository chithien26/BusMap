<%-- 
    Document   : schedules
    Created on : Aug 31, 2024, 11:23:23 AM
    Author     : lechi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/list.css"/>

<c:url value="/schedules" var="action"/>


<div class="container">
    <h2>Quản trị Lịch Trình</h2>
    <form action="${action}" method="get" class="search-form">
        <div class="search-input-container">
            <span class="search-icon">🔍</span>
            <input type="text" id="keyword" name="kw" placeholder="Nhập tên Lịch Trình...">
            <input type="submit" value="Tìm kiếm">
        </div>

    </form>

    <div class="route-list">
        <table class="route-table">
            <thead>
                <tr>
                    <th style="width: 130px">Mã lịch trình</th>
                    <th>Mã chuyến</th>
                    <th>Mã trạm</th>
                    <th>Thời gian đến</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="schedule" items="${schedules}">
                    <tr>
                        <td style="text-align: center">${schedule.id}</td>
                        <td style="text-align: center">${schedule.busTrip}</td>
                        <td style="text-align: center">${schedule.station}</td>
                        <td>${schedule.arrivalTime}</td>
                        <td>
                            <div class="action-buttons">
                                <a href="<c:url value='/schedules/${schedule.id}' />" class="btn-edit">Sửa</a>
                                <a href="<c:url value='/schedules/${schedule.id}/delete' />"  class="btn-delete" >Xóa</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


    
    <div class="create-route-form">
        <h4>Tạo Mới Lịch Trình</h4>
        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
        <form:form method="post" action="${action}"  modelAttribute="schedule">
            <label for="browser" class="form-label">Chuyến xe:</label>
            <form:select class="form-select" path="busTrip" >
                <c:forEach items="${busTrips}" var="b">
                    <c:choose>
                        <c:when test="${b.id == schedule.busTrip.id}">
                            <option value="${b.id}" selected>${b.id}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${b.id}">${b.id}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <label for="station">Mã trạm</label>
            <form:input path="station" type="number" id="station" placeholder="Nhập mã trạm..." name="station" />
            <label for="arrivalTime">Thời gian đến trạm:</label>
            <form:input path="arrivalTime" type="time" id="arrivalTime" name="arrivalTime" />
            <button type="submit">Thêm lịch trình</button>
        </form:form>
    </div>
</div>
