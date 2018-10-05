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
        <%String userPath = application.getRealPath("WEB-INF/users.xml");%>
        <jsp:useBean id = "editUser" class = "uts.wsd.oms.UserController" scope = "application">
            <jsp:setProperty name = "editUser" property = "filePath" value = "<%=userPath%>"/>
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
            User user = (User) session.getAttribute("user");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
//            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phoneNo = request.getParameter("phoneNo");
            String address = request.getParameter("address");
//            String city = request.getParameter("city");
//            String state = request.getParameter("state");
//            String zipcode = request.getParameter("zipcode");
            if (user != null) {
                editUser.editUser(user, firstName, lastName, password, phoneNo, address);
            }
        %>
        <h1>You are currently logged in as: <%=firstName%> <%=lastName%></h1>
        <%
            String edit = request.getParameter("edit");
            String cancel = request.getParameter("cancel");
            String action = "";
            if (cancel != null && edit == null) {
                action = "logout.jsp";
            }
            else if (edit != null && cancel == null)
            {
                action = "account.jsp";
            }

        %>
        <div class="div_form">          
            <form class="form" action="<%=action%>" method="POST">
                <table class="table_register">                
                    <tr><td>First Name:</td><td><input style="width:250px;" type="text" value="${user!=null ? user.getName() : tutor.getName()}" name="firstName" required><span class="validity" ></span></td></tr>
                    <tr><td>Last Name:</td><td><input style="width:250px;" type="text" value="${user!=null ? user.getName() : tutor.getName()}" name="lastName" required><span class="validity" ></span></td></tr>
                    <tr><td>Password:</td><td><input style="width:250px;" type="password" value="${user!=null ? user.getEmail() : tutor.getEmail()}" name="password" required><span class="validity" ></span></td></tr>               
                    <tr><td>Phone Number:</td><td><input style="width:250px;" type="text" value="${user!=null ? user.getDob() : tutor.getDob()}" name="phoneNo" required ><span class="validity" ></span></td></tr>
                    <tr><td>Address:</td><td><input style="width:250px;" type="text" value="${user!=null ? user.getName() : tutor.getName()}" name="address" required><span class="validity" ></span></td></tr>
                    <tr><td></td><td><input class="button" type="submit" value=" Update " name="edit" > &emsp; <input class="button" type="submit" value="Cancel Account" name="cancel" ></td></tr>
                </table>                  
            </form>            
        </div>
    </body>
</html>
