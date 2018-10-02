<%@page import="uts.wsd.oms.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String filePath = application.getRealPath("WEB-INF");%>
<jsp:useBean id="movieStoreApp" class="uts.wsd.oms.MovieStoreApplication" scope="application">
    <jsp:setProperty name="movieStoreApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>
<%
    boolean loginError = false;
    boolean validEmail = false, validPassword = false;
    User user = (User) session.getAttribute("user");
    //redirect user if they go to the login page while already logged in
    if(user != null)
            response.sendRedirect("index.jsp");
    
    if (request.getParameter("login") != null) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        user = movieStoreApp.getUsers().login(email, password);
        if (user != null) {
            session.setAttribute("user", user);
            response.sendRedirect("index.jsp");
        } else {
            loginError = true;
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <h1>Login</h1>

        <%@include file="/WEB-INF/jspf/navbar.jspf" %>

        <% if (loginError) { %>
        <p class="validation">Username or Password invalid. Try again</p>
        <% }%>

        <form action="" method="post">
            <table>
                <tbody>
                    <tr>
                        <td><label for="email">Email</label></td>
                        <td><input type="email" name="email"></td>
                        <td><text class="validation">Invalid Email</text></td>
                    </tr>
                    <tr>
                        <td><label for="password">Password</label></td>
                        <td><input type="password" name="password"></td>
                        <td><text class="validation">Invalid Password</text></td>
                    </tr>
                    <tr>
                        <td><label for="login"></label></td>
                        <td><input type="submit" name="login" value="Login" <%= validEmail && validPassword ? "" : "disabled=\"\""%> ></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
