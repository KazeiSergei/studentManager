<%@ page
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>

<%@ include file="/WEB-INF/fragments/taglibs.jsp" %>
<div class="container-fluid">

  <div class="row">
    <div class="col-lg-6">
      <c:choose>
        <c:when test="${student.id != 0}">
          <h2>Edit Student</h2>
          <c:set var="formAction" value="updateStudent.html" />
        </c:when>
        <c:otherwise>
          <h2>Create Student</h2>
          <c:set var="formAction" value="createStudent.html" />
        </c:otherwise>
      </c:choose>

      <form:form method="POST" commandName="student" action="${formAction}">
        <div  class="form-group">
          <c:if test="${student.id != 0}">
          <form:hidden path="id"/>
          </c:if>
          <form:label path="firstName">Name:</form:label>
          <form:input path="firstName" class="form-control"/>
          <utils:errors bean="student" property="firstName"/>

          <form:label path="secondName">SecondName:</form:label>
          <form:input path="secondName" class="form-control"/>
          <utils:errors bean="student" property="secondName"/>
        </div class="form-group">
        <footer>
          <input type="submit" value="Save" class="btn btn-primary">
          <c:url value="/" var="cancelUrl"/>
          <input type="button" class="btn btn-warning" onclick="location.href='${cancelUrl}'" value="Cancel">
        </footer>
      </form:form>

    </div>
  </div>


</div>
<!-- /.container-fluid -->
