<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "/WEB-INF/views/includes/header.jsp"%>

<div class="container">
		<form action="join" method="post" id="frm">
			<div class="row">
				<div class="col">
					<label for="userid">아이디:</label> <input type="text"
					class="form-control" id="id" placeholder="Enter UserID"
					name="id">
				</div>
				<div class="col align-self-end">
<!-- 					<button type="button" class="btn btn-secondary" id="idCheckBtn">중복확인</button> -->
					<span id="idcheck"></span> <!-- 중복확인창 띄우지 않고 바로 확인하기 -->
				</div>
			</div>

			<div class="form-group">
				<label for="pwd">비밀번호:</label> <input type="password"
					class="form-control" id="pass" placeholder="Enter Password"
					name="pass">
			</div>

			<div class="form-group">
				<label for="pwd_check">비밀번호 체크:</label> <input
					type="password" class="form-control" id="pass_check"
					placeholder="Enter Password_check" name="pass_check">
			</div>

			<div class="form-group">
				<label for="name">이름:</label> <input type="text"
					class="form-control" id="name" placeholder="Enter name" name="name">
			</div>
			
			<div class="form-group">
				<label for="addr">주소:</label> <input type="text"
					class="form-control" id="addr" placeholder="Enter address"
					name="addr">
			</div>

			<button type="button" class="btn btn-secondary" id="btnJoin">회원가입</button>
			</form>
			<script>
			// 유효성 검사
			$("#btnJoin").click(function(){
				if($("#id").val()==""){
					alert("아이디를 입력하세요.")
					$("#id").focus();
					return false;
				}
				if($("#pass").val()==""){
					alert("비밀번호를 입력하세요.")
					$("#pass").focus();
					return false;
				}
				if($("#pass").val() != $("#pass_check").val()){
					alert("비밀번호가 일치하지 않습니다.")
					$("#pass_check").focus();
					return false;
				}
				if($("#addr").val()==""){
					alert("주소를 입력하세요.");
					$("#addr").focus();
					return false;
				}
				data = {
						"id":$("#id").val(), 
						"pass":$("#pass").val(),
						"name":$("#name").val(), 
						"addr":$("#addr").val(),
				}
				$.ajax({
					type:'post',
					url:'/app07/member/join',
					contentType: "application/json;charset=utf-8",
					data:JSON.stringify(data)
				}).done(function(resp){
					if(resp=="success"){
						alert("회원가입을 축하합니다!")
						location.href="login"
					}else if(resp=="fail"){
						alert("아이디 중복확인 하세요.")
						$("#idCheck").html("<b>아이디 중복</b>");
						$("#id").val("");
					}
					
				}).fail(function(){
					
				})
			
			})
			
			</script>
			</div>
<br /><br />

<%@ include file = "/WEB-INF/views/includes/footer.jsp"%>