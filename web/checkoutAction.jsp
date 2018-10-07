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
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String paymentMethod = request.getParameter("paymentMethod");
    boolean emailError = email == null || email.isEmpty();
    boolean firstNameError= firstName == null || firstName.isEmpty();
    boolean lastNameError= lastName == null || lastName.isEmpty();
    
    cartController.setOrderDetails(firstName, lastName, email, paymentMethod);
    
    if(emailError || firstNameError || lastNameError)
    {
        session.setAttribute("emailError", emailError);
        session.setAttribute("firstNameError", firstNameError);
        session.setAttribute("lastNameError", lastNameError);
        response.sendRedirect("checkout.jsp");
        return;
    }

    ArrayList<String> paramNames = Collections.list(request.getParameterNames());
    for (String param : paramNames) {
        if (param.contains("remove")) {
            cartController.removeMovie(param);
            response.sendRedirect("checkout.jsp");
            return;
        } else if (param.equals("placeOrder")) {
            movieStoreApp.addOrder(cartController.getOrder());
            cartController.cancelOrder();
            if (session.getAttribute("user") == null) {
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("main.jsp");
            }
            return;
        } else if (param.equals("cancelOrder")) {
            cartController.cancelOrder();
            response.sendRedirect("index.jsp");
            return;
        }
    }

%>