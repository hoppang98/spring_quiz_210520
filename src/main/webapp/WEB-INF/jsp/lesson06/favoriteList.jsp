<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

 	 <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 	 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<title>즐겨찾기 목록</title>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 목록</h1>
		
		<table class="table text-center">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${favoriteList}" var="favorite">
				<tr>
					<td>${favorite.id}</td>
					<td>${favorite.name}</td>
					<td>${favorite.url}</td>
					<%-- (1) value에 원하는 값을 담아 놓는다. --%>
					<%-- <td><button type="button" name="delBtn" class="removeBtn btn btn-danger" value="${favorite.id}">삭제</button></td> --%>
					
					<%-- (2) data를 이용해서 태그에 값를 임시 저장하기 --%>
					<td><button type="button" name="delBtn" class="removeBtn btn btn-danger" data-favorite-id="${favorite.id}">삭제</button></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
	<script>
		$(document).ready(function (){
			// (1) value에 원하는 값을 담아 놓는다.
/* 			$('td').on('click', 'button[name=delBtn]', function(e){ // 아래와 같은 방식
				// alert("삭제 버튼 클릭");
				// alert($(this).val());
				alert(e.target.value);
			}); */
			
			// (2) data를 이용해서 태그에 값를 임시 저장하기
			// 태그 : 태그 안에 data-favorite-id 같은 형식으로(data-뒤부터는 우리가 이름을 정한다, 대문자 사용 금지)
 			$('.removeBtn').on('click', function(){ 
				//alert("삭제 버튼 클릭");
				let favoriteId = $(this).data('favorite-id');
				// alert(favoriteId);
				
				$.ajax({
					type:'post'
					, url:'/lesson06/quiz01/delete_favorite'
					, data: {'favorite_id':favoriteId}
					, success: function(data) {
						// json : 성공 : {"result":"success"}    실패: {"result": "fail"}
						if (data.result == 'success') {
							//alert("성공");
							location.reload(); // 새로고침
						} else {
							alert("삭제가 실패했습니다.");
						}
					}, error: function(e) {
						alert("error:" + e);
					} 
				});
			}); 
		});
	</script>
</body>
</html>