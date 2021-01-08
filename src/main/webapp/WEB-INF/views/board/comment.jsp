<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Comment</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<style>
		*{box-sizing:border-box;}
		div{border: 1px solid black;}
		#commentNote{width:500px;height:200px; overflow:auto;}
		#navi{text-align:center;}
		#rUpdModal {
		position:fixed;
		
		display: none;
	}
	</style>
</head>
<body>
	<div class="container">
		<div id="commentBox">
			<textarea id="commentNote"></textarea>
			<input type=button value="확인" class="btns" id="commentSend">
		</div>
		<div id="commentView">
		<input type="hidden" value=${id} id="id">
		<c:forEach var="i" items="${clist}">
			<div class="commentList">
				<div class="writer">${i.writer}</div>				
				<div class="comment"> ${i.content}</div>
				<div class="date">${i.reg_date}</div>
				<input type="hidden" value=${i.seq}>
			<c:if test="${i.writer == id}">
				<input type="button" value="수정 " class="upd">
				<input type="button" value="삭제" class="del">
			</c:if>
			</div>
		</c:forEach>
		</div>
		<div id="navi">${cnavi}</div>
		<div id="rUpdModal">
					<div>
						<textarea id="updContent"></textarea>
						<input type="hidden" id="hiddenSeq">
					</div>
					<div class="BtnsArea">
						<button type="button" class="modalUpd" id="modUpdBtn">수정</button>
						<button type="button" class="modalCancel" id="modCanBtn">취소</button>
					</div>
			</div>
	</div>
</body>
	<script>
		$("#commentSend").on("click",function(){	
			$(".commentList").remove();
			$.ajax({
				url :"/comment/insert.comment",
				type : "post",
				data : {seq:$("#seq").val(), content :$("#commentNote").val()},
				dataType : "json"
			}).done(function(obj){
				let id = $("#id").val()
				console.log(id);
				  for (let i=0; i<obj.length;i++){
                      let div = $("<div class='commentList'>");  
                      if(obj[i].writer == id){
                      	 str= "<div class='revWriter'>"+obj[i].writer+"</div>"+
                           "<div class='date'>"+obj[i].content+"</div>"+
                           "<div class='comment'>"+obj[i].reg_date+"</div>"+
                           "<input type='hidden' value='"+obj[i].seq+"'>" +
                           "<button type='button' class='upd'>수정</button> "+
                           "<button type='button' class='del'>삭제</button>"
                           
                      }else{
                      	 str= "<div class='writer'>"+obj[i].writer+"</div>"+
                           "<div class='comment'>"+obj[i].reg_date+"</div>"+
                           "<div class='date'>"+obj[i].content+"</div>"                        
                      }
                      div.html(str);
                      $("#commentView").append(div);
                      $("#commentNote").val("");
                  }               			
				$.ajax({
					url:"/comment/getNavi.comment",
					type:"post", 
					data:{seq:$("#seq").val()}
				}).done(function(resp){
					$("#navi").html(resp);
				})
				
			})
		});
		
		$("#commentView").on("click",".del",function(){
			let delConfirm = confirm("삭제하시겠습니까?");
			let seq = $("#seq").val();
			console.log(seq);
            if(delConfirm){
           		$(this).parent().remove();
				$.ajax({
					url:"/comment/del.comment",
					type:"post",
					data: {seq : $(this).prev().prev().val()},
					dataType:"json"
				})
				$.ajax({
					url:"/comment/getNavi.comment",
					type:"post", 
					data:{seq:seq}
				}).done(function(resp){
					$("#navi").html(resp);
				})
			}
		});
		$("#commentView").on("click",".upd",function(){
			 let seq = $(this).prev().val();
			 $("#hiddenSeq").val(seq);
			 $("#rUpdModal").show();
			 let content = $(this).prev().prev().prev();	 
			 $(".modalUpd").on("click",function(){
					$("#rUpdModal").hide();
					$.ajax({
						url:"/comment/update.comment",
						type:"post",
						data :{seq:$("#hiddenSeq").val(),content : $("#updContent").val()},
						dataType:"json"
					}).done(function(){
						content.html($("#updContent").val());
					})
				})
		})
		$(".modalCancel").on("click",function(){
			 $("#rUpdModal").hide();
		})
		
	</script>
</html>