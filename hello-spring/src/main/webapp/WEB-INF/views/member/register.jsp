<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h2>회원 가입</h2>
	</div>
</div>
<div class="container">
		<form action="register" method="post">
			<div class="form-group">
				<label for="username">아이디:</label>
				<input type="text" class="form-control"  id="username"  name="username">
			</div>
		
			<div class="form-group">
				<label for="password">패스워드:</label> 
				<input type="password" class="form-control" id="password"  name="password">
			</div>
			
			<div class="form-group">
				<label for="email">이메일:</label> 
				<input type="text" class="form-control" id="email"  name="email">
			</div>
			
			<div class="form-group">
				<label for="addr">주소:</label> 
				<input type="text" class="form-control" id="addr"  name="addr">
			</div>
			
			<div class="form-group">
    			<label for="memo">알림 사항:</label>
    			<input type="text" class="form-control" id="memo"  name="memo">
    		</div>
			
			<div class="form-check-inline">
      			<label class="form-check-label">
        		<input type="radio" class="form-check-input" name="role" value="user" checked>일반 회원
      			</label>
    		</div>
    			
    		<div class="form-check-inline">
      			<label class="form-check-label">
        		<input type="radio" class="form-check-input" name="role" value="admin">관리자
      			</label>
    		</div>
   
   			<button type = "button" class="btn btn-primary" id="registerBtn">가입하기</button>
   			
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
		if($("#addr").val==""){
			alert("주소를 입력하세요.")
			$("#addr").focus();
			return false;
		}
		var dataParam={
				"username":$("#username").val(),
				"password":$("#password").val(),
				"email":$("#email").val(),
				"addr":$("#addr").val(),
				"memo":$("#memo").val(),
				"role":$("#role").val(),
		}
		$.ajax({
			type:"post",
			url:"/register",
			contentType:"application/json;charset=utf-8",
			data:JSON.stringify(dataParam)
		})
		.done(function(resp){
			if(resp=="success"){
				alert("회원 가입 성공!")
				location.href="/login"
			}else if(resp=="fail"){
				alert("아이디 중복입니다.")
				$("#username").val("")
			}
		})
		.fail(function(){
			alert("회원 가입 실패")
		})
	})
	</script>