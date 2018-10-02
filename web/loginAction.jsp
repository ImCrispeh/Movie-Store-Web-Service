<%@page import="uts.wsd.oms.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String filePath = application.getRealPath("WEB-INF");%>
<jsp:useBean id="movieStoreApp" class="uts.wsd.oms.MovieStoreApplication" scope="application">
    <jsp:setProperty name="diaryApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = movieStoreApp.getUsers().login(email, password);
        %>
        <% if (user != null && request != null) {
                session.setAttribute("user", user);
                response.sendRedirect("index.jsp");
        %>
        <p>Login successful. Click <a href="index.jsp">here</a> to return to the main page.</p>
        <% } else { %>
        <p>Password incorrect. Click <a href="login.jsp">here</a> to try again.</p>
        <% }%>
    </body>
</html>
