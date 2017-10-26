<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <style type="text/css">
        TABLE {
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
        }
        TH, TD {
            border: 1px solid black; /* Параметры рамки */
            text-align: center; /* Выравнивание по центру */
            padding: 4px; /* Поля вокруг текста */
        }
        TH {
            height: 40px; /* Высота ячеек */
            vertical-align: bottom; /* Выравнивание по нижнему краю */
            padding: 0; /* Убираем поля вокруг текста */
        }
    </style>

    <title>Administrators</title>
</head>
<body>
<table align="center">
    <tbody>
    <tr>
        <th width="100">Nick name</th>
        <th width="100">First name</th>
        <th width="100">Family name</th>
        <th width="100">Town</th>
        <th width="100">Email</th>
        <th a>
            <form>
                <button style="width: 75px" name="back" formmethod="post" formaction="/webtravel/admin">Back</button>
            </form>
        </th>
    </tr>

    <c:forEach items="${listAdmin}" var="items">
        <tr>
            <td><c:out value="${items.nickName}"/></td>
            <td><c:out value="${items.firstName}"/></td>
            <td><c:out value="${items.familyName}"/></td>
            <td><c:out value="${items.town}"/></td>
            <td><c:out value="${items.email}"/></td>

            <td>
                <form>
                    <button style="width: 75px" formmethod="post" name="delete" value="${item.customer_id}" formaction="/webtravel/admin/administrators">Удалить</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

