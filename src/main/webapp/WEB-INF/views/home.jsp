<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<style>
* {box-sizing: border-box}
.container {width: 300px;height: 110px;margin: auto;border: 1px solid black;
	text-align: center;line-height: 25px;}
#id {float: left;width: 30%;text-align: right;}
#text {float: left;width: 70%;}
#idSpace {width: 100%;}
.space {width: 100%;}
#pw {width: 30%;float: left;text-align: right;}
#password {width: 70%;float: left;}
#pwSpace {width: 100%;}
#fieldset {width: 400px;height: 100px;}

</style>
</head>
<body>
	<c:choose>
		<c:when test="${id != null}">
			<fieldset id=fieldset>
				<legend style="text-align: center">Welcome</legend>
				${id} 님 환영합니다.<br>
				<button type=button id=board>게시판</button>
				<button type=button id=MyPage>마이페이지</button>
				<button type=button id=logout>로그아웃</button>
				<button type=button id=deleteck>회원탈퇴</button>
			</fieldset>
			
			<script>
			
    		document.getElementById("board").onclick=function(){
    			location.href="/board/boardListView.board?cpage=1";	
    		}
    		document.getElementById("MyPage").onclick=function(){
    			location.href="";	
    		}
    		document.getElementById("logout").onclick=function(){
    			location.href="";	
    		}
    		document.getElementById("deleteck").onclick=function(){
    			location.href="";	
    		}
    		
    	
    	</script>
		</c:when>

		<c:otherwise>
			<form action="/member/login.mem" method="post">
				<div class="container">
					<div id="loginbox">
						<b>Login Box</b>
					</div>
					<div class="space">
						<div id=id>아이디 :</div>
						<div id="text">
							<input type="text" id="idSpace" name=id>
						</div>
					</div>
					<div class="space">
						<div id=pw>비밀번호 :</div>
						<div id="password">
							<input type="password" id="pwSpace" name=pw>
						</div>
					</div>
					<div class="space" id=button>
						<button id=login>로그인</button>
						<button type="button" id=signup>회원가입</button>
					</div>
				</div>
			</form>
			<script>
        document.getElementById('signup').onclick=function(){
        	location.href="/member/signUp.mem";
        }
	
		
	
        </script>
		</c:otherwise>
	</c:choose>

</body>
</html>
