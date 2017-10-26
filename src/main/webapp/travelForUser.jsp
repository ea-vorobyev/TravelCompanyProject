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
        <th width="30">ID</th>
        <th width="100">Country</th>
        <th width="100">Town</th>
        <th width="100">Level hotel</th>
        <th width="100">Food</th>
        <th width="100">Rating</th>
        <th width="100">Quantity</th>
        <th>
            <form>
                <button style="width: 75px" name="back" formmethod="post" formaction="/webtravel/user">Back</button>
            </form>
        </th>
    </tr>

    <c:forEach items="${listTravel}" var="itemCustomer">
        <tr>
            <td><c:out value="${itemCustomer.travel_id}"/></td>
            <td><c:out value="${itemCustomer.country}"/></td>
            <td><c:out value="${itemCustomer.town}"/></td>
            <td><c:out value="${itemCustomer.levelHotel}"/></td>
            <td><c:out value="${itemCustomer.food}"/></td>
            <td><c:out value="${itemCustomer.rating}"/></td>
            <td><c:out value="${itemCustomer.quantity}"/></td>
            <td>
                <form>
                    <button style="width: 75px" formmethod="post" name="minus" value="${item.travel_id}" formaction="/webtravel/user/travels">Купить</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

