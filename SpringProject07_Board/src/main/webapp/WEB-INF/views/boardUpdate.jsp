<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "includes/header.jsp"%>
<div class="container mt-3">
<h2>수정하기</h2>
<input type="hidden" name="num" id="num"  value="${board.num }" />
<form action="update">
	<div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title"
       value="${board.title }">
<%--       value="${sessionScope.suser.userid}" readonly="readonly" --%>
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
<button type="button" class="btn btn-secondary" id="btnModify">수정</button>
</form>
</div>
<script>
$("#btnModify").click(function(){
	data = {
			"num":$("#num").val(),
			"title":$("#title").val(),
			"content":$("#content").val()
	}
	$.ajax({
		type:'put',
		url:"/app07/update",
		contentType: "application/json;charset=utf-8",
		data: JSON.stringify(data),
		success:function(resp){
			alert("수정완료")
			location.href="/app07/list";
		},
		error:function(e){
			alert("수정 실패" + e);
		}
	})
})
</script>
<%@ include file = "includes/footer.jsp"%>