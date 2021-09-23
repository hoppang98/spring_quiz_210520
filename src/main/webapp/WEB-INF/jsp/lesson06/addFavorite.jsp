<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

 	 <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 	 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<title>즐겨찾기 추가하기</title>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		
		<div class="form-group">
			<label for="name">제목</label>
			<input type="text" id="name" class="form-control col-3">
		</div>
		
		<div class="form-group">
			<label for="url">URL 주소</label>
			
			<div class="form-inline">
				<input type="text" id="url" class="form-control col-10">
				<button type="button" id="checkDuplicateBtn" class="btn btn-info">중복확인</button>
			</div>
			<small id="isDuplicationText" class="text-danger d-none">중복된 url입니다.</small> <%-- d-none로 숨겨놨다가 중복이면 드러나게 --%>
			<small id="availableUrlText" class="text-success d-none">저장 가능한 url입니다.</small>
		</div>
		
		<button type="button" id="addBtn" class="btn btn-success btn-block">추가</button> <%-- btn-block은 행을 다 차지하게 늘린다. --%>
	</div>
	
	<script>
		$(document).ready(function() {
			// quiz02 - url중복확인
			$('#checkDuplicateBtn').on('click', function(){
				// alert("중복 확인 버튼 클릭");
				let url = $('#url').val().trim();
				if (url == ''){
					alert("검사할 url을 입력해주세요.");
					return;
				}
				
				$.ajax({
					type:'post'
					, url: '/lesson06/quiz01/check_duplication_url'
					, data: {'url':url}
					, success: function(data) {
						// 중복이라면 : {"isDuplication":true}
					 	if (data.isDuplication == true) {
					 		// 중복일때
					 		$('#isDuplicationText').removeClass('d-none');
					 		$('#availableUrlText').addClass('d-none');
					 	} else {
					 		// 사용가능
					 		$('#isDuplicationText').addClass('d-none');
					 		$('#availableUrlText').removeClass('d-none');
					 	}
					}, error: function(e) {
						alert("error:" + e);
					}
				});
			});
			
			
			$('#addBtn').on('click', function() {
				//alert("추가 버튼 클릭");
				let name = $('#name').val().trim();
				let url = $("#url").val().trim();
				
				if(name == '') {
					alert("제목을 입력해주세요.");
					return;
				}
				
				if(url == '') {
					alert("URL을 입력해주세요.");
					return;
				}
				
				if (!url.startsWith('http') && url.startsWith('https') == false) { // 둘이 같은 뜻 (!랑 == false)
					alert("주소 형식이 잘못되었습니다.");
					return;
				}
				
				// 서버에 보내기 AJAX 통신
				$.ajax({
					type:'POST'
					, url: '/lesson06/quiz01/add_favorite'
					, data: {'name':name, 'url':url}
				
					, dataType: 'json' //response body - 없어도 상관없다(알아서 json인걸 판단함)
					, success: function(data) {
						// AJAX 통신 후 response body로 String 또는 JSON이 리턴되어야 한다.
						// alert(data.result); //data.key이름으로 데이터를 받아온다
						if (data.result == 'success') {
							location.href = "/lesson06/quiz01/favorite_list"; //이후 여기로 이동
						} else {
							alert("실패했습니다.");
						}
					}, error: function(e) {
						alert("에러:" + e);
					}
				});
			});
		});
	</script>
</body>
</html>