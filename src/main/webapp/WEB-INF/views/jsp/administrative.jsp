<%@ page
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>

<%@ include file="/WEB-INF/fragments/taglibs.jsp"%>

<div class="container-fluid">
  <div class="row">
    <div class="col-lg-6">
      <h2><spring:message code="administrative.students"/></h2>
      <div class="table-responsive">
        <c:choose>
            <c:when test="${empty students}">
                <div class="panel panel-search-result" class="panel-warning">
                    <div class="panel-body text-danger">
                        <h2 class="panel-title text-center"><spring:message code="administrative.noStudents"/></h2>
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
                        <a class="btn btn-sm btn-info"
                           href="<c:url value='/updateStudent.html?id=${student.id}'/>" title="<spring:message code="administrative.update"/>">
                          <i class="fa fa-fw fa-edit" aria-hidden="true"></i>
                        </a>
                        <a class="btn btn-sm btn-info confirmation"
                           href="<c:url value='/deleteStudent.html?id=${student.id}'/>" title="<spring:message code="administrative.delete"/>" >
                          <i class="fa fa-fw fa-remove" aria-hidden="true"></i>
                        </a>
                      </td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
            </c:otherwise>
        </c:choose>
        <c:url value="/createStudent.html" var="createUrl"/>
        <button class="btn btn-success" onClick='location.href="${createUrl}"'><spring:message code="administrative.student.createStudent"/></button>
      </div>
    </div>
    <div class="col-lg-6">
      <h2><spring:message code="administrative.subjects"/></h2>
      <div class="table-responsive">
        <c:choose>
          <c:when test="${empty subjects}">
            <div class="panel panel-search-result" class="panel-warning">
              <div class="panel-body text-danger">
                <h2 class="panel-title text-center"><spring:message code="administrative.noSubjects"/></h2>
              </div>
            </div>
          </c:when>
          <c:otherwise>
            <table class="table table-bordered table-hover table-striped">
              <thead>
              <tr>
                <th width="10%"><spring:message code="administrative.id"/></th>
                <th><spring:message code="administrative.subject.name"/></th>
                <th><spring:message code="administrative.actions"/></th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="subject" items="${subjects}">
                <tr>
                  <td>${subject.id}</td>
                  <td>${subject.name}</td>
                  <td>
                    <a class="btn btn-sm btn-info"
                       href="<c:url value='/updateSubject.html?id=${subject.id}'/>" title="<spring:message code="administrative.update"/>">
                      <i class="fa fa-fw fa-edit" aria-hidden="true"></i>
                    </a>
                    <a class="btn btn-sm btn-info confirmation"
                       href="<c:url value='/deleteSubject.html?id=${subject.id}'/>" title="<spring:message code="administrative.delete"/>">
                      <i class="fa fa-fw fa-remove" aria-hidden="true"></i>
                    </a>
                  </td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </c:otherwise>
        </c:choose>
        <c:url value="/createSubject.html" var="createUrl"/>
        <button class="btn btn-success" onClick='location.href="${createUrl}"'><spring:message code="administrative.subject.createSubject"/></button>
      </div>
    </div>
  </div>
  <!-- /.row -->

</div>
<!-- /.container-fluid -->
