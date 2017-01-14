<%@ page
        language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
        trimDirectiveWhitespaces="true" %>

<%@ include file="/WEB-INF/fragments/taglibs.jsp" %>

<div id="LoginForm">
    <span style="float:right">
            <a href="?language=en">en</a>
            <a href="?language=ru">ru</a>
        </span>
    <form action="<c:url value='/login'/>" method="POST" class="form-horizontal">
        <h1><spring:message code="login.authorize"/></h1>
        <div class="control-group">
            <label class="control-label" for="j_username">
                <fmt:message key="login.login"/>
            </label>
            <div class="controls">
                <input name="j_username" type="text" class="input-xlarge" autofocus="autofocus">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="j_password">
                <fmt:message key="login.password"/>
            </label>
            <div class="controls">
                <input name="j_password" type="password" class="input-xlarge">
            </div>
        </div>
        <div class="text-center loginSubmit">
            <input type="submit" value="<fmt:message key='login.enter'/>" class="btn btn-primary">
        </div>
    </form>
</div>
