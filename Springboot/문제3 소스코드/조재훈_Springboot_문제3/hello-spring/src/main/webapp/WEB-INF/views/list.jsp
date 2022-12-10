<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>

<div class="container">
	<table class="table table-hover" style="text-align: center;">
	<h3>회원 리스트</h3>
	<thead>
	<tr>
	<th>이름</th>
	<th>주소</th>
	<th>이메일</th>
	<th>권한</th>
	</tr>
	</thead>
	
	<tbody>
<c:forEach items="${lists}" var="member">
<tr>
<td><a href="detail/${member.id}"> ${member.username }</a></td>
<td> ${member.addr }</td>
<td> ${member.email }</td>
<td> ${member.role }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<script>


	


</script>
