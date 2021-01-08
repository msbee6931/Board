<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
</head>
<body>
	<div class="container">
		<form action="/board/boardWrite.board">
			<table>
				<tr>
					<td>글쓰기</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="title" placeholder="제목을 입력하세요." Required>
						<input type="hidden" name="writer" value="${id }">
					</td>
				</tr>
				<tr>
					<td>
						<input type="file" name="file">
					</td>
				</tr>
				<tr>
					<td>
						<textarea name="contents" placeholder="내용을 입력해주세요." Required></textarea>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="완료">
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