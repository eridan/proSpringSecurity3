<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <c:url value="/styles/style.css" var="cssUrl"/>
        <link rel="stylesheet" type="text/css" href="${cssUrl}"/>
        <title>JBCP Pets: ${pageTitle}</title>
    </head>
    <body>
        <div id="header">

            <ul>
                <sec:authorize ifNotGranted="ROLE_USER">
                    <c:url value="/login.do" var="loginUrl"/>
                    <li><a href="${loginUrl}">Log In</a></li>
                </sec:authorize>

                <c:url value="/" var="homeUrl"/>
                <li><a href="${homeUrl}">Home</a></li>

                <c:url value="/logout" var="logoutUrl"/>
                <li><a href="${logoutUrl}">Log Out</a></li>

                <sec:authorize url="/account/home.do">
                    <c:url value="/account/home.do" var="accountUrl"/>
                    <li><a href="${accountUrl}">My Account</a></li>
                </sec:authorize>

                <c:url value="/wishlist/home.do" var="wishlistUrl"/>
                <li><a href="${wishlistUrl}">My Wishlist</a></li>

            </ul>
            <br />
        </div>

