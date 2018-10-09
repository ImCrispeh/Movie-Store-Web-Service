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
    //History history = movieStoreApp.getHistory();
    //Order order = history.getOrders();
    //List<String> orderID = Collections.list(request.getParameterNames());
    //String[] orderNumber;
    //for(String order : orderName){
    //    orderNumber = order.split("_")
    //}
    //String[] concat;
    //int orderID = Integer.parseInt("0");
    //String order = request.getParameter("{ns:orderID}");
    //String[] concat = order.split("_");
    //int orderID = Integer.parseInt(order);
//  
    String orderID = request.getParameter("{ns:orderID}");

    if (request.getParameter("Cancel") != null) {
        //System.out.print("print");
        response.sendRedirect("main.jsp");
    } else if (request.getParameter("Confirm") != null) {
        movieStoreApp.cancelOrder(Integer.parseInt(orderID));
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
