<%-- 
    Document   : User
    Created on : Sep 7, 2024, 8:59:24 AM
    Author     : lechi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/list.css"/>


<c:url value="/users" var="action"/>


<div class="container">
    <h2>Quản trị Người Dùng</h2>
    <form action="${action}" method="get" class="search-form">
        <div class="search-input-container">
            <span class="search-icon">🔍</span>
            <input type="text" id="keyword" name="kw" placeholder="Nhập username...">
            <input type="submit" value="Tìm kiếm">
        </div>

    </form>

    <div class="route-list">
        <table class="route-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Role</th>
                    <th>Avatar</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td style="text-align: center">${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.role}</td>
                        <td>${user.avatar}</td>
                        <td>
                            <div class="action-buttons">
                                <a href="<c:url value='/users/${user.id}' />" class="btn-edit">Sửa</a>
                                <a href="<c:url value='/users/${user.id}/delete' />"  class="btn-delete" >Xóa</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


    <div class="create-route-form">
        <h4>Tạo Mới Người Dùng</h4>
        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
        <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="user">
            <label for="username">Tên người dùng:</label>
            <form:input path="username" type="text" id="username" placeholder="" name="username" />
            <label for="password">Mật khẩu:</label>
            <form:input path="password" type="text" id="password" placeholder="" name="password" />
            <label for="firstName">Tên:</label>
            <form:input path="firstName" type="text" id="firstName" name="firstName" />
            <label for="lastName">Họ:</label>
            <form:input path="lastName" type="text" id="lastName" name="lastName" />
            <label for="email">Email:</label>
            <form:input path="email" type="text" id="email" name="email" />
            <label for="phone">Phone</label>
            <form:input path="phone" type="text" id="phone" name="phone" />
            <label for="role">Role</label>
            <form:select class="form-select" path="role">
                <c:forEach items="${roles}" var="r">
                    <form:option value="${r}">${r}</form:option>
                </c:forEach>
            </form:select>
            <form:input id="image" path="avatar" type="file" />
            <input type="submit" value="upload" />
            <button type="submit">Thêm Người Dùng</button>
        </form:form>
    </div>
</div>
