<%@ page
        language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
        trimDirectiveWhitespaces="true" %>

<%@ include file="/WEB-INF/fragments/taglibs.jsp" %>

<div class="container-fluid">
    <span style="float:right">
            <a href="?id=${student.id}&language=en">en</a>
            <a href="?id=${student.id}&language=ru">ru</a>
     </span>
    <div class="row">
        <div class="col-lg-6">
            <h2><spring:message code="administrative.students"/></h2>
            <div class="table-responsive">
                <c:choose>
                    <c:when test="${empty students}">
                        <div class="panel panel-search-result" class="panel-warning">
                            <div class="panel-body text-danger">
                                <h2 class="panel-title text-center"><spring:message
                                        code="administrative.noStudents"/></h2>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th width="10%"><spring:message code="administrative.id"/></th>
                                <th><spring:message code="administrative.student.firstName"/></th>
                                <th><spring:message code="administrative.student.secondName"/></th>
                                <th><spring:message code="administrative.actions"/></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="student" items="${students}">
                                <tr>
                                    <td>${student.id}</td>
                                    <td>${student.firstName}</td>
                                    <td>${student.secondName}</td>
                                    <td>
                                        <sec:authorize access="hasRole('DIRECTOR')">
                                            <a class="btn btn-sm btn-info"
                                               href="<c:url value='/updateStudent.html?id=${student.id}'/>"
                                               title="<spring:message code="administrative.update"/>">
                                                <i class="fa fa-fw fa-edit" aria-hidden="true"></i>
                                            </a>
                                            <a class="btn btn-sm btn-info confirmation"
                                               href="<c:url value='/deleteStudent.html?id=${student.id}'/>"
                                               title="<spring:message code="administrative.delete"/>">
                                                <i class="fa fa-fw fa-remove" aria-hidden="true"></i>
                                            </a>
                                        </sec:authorize>
                                        <sec:authorize access="hasRole('TEACHER')">
                                            <a class="btn btn-sm btn-info"
                                               href="<c:url value='/infoStudent.html?id=${student.id}'/>"
                                               title="<spring:message code="teachersJournal.info"/>">
                                                <i class="fa fa-fw fa-info" aria-hidden="true"></i>
                                            </a>
                                        </sec:authorize>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:otherwise>
                </c:choose>
                <sec:authorize access="hasRole('DIRECTOR')">
                    <c:url value="/createStudent.html" var="createUrl"/>
                    <button class="btn btn-success" onClick='location.href="${createUrl}"'><spring:message
                            code="administrative.student.createStudent"/></button>
                </sec:authorize>
            </div>
        </div>
        <div class="col-lg-6">
            <h2><spring:message code="administrative.subjects"/></h2>
            <div class="table-responsive">
                <c:choose>
                    <c:when test="${empty subjects}">
                        <div class="panel panel-search-result" class="panel-warning">
                            <div class="panel-body text-danger">
                                <h2 class="panel-title text-center"><spring:message
                                        code="administrative.noSubjects"/></h2>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                            <tr>
                                <th width="10%"><spring:message code="administrative.id"/></th>
                                <th><spring:message code="administrative.subject.name"/></th>
                                <sec:authorize access="hasRole('DIRECTOR')">
                                    <th><spring:message code="administrative.actions"/></th>
                                </sec:authorize>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="subject" items="${subjects}">
                                <tr>
                                    <td>${subject.id}</td>
                                    <td>${subject.name}</td>
                                    <sec:authorize access="hasRole('DIRECTOR')">
                                        <td>

                                            <a class="btn btn-sm btn-info"
                                               href="<c:url value='/updateSubject.html?id=${subject.id}'/>"
                                               title="<spring:message code="administrative.update"/>">
                                                <i class="fa fa-fw fa-edit" aria-hidden="true"></i>
                                            </a>
                                            <a class="btn btn-sm btn-info confirmation"
                                               href="<c:url value='/deleteSubject.html?id=${subject.id}'/>"
                                               title="<spring:message code="administrative.delete"/>">
                                                <i class="fa fa-fw fa-remove" aria-hidden="true"></i>
                                            </a>
                                        </td>
                                    </sec:authorize>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:otherwise>
                </c:choose>
                <sec:authorize access="hasRole('DIRECTOR')">
                    <c:url value="/createSubject.html" var="createUrl"/>
                    <button class="btn btn-success" onClick='location.href="${createUrl}"'><spring:message
                            code="administrative.subject.createSubject"/></button>
                </sec:authorize>
            </div>
        </div>
    </div>
    <!-- /.row -->
    <sec:authorize access="hasRole('DIRECTOR')">
        <div class="col-lg-6">
            <h2><spring:message code="administrative.user"/></h2>
            <div class="table-responsive">
                <c:choose>
                    <c:when test="${empty users}">
                        <div class="panel panel-search-result" class="panel-warning">
                            <div class="panel-body text-danger">
                                <h2 class="panel-title text-center"><spring:message
                                        code="administrative.noUsers"/></h2>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                            <tr>
                                <th width="10%"><spring:message code="administrative.id"/></th>
                                <th><spring:message code="administrative.user.name"/></th>
                                <th><spring:message code="administrative.user.secondName"/></th>
                                <th><spring:message code="administrative.user.login"/></th>
                                <th><spring:message code="administrative.user.role"/></th>
                                <th><spring:message code="administrative.actions"/></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.name}</td>
                                    <td>${user.secondName}</td>
                                    <td>${user.login}</td>
                                    <td>${user.role}</td>
                                        <td>
                                            <a class="btn btn-sm btn-info"
                                               href="<c:url value='/updateUser.html?id=${user.id}'/>"
                                               title="<spring:message code="administrative.update"/>">
                                                <i class="fa fa-fw fa-edit" aria-hidden="true"></i>
                                            </a>
                                            <a class="btn btn-sm btn-info confirmation"
                                               href="<c:url value='/deleteUser.html?id=${user.id}'/>"
                                               title="<spring:message code="administrative.delete"/>">
                                                <i class="fa fa-fw fa-remove" aria-hidden="true"></i>
                                            </a>
                                        </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </sec:authorize>
</div>

</div>
<!-- /.container-fluid -->
