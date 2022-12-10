<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>${user.username }의 정보 변경하기</h1>
	</div>
</div>
<div class="container">
		<form action="userupdate">
		<input type="hidden" name="id" id="id" value="${user.id}" />
			<div class="form-group">
				<label for="username">User ID:</label>
				<input type="text" class="form-control"  id="username"  name="username" 
				value="${user.username }" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="password">Password:</label> 
				<input type="password" class="form-control" id="password"  name="password">
			</div>
			
			<div class="form-group">
				<label for="email">Email:</label> 
				<input type="email" class="form-control" id="email"  name="email"
				value="${user.email }">
			</div>
			
			<div class="form-check-inline">
      			<label class="form-check-label">
        		<input type="radio" class="form-check-input" name="role" value="user" checked
        		readonly="readonly">General
      			</label>
    		</div>
    		
    		<div class="form-check-inline">
      			<label class="form-check-label">
        		<input type="radio" class="form-check-input" name="role" value="admin"
        		readonly="readonly">Admin
      			</label>
    		</div>
   
   			<button type = "button" class="btn btn-primary" id="updateBtn">정보 수정</button>
   			<button type = "button" class="btn btn-primary" id="deleteBtn">탈퇴</button>
		</form>
	</div>
	<script>
$("#updateBtn").click(function(){
	var dataParam = {
			"id":$("#id").val(),
			"password":$("#password").val(),
			"email":$("#email").val(),
	}
	$.ajax({
		type:"put",
		url:"/userupdate/",
		data:JSON.stringify(dataParam),
		contentType:"application/json;charset=utf-8"
	})
	.done(function(){
		alert("수정 성공")
		location.href="/login"
	})
	.fail(function(){
		alert("수정 실패")
	})
})
</script>