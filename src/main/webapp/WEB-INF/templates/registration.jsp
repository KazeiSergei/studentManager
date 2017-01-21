<%@ page
    language="java"
    contentType="text/html; charset=UTF-8"
    trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8" %>

<%@ include file="/WEB-INF/fragments/taglibs.jsp" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>School Application</title>

  <!-- Bootstrap Core CSS -->
  <link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="<c:url value="/resources/core/css/sb-admin.css" />" rel="stylesheet">

  <!-- Custom Fonts -->
  <link href="<c:url value="/resources/core/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">

  <link href="<c:url value="/resources/css/school.css" />" rel="stylesheet">

</head>

<body>

<div id="wrapper">

  <!-- Navigation -->
  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.html"><spring:message code="main.schoolManagement"/></a>
    </div>
    <ul class="nav navbar-right top-nav">
      <li class="dropdown">
        <a href="?id=${user.id}&language=en">en</a>
      </li>
      <li class="dropdown">
        <a href="?id=${user.id}&language=ru">ru</a>
      </li>
    </ul>

  </nav>
  <div class="login-wrapper">
    <tiles:insertAttribute name="body"/>
  </div>
</div>
<script src="<c:url value='/resources/core/js/jquery.js' />"></script>
<script src="<c:url value='/resources/core/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/resources/js/school.js' />"></script>
</body>

</html>
