<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/core/css/home.css" />" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<form:form method="POST" commandName="subject" action="createSubject" class="box login1">
    <fieldset class="boxBody">

        <form:label path="name">Name:</form:label>
        <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>

    </fieldset>
    <footer><input type="submit" class="btnLogin" value="Send"></footer>

</form:form>

</body>
</html>
