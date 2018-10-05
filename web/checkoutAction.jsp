<%@page import="java.util.*"%>
<%@page import="uts.wsd.oms.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String filePath = application.getRealPath("WEB-INF/order.xml");%>
<jsp:useBean id="cartController" class="uts.wsd.oms.CartController" scope="application">
    <jsp:setProperty name="cartController" property="filePath" value="<%=filePath%>"/>
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
            cartController.removeMovie(param);
            response.sendRedirect("checkout.jsp");
        }
        else if(param.equals("placeOrder"))
        {
            movieStoreApp.addOrder(cartController.getOrder());
            cartController.cancelOrder();
            response.sendRedirect("main.jsp");
        }
        else if(param.equals("cancelOrder"))
        {
            cartController.cancelOrder();
            response.sendRedirect("index.jsp");
        }
    }
    
%>