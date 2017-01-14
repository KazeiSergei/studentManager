<%@ page
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>

<%@ include file="/WEB-INF/fragments/taglibs.jsp"%>

<div class="container-fluid">
  <div class="row">
    <div class="col-lg-6">
      <h2><spring:message code="teachersJournal.students"/></h2>
      <div class="table-responsive">
        <c:choose>
            <c:when test="${empty students}">
                <div class="panel panel-search-result" class="panel-warning">
                    <div class="panel-body text-danger">
                        <h2 class="panel-title text-center"><spring:message code="teachersJournal.noStudents"/></h2>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <table class="table table-bordered table-hover">
                  <thead>
                  <tr>
                    <th width="10%">ID</th>
                    <th><spring:message code="teachersJournal.student.firstName"/></th>
                    <th><spring:message code="teachersJournal.student.secondName"/></th>
                    <th><spring:message code="teachersJournal.actions"/></th>
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
                           href="<c:url value='/infoStudent.html?id=${student.id}'/>" title="<spring:message code="teachersJournal.info"/>">
                          <i class="fa fa-fw fa-info" aria-hidden="true"></i>
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
    <div class="col-lg-6">
      <h2><spring:message code="teachersJournal.subjects"/></h2>
      <div class="table-responsive">
        <c:choose>
          <c:when test="${empty subjects}">
            <div class="panel panel-search-result" class="panel-warning">
              <div class="panel-body text-danger">
                <h2 class="panel-title text-center"><spring:message code="teachersJournal.noSubjects"/></h2>
              </div>
            </div>
          </c:when>
          <c:otherwise>
            <table class="table table-bordered table-hover table-striped">
              <thead>
              <tr>
                <th width="10%">ID</th>
                <th><spring:message code="teachersJournal.subjects"/></th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="subject" items="${subjects}">
                <tr>
                  <td>${subject.id}</td>
                  <td>${subject.name}</td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
  </div>
  <!-- /.row -->

</div>
<!-- /.container-fluid -->