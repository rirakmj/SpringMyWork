<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insert" method="post">
	<table align="center">
	<tr>
		<td>글쓴이</td> 
		<td><input type="text" id="name" name="name"><td/>
	</tr>
	<tr>
		<td>내용</td>
		<td> <input type="text" id="content" name="content" size="80"></td>
	</tr>
	<tr>
		<td>평가</td>
		<td>
		<input type="radio" id="excellent" checked>아주잘함(excellent)
		<input type="radio" name="grade" id="good">잘함(good)
		<input type="radio" name="grade" id="normal">보통(normal)
		<input type="radio" name="grade" id="fail">노력(fail)</td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="입력">
		</td>
	</tr>
	</table>
</form>
</body>
</html>