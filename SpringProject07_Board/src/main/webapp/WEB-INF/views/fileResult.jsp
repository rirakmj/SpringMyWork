<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	   <%@ include file = "includes/header.jsp"%>
	
<div class="container">

	<c:forEach items="${uploadFileName }" var="file">
		<img src="/app07/resources/${file}">
uploadFileName : ${file }<br />
	</c:forEach>

</div>
   <%@ include file = "includes/footer.jsp"%>