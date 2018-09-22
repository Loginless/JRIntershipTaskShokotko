<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style type="text/css"></style>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Computer Parts</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
            text-align: left;
        }
    </style>
</head>

<body>
<h1>Список доступного оборудования</h1>

<div>
    <form action="/comparts">
        <input type="text" placeholder="название детали" name="param"/>
        <input type="submit" value="Поиск"/>
    </form>
</div>
<form action="/comparts">
    Фильтрация:
    <button name="param" type="submit" value="allParts">Показать все детали</button>
    <button name="param" type="submit" value="mandatory">Детали, необходимые для сборки компьютера</button>
    <button name="param" type="submit" value="optional">Опциональные делати</button>
</form>

<table style="width:100%">
    <tr>
        <th>ID</th>
        <th>Наименование</th>
        <th>Требуется</th>
        <th>Количество</th>
    </tr>

    <c:forEach var="row" items="${listParts}">
        <tr>
            <td>${row.id}</td>
            <td>${row.partName}</td>
            <c:choose>
                <c:when test="${row.mandatory}">
                    <td>да</td>
                </c:when>
                <c:otherwise>
                    <td>нет</td>
                </c:otherwise>
            </c:choose>
            <td>${row.quantity}</td>
        </tr>
    </c:forEach>
</table>
<div align="center" id="pagination" style="background-color:darkred">
    <c:url value="/comparts" var="prev">
        <c:param name="page" value="${page-1}"/>
    </c:url>
    <c:if test="${page > 1}">
        <a href="<c:out value="${prev}" />">Предыдущая</a>
    </c:if>

    <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
        <c:choose>
            <c:when test="${page == i.index}">
                <span>${i.index}</span>
            </c:when>
            <c:otherwise>
                <c:url value="/comparts" var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href='<c:out value="${url}" />'>${i.index}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:url value="/comparts" var="next">
        <c:param name="page" value="${page + 1}"/>
    </c:url>
    <c:if test="${page + 1 <= maxPages}">
        <a href='<c:out value="${next}" />'>Следующая</a>
    </c:if>
</div>

<div style="margin-top: 7px">
    <p style="display: inline;">Можно собрать ${availableComputers} компьютеров</p>
</div>

</body>
</html>