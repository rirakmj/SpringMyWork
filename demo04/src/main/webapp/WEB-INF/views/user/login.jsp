<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/includes/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>LOGIN</h1>
	</div>
</div>
	<div class="container">
		<form action="loginPro" method="post">
			<div class="form-group">
				<label for="username">UserID:</label> <input type="text"
					class="form-control" id="username" placeholder="Enter userID" name="username">
			</div> <!-- usernaem, password는 정해진 포맷, 다른 이름 하고 싶으면 security xml에서 username-parameter를 사용해서 바꾸기 -->
		
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="pass" placeholder="Enter Password" name="password">
			</div>
			<button class="btn btn-primary">로그인</button>
		</form>
	</div>