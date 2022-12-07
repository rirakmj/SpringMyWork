<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../includes/header.jsp"%>
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
			<c:forEach items="${boards }" var="b" varStatus="st">
				<tr>
					<td>${b.num }</td> <!-- ${rowNo - st.index} -->
					<td><a href="view/${b.num}">${b.title }[${b.replyCnt}]</a></td>
					<td>${b.writer }</td>
					<td><fmt:formatDate value="${b.regdate }"
					pattern="yyyy-MM-dd" /></td>
					<td>${b.hitcount }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
</div>