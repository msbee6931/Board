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


				<span class="selectImg"> <img src="" width="100px"
					height="100px" />
				</span>
				<tr>
					<td style="text-align: right">이미지:</td>
					<td><input type="file" id="Img" name="img"></td>
				</tr>


				<tr>
					<td>아이디</td>
					<td><input type="text" id=id name=id value=${dto.id }>
					</td>

				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" id=name name=name value=${dto.name }></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" id=email name=email value=${dto.email }></td>
				</tr>
				<tr>
					<td colspan="2"><input type=submit id=update value=수정완료>
					<input type=button id=return value=되돌아가기>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script
		src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
$("#Img").change(
        function() {
            if (this.files && this.files[0]) {
                let reader = new FileReader;
                reader.onload = function(data) {
                    $(".selectImg img").attr("src", data.target.result).width(100);
                }
                reader.readAsDataURL(this.files[0]);
            }
        });
    
document.getElementById("return").onclick=function(){
  	location.href="/members/mypage";
  }
           
            </script>

</body>
</html>