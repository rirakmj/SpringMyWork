<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "/WEB-INF/views/includes/header.jsp"%>

<div class="container">
		<form action="login" method="get" id="frm">
			<div class="form-group">
				<label for="id">아이디:</label> <input type="text"
					class="form-control" id="id" placeholder="Enter UserID" name="id">
			</div>
		
			<div class="form-group">
				<label for="pass">Password:</label> <input type="password"
					class="form-control" id="pass" placeholder="Enter Password"
					name="pass">
			</div>
			<button type="button" class="btn btn-primary" id="loginBtn">로그인</button>
		</form>
	</div>
			<script>
			// 유효성 검사
			$("#loginBtn").click(function(){
				$.ajax({
					type:'post',
					url:'/app07/member/login',
					contentType: "application/json;charset=utf-8",
					data:JSON.stringify({"id":$("#id").val(), "pass":$("#pass").val()})
				}).done(function(resp){
					if(resp=="no"){
						alert("회원가입을 해 주세요.")
						location.href="join"
					}else if(resp=="success"){
						alert("로그인 성공")
						location.href="/app07/"
					}else{
						alert("비밀번호를 확인하세요.")
					}
				})
			})
			</script>
<br /><br />

<%@ include file = "/WEB-INF/views/includes/footer.jsp"%>