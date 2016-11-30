<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Students</title>
</head>
<body>
<table>
    <c:forEach var="student" items="${students}">
        <tr><c:url value="/getStudentById?id=${student.id}" var="editLink"/>
            <td><a href="${editLink}">${student}</a></td>
        </tr>
    </c:forEach>
    <c:url value="/create" var="createUrl"/>
    <tr>
        <td><input type="button" value="create"  onClick='location.href="${createUrl}"'/></td>
    </tr>
</table>
</body>
</html>