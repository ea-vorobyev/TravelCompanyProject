<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

    <head>
        <title>CheckIn</title>
    </head>

    <body>

        <h1 align="center">
            Registration
        </h1>

        <form>
            <input required placeholder="Nick name" name="nickName">
            <input required placeholder="First name" name="firstName">
            <input required placeholder="Family name" name="familyName">
            <input required type="password" placeholder="${passwordError}" name="password">
            <button style="width: 85px" name="add" formmethod="post" formaction="/webtravel/checkIn">Check In</button>
        </form>

        <form>
            <button style="width: 85px" name="back" formmethod="post" formaction="/webtravel/auth">Back</button>
        </form>

    </body>

</html>
