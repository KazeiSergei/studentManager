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
        <c:when test="${user.id != 0}">
          <h2><spring:message code="registration.user.edit"/></h2>
          <c:set var="formAction" value="updateUser.html" />
        </c:when>
        <c:otherwise>
          <h2 class="white-color"><spring:message code="registration.user.create"/></h2>
          <c:set var="formAction" value="createUser.html" />
        </c:otherwise>
      </c:choose>

      <form:form method="POST" commandName="user" action="${formAction}">
        <div  class="form-group">
          <c:choose>
          <c:when test="${user.id != 0}">
            <form:hidden path="id"/>
            <form:label path="name"><spring:message code="registration.user.name"/></form:label>
          </c:when>
          <c:otherwise>
            <form:label path="name" class="white-color"><spring:message code="registration.user.name"/></form:label>
          </c:otherwise>
          </c:choose>
          <form:input path="name" class="form-control"/>
          <utils:errors bean="user" property="name"/>

          <c:choose>
          <c:when test="${user.id != 0}">
            <form:label path="secondName"><spring:message code="registration.user.secondName"/></form:label>
          </c:when>
          <c:otherwise>
            <form:label path="secondName" class="white-color"><spring:message code="registration.user.secondName"/></form:label>
          </c:otherwise>
          </c:choose>
          <form:input path="secondName" class="form-control"/>
          <utils:errors bean="user" property="secondName"/>

          <c:choose>
          <c:when test="${user.id != 0}">
            <form:label path="login"><spring:message code="registration.user.login"/></form:label>
          </c:when>
          <c:otherwise>
            <form:label path="login" class="white-color"><spring:message code="registration.user.login"/></form:label>
          </c:otherwise>
          </c:choose>
          <form:input path="login" class="form-control"/>
          <utils:errors bean="user" property="secondName"/>

          <c:choose>
          <c:when test="${user.id != 0}">
            <form:label path="password"><spring:message code="registration.user.password"/></form:label>
          </c:when>
          <c:otherwise>
           <form:label path="password" class="white-color"><spring:message code="registration.user.password"/></form:label>
          </c:otherwise>
          </c:choose>
          <form:input path="password" class="form-control" type="password"/>
          <utils:errors bean="user" property="secondName"/>
          <sec:authorize access="hasRole('DIRECTOR')">
            <form:label path="role"><spring:message code="registration.user.role"/></form:label>
            <form:select path="role" class="form-control">
              <form:option value="USER" label="User"/>
              <form:option value="DIRECTOR" label="Director"/>
              <form:option value="TEACHER" label="Teacher"/>
            </form:select>
          </sec:authorize>
        </div class="form-group">
        <footer>
          <input type="submit" value="<spring:message code="registration.user.save"/>" class="btn btn-primary">
          <c:url value="/" var="cancelUrl"/>
          <input type="button" class="btn btn-warning" onclick="location.href='${cancelUrl}'" value="<spring:message code="registration.user.cancel"/>">
        </footer>
      </form:form>

    </div>
  </div>


</div>
<!-- /.container-fluid -->
