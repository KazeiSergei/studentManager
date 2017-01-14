<%@ page
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>

<%@ include file="/WEB-INF/fragments/taglibs.jsp"%>

<div class="container-fluid">
  <span style="float:right">
            <a href="?id=${student.id}&language=en">en</a>
            <a href="?id=${student.id}&language=ru">ru</a>
        </span>
  <div class="row">
    <div class="col-lg-6">
      <h2><spring:message code="infoStudent.student"/> &nbsp ${student.firstName} &nbsp ${student.secondName}</h2>
      <div class="table-responsive">
        <c:choose>
            <c:when test="${empty student.marks}">
                <div class="panel panel-search-result" class="panel-warning">
                    <div class="panel-body text-danger">
                        <h2 class="panel-title text-center"><spring:message code="infoStudent.studentDoesNotHaveMarks"/></h2>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <table class="table table-bordered table-hover">
                  <thead>
                  <tr>
                    <th><spring:message code="infoStudent.mark"/></th>
                    <th><spring:message code="infoStudent.subject"/></th>
                    <th><spring:message code="infoStudent.action"/></th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="mark" items="${student.marks}">
                    <tr>
                      <td>${mark.mark}</td>
                      <td>${mark.subject.name}</td>
                      <td><a class="btn btn-sm btn-info confirmation"
                             href="<c:url value='deleteMark.html?id=${student.id}&markId=${mark.id}'/>" title="<spring:message code="infoStudent.delete"/>">
                        <i class="fa fa-fw fa-remove" aria-hidden="true"></i>
                      </a></td>
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
  <div class="row">
    <div class="col-lg-6">
      <h2><spring:message code="infoStudent.AddMark"/></h2>
      <div class="table-responsive">
        <form method="post" action="insertMark.html?id=${student.id}">
            <table class="table table-bordered table-hover table-striped">
              <thead>
              <tr>
                <th><spring:message code="infoStudent.subject"/></th>
                <th><spring:message code="infoStudent.mark"/></th>
              </tr>
              </thead>
              <tbody>
                <tr>
                  <td>
                    <div class="form-group">
                      <select name="subject" class="form-control">
                      <c:forEach var="subject" items="${subjects}">
                        <option value="${subject.id}">${subject.name}</option>
                      </c:forEach>
                      </select>
                    </div>
                  </td>
                  <td>
                    <div class="form-group">
                    <select name="mark" class="form-control">
                      <option value="1">1</option>
                      <option value="2">2</option>
                      <option value="3">3</option>
                      <option value="4">4</option>
                      <option value="5">5</option>
                      <option value="6">6</option>
                      <option value="7">7</option>
                      <option value="8">8</option>
                      <option value="9">9</option>
                      <option value="10">10</option>
                    </select>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          <input type="submit" value="<spring:message code="infoStudent.AddMark"/>" class="btn btn-primary">
        </form>

      </div>
    </div>
  </div>

</div>
<!-- /.container-fluid -->
