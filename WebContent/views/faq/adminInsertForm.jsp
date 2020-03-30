<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width:75%;
		height:100%;
		float:left;
		margin:auto;
		margin-top:30px;
		margin-left:5%;
	}
	.outer>form>table{
		width:100%;
		height:100%;
	}
	.outer>form>table tr>th{
		border:0.5px solid black;
		height:50px;
	}
	.outer>form>table p{
		height:300px;
	}
	.content>td{
		text-align:center;
	}
	input{
		width:100%;
		height:100%;
	}
	.content{
		height:110%;
		margin-top:-16px;
	}
	select{
		width:100%;
		height:100%;
	}
	option{
		text-align:center;
	}
</style>
</head>
<body>
	<%@ include file="../common/adminMenubar.jsp" %>
	<div class="outer">
		<form action="<%= request.getContextPath()%>/adminInsert.fq" method="POST">
		<fieldset style="width:1200px;height:600px;">
			<legend><h2>FAQ 작성</h2></legend>
			<table style="border-collapse:collapse;width: 1100px;margin-left: 50px;margin-top:50px">
				<tr>
					<th width="10%" style="background:gray;height:50px;">글번호</th>
					<td width="20%" style="text-align:center;background:gray;"></td>
					<th width="30%" style="border:2px solid darkgray">구분</th>
					<td width="40%" class="content">
						<select name="type" style="height:50px;">
						    <option value="구분">구분선택</option>
						    <option value="예매">예매</option>
						    <option value="영화관이용">영화관이용</option>
						    <option value="홈페이지">홈페이지</option>
						    <option value="VIP관련">VIP관련</option>
						    <option value="특별관">특별관</option>
						</select>
					</td>
				</tr>
				<tr>
					<th style="height:50px;border-bottom:2px solid darkgray">제목</th>
					<td colspan="3"><input type="text" name="question" style="height:50px"></td>
				</tr>
				<tr>
					<th style="border-bottom:2px solid darkgray">내용</th>
					<td colspan="4">
						<p><input type="text" name="answer" class="content" style="height: 300px;margin:0;"></p>
						
					</td>
				</tr>
			</table>
			<br>
			<div class="btns" align="center">
				<button id="submit" type="submit" style="width:64px;height:34px;border-radius:5px;">등록</button>
				<button id="cancle" type="button" style="width:64px;height:34px;border-radius:5px;">취소</button>
			</div>
			</fieldset>
		</form>
	</div>
	
	<script>
		$(document).ready(function(){
			$('#submit').click(function(){
				var result = confirm("faq를 등록 하시겠습니까?");
				
				if(result){
					alert("등록이 완료되었습니다.");
					location.replace("adminList.fq");
					location.href='<%= request.getContextPath()%>/adminInsert.fq';
				}else{
					alert("등록이 취소되었습니다.");
				}
			})
			$('#cancle').click(function(){
				var result = confirm("공지사항을 등록을 취소 하시겠습니까?");
				
				if(result){
					location.replace("adminList.fq");
				}else{

				}
			})
		})
	</script>
</body>
</html>