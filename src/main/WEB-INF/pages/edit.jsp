<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <style>

        h1 {
            background-color: #4c7aaf;
            text-align: left;
        }

        .formStyle {
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

<h1>Изменить даннные об оборудовании</h1>
<c:url var="editPart" value="${pageContext.request.contextPath}/editPart"/>
<form:form action="${editPart}" modelAttribute="computerParts">

    <c:if test="${!empty computerParts.partName}">
        <form:label path="id">
            <spring:message text="ID"/>
        </form:label>
        ${part.id}
        <form:hidden path="id"/>
    </c:if>

    <form:label path="partName">
        <spring:message text="Наименование"/>
    </form:label>
    <form:input path="partName" size="40"/>


    <form:label path="mandatory">
        <spring:message text="Необходимость"/>
    </form:label>
    <form:checkbox path="mandatory" value="1"/>

    <form:label path="quantity">
        <spring:message text="Количество"/>
    </form:label>
    <form:input path="quantity"/>


<input type="submit" value="<spring:message text="Подтвердить изменения"/>"/>

</form:form>

<p><a href="${pageContext.request.contextPath}/comparts/">Назад к списку.</a></p>


</body>
</html>