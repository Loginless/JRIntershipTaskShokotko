<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <style>

        h1 {
            background-color: #4c7aaf;
            text-align: left;
        }

        .formStyle{
            text-align: left;
            font-family: sans-serif;
        }

        input[type=text]:focus {
            background-color: lightblue;
        }

    </style>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add a new part</title>
</head>

<body>

<h1>Добавить новое оборудование </h1>

<form action="${pageContext.request.contextPath}/createPart" method="post" class="formStyle">
    <p>
        Название детали:
        <input type="text" placeholder="название детали" name="partName"/>
    </p>

    <p>
        Основная деталь:
        <input type="checkbox" name="paramMandatory" value="1"/>
    </p>

    <p>
        Количество:
        <input type="text" placeholder="количество деталей" name="partsQuantity"/>
    </p>

    <input type="submit" value="Добавить">
</form>
</body>
</html>