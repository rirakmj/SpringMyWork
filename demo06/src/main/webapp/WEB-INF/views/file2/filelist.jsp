<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<div class="container">
	<div class="row">
		<c:forEach items="${lists }" var="fboard">
			<div class="col-3 mb-3" style="width: 400px">
				<div class="card">
					<img class="card-img-top"
						src="/images/${fboard.fileimage }" alt="Card Image"
						style="width: 100%; height:200px">
					<div class="card-body">
						<h4 class="card-title">title:${fboard.title }</h4>
						<p class="card-text">writer:${fboard.writer }</p>
						<p class="card-text">content:${fboard.content }</p>
					</div>
					<!--  card-body -->
				</div>
				<!--  card -->
			</div>
			<!-- col -->
		</c:forEach>
	</div>
	<!-- row -->
</div>