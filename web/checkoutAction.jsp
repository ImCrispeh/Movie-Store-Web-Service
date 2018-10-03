<%@page import="java.util.*"%>
<%@page import="uts.wsd.oms.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String filePath = application.getRealPath("WEB-INF/order.xml");%>
<jsp:useBean id="orderController" class="uts.wsd.oms.OrderController" scope="application">
    <jsp:setProperty name="orderController" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>
<% String msFilePath = application.getRealPath("WEB-INF");%>
<jsp:useBean id="movieStoreApp" class="uts.wsd.oms.MovieStoreApplication" scope="application">
    <jsp:setProperty name="movieStoreApp" property="filePath" value="<%=msFilePath%>"/>
</jsp:useBean>
<%
    ArrayList<String> paramNames = Collections.list(request.getParameterNames());
    for(String param : paramNames)
    {
        if(param.contains("remove"))
        {
            orderController.removeMovie(param);
            response.sendRedirect("checkout.jsp");
        }
        else if(param.equals("placeOrder"))
        {
            movieStoreApp.addOrder(orderController.getOrder());
            orderController.cancelOrder();
            response.sendRedirect("main.jsp");
        }
        else if(param.equals("cancelOrder"))
        {
            orderController.cancelOrder();
            response.sendRedirect("index.jsp");
        }
    }
    
%>