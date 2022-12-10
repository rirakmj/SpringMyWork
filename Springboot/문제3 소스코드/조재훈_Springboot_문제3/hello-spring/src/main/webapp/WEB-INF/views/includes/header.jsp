<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="SpringProject">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<body>

	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1>SpringDATAJPA Board</h1>
	</div>
	<nav class="navbar navbar-expand-sm bg-primary navbar-dark mb-5">
		<div class="container">
			<!-- Brand/logo -->
			<a class="navbar-brand" href="/">HOME</a>

			<!-- Links -->
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/join">회원 등록</a></li>
				<li class="nav-item"><a class="nav-link" href="/list">회원리스트</a></li>
			</ul>
			
			<ul class="navbar-nav">
<sec:authorize access="isAnonymous()">
<li class="nav-item"><a class="nav-link" href="/login"> 로그인</a></li>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<sec:authentication property="principal" var="p"/>
<li class="nav-item"><a class="nav-link" href="/logout">로그아웃(<sec:authentication property="principal.user.username"/>)</a></li>
</sec:authorize>
</ul>
		</div>
	</nav>