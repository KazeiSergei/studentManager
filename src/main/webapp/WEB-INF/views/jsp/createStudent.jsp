<%@ page
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>

<%@ include file="/WEB-INF/fragments/taglibs.jsp" %>
<div class="container-fluid">
  <div class="row">
    <span style="float:right">
            <a href="?id=${student.id}&language=en">en</a>
            <a href="?id=${student.id}&language=ru">ru</a>
     </span>
    <div class="col-lg-6">
      <c:choose>
        <c:when test="${student.id != 0}">
          <h2><spring:message code="createStudent.student.edit"/></h2>
          <c:set var="formAction" value="updateStudent.html" />
        </c:when>
        <c:otherwise>
          <h2><spring:message code="createStudent.student.create"/></h2>
          <c:set var="formAction" value="createStudent.html" />
        </c:otherwise>
      </c:choose>

      <form:form method="POST" commandName="student" action="${formAction}">
        <div  class="form-group">
          <c:if test="${student.id != 0}">
          <form:hidden path="id"/>
          </c:if>
          <form:label path="firstName"><spring:message code="createStudent.student.name"/></form:label>
          <form:input path="firstName" class="form-control"/>
          <utils:errors bean="student" property="firstName"/>

          <form:label path="secondName"><spring:message code="createStudent.student.secondName"/></form:label>
          <form:input path="secondName" class="form-control"/>
          <utils:errors bean="student" property="secondName"/>
        </div class="form-group">
        <footer>
          <input type="submit" value="<spring:message code="createStudent.student.save"/>" class="btn btn-primary">
          <c:url value="/" var="cancelUrl"/>
          <input type="button" class="btn btn-warning" onclick="location.href='${cancelUrl}'" value="<spring:message code="createStudent.student.cancel"/>">
        </footer>
      </form:form>

    </div>
  </div>


</div>
<!-- /.container-fluid -->
