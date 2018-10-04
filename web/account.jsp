<%@page import="uts.wsd.oms.Users"%>
<%@page import="uts.wsd.oms.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accounts</title>
    </head>
    <body>
        <%String userPath = application.getRealPath("WEB-INF/users.xml"); %>
        <jsp:useBean id = "editUser" class = "uts.wsd.oms.Users" scope = "application">
            <jsp:setProperty name = "editUser" property = "filePath" value = "<%userPath%>"/>
            <%--<jsp:setProperty name = "editUser" property = "lastName" value = "<%userPath%>"/>--%>
            <%--<jsp:setProperty name = "editUser" property = "email" value = "<%userPath%>"/>--%>
            <%--<jsp:setProperty name = "editUser" property = "password" value = "<%userPath%>"/>--%>
            <%--<jsp:setProperty name = "editUser" property = "phoneNo" value = "<%userPath%>"/>--%>
            <%--<jsp:setProperty name = "editUser" property = "address" value = "<%userPath%>"/>--%>
            <%--<jsp:setProperty name = "editUser" property = "city" value = "<%userPath%>"/>--%>
            <%--<jsp:setProperty name = "editUser" property = "state" value = "<%userPath%>"/>--%>
            <%--<jsp:setProperty name = "editUser" property = "zipcode" value = "<%userPath%>"/>--%>            
        </jsp:useBean>
        <%Users users = editUser.getUsers();%>
        <%
            User user = (User)session.getAttribute("user");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phoneNo = request.getParameter("phoneNo");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipcode = request.getParameter("zipcode");
            if (user != null)
            {
                editUser.editUser(firstName, lastName, email, password, phoneNo, address, city, state, zipcode);
            }
    </body>
</html>
