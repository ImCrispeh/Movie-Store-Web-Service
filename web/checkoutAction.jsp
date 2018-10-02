<%@page import="java.util.*"%>
<%@page import="uts.wsd.oms.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String filePath = application.getRealPath("WEB-INF/order.xml");%>
<jsp:useBean id="orderController" class="uts.wsd.oms.OrderController" scope="application">
    <jsp:setProperty name="orderController" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>
<%
    String submissionString;
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
            //TODO: place an order
        }
        else if(param.equals("cancelOrder"))
        {
            //TODO: cancel order
        }
    }
    
%>