<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>SIGN UP</h1>
	</div>
</div>
<div class="container">
		<form action="register" method="post">
			<div class="form-group">
				<label for="username">User ID:</label>
				<input type="text" class="form-control"  id="username"  name="username">
			</div>
		
			<div class="form-group">
				<label for="password">Password:</label> 
				<input type="password" class="form-control" id="password"  name="password">
			</div>
			
			<div class="form-group">
				<label for="email">Email:</label> 
				<input type="email" class="form-control" id="email"  name="email">
			</div>
			
			<div class="form-check-inline">
      			<label class="form-check-label">
        		<input type="radio" class="form-check-input" name="role" value="user" checked>General
      			</label>
    		</div>
    		
    		<div class="form-check-inline">
      			<label class="form-check-label">
        		<input type="radio" class="form-check-input" name="role" value="admin">Admin
      			</label>
    		</div>
   
   			<button type = "button" class="btn btn-primary" id="registerBtn">Register</button>
		</form>
	</div>
	<script>
	$("#registerBtn").click(function(){
		if($("#username").val==""){
			alert("아이디를 입력하세요.");
			$("#userid").focus();
			return false;
		}
		if($("#password").val==""){
			alert("비밀번호를 입력하세요.")
			$("#password").focus();
			return false;
		}
		if($("#email").val==""){
			alert("이메일을 입력하세요.")
			$("#email").focus();
			return false;
		}
		var dataParam={
				"username":$("#username").val(),
				"password":$("#password").val(),
				"email":$("#email").val(),
		}
		$.ajax({
			type:"post",
			url:"/register",
			contentType:"application/json;charset=utf-8",
			data:JSON.stringify(dataParam)
		})
		.done(function(resp){
			if(resp=="success"){
				alert("회원 가입 성공")
				location.href="/login"
			}else if(resp=="fail"){
				alert("아이디 중복")
				$("#username").val("")
			}
		})
		.fail(function(){
			alert("회원 가입 실패")
		})
	})
	</script>