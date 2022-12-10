<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ include file ="includes/header.jsp" %>
 
 	<div class="container">
	<form action="/join" method="post">
	<div class="form-group">
		<label for="username">이름:</label> 
		<input type="text" id="username" name="username" class="form-control">
		</div>
			<div class="form-group">
		<label for="password">비밀번호:</label> 
		<input type="password" id="password" name="password" class="form-control">
		</div>
			<div class="form-group">
		<label for="email">이메일:</label> 
		<input type="email" id="email" name="email" class="form-control">
		</div>
			<div class="form-group">
		<label for="addr">주소:</label> 
		<input type="text" id="addr" name="addr" class="form-control">
		</div>
		<div class="form-group">
      <label for="content">내용</label>
     <textarea class="form-control" rows="5" id="memo" name="memo"></textarea>
    </div>
		<button>Submit</button>
	</form>
</div>
 

