<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/includes/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h2>로그인</h2>
	</div>
</div>
	<div class="container">
		<form action="login" method="post">
			<div class="form-group">
				<label for="username">아이디:</label> 
				<input type="text" class="form-control" id="username"  name="username"
				placeholder="아이디를 입력하세요." >
			</div> 
		
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="pass" name="password"
					placeholder="비밀번호를 입력하세요." >
			</div>
			<button class="btn btn-primary">로그인</button>
		</form>
	</div>