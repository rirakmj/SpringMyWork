<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
<h3>${board.user.username }의 글 수정하기</h3>
	<form action="update" >
	<div class="form-group">
			<label for="num">글번호:</label> 
			<input type="text" class="form-control" id="num" name="num" 
			value=${board.num } readonly="readonly">
		</div>
		
		<div class="form-group">
			<label for="title">제목:</label> 
			<input type="text" class="form-control" id="title" name="title" 
			value=${board.title }>
		</div>

		<div class="form-group">
			<label for="writer">작성자:</label> 
			<input type="text" class="form-control" id="writer" name="writer" 
			value="<sec:authentication property="principal.user.username" />" 
			readonly="readonly" >
		</div>

		<div class="form-group">
			<label for="content">내용:</label>
			<textarea class="form-control" rows="5" id="content" name="content" >${board.content } </textarea>
		</div>
		<button type="button" class="btn btn-secondary btn-sm" id="modifyBtn">수정</button>
	</form>
</div>
<script>
$("#modifyBtn").click(function(){
	var dataParam = {
			"num":$("#num").val(),
			"title":$("#title").val(),
			"content":$("#content").val(),
	}
	$.ajax({
		type:"put",
		url:"/board/update/",
		data:JSON.stringify(dataParam),
		contentType:"application/json;charset=utf-8"
	})
	.done(function(){
		alert("수정 성공")
		location.href="/board/list"
	})
	.fail(function(){
		alert("수정 실패")
	})
})
</script>