<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

    <head>
        <title>Admin</title>
    </head>

    <body>

        <h1 align="center">
            Hello, <c:out value="${user}"/>!
        </h1>

        <form>
            <button name="exitAdmin" style="width: 85px" value="exit" formmethod="post" formaction="/webtravel/admin">Exit</button>
        </form>

        <form>
            <button name="customers" style="width: 85px" formmethod="post" formaction="/webtravel/admin/customers">Customers</button>
        </form>

        <form>
            <button name="administrators" style="width: 85px" formmethod="post" formaction="/webtravel/admin/administrators">Administrators</button>
        </form>

        <form>
            <button name="travels" style="width: 85px" formmethod="post" formaction="/webtravel/admin/travels">Travels</button>
        </form>

    </body>
</html>