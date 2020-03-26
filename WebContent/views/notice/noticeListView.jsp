<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.notice.model.vo.Notice" %>    
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
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
    
    .layout{
    	color:black;
    }
    #noticeContent p, #noticeContent h1{
    color:black;}
 
	#requestBtn{
		border:none;
		outline:none;
		background:beige;
		border-radius:5px;
	}
	
	.listArea tbody tr td, .listArea thead tr th{
		color:black;
	}
	.listArea{
		margin-top:50px;
		
	}
	#noticeList{
		margin-top:10px;
		display:inline-block;
		float:right;
		
	}
	#noticeList div{
	width:100px;
	height:30px;
	float:left;
	margin-left:40px;
	
	}
	#noticeList div:hover{cursor:pointer;}
	.noticeTitle{
		width:300px !important;
	}
	.noticeContentDetail{
	width:700px !important;
	height:200px !important;
	display:none;
	margin-left:40px;
	margin-top:50px;
	}

    </style>
    
    
   
    
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<br><br>


<div class="layout">

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
        
        <div id="noticeContent">
        <p>공지사항.</p>
        <br><br><br>
        	<table class="listArea" align="center">
			<thead>
				<tr>	
					<th width="80">번호</th>
					<th width="80">분류</th>
					<th width="500">제목</th>
					<th width="100">등록일</th>
					<th width="50">조회수</th>
				</tr>
			</thead>
		</table>
			
				<% if(list.isEmpty()){ %>
				<%} else{ %>
					<%for(Notice n:list) {%>
						<div id="noticeList">
							<div><%=n.getNoticeNo() %></div>
							<div><%=n.getNoticeType() %></div>
							<div class="noticeTitle"><%=n.getNoticeTitle() %></div>
							<div><%=n.getNoticeDate() %></div>
							<div><%=n.getReference() %></div>
							<div class="noticeContentDetail"><%=n.getNoticeContent() %></div>
						</div>
					<%} %>
				<%} %>
	
        </div>
        
        <script>
        	$(function(){
        		$(".noticeTitle").on("click",function(){
        			var p = $(this).parent().children().last();
        			
        			if(p.css("display") == "none"){
        				$(this).siblings(".noticeContentDetail").slideUp();
        				
        				p.slideDown();
        			}else{
        				p.slideUp();
        			}
        		});
        	});
        </script>
        
   </div>
</div>

		
</body>
</html>