<%@ tag body-content="empty" %>
<%@ attribute name="bean" type="java.lang.String" required="true" rtexprvalue="true" %>
<%@ attribute name="property" type="java.lang.String" required="true" rtexprvalue="true" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:bind path="${bean}.${property}">
  <c:if test="${status.error}">
    <c:set var="selector" value="#${property}"/>
    <span class="hide" data-server-validation-error="${selector}">
      <form:errors path="${property}"/>
    </span>
  </c:if>
</spring:bind>
