<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<div class="container">
		<form action="/board/boardUpdate.board">
			<table>
				<tr>
					<td>
						<input type="text" name="title" value="${dto.title }" Required>
						<input type="hidden" name="writer" value="${dto.writer }">
					</td>
				</tr>
				<tr>
					<td>
						<input type="file" name="file" value="${dto.img }">
					</td>
				</tr>
				<tr>
					<td>
						<textarea name="contents" value="${dto.contents }" Required></textarea>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="수정">
						<input type="button" value="취소" id="cancel">
					</td>
				</tr>
			</table> 
		</form>
	</div>
	
	<script>
		document.getElementById("cancel").onclick = function(){
			location.href = "/board/boardListView.board?cpage=1";
		}
	</script>
</body>
</html>