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
		<form action="<%= request.getContextPath()%>/adminInsert.no" method="POST">
		<fieldset style="width:1200px;height:700px;">
			<legend><h2>공지사항 작성</h2></legend>
			<table style="border-collapse:collapse;width: 1100px;margin-left: 50px;margin-top:50px">
				<tr style="border-bottom:2px solid darkgray;">
					<th width="10%" style="background:gray;height:50px;">글번호</th>
					<th width="40%" style="border-top:2px solid darkgray;">구분</th>
					<th width="40%" style="background:gray;border-right:2px solid darkgray;">작성 날짜</th>
					<th width="10%" style="background:gray;">조회수</th>
				</tr>
				<tr class="content">
					<td style="background:gray;"></td>
					<td>
						<select name="noticeType" style="height:32px">
						    <option value="구분">구분선택</option>
						    <option value="전체">전체</option>
						    <option value="영화관">영화관</option>
						    <option value="시스템점검">시스템점검</option>
						    <option value="기타">기타</option>
						</select>
					</td>
					<td style="background:gray;border-right:2px solid darkgray;"></td>
					<td style="background:gray;"></td>
				</tr>
				<tr>
					<th style="height:50px;">제목</th>
					<td colspan="3" style="height:50px"><input type="text" name="noticeTitle"></td>
				</tr>
				<tr>
					<th style="border-bottom:2px solid darkgray;border-top:2px solid darkgray;">내용</th>
					<td colspan="4">
						<p><input type="text" name="noticeContent" class="content" style="height: 300px;margin:0;"></p>
						
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
				var result = confirm("공지사항을 등록 하시겠습니까?");
				
				if(result){
					alert("등록이 완료되었습니다.");
					location.replace("adminList.no");
					location.href='<%= request.getContextPath()%>/adminInsert.no';
				}else{
					alert("등록이 취소되었습니다.");
				}
			})
			$('#cancle').click(function(){
				var result = confirm("공지사항을 등록을 취소 하시겠습니까?");
				
				if(result){
					location.replace("adminList.no");
				}else{

				}
			})
		})
	</script>
</body>
</html>