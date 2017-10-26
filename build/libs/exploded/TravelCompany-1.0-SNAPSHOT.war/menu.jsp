<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <style>

        </style>
        <title>Menu</title>
    </head>
    <body>
    <table align="center">
        <tbody>
        <tr>
            <th width="100">Nick name</th>
            <th width="100">First name</th>
            <th width="100">Family name</th>
            <th width="100">Town</th>
            <th width="130">Contact number</th>
            <th width="100">Email</th>
        </tr>
        <tr align="center">
            <td><c:out value="${userMenu.nickName}"/></td>
            <td><c:out value="${userMenu.firstName}"/></td>
            <td><c:out value="${userMenu.familyName}"/></td>
            <td><c:out value="${userMenu.town}"/></td>
            <td><c:out value="${userMenu.contactNumber}"/></td>
            <td><c:out value="${userMenu.email}"/></td>
        </tr>
        </tbody>
    </table>

    <form>
        <input required placeholder="Town" name="town">
        <button style="width: 85px" name="update" formmethod="post" formaction="/webtravel/user/menu">Update</button>
    </form>
    <form>
        <input required placeholder="Contact number" name="number">
        <button style="width: 85px" name="number" formmethod="post" formaction="/webtravel/user/menu">Update</button>
    </form>
    <form>
        <input required placeholder="Email" name="email">
        <button style="width: 85px" name="email" formmethod="post" formaction="/webtravel/user/menu">Update</button>
    </form>
    <form>
        <button style="width: 85px" name="back" formmethod="post" formaction="/webtravel/user">Back</button>
    </form>
    </body>
</html>