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
<<<<<<< HEAD
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
=======
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
    
    ArrayList<String> paramNames = Collections.list(request.getParameterNames());
    for (String param : paramNames) {
        if (param.contains("order")) {
            String[] split = param.split("_");
            if(split.length>1)
                session.setAttribute("orderID", split[1]);
        } 
    }
    
    if (request.getParameter("Cancel") != null || request.getParameter("Confirm") != null) {
        String orderID = (String) session.getAttribute("orderID");
        session.removeAttribute("orderID");
        System.out.println(orderID);
        if (request.getParameter("Cancel") != null) {
            //System.out.print("print");
            response.sendRedirect("main.jsp");
        } else if (request.getParameter("Confirm") != null) {
            movieStoreApp.cancelOrder(Integer.parseInt(orderID));
            response.sendRedirect("main.jsp");
        }
>>>>>>> master
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
<<<<<<< HEAD

        <input type="submit" value="Confirm" name="Confirm"/>
        <input type="submit" value="Cancel" name="Cancel"/>

=======
        <form action="" method="Post">
            <input type="submit" value="Confirm" name="Confirm"/>
            <input type="submit" value="Cancel" name="Cancel"/>
        </form>
            
        
>>>>>>> master
    </body>
</html>
