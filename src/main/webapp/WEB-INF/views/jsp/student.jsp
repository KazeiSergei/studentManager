<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td> ${student} </td>
        </tr>
    </table>
    <table>
        <td>
            <c:url value="/getStudentWithMarkAndSubject?id=${student.id}" var="getStudentWithMarkAndSubjectUrl"/>
            <input type="button" value="Info student" onClick='location.href="${getStudentWithMarkAndSubjectUrl}"'>

        </td>
        <td>
            <c:url value="/pageForUpdating?id=${student.id}" var="pageForUpdatingUrl"/>
            <input type="button" value="Update" onClick='location.href="${pageForUpdatingUrl}"'>
        </td>
        <td>
            <c:url value="/deleteStudent?id=${student.id}" var="deleteStudentUrl"/>
            <input type="button" value="Delete" onClick='location.href="${deleteStudentUrl}"'>
        </td><td><input type="button" onclick="history.back()" value="Back"></td>
    </table>

</body>
</html>
