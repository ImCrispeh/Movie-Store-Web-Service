<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html"%>
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
<body bgcolor="#bdbdbd">
<div id="Title" style="text-align: right;">
    <H1 style="text-align: center">Movies</H1>
    <a href="register.jsp">Register</a>
    <a href="login.jsp">Login</a>
</div>
<div id="Search" style="margin: auto; width: 50%; padding: 10px;">
    <form action="">
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
                    <input name="YearS" type="number"  value="2000" autocomplete="false" min="1900" max="2020" maxlength="4" minlength="4"> <!-- TODO Use todays Date -->
                </td>
                <td>
                    <label for="YearF">End</label>
                    <input name="YearF" type="number" value="2000" autocomplete="false" min="1900" max="2020" maxlength="4" minlength="4">
                </td>
                <td>
                </td>
                <td>
                    <button>Submit</button>
                </td>
            </tr>
        </table>
    </form>
</div><div id="Movies">
    <%--movies should apear here--%>
    <c:import url="WEB-INF/movies.xml" var="moviesxml"/>
    <c:import url="xsl/Movies.xsl" var="Moviesxslt"/>

    <x:transform xml="${moviesxml}" xslt="${Moviesxslt}">
        <x:param name="Title" value="The Lord of the Rings" />
    </x:transform>
</div><div id="Checkout">
    <a href="checkout."></a>
</div>
</body>
</html>