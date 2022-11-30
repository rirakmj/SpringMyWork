<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>개인 정보 입력</h2>
<form action="person_insert.go" method="post">
이름 :  <input type="text" name="name" id="name"><br/>
아이디 :  <input type="text" name="id" id="id"><br/>
비밀번호 :  <input type="password" name="password" id="password"><br/>
성별 :
<label for="m">남자</label>
<input type="radio"  value="남" id="m" name="gender" checked>
<label for="f"> 여자</label>
<input type="radio"  value="여" id="f"  name="gender"><br/>
 직업 :
  <select name="job">
	  <option value="학생">학생</option>
	  <option value="공무원">공무원</option>
	  <option value="회사원">회사원</option>
	   <option value="기타">기타</option>   
</select><br>
 <input type="button" value="등록"  onclick="submit()">
 <input type="button" value="취소"  onclick="del()">
</form>
</body>
</html>