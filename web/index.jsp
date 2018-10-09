<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html"%>
<%@ page import="java.io.*" %>
<% String msFilePath = application.getRealPath("WEB-INF");%>
<link rel="stylesheet" href="styles.css"/>
<script src="https://code.jquery.com/jquery-3.3.1.js" type="text/javascript"></script>
<html>
<head>
    <title>index</title>
    <datalist id="Genres">
        <option value="Action">
        <option value="Sci-Fi">
        <option value="Horror">
        <option value="Comedy">
    </datalist>
</head>
<script>
$(document).ready(function () {
    $('.order tr').click(function (event) {
        if (event.target.type !== 'checkbox') {
            $(':checkbox', this).trigger('click');
        }
    });
    $("input[type='checkbox']").change(function (e) {
        if ($(this).is(":checked")) {
            $(this).closest('tr').addClass("highlight_row");
        } else {
            $(this).closest('tr').removeClass("highlight_row");
        }
    });
});
</script>
<body bgcolor="#bdbdbd">
<div id="Title" style="text-align: right;">
    <H1 style="text-align: center">Movies</H1>
    <%@include file="/WEB-INF/jspf/navbar.jspf" %>
</div>
<div id="Search" style="margin: auto; width: 50%; padding: 10px;">
    <form action="index.jsp" method="Post" id="MovieSearch">
        <table>
            <tr>
                <td>
                    <label for="Title">Title</label>
                    <input name="Title" type="text" value="" autocomplete="false">
                </td>
                <td>
                    <label for="Genre">Genre</label>
                    <input name="Genre" list="Genres" value="" autocomplete="false" onclick="value=''">
                </td>
                <td>
                    <label for="YearS">Start Year</label>
                    <input name="YearS" type="number"  value="2000" autocomplete="false" min="1900" max="2020" maxlength="4" minlength="4"> 
                </td>
                <td>
                    <label for="YearF">End</label>
                    <input name="YearF" type="number" value="2020" autocomplete="false" min="1900" max="2020" maxlength="4" minlength="4"> <!-- TODO Use todays Date -->
                </td>
                <td>
                    <button>Search</button>
                </td>
            </tr>
        </table>
    </form>
</div><div id="Movies">
    <%--movies should apear here--%>
    <c:import url="WEB-INF/movies.xml" var="moviesxml"/>
    <c:import url="xsl/movies.xsl" var="Moviesxslt"/>

    <%
        String genre = request.getParameter("Genre");
        String title = request.getParameter("Title");
        String startY = request.getParameter("YearS");
        String endY = request.getParameter("YearF");
    %>
    <x:transform xml="${moviesxml}" xslt="${Moviesxslt}">
        <x:param name="Genre" value="<%= genre %>" />
        <x:param name="Title" value="<%= title %>" />
        <x:param name="StartYear" value="<%= startY %>" />
        <x:param name="EndYear" value="<%= endY %>" />
    </x:transform>

</body>
</html>