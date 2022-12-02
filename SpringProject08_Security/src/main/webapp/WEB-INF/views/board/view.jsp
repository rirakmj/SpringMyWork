<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../includes/header.jsp"%>

<div class="container mt-3">
<h2>${board.writer }의 글보기</h2>
<input type="hidden" id="num" value="${board.num }" />
	<table class="table table-hover">
		<tr>
			<th>글번호</th>
			<td>${board.num }</td>
			<th>조회수</th>
			<td>${board.hitcount }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer }</td>
			<th>작성일</th>
			<td><fmt:formatDate value="${board.regdate }"
			pattern="yyyy-MM-dd" /></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td colspan="3">${board.title }</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td colspan="3">${board.content }</td>
		</tr>
	</table>
	<br />
</div>

<div class = "container mt-3">
<sec:authorize access="isAuthenticated()">
<c:if test="${pinfo.username==board.writer}">
<input type="button" class="btn btn-secondary btn-sm" value="수정" id="upBtn" 
onclick="location.href='/app08/board/update/${board.num}'"/>
<input type="button" class="btn btn-danger btn-sm" value="삭제" id="delBtn"/> 
<!-- <a href="/app08/delete/${board.num}">삭제</a>  -->
</c:if>
</sec:authorize>
  </div>
  
  <br/><br/>
 <div align="center">
  		<textarea rows="3" cols="50" id="msg"></textarea>
  		<button type="button" class="btn btn-secondary btn-sm" id="btnComment">댓글쓰기</button>
  	</div>
  	<hr/>
<div id="replyResult"></div>
	<sec:authorize access="isAnonymous()">
	<input type="hidden" id="prin" name="prin" value="null" />
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
	<input type="hidden" id="prin" name="prin" 
	value="<sec:authentication property="principal.username" />" />
	</sec:authorize>
  <script>
  var init = function(){
	  $.ajax({
		 type:'get',
		 url:'/app08/reply/commentList/${board.num}'
	  }).done(function(resp){
		  str="댓글("+resp.count+")<br/>";
		  $.each(resp.carr, function(key,val){
			  str+=val.userid+" "
			  str+=val.content+" "
			  str+=val.regdate+" "
			  if($("#prin").val()==val.userid) {
			  str+="<a href='javascript:del("+val.cnum+")'>삭제</a><br/>"
		  }
			  str += "<br/>"
		  }) // each
		  $("#replyResult").html(str)
		}).fail(function(e){
		  alert("실패")
	  })
  }

  //댓글 삭제
  function del(cnum) {
  	  $.ajax({
  		  type:"Delete",
  		  url:'/app08/reply/delete/'+cnum,
  	  })
  	  .done(function(resp){
  		 alert(resp+"번 글 삭제 완료")
  		 init()
  	  }).fail(function(e){
  		  alert("댓글 삭제 실패:"+e)
  	  })
    }
  
  $("#btnComment").click(function(){
	  if($("#prin").val()=="null"){
		  alert("로그인하세요")
		  location.href="/app08/customLogin"
	  }
	  else if($("#msg").val()==""){
		alert("댓글을 입력하세요.");
		return;
	}
dataStr={
		"bnum":$("#num").val(),
		"content":$("#msg").val(),
		"userid":$("#prin").val(),
}
	$.ajax({ // commentInsert
	type:'post',
	url:'/app08/reply/commentInsert',
	contentType:'application/json;charset=utf-8',
	data:JSON.stringify(dataStr)
	}).done(function(){
		alert("댓글 추가 성공")
		init()
	}).fail(function(e){
	alert("댓글 추가 실패:" +e)	
	})
})
 init()
 // 글 삭제
$("#delBtn").click(function() {
	if(!confirm('정말 삭제할까요?')) {
		return false;
	}
	$.ajax({
		type:"DELETE",
		url:"/app08/board/delete/${board.num}",
		success: function(resp) {
			if(resp=="success") {
			alert("삭제 성공");
			location.href="/app08/board/list"
			}
		},
		error: function(e) {
			alert("삭제 실패:" + e)
		}
	})
})
init()



	  </script>

