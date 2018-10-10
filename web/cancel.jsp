<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="uts.wsd.oms.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String filePath = application.getRealPath("WEB-INF");%>
<jsp:useBean id="movieStoreApp" class="uts.wsd.oms.MovieStoreApplication" scope="application">
    <jsp:setProperty name="movieStoreApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>
<%
    List<String> orderID = Collections.list(request.getParameterNames());

    String email = request.getParameter("email");

    if (request.getParameter("Cancel") != null) {
        //System.out.print("print");
        response.sendRedirect("main.jsp");
    } else if (request.getParameter("Confirm") != null) {
        for (String order : orderID) {
            if (order.contains("order")) {
                Order selectedOrder = movieStoreApp.getOrder(order);
                if (selectedOrder != null) {
                    movieStoreApp.cancelOrder(selectedOrder.getOrderID());
                }
            }
        }
        response.sendRedirect("main.jsp");
    }


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cancellation</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <h1>Are you sure?</h1>
        <%@include file="/WEB-INF/jspf/navbar.jspf" %>

        <input type="submit" value="Confirm" name="Confirm"/>
        <input type="submit" value="Cancel" name="Cancel"/>

    </body>
</html>
