<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body, html{
		background-color:#EAEAEA !important;
		
	}
#listArea{
		
		float:left;
		margin-top: 200px;
		margin-left:100px;
		width:200px;
		height:350px;
		color:white;
		border-radius:10px;
	}
	.list{
		display:block;
		border-radius:10px;
		margin-top:30px;
		background-color:#e83a4e;
		width:150px;
		height:30px;
		text-align:center;
		vertical-align:middle;
		margin-left:auto;
		margin-right:auto;
		font-size:15px;
		font-family: 'Nanum Gothic', sans-serif;
		font-weight:bold;
	}
	.outer{
		margin-top:100px;
		color:black;
	
	}
	#headNo{
		font-weight:bold;
		font-size:30px;
		text-decoration:underline;
		width:200px;
		height:100px;
		float:left;
	}
	.insertForm{
		margin-top:100px;
		width:800px;
		height:1100px;
		float:left;
		font-size:30px;
		border:1px solid black;
	}
	#insertFormTable{
		padding:5px;
		margin-top:50px;
	}
	.insertForm table tbody tr td{
		color:black; 
		padding:10px;
	}
	
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	
	
	<div id="listArea">
		<div class="list">공지사항</div>
		<div class="list">FAQ</div>
		<div class="list">1:1문의</div>
		<div class="list">분실물찾기</div>
		<div class="list">대관문의</div>
	</div>


	<div class="outer" id="noticeList">
			<br>
			<h2 align="center"><div id="headNo">분실물 찾기</div></h2>
			<br>
			<pre> 분실물을 등록해주시면 확인후 
 신속하게 답변드리겠습니다.</pre>
 
			<div class="insertForm">
			<form id="insertForm" method="post" action="<%=contextPath%>/insertLost.lo">
				<table align="center" id="insertFormTable">
					<tr>
						<td>이름</td>
						<td><input type="text" name="lName"></td>
					</tr>
					<tr>
						<td>휴대전화</td>
						<td><input type="phone" name="lPhone"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="email" name="lEmail"></td>
					</tr>
					<tr>
						<td>분실장소</td>
						<td><input type="text" name="lPlace"></td>
					</tr>
					<tr>
						<td>작성일</td>
						<td><input type="date" name="lDate"></td>
						
					</tr>
					<tr>
						<td>비밀글 등록</td>
						<td><input type="checkbox" value="Y" name="checkPwd" onclick="changeBox();"><a>비밀번호</a><input type="text" name="lSecretPwd"></td>
						
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="Title"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="3"></td>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="lContent" cols="100" rows="30" style="resize:none"></textarea>
						</td>
					</tr>
				</table>
				<br>
				<div class="btns" align="center">
					<button type="reset">취소하기</button>
					<button type="submit" onclick="insertLost();">등록하기</button>
				</div>
			</form>
			</div>
		</div>

	<script>
		function changeBox(){
			var checkbox = document.getElementsByName("checkPwd");
			var $check = checkbox[0];
			
			if($check.checked){
				$check.value = "Y";
			}esle{
				$check.value = "N";
			}
			console.log($check.value);
			
		};
	
	</script>


</body>
</html>