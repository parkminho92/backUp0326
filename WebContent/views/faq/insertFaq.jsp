<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>
	body, html{
		background-color:white !important;
		
	}
	#noticeList{
		width:1100px;
		height:600px;
		color:black !important;
		margin-right:200px;
		margin-top:100px;
		float:right;
		background-color:white;
		border-radius:10px;
		
	}
	
	#headNo{
		width:150px;
		height:30px;
		text-align:center;
		margin-right:auto;
		margin-left:auto;
		border-radius:5px;
		background-color:#e83a4e;
		color:white;
		margin-bottom:60px;
	}
	thead>tr>th{
		border-radius:5px;
		background-color:#ffb5b5;
		color:white;
		margin-left:10px;
	}
	#listArea{
		
		float:left;
		margin-top: 200px;
		margin-left:100px;
		width:200px;
		height:350px;
		color:white;
		border-radius:10px;
		background-color:white;
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
	.list:hover{
		cursor:pointer;
		text-decoration:underline;
		background-color:lightgray;
		color:black;
	}
	.outer{
		background:black;
		color:white;
		width:800px;
		height:500px;
		margin:auto;
		margin-top:50px;
	}
	#insertForm>table{
	border:1px solid white;
	}
	#insertForm>table input{
		width:100%;
		box-sizing:border-box;
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
		<h2 align="center"><div id="headNo">FAQ</div></h2>
		<br>
		
		<br>
		<h2 align="center">문의내용</h2>
		
		<form id="insertForm">
			<table align="center">
				<tr>
					<td>제목</td>
					<td colspan="3"><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer" readonly></td>
					<td>작성일</td>
					<td><input type="date" name="date"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="content" cols="60" rows="15" style="resize:none"></textarea>
					</td>
				</tr>
			</table>
			<br>
			<div class="btns" align="center">
				<button type="submit">등록하기</button>
			</div>
		</form>
	</div>
	
	
		
</body>
</html>