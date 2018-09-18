<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<table style="width:100%">
<tr>
    <th>ID</th>
    <th>Наименование</th>
    <th>Требуется</th>
    <th>Количество</th>
</tr>

    <c:forEach var="row" items="${partsList}">
    <tr>
        <td>${row.id}</td>
        <td>${row.partName}</td>
        <td>${row.isMandatory}</td>
        <td>${row.quantity}</td>
    </tr>
    </c:forEach>

</body>
</html>