<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="icon" type="image/png" href="http://example.com/myicon.png">
<meta charset="UTF-8">
<title>SignUp</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
	*{overflow:hidden;}
	 #table{
        line-height: 25px;
    }
  
    #tname{
        text-align: center;
    }
    
</style>
</head>
<body>
	<form action="/member/okSignUp.mem" onsubmit="return cpw.oninput()" data-ajax="false" method=post>
	<table border="1" id ="table">
	<tr><td colspan=2 id=tname>회원 가입 정보</td></tr>
    <span class="selectImg">
    <img src="" width="100px" height="100px"/>
                        </span>
	<tr><td style="text-align:right">이미지:</td>
	<td><input type="file" id="Img" name="img"></td>
	</tr>
	<tr><td style="text-align:right">아이디:</td>
	<td><input type="text" id="id" name="id" required>
        <button type=button id="check">중복확인</button>
        <span id="resultid"></span></td></tr>
        <tr>
            <td style="text-align:right">비밀번호 : </td>
            <td><input type=password id="pw" name="pw" required></td>
        </tr>
        <tr>
            <td style="text-align:right">비밀번호 확인 : </td>
            <td><input type=password id="cpw" name="cpw" required>
            <span id="resultpw"></span>
            </td>
        </tr>
        <tr>
            <td style="text-align:right">이름 : </td>
            <td><input type=text id=name name=name required></td>
        </tr>
        
        <tr>
            <td style="text-align:right">이메일 : </td>
            <td><input type=text id=emailid name=emailid required>@
            <input type=text id=dotcom name=dotcom style="width:100px" required>
            </td>
            <input type="hidden" id=email name=email>
        </tr>
        <tr>
        <td colspan=2 style="text-align:center"><button id=signup name=signup>회원가입</button>
        <button type=button id="retry" name="retry">다시입력</button></td>
        </tr>


</table>
</form>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    let pw=document.getElementById('pw');
    let cpw=document.getElementById('cpw');
    let emailid = document.getElementById('emailid');
    let dotcom = document.getElementById('dotcom');
    let email = document.getElementById('email');
    
    
      cpw.oninput=function(){
          if(pw.value==cpw.value){
              document.getElementById('resultpw').innerHTML='일치합니다.';
              document.getElementById('resultpw').style.color='blue';
              
          }else{
              document.getElementById('resultpw').innerHTML='불일치합니다.';
              document.getElementById('resultpw').style.color='red';
              return false;
          }
      }
      
      $("#check").click(function(){
    	  let id = document.getElementById("id").value;
          $.ajax({url:"/member/idCheck.mem",
          type:"post",
          data:{id:id},
          }).done(function(resp){
          document.getElementById("resultid").innerHTML=resp;
          
          })
       })
    	  
      document.getElementById("retry").onclick=function(){
    	  location.href="/member/signUp.mem";
      }
      document.getElementById("signup").onclick=function(){
          email.value=emailid.value+'@'+dotcom.value;
      }
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
</script>
</body>
</html>