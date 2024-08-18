<%-- 
    Document   : header
    Created on : Aug 12, 2024, 10:47:47 AM
    Author     : lechi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:url value="/" var="home"/>
<c:url value="/contact" var="contact"/>
<c:url value="/routes" var="routes"/>
<c:url value="/stations" var="stations"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

    <div class="container-fluid">
        <!-- Links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <img class="nav-item" src="https://image.freepik.com/vector-gratis/ilustracion-icono-dibujos-animados-autobus_138676-1957.jpg" alt="logo" id="logo" />
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${home}"><spring:message code="lable.trangchu"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contact}"><spring:message code="lable.lienhe"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${routes}"><spring:message code="lable.tuyenduong"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${stations}"><spring:message code="lable.tramdung"/></a>
            </li>
        </ul>
    </div>

</nav>