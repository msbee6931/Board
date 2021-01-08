<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Result</title>
</head>
<body>
	<c:choose>
		<c:when test="${result>0 }">
			<script>
				alert("작성 성공!");
				location.href = "/board/boardListView.board?cpage=1";
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("작성 실패!");
				location.href = "/board/boardListView.board?cpage=1";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>