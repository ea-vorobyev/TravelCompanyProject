<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>User</title>
    </head>
    <body>
        <h1 align="center">
            Hello, <c:out value="${user}"/>!
        </h1>
        <form>
            <button name="exitUser" value="exit" formmethod="post" formaction="/webtravel/user">Exit</button>
        </form>
        <form>
            <button name="userMenu" formmethod="post" formaction="/webtravel/user/menu">User menu</button>
        </form>
        <form>
            <button name="travels" formmethod="post" formaction="/webtravel/user/travels">Travels</button>
        </form>
    </body>
</html>