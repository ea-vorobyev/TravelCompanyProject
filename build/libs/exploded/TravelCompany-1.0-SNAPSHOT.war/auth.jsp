<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <head>
        <title>Travel Company</title>
    </head>

    <body>

        <h1 align="center">
            Log In
        </h1>

        <form method="post">
            <input required placeholder="Nick name" name="nickName">
            <input required type="password" placeholder="Password" name="password">
            <button style="width: 85px" name="logIn" formmethod="post" formaction="/webtravel/auth">Log In</button>
        </form>

        <form>
            <button style="width: 85px" name="checkIn" formmethod="post" formaction="/webtravel/checkIn">Register</button>
        </form>

    </body>

</html>
