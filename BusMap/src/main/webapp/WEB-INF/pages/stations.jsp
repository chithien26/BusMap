<%-- 
    Document   : station
    Created on : Aug 12, 2024, 10:27:56 AM
    Author     : lechi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/list.css"/>


<c:url value="/stations" var="action"/>


<div class="container">
    <h2>Quản trị trạm dừng</h2>

    <form action="${action}" method="get" class="search-form">
        <div class="search-input-container">
            <span class="search-icon">🔍</span>
            <input type="text" id="keyword" name="kw" placeholder="Nhập tên trạm dừng...">
            <input type="submit" value="Tìm kiếm">
        </div>
        
    </form>

    <div class="route-list">
        <table class="route-table">
            <thead>
                <tr>
                    <th>Mã số trạm</th>
                    <th>Tên trạm</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="station" items="${stations}">
                    <tr>
                        <td style="text-align: center">${station.id}</td>
                        <td>${station.name}</td>
                        <td>
                            <div class="action-buttons">
                                <a href="<c:url value='/stations/${station.id}' />" class="btn-edit">Sửa</a>
                                <a href="<c:url value='/stations/${station.id}/delete' />"  class="btn-delete" >Xóa</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="create-route-form">
        <h4>Tạo Mới Trạm Dừng</h4>
        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
        <form:form method="post" action="${action}"  modelAttribute="station">
            <label for="id">Mã số trạm:</label>
            <form:input path="id" type="number" id="id" placeholder="Nhập mã số tuyến..." name="id" />
            <label for="name">Tên Trạm:</label>
            <form:input path="name" type="text" id="name" placeholder="Nhập tên tuyến đường..." name="name" />
            <label for="address">Địa chỉ:</label>
            <form:input path="address" type="text" id="address" name="address" />
            <label for="longitude">Kinh độ:</label>
            <form:input path="longitude" type="number" id="longitude" name="longitude" />
            <label for="longitude">Vĩ độ:</label>
            <form:input path="latitude" type="number" id="latitude" name="latitude" />
            <button type="submit">Thêm trạm dừng</button>
        </form:form>
    </div>
</div>

    

