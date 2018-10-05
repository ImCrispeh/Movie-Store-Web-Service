<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String xmlPath = "file:///" + application.getRealPath("WEB-INF\\order.xml");
    String xslPath = "file:///" + application.getRealPath("WEB-INF\\order.xsl");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Page</title>
        <link rel="stylesheet" href="styles.css">
    </head>

    <body>
        <c:import url="<%=xmlPath%>"  var="inputDoc" />

        <c:import url="<%=xslPath%>" var="stylesheet" />

        <h1 align="center">Checkout Page</h1>
        <%@include file="/WEB-INF/jspf/navbar.jspf" %>

        <form action="checkoutAction.jsp" method="Post">
            <x:transform xml="${inputDoc}" xslt="${stylesheet}">
            </x:transform>
            <input type="submit" name="cancelOrder" value="Cancel Order">
            <input type="submit" name="placeOrder" value="Place Order">
        </form>
    </body>
</html>
