<%-- 
    Document   : search
    Created on : Aug 8, 2024, 3:52:59 AM
    Author     : lechi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/list.css"/>


<c:url value="/routes" var="action"/>


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
                    <th>Tên Tuyến</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="route" items="${routes}">
                    <tr>
                        <td style="text-align: center">${route.id}</td>
                        <td>${route.name}</td>
                        <td>
                            <div class="action-buttons">
                                <a href="<c:url value='/routes/${route.id}' />" class="btn-edit">Sửa</a>
                                <a href="<c:url value='/routes/${route.id}/delete' />"  class="btn-delete" >Xóa</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


    
    <!-- Form tạo mới tuyến đường -->
    <div class="create-route-form">
        <h4>Tạo Mới Tuyến Đường</h4>
        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
        <form:form method="post" action="${action}"  modelAttribute="route">
            <label for="id">Mã số tuyến:</label>
            <form:input path="id" type="number" id="id" placeholder="Nhập mã số tuyến..." name="id" />
            <label for="name">Tên Tuyến:</label>
            <form:input path="name" type="text" id="name" placeholder="Nhập tên tuyến đường..." name="name" />
            <label for="firstTrip">Chuyến đầu tiên:</label>
            <form:input path="firstTrip" type="time" id="firstTrip" name="firstTrip" />
            <label for="lastTrip">Chuyến cuối cùng:</label>
            <form:input path="lastTrip" type="time" id="lastTrip" name="lastTrip" />
            <label for="fare" >Giá vé:</label>
            <form:input path="fare" type="number" id="fare" placeholder="Nhập giá vé..." name="fare" />
            <button type="submit">Thêm tuyến đường</button>
        </form:form>
    </div>
</div>