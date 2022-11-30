<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h2>개인 정보 수정</h2>
<form action="personUpdate.sp" method="post">
이름 :  <input type="text" name="name" id="name" value="${person.name }"><br/>
아이디 :  <input type="text" name="id" id="id" value="${person.id }" readonly="readonly"><br/>
비밀번호 :  <input type="password" name="password" id="password"><br/>
성별 :
<label for="m">남자</label>
<input type="radio"  value="남" id="m" name="gender" checked>
<label for="f"> 여자</label>
<input type="radio"  value="여" id="f"  name="gender"><br/>
 직업 :
  <select name="job" id='job'>
	  <option value="학생">학생</option>
	  <option value="공무원">공무원</option>
	  <option value="회사원">회사원</option>
	   <option value="기타">기타</option>   
</select><br>
<script>
$("input:radio[value='${person.gender}']").prop("checked",true);

$("#job option").each(function() {
	if($(this).val()=="${person.job}"){
		$(this).prop("selected",true);
		
	}
		
})
</script>
<input type="submit" value="확인">
<input type="reset" value="취소">
</form>
</body>
</html>