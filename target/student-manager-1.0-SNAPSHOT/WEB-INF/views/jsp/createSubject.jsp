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
                <c:when test="${subject.id != 0}">
                    <h2>Edit Subject</h2>
                    <c:set var="formAction" value="updateSubject.html" />
                </c:when>
                <c:otherwise>
                    <h2>Create Subject</h2>
                    <c:set var="formAction" value="createSubject.html" />
                </c:otherwise>
            </c:choose>

            <form:form method="POST" commandName="subject" action="${formAction}">
                <div class="form-group">
                    <c:if test="${subject.id != 0}">
                        <form:hidden path="id"/>
                    </c:if>
                    <form:label path="name">Name:</form:label>
                    <form:input path="name" class="form-control"/>
                    <utils:errors bean="subject" property="name"/>

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
