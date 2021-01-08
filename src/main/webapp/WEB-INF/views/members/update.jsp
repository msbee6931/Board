<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
<style>
                *{
                    margin: 0;
                    padding: 0;
                }
                .container{
                    margin: auto;
                }
                .container table,tr,td{
                    border: 1px solid black;
                }
                tr td:nth-child(1){
                    text-align: center;
                }
                #msg{
                   border-style: none;
                }
            </style>
</head>
<body>
<div class="container">
            <form action = /members/update method="post">
                <table>
                    <tr>
                        <td colspan="2">회원 가입 정보</td>
                    </tr>
                    <tr class="selectImg">
                            <img src="/files/${dto.goodImg}"/>
                    	<input type="file" class="imgUpBtn" id="goodImg" name="file"/>
                    </tr>
                    
                    <tr>
                        <td>아이디</td>
                        <td>
                        <input type="text" id= id name=id value=${dto.getId }>
                        </td>
                            
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td><input type="text"id= name name=name value=${dto.getName }></td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td><input type="text" id = email name = email value=${dto.getEmail }></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type=submit id=update value=정보수정>
                        </td>
                    </tr>
                </table>
                 </form>
            </div>

<script>
$("#goodImg").change(
        function() {
            if (this.files && this.files[0]) {
                let reader = new FileReader;
                reader.onload = function(data) {
                    $(".selectImg img").attr("src", data.target.result).width(500);
                }
                reader.readAsDataURL(this.files[0]);
            }
        });
   
    
            
           
            </script>
     
</body>
</html>