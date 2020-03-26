<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.borrow_room.model.vo.BorrowRoom" %>    
<%
	BorrowRoom b = (BorrowRoom)request.getAttribute("b");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	  *{margin:0; padding:0;}
        .layout{ position: relative; margin:0 auto; width: 1200px; }
        ul li{list-style: none;}
        #noticeMenu {position:absolute; width:250px; left:0; top:40px; }
        #noticeMenu h2{width:100%; height:100px; background:#9C0E0E; color:#fff; text-align: center; line-height:100px;}
        #noticeMenu ul {border-left:1px solid #ddd; border-right:1px solid #ddd;}
        #noticeMenu ul li{border-bottom:1px solid #ddd; padding:15px; box-sizing: border-box;}
        #noticeMenu ul li a{display:block; text-decoration:none; color:#616060; }
        #noticeMenu ul li a img{display:inline-block; vertical-align: middle; margin-right:15px;}
        #noticeMenu ul li a span{display:inline-block; vertical-align: middle;}


        #noticeContent { padding-left:270px; padding-top:40px; }
        #noticeContent>p { font-size: 30px; font-weight: 800;}
        #noticeContent table{ text-align: center; font-weight: 800; margin-bottom: 50px; margin:15px auto;}
        #noticeContent table tr td {width: 400px; height: 35px;}
        #noticeContent table tr td>input:nth-child(1) {text-align: center;}
        #noticeContent table tr td>input:nth-child(2){ width:300px; height: 50px; box-sizing: border-box;}
        #noticeContent table tr td #searchBtn {width: 50px; height: 50px; background:#9C0E0E; border:0; cursor:pointer; display: inline-block; vertical-align: bottom;}
        #noticeContent table tr td #requestBtn {width: 100px; height: 30px;}
    
    .layout{color:black;}
    
    #noticeContent p, #noticeContent h1{color:black;}
    .outer{
   		margin-top:100px;
		color:black;
		color:black;
		height:800px;
	}
	#headNo{
		font-weight:bold;
		font-size:30px;
		text-decoration:underline;
		width:200px;
		height:100px;
		color:black;
		margin-left:250px;
	}
	.broomDetailTable{
		color:black;
		margin-left:400px;
	}
	.broomDetailTable tr th{
		color:black; 
		border:1px solid black;
		padding:10px;}
    
    
</style>
</head>
<body>
	
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="layout">

    <div class="container">
        <div id="noticeMenu">
            <h2>고객센터</h2>
            <ul>
                <li><a href=""><img src="<%=contextPath %>/resources/images/req1.png" alt=""><span>1:1문의</span></a></li>
                <li><a href=""><img src="<%=contextPath %>/resources/images/req2.png" alt="">FAQ</a></li>
                <li><a href=""><img src="<%=contextPath %>/resources/images/req3.png" alt="">공지사항</a></li>
                <li><a href=""><img src="<%=contextPath %>/resources/images/req4.png" alt="">분실물찾기</a></li>
                <li><a href=""><img src="<%=contextPath %>/resources/images/req5.png" alt="">대관문의</a></li>
            </ul>
        </div>
        
       <div class="outer" id="broomDetailView">
			<br>
			<h2 align="center"><div id="headNo">분실물찾기</div></h2>
			<br>
			
			<table class="broomDetailTable">
				<tr>
					<th>제목</th>
					<th colspan="5" width="300"><%=b.getTitle() %></th>
				
				</tr>
				<tr>
					<th>이메일주소</th>
					<th width="100"><%=b.getEmail() %></th>
					<th>작성자</th>
					<th width="100">작성자아이디</th>
					<th>글번호</th>
					<th width="30"><%=b.getBorrowRoomNo() %></th>
				</tr>
				<tr>
					<th>답변유무</th>
					<th width="30"><%=b.getReplyStatus() %></th>
					<th>비밀유무</th>
					<th width="30"><%=b.getSecretStatus() %></th>
					<th>대관희망날짜</th>
					<th width="50"><%=b.getHopeDate() %></th>
				</tr>
				<tr>
					<th colspan="6">희망인원</th>
				</tr>
				<tr>
					<th width="80">성인 :<%=b.getAdultCount() %></th>
					<th width="80">청소년 :<%=b.getYouthCount() %></th>
					<th width="80">시니어 : <%=b.getSeniorCount() %></th>
					<th width="80">장애인 :<%=b.getDisabledCount() %></th>
					<th>작성일</th>
					<th width="80"><%=b.getRegiDate() %></th>
				</tr>
				<tr>
					<th colspan="6" height="400">
						<%=b.getContent() %>
					</th>
				</tr>
				
			</table>
		
			
		</div>
	</div>
</div>

</body>
</html>