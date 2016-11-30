<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/core/css/home.css" />" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<form:form method="POST" commandName="student" action="updateStudent" class="box login">
    <fieldset class="boxBody">


        <form:hidden path="id"/>

        <form:label path="firstName">Name:</form:label>
        <form:input path="firstName" />
        <form:errors path="firstName" cssClass="error"/>

        <form:label path="secondName">SecondName:</form:label>
        <form:input path="secondName" />
        <form:errors path="secondName" cssClass="error"/>

    </fieldset>
    <footer><input type="submit" class="btnLogin" value="Send" > </footer>

</form:form>
</body>
</html>
