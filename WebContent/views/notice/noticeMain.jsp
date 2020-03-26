<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		background:white;
		height:800px;
		width:1200px;
		margin:auto;
		margin-top:50px;
	}
	.topTitle{
		width:120px;
		height:30px;
		color:black;
		margin-left:50px;
		text-align:center;
		font-size:30px;
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
	#line {
		height:2px;
		background:#000;
		font-size:0;
		line-height:0;
		padding:0;
		margin:20px;
		width:1000px;
		}
		.mainArea{
			float:left;
			background:beige;
			width:260px;
			height:300px;
			margin:20px;
			margin-top:50px;
			border-radius:5px;
		}
	.mainArea > img{
		margin-left:100px;
		margin-top:30px;
	
	}
	.mainContent{
		color:black;
		font-size:25px;
		margin:auto;
		width:200px;
		align:center;
		
	}
	.btns{
		border-radius:10px;
		margin:auto;
		background:lightgray;
	    color: white;
	    text-align: center;
	    text-decoration: none;
	    display: inline-block;
	    font-size: 16px;
	    cursor: pointer;
	    width:140px;
	    height:50px;
	    
	}
	ul li{list-style: none;}
        #noticeMenu {position:absolute; width:250px; left:0; top:40px; }
        #noticeMenu h2{width:100%; height:100px; background:#9C0E0E; color:#fff; text-align: center; line-height:100px;}
        #noticeMenu ul {border-left:1px solid #ddd; border-right:1px solid #ddd;}
        #noticeMenu ul li{border-bottom:1px solid #ddd; padding:15px; box-sizing: border-box;}
        #noticeMenu ul li a{display:block; text-decoration:none; color:#616060; }
        #noticeMenu ul li a img{display:inline-block; vertical-align: middle; margin-right:15px;}
        #noticeMenu ul li a span{display:inline-block; vertical-align: middle;}
		#noticeMenu{margin-left:200px; margin-top:300px;}
		#mainArea1{margin-left:320px;}
	
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
	<br clear="both"><br><br><br>
		<div class="topTitle">고객센터</div><div id="line"></div>
		<hr width="500px" color="gray">
		
	    <div class="container">
        <div id="noticeMenu">
            <h2>고객센터</h2>
            <ul>
                <li><a href=""><img src="resources/images/req1.png" alt=""><span>1:1문의</span></a></li>
                <li><a href=""><img src="resources/images/req2.png" alt="">FAQ</a></li>
                <li><a href=""><img src="resources/images/req3.png" alt="">공지사항</a></li>
                <li><a href=""><img src="resources/images/req4.png" alt="">분실물찾기</a></li>
                <li><a href=""><img src="resources/images/req5.png" alt="">대관문의</a></li>
            </ul>
        </div>
        
	<div class="mainArea" id="mainArea1">
	<img src="../../resources/images/zoom2.png" width="60px" height="60px" align="center"><br><br><br>
	<p class="mainContent" align="center">자주 찾는 질문</p>
	<br><br><br>
	<div align="center">
	<button type="button" class="btns">바로가기</button>
	</div>
	</div>
	
	<div class="mainArea"id="mainArea2">
	<img src="../../resources/images/msg.png" width="60px" height="60px" align="center"><br><br><br>
	<p class="mainContent" align="center"> E-mail 문의</p>
	<br><br><br>
	<div align="center">
	<button type="button" class="btns">문의하기</button>
	</div>
	</div>
	
	<div class="mainArea"id="mainArea3">
	<img src="../../resources/images/book.png" width="60px" height="60px" align="center"><br><br><br>
	<p class="mainContent" align="center">내 문의내역 확인</p>
	<br><br><br>
	<div align="center">
	<button type="button" class="btns">문의내역 조회</button>
	</div>
	</div>	
		
		
	</div>





</body>
</html>