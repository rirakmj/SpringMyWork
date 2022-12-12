<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<sec:authorize access="isAnonymous()">
		<a href="/login">로그인</a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<a href="/logout">로그아웃</a>
		principal:<sec:authentication property='principal'/><br/>
		사용자ID:<sec:authentication property="principal.username" /><br/>
		사용자이름:<sec:authentication property="principal.member.username" /><br/>
		권한:<sec:authentication property="principal.member.authList" /><br/>
		Member:<sec:authentication property="principal.member" /><br/>
		</sec:authorize>
</body>
</html>