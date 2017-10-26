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

    <title>Travels</title>
</head>
<body>
<table align="center">
    <tbody>
    <tr>
        <th width="100">Country</th>
        <th width="100">Town</th>
        <th width="100">Level hotel</th>
        <th width="100">Food</th>
        <th width="100">Rating</th>
        <th width="100">Quantity</th>
        <th>
            <form>
                <button style="width: 75px" name="back" formmethod="post" formaction="/webtravel/admin">Back</button>
            </form>
        </th>
    </tr>

    <c:forEach items="${listTravel}" var="itemAdin">
        <tr>
            <td><c:out value="${itemAdin.country}"/></td>
            <td><c:out value="${itemAdin.town}"/></td>
            <td><c:out value="${itemAdin.levelHotel}"/></td>
            <td><c:out value="${itemAdin.food}"/></td>
            <td><c:out value="${itemAdin.rating}"/></td>
            <td><c:out value="${itemAdin.quantity}"/></td
            <td> </td>
            <td> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

