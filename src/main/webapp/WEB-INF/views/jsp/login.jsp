<%@ page
        language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
        trimDirectiveWhitespaces="true" %>

<%@ include file="/WEB-INF/fragments/taglibs.jsp" %>

<div id="LoginForm">
    <div class="row">
        <div class="col-lg-6">
            <h2 class="white-color"><spring:message code="login.authorize"/></h2>
            <form action="${loginUrl}" method="post" class="form-horizontal">
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger">
                        <p><spring:message code="login.invalid"/></p>
                    </div>
                </c:if>
                <c:if test="${param.logout != null}">
                    <div class="alert alert-success">
                        <p><spring:message code="login.logged"/></p>
                    </div>
                </c:if>
                <div class="input-group input-sm">
                    <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                    <input type="text" class="form-control" id="username" name="login" placeholder="Enter Username"
                           required>
                </div>
                <div class="input-group input-sm">
                    <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                    <input type="password" class="form-control" id="password" name="password"
                           placeholder="Enter Password" required>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <div class="form-actions">
                    <input type="submit"
                           class="btn btn-block btn-primary btn-default" value='<spring:message code="login.enter"/>'>
                    <c:url value="/registration.html" var="registration"/>
                    <input type="button" class="btn btn-block btn-primary btn-default" onclick="location.href='${registration}'" value="<spring:message code="login.registration.user"/>">
                </div>
            </form>
        </div>
    </div>
</div>
