<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div class="container">
<h3>File Board Insert</h3>
<form action = "fileInsert" method="post" encType="multipart/form-data">
		<div class="form-group">
			<label for="title">제목:</label> <input type="text"
				class="form-control" id="title" name="title">
		</div>

		<div class="form-group">
			<label for="title">작성자:</label> 
			<input type="text" class="form-control" id="writer" name="writer" 
				value="${user.user.username}" readonly="readonly" />
		</div>

		<div class="form-group">
			<label for="title">내용:</label>
			<textarea class="form-control" rows="5" id="content" name="content"></textarea>
		</div>
		
		<div class="form-group">
			<label for="upload">파일:</label>
			<input type="file" class="form-control" id="upload" name="upload" >
		</div>
		<button class="btn btn-primary">글쓰기</button>
	</form>
</div>