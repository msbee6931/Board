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

	document.getElementBy("yes").onclick=function(){
		hidden.value="yes";
		opener.document.getElementById("phidden").value = document.getElementById("hidden").value;
		window.close();
	}
	document.getElementBy("no").onclick=function(){
		hidden.value="no";
		opener.document.getElementById("phidden").value = document.getElementById("hidden").value;
		window.close();
	}
	
	
</script>
</html>