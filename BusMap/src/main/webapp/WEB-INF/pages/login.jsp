<%-- 
    Document   : login
    Created on : Sep 2, 2024, 11:40:51 PM
    Author     : lechi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring"
           uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/login" var="action" />
<div class="alert alert-danger">
    <c:if test="${param.error != null}">
        <spring:message code="user.login.error1" />
    </c:if>
    <c:if test="${param.accessDenied != null}">
        <spring:message code="user.login.error2" />
    </c:if>
</div> 
<form action="${action}" method="post" >
    <div class="form-group">
        <label for="usernameId">
            <spring:message code="user.username" />
        </label>
        <input name="username" id="usernameId"
               class="form-control" />
    </div>
    <div class="form-group">
        <label for="passwordId">
            <spring:message code="user.password" />
        </label>
        <input id="passwordId" name="password"
               class="form-control" type="password" />
    </div>
    <div class="form-group">
        <input type="submit"
               value="<spring:message code="user.login" />"/>
    </div>
</form>
