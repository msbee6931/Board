<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<input type="button" value="회원 탈퇴" onclick="openChild()">
<input type= hidden id = phidden>
</body>
<script>
var openWin;
function openChild(){
window.name="parentForm";
openWin = window.open("members/re-quest","childForm", "width=570, height=350, resizable = no, scrollbars = no");
}
if(phidden.value=="yes"){
	location.href="/members/quit"
}
</script>
</html>
