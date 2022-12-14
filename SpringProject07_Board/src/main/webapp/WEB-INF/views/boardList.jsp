<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "includes/header.jsp"%>

<div class="container">
<h4>게시판(${count })</h4>
</div>
<div class="container mt-3">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${barr }" var="b" varStatus="st">
				<tr>
					<td>${rowNo-st.index}</td> <!-- ${rowNo - st.index} -->
					<td><a href="view/${b.num}">${b.title }[${b.replyCnt }]</a></td>
					<td>${b.writer }</td>
					<td><fmt:formatDate value="${b.regdate }"
					pattern="yyyy-MM-dd" /></td>
					<td>${b.hitcount }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="d-flex justify-content-between">
	<ul class="pagination mt-3">
		<!-- 이전 -->
		<c:if test="${p.startPage > p.blockPage }">
		  	<li class="page-item"><a class="page-link" href="list?pageNum=${p.startPage-p.blockPage }&field=${p.field}&word=${p.word}">Previous</a></li>
		  </c:if>
		  <!--  페이지 -->
		  <c:forEach begin="${p.startPage }" end="${p.endPage}" var="i">
		   <c:if test="${p.currentPage == i }">
		   	<li class="page-item active"><a class="page-link" href="#">${i}</a></li>
		  </c:if>
		  <c:if test="${p.currentPage !=i }">
 		  	<li class="page-item"><a class="page-link" href="list?pageNum=${i}&field=${p.field}&word=${p.word}">${i}</a></li>
<%-- 		  <li class="page-item"><a class="page-link" href="list?pageNum=${i}&field=${param.field}&word=${param.word}">${i}</a></li> --%>
		  </c:if>
		  </c:forEach>
		  <!--  다음 -->
		  <c:if test="${p.endPage < p.totPage }">
		  <li class="page-item"><a class="page-link" href="list?pageNum=${p.endPage+1 }&field=${p.field}&word=${p.word}">Next</a></li>
		  </c:if>
	</ul>
	
	<form class="form-inline" action="/app07/list" method="get">
		<select name='field' class="form-control mr-sm-1">
			<option value="writer">작성자</option>
			<option value="content">내용</option>
			</select>
			<script>
			$("#field option").each(function(){
				if($(this).val()=="${p.field}"){
					$(this).prop("selected",true);
				}	
			}) // 검색한 field가 검색 후에도 표시되게 하기
			</script>
		<input type='text' name='word' class="form-control" placeholder="Search">
		<button class='btn btn-secondary'>Search</button>
		</form>	
	</div>
</div>

	<%@ include file = "includes/footer.jsp"%>
