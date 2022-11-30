<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>LOGIN</h1>
	</div>
</div>
	<div class="container">
		<form action="/app08/login" method="post">
			<div class="form-group">
				<label for="username">UserID:</label> <input type="text"
					class="form-control" id="username" placeholder="Enter userID" name="username">
			</div> <!-- usernaem, password는 정해진 포맷, 다른 이름 하고 싶으면 security xml에서 username-parameter를 사용해서 바꾸기 -->
		
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="pass" placeholder="Enter Password" name="password">
			</div>
			<button class="btn btn-primary">로그인</button>
		</form>
	</div>
<!-- 	<script> -->
<!-- // 	$("#loginBtn").click(function(){ -->
<!-- // 		if($("#userid").val()==""){ -->
<!-- // 			alert("아이디를 입력하세요"); -->
<!-- // 			$("#userid").focus(); -->
<!-- // 			return false; -->
<!-- // 		}//userid -->
<!-- // 		if($("#pwd").val()==""){ -->
<!-- // 			alert("비밀번호를 입력하세요"); -->
<!-- // 			$("#pwd").focus(); -->
<!-- // 			return false; -->
<!-- // 		}//pwd -->
<!-- // 		$.ajax({ -->
<!-- // 			type:"post", -->
<!-- // 			url : "login", -->
<!-- // 			data : { -->
<!-- // 				"userid" : $("#userid").val(), -->
<!-- // 			    "pwd" :	$("#pwd").val() -->
<!-- // 			}, -->
<!-- // 			success:function(resp){ -->
<!-- // 				if(resp.trim()==-1){ -->
<!-- // 					alert("회원이 아닙니다. 회원가입하세요"); -->
<!-- // 				}else if(resp.trim()==0){ -->
<!-- // 					//일반회원 ==>memberView.jsp  관리자==>memberList.jsp -->
<!-- // 					alert("일반회원 로그인 성공")   -->
<!-- // 					$(location).attr("href","../board/boardlist") -->
<!-- // 				}else if(resp.trim()==1){ -->
<!-- // 					alert("관리자 로그인 성공")   -->
<!-- // 					$(location).attr("href","../board/boardlist") -->
<!-- // 				}else if(resp.trim() ==2){ -->
<!-- // 					alert("비밀번호가 틀립니다. 비밀 번호를 확인하세요"); -->
<!-- // 				} -->

<!-- // 			}, -->
<!-- // 			error:function(e){ -->
<!-- // 				alert(e + "error") -->
<!-- // 			} -->
<!-- // 		})  //ajax -->
	
<!-- // 	})	//loginBtn -->
	
	
<!-- 	</script> -->