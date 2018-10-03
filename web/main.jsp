<%@page import="java.util.*"%>
<%@page import="uts.wsd.oms.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Landing Page</title>
        <link rel="stylesheet" href="styles.css">
    </head>

    <!-- Getting application JavaBean and using it to get orders of user that is logged in -->
    <% String filePath = application.getRealPath("WEB-INF");%>
    <jsp:useBean id="movieStoreApp" class="uts.wsd.oms.MovieStoreApplication" scope="application">
        <jsp:setProperty name="movieStoreApp" property="filePath" value="<%=filePath%>"/>
    </jsp:useBean>
    <%History history = movieStoreApp.getHistory();%>
    <%
        List<Order> userOrders = new ArrayList<Order>();
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                String userEmail = user.getEmail();
                userOrders = history.getUserOrders(userEmail);
            } else {
                userOrders = history.getOrders();
            }
        } else {
            userOrders = history.getOrders();
        }
    %>

    <!-- Provide XML using user specific orders -->
    <c:set var = "xmltext"> 
        <history>
                <%
                    for (Order order : userOrders) {
                %>
                <order>
                <orderID><%= order.getOrderID()%></orderID>
                <movies>
                    <%
                        for (Movie movie : order.getMovies().getList()) {
                    %>
                    <movie>
                        <title><%= movie.getTitle()%></title>
                        <copies><%= movie.getCopies()%></copies>
                    </movie>
                    <%}%>
                </movies>
                <saleTotal><%= order.getSaleTotal()%></saleTotal>
                <orderStatus><%= order.getOrderStatus()%></orderStatus>
                </order>
                    <%}%>
        </history>
    </c:set>

    <body>
        <h1 align="center">Main Page</h1>
        <%@include file="/WEB-INF/jspf/navbar.jspf" %>
        <h3 align="center">Order History</h3>
        <c:import url = "xsl/history.xsl" var="xslt"/>
        <x:transform xml = "${xmltext}" xslt = "${xslt}"/>
    </body>
</html>
