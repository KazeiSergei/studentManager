<%@ page
		language="java"
		contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"
		trimDirectiveWhitespaces="true" %>

<%@ include file="/WEB-INF/fragments/taglibs.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-lg-6">
			<div class="panel-body text-danger">
				Dear <strong>${user}</strong>, You are not authorized to access this page
			</div>
		</div>
	</div>

</div>