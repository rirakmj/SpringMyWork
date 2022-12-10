<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>

<div class="container">
<h3>${member.username}회원정보</h3>
<form action="/update/${member.id }">
	<div class="form-group">
		<label for="id">아이디:</label>
		 <input type="text" class="form-control" id="id" name="id" value="${member.id }" readonly="readonly">
	</div>
		<div class="form-group">
		<label for="username">이름:</label>
		 <input type="text" class="form-control" id="username" name="username" value="${member.username }" readonly="readonly">
	</div>
			<div class="form-group">
		<label for="password">비밀번호:</label>
		 <input type="password" class="form-control" id="password" name="password">
	</div>
		<div class="form-group">
		<label for="addr">주소:</label>
		 <input type="text" class="form-control" id="addr" name="addr" value="${member.addr }" >
	</div>
		<div class="form-group">
		<label for="email">이메일:</label>
		 <input type="email" class="form-control" id="email" name="email" value="${member.email }">
	</div>
<div class="form-group">
		<label for="content">내용</label>
		<textarea class="form-control" rows="5" id="memo" name="memo">${member.memo }</textarea>
	</div>
<button type="button" class="btn btn-secondary btn-sm" id="btnUpdate">수정</button>
</form>
</div>


<script>
$("#btnUpdate").click(function(){
	var dataParam = {
		id: $("#id").val(),
		name: $("#name").val(),
		password: $("#password").val(),
		email: $("#email").val(),
		addr: $("#addr").val(),
		memo: $("#memo").val(),
	}
	$.ajax({
		type:'put',
		url: '/update/',
		data:JSON.stringify(dataParam),
		contentType: 'application/json;charset=utf-8'
	})
	.done(function(){
		alert("수정 성공")
		location.href="/list"
	})
	.fail(function(){
		alert("수정 실패")
	})
})

</script>
