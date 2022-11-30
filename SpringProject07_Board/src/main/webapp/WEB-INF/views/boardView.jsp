<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file = "includes/header.jsp"%>
<!--     <script> -->
<!-- $(function() {
     	$("#delBtn").click(function() {
     	if (confirm("정말 삭제할까요?")) {
     	location.href = "/app07/delete/${board.num}"
     			}
     		})
     	}) -->     
<!-- </script> -->
<div class="container mt-3">
<h2>상세 보기</h2>
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
<c:if test="${sessionScope.sMember.id ==  board.writer}">
<input type="button" class="btn btn-secondary btn-sm" value="수정" id="upBtn" 
onclick="location.href='/app07/update/${board.num}'"/>
  <!--onclick="location.href='/app07/update/${board.num}'" />-->
<input type="button" class="btn btn-danger btn-sm" value="삭제" id="delBtn"/>
  <!-- onclick="location.href='/app07/delete/${board.num}'" js 넣어주면 필요없음 --> 
  <a href="/app07/delete/${board.num}">삭제</a>
  </c:if>
  </div>
  <br/><br/>
  	<div align="center">
  		<textarea rows="3" cols="50" id="msg"></textarea>
  		<button type="button" class="btn btn-secondary btn-sm" id="btnComment">댓글쓰기</button>
  	</div>
  	<hr/>
  	<h4>댓글(${replyCnt })</h4>
  	<div id="replyResult" ></div>
  <script>
  var init = function(){
	  $.ajax({
		type:'get',
		url:'/app07/reply/commentList/${board.num}'
// 		url:'/app07/reply/commentList',
// 		data:{"bnum":$("#num").val()}
	  })
	  .done(function(resp){
		  var str ="";
		  $.each(resp,function(key,val){
		  	str += val.userid+' '
		  	str += val.content+' '
		  	str += val.regdate+' '
		  	if("${sessionScope.sMember.id}"==val.userid){
		  	str +="<a href=javascript:fdel("+val.cnum+")>삭제</a><br/>"
		  }
	  }) // each
	  $("#replyResult").html(str)
  }) // done
  .fail(function(e){
	alert("실패")  
  }) // fail
  } // init
  
  // 댓글 삭제
  function fdel(cnum){
	  $.ajax({
		 type:"Delete",
		 url:'/app07/reply/delete/'+cnum
	  })
	  .done(function(resp){
		  alert(resp+"번 글 삭제 완료")
		  init()
	}).fail(function(e){
		alert("댓글 삭제 실패:"+e)
	})
  } // fdel
  
  // 댓글쓰기
  $("#btnComment").click(function(){
	  if(${empty sessionScope.sMember}){
		  alert("로그인하세요")
		  location.href="/app07/member/login"
		  return;
	  }
	if($("#msg").val()==""){
		alert("댓글 입력하세요")
		return;
	} 
	data = {
			"bnum":$("#num").val(), // parent content number
			"content":$("#msg").val(), // comment
	}
	$.ajax({
		type:"post",
		url:'/app07/reply/commentInsert',
		contentType: "application/json;charset=utf-8", // JSON형태
		data: JSON.stringify(data),
		success:function(resp){
			if(resp=="success") alert("댓글 추가 성공");
			init();
		},
		error:function(){
			alert("댓글 추가 실패")
		}
	}) // ajax
  }) // btnComment
  
// 삭제
$("#delBtn").click(function() {
	if(!confirm('정말 삭제할까요?')) {
		return false;
	}
	$.ajax({
		type:"DELETE",
		url:"/app07/delete/${board.num}",
		success: function(resp) {
			if(resp=="success") {
			alert("삭제 성공");
			location.href="/app07/list"
			}
		},
		error: function(e) {
			alert("삭제 실패:" + e)
		}
	})
})

//수정폼
$("#upBtn").click(function(){
	if(!confirm('정말 수정할까요?'))
		return false;
		location.href="/app07/update/${board.num}"		
})
init()
</script>
<%@ include file = "includes/footer.jsp"%>