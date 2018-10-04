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
    </body>
</html>
