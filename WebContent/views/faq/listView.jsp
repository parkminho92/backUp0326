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
	.first{
		width:100%;
		height:60px;
		border-bottom: 2px solid black;
	}
	.name{
		float:left;
		margin-left:20px;
	}
	.button{
		float:right;
		margin-top:20px;
		margin-right:20px;
	}
	.second{
		width:100%;
		height:60px;
		border-bottom: 2px solid black;
	}
	.number{
		float:left;
		margin-right:240px;
	}
	.title{
		float:left;
	}
	.alter{
		float:right;
		margin-top:16px;
		margin-right:20px;
	}
</style>
</head>
<body>

	<%@ include file="../common/admin.jsp" %>
	<div class=outer>
		<div class="first">
			<div class="name">
				<h3 align="left">FAQ</h3>
			</div>
			<div class="button">
				<button onclick="location.href='<%=contextPath%>/insertForm.fq';">등록</button>
			</div>
		</div>
		<div class="second">
			<div class="number">
				<p>번호</p>
			</div>
			<div class="title">
				<p>제목</p>
			</div>
			<div class="alter">
				<button onclick="location.href='<%=contextPath%>/insertForm.fq';">수정</button>
			</div>
		</div>
		<div class="third">
		</div>
		
	</div>
</body>
</html>