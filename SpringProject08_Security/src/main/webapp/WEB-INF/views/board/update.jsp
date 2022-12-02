<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../includes/header.jsp"%>
<div class="container mt-3">
<h2>수정하기</h2>
<form action="/app08/board/update" method="post">
<input type="hidden" name="num" id="num"  value="${board.num }" /> <!-- form tag 안에 있어야 함 -->
	<div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title"
       value="${board.title }">
    </div>
    
    <div class="form-group">
      <label for="writer">글쓴이:</label>
      <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" readonly="readonly"
      value="${board.writer }">
    </div>
      
     <div class="form-group">
       <label for="content">내용:</label>
       <textarea class="form-control" rows="5" id="content" name="content" >${board.content }</textarea>
     </div>
<input type="submit" class="btn btn-secondary" id="btnModify" />

</form>
</div>