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
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" href="css/style.css"/>

<c:url value="/" var="home"/>
<c:url value="/contact" var="contact"/>
<c:url value="/routes" var="routes"/>
<c:url value="/stations" var="stations"/>
<c:url value="/busTrip" var="busTrip"/>
<c:url value="/schedules" var="schedules"/>
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
            <li class="nav-item">
                <a class="nav-link" href="${busTrip}"><spring:message code="lable.chuyenxe"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${schedules}"><spring:message code="lable.lichtrinh"/></a>
            </li>
            <s:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/" />">
                        Welcome <s:authentication property="principal.username" />
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/logout" />">
                        Dang xuat
                    </a>
                </li>
            </s:authorize>
                <s:authorize access="!isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/login" />">
                        Dang nhap
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/register" />">
                        Dang ky
                    </a>
                </li>
            </s:authorize>
        </ul>
    </div>

</nav>