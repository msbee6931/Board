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
            #tit {border-bottom: 1px solid #c1c1c1;}
            #btn {text-align: right;}
            a {text-decoration: none;}
            a:hover {cursor:pointer;}
        </style>
</head>
<body>
<div class="container">
            <div class="row text-center" id="tit">
                <div class="col-md-1 d-none d-sm-block"><b>No</b></div>
                <div class="col-8 col-md-6"><b>제목</b></div>
                <div class="col-2 col-md-2"><b>작성자</b></div>
                <div class="col-md-1 d-none d-sm-block"><b>조회수</b></div>
                <div class="col-2 col-md-2"><b>날짜</b></div>
            </div>
            <c:forEach var="i" items="${list }">
            <div class="row text-center">
                <div class="col-md-1 d-none d-sm-block">${list.seq }</div>
                <div class="col-8 col-md-6"><a href="/board/viewBoard?seq=${list.seq}">${list.title }</a></div>
                <div class="col-2 col-md-2">${list.writer }</div>
                <div class="col-md-1 d-none d-sm-block">${list.view_count}</div>
                <div class="col-2 col-md-2">${list.write_date}</div>
            </div>
            </c:forEach>
             <div class="row text-center">
             <div class="col-12">
             <nav aria-label="Page navigation example">
 			 <ul class="pagination">
			${navi}
  			</ul>
			</nav>
			</div>
            </div>
            <div class="row" id="btn">
             <div class="col-10"></div>
             <div class="col-12">
                 <button type="button" class="btn btn-outline-primary" id="inBtn">글쓰기</button>
                <button type="button" class="btn btn-outline-secondary" id="backBtn">뒤로가기</button>
             </div>
            </div>

    
        </div>

</body>

<script>
$("#inBtn").on("click", function() {
	let id=${id}
	location.href="/board/boardWrite.board?id="+id;
})

$("#backBtn").on("click", function() {
	location.href="/board/boardListView.board?cpage=1";
	})
</script>
</html>