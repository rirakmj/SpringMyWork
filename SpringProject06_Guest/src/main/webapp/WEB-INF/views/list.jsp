<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Guest List(${count })</h2>
<form action="list">
	<select name="field">
	<option value="name">이름</option>
	<option value="content">내용</option>
	</select>
	<input type="text" name="word" id="word">
	<input type="submit" value="찾기">
</form>
<br>
<c:forEach items="${guests }" var="guest" >
이름 : <a href="">${guest.name }</a><br/>
내용 : ${guest.content }<br/>
등급 : ${guest.grade }<br/><br/>
</c:forEach>
</body>
</html>