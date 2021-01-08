<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>re-quest</title>
<style>*{text-aligin : center;}</style>
</head>
<body>
<fieldset>
<legend>정말 탈퇴하시겠습니까?</legend>
<input type = "button" id= yes name = yes value="예">
<input type = "button" id = no name = no value="아니요">
<input type = hidden id = hidden>
</fieldset>
</body>
<script>

document.getElementById("yes").onclick=function(){
		window.opener.location.href="/members/quit";
		window.close();
	}
document.getElementById("no").onclick=function(){
		window.close();
	}
	
	
</script>
</html>