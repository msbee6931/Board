<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" ></script>
        <style>

            .container {margin: 50px auto; border: 2px solid #c1c1c1;}
            #btn {text-align: right;}
            a {text-decoration: none;}
            #b,#bb,#bbb {border-bottom: 1px solid #c1c1c1;}
            
            #w {font-size:small;}
            #wDate,#vCount {font-size: x-small;}
            
        </style>
</head>
<body>


        <div class="container">
        <form action="/board/boardUpdate.board" method="post" enctype="multipart/form-data">
			<input type="hidden" id="seq" value="${dto.seq}">
            <div class="row text-center" id="b">
                <div class="col-12"><b>${dto.title}</b></div>
            </div>
            <div class="row text-center" id="bb">
                <div class="col-1" id="w">${dto.writer}</div>
                <div class="col-1" id="wDate">${dto.write_date}</div>
                <div class="col-9" ></div>
                <div class="col-1" id="vCount">${dto.view_count}</div>
            </div>
            <div class="row text-center">
                <div class="col-12" id="w"><img src="/files/${dto.img}"/></div>
            </div>
            <div class="row text-center" id="bbb">
                <div class="col-12" id="w">${dto.contents}</div>
            </div>  
            <div class="row" id="btn">
             <div class="col-12">
             <c:if test="${id} == ${dto.writer}">
                 <button type="submit" class="btn btn-outline-primary" id="updBtn">수정하기</button>
                 <button type="button" class="btn btn-outline-danger" id="delBtn">삭제하기</button>
             </c:if>
                 <button type="button" class="btn btn-outline-secondary" id="backBtn">뒤로가기</button>
             </div>
            </div>
            </form>
            <div class="row text-center">
                <div class="col-12" ><jsp:include page="/WEB-INF/views/board/comment.jsp"></jsp:include></div>
            </div>

    
        </div>
</body>

<script>
	$("#delBtn").on("click", function() {
		let seq=${dto.seq};
		location.href="/board/boardDelete.board?seq="seq;
	})
	
	$("#backBtn").on("click", function() {
		location.href="/board/boardListView.board?cpage=1";
		})
	
	</script>

</html>