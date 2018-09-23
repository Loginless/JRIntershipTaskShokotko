<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <style>

        /*Grid Containder*/
        .header {
            grid-area: header;
            background-color: #4c7aaf;
        }

        .search {
            grid-area: search;
            text-align: left;
        }

        .mainTable {
            grid-area: mainTable;
        }

        .computersQty {
            grid-area: computersQty;
            text-align: left;
        }

        .footer {
            grid-area: footer;
            text-align: center;
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        }

        .grid-container {
            display: grid;
            grid-template-areas: 'header header header' 'search search search' 'mainTable mainTable mainTable' 'computersQty computersQty computersQty' 'footer footer footer';
            grid-gap: 1px;
            padding: 1px;
        }

        .grid-container > div {
            background-color: rgba(255, 255, 255, 0.8);
            text-align: center;
            padding: 2px 0;
            font-size: 25px;
        }

        /*Header*/
        h1 {
            color: black;
            font-family: sans-serif;
            font-size: 40px;
            text-align: left;
        }

        /*Search*/

        /*Table style*/
        #ComputerParts {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #ComputerParts td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #ComputerParts tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #ComputerParts tr:hover {
            background-color: #ddd;
        }

        #ComputerParts th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            background-color: #4c7aaf;
            color: white;
        }

        #ComputerParts td {
            text-align: center;
        }

    </style>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Computer Parts</title>
</head>

<body>

<div class="grid-container">

    <%--Header--%>
    <div class="header" style="background-color: #4c7aaf">
        <h1>Список доступного оборудования</h1>
    </div>


    <%--Search and filter--%>
    <div class="search">
        <div>
            <form action="${pageContext.request.contextPath}/comparts/" class="search">
                Поиск по наименованию детали:
                <input type="text" placeholder="название детали" name="param"/>
                <input type="submit" value="Поиск"/>
            </form>
        </div>

        <form action="${pageContext.request.contextPath}/comparts/" class="search">
            Применить фильтр:
            <button name="param" type="submit" value="allParts">Показать все детали</button>
            <button name="param" type="submit" value="mandatory">Детали, необходимые для сборки компьютера</button>
            <button name="param" type="submit" value="optional">Опциональные делати</button>
        </form>
    </div>


    <%--Computer Parts main table--%>
    <div class="mainTable">
        <table id="ComputerParts">
            <tr>
                <th>ID</th>
                <th>Наименование</th>
                <th>Необходимость</th>
                <th>Количество</th>
                <th>Изменить</th>
                <th>Удалить</th>
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
                    <td align="center"><a href="<c:url value='${pageContext.request.contextPath}/edit/${row.id}'/>">Изменить</a></td>
                    <td align="center"><a href="<c:url value='${pageContext.request.contextPath}/delete/${row.id}'/>">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <%--Total comp. q-ty--%>
    <div class="computersQty" style="text-align: left">
            Можно собрать ${availableComputers} компьютеров
        <p><a href="${pageContext.request.contextPath}/addpart/">Добавить новое оборудование.</a></p>

    </div>

    <%--Pagination--%>
    <div class="footer">
        <div align="center" id="pagination">
            <c:url value="/comparts/" var="prev">
                <c:param name="page" value="${page-1}"/>
            </c:url>
            <c:if test="${page > 1}">
                <a href="<c:out value="${prev}" />">Назад</a>
            </c:if>

            <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
                <c:choose>
                    <c:when test="${page == i.index}">
                        <span>${i.index}</span>
                    </c:when>
                    <c:otherwise>
                        <c:url value="/comparts/" var="url">
                            <c:param name="page" value="${i.index}"/>
                        </c:url>
                        <a href='<c:out value="${url}" />'>${i.index}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:url value="/comparts/" var="next">
                <c:param name="page" value="${page + 1}"/>
            </c:url>
            <c:if test="${page + 1 <= maxPages}">
                <a href='<c:out value="${next}" />'>Вперед</a>
            </c:if>
        </div>
    </div>

</div>
</body>
</html>