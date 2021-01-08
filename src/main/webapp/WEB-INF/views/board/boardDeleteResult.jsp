<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Result</title>
</head>
<body>
	<c:choose>
		<c:when test="${result>0 }">
			<script>
				alert("삭제 성공!");
				location.href = "/board/boardListView.board?cpage=1";
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("삭제 실패!");
				location.href = "/board/boardListView.board?cpage=1";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>