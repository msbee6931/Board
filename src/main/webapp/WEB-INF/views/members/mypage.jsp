<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="http://example.com/myicon.png">
<meta charset="UTF-8">
<title>Update Page</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
}

.container {
	margin: auto;
}

.container table, tr, td {
	border: 1px solid black;
}

tr td:nth-child(1) {
	text-align: center;
}

#msg {
	border-style: none;
}
</style>
</head>
<body>
	<div class="container">
		<form action=/members/update method="post">
			<table>
				<tr>
					<td colspan="2">회원 가입 정보</td>
				</tr>


				<span class="selectImg"> <img src="files/${dto.img }" width="100px"
					height="100px" />
				</span>


				<tr>
					<td>아이디</td>
					<td>${dto.id }
					</td>

				</tr>
				<tr>
					<td>이름</td>
					<td>${dto.name }</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>${dto.email }</td>
				</tr>
				<tr>
					<td colspan="2"><input type=button id=update value="수정하기" />
					<input type=button id=return value="되돌아가기" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script
		src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	document.getElementById("update").onclick=function(){
		location.href="/members/updatePage"	
	}
	document.getElementById("return").onclick=function(){
      	location.href="/";
      }
            </script>
</body>
</html>