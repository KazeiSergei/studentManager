<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" commandName="subject" action="createSubject" class="box login1">
    <fieldset class="boxBody">

        <form:label path="name">Name:</form:label>
        <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>

    </fieldset>
    <footer><button type="submit" class="btn btn-primary" value="Send"></button></footer>

</form:form>

</body>
</html>
