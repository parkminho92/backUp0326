<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.faq.model.vo.Faq" %>    
<%
	ArrayList<Faq> list = (ArrayList<Faq>)request.getAttribute("list");
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


        #faqContent { padding-left:270px; padding-top:40px; }
        #faqContent>p { font-size: 30px; font-weight: 800;}
        #faqContent table{ text-align: center; font-weight: 800; margin-bottom: 50px; margin:15px auto;}
        #faqContent table tr td {width: 400px; height: 35px;}
        #faqContent table tr td>input:nth-child(1) {text-align: center;}
        #faqContent table tr td>input:nth-child(2){ width:300px; height: 50px; box-sizing: border-box;}
        #faqContent table tr td #searchBtn {width: 50px; height: 50px; background:#9C0E0E; border:0; cursor:pointer; display: inline-block; vertical-align: bottom;}
        #faqContent table tr td #requestBtn {width: 100px; height: 30px;}
    
    .layout{
    	color:black;
    }
    #faqContent p, #faqContent h1{
    color:black;}
 
    .faqQusetion{
    	text-align:center;
    }
  
    .contentA{
    	display:none;
    	margin-left:200px;
    	height:150px;
    }
  
	#contentNo{
		width:50px;
		display:inline-block;
		margin-left:50px;
		
	}
	.contentQ{
		display:inline-block;
		margin-left:200px;
		height:50px;
		border-buttom:1px solid black;
		
	}
	
	#requestBtn{
		border:none;
		outline:none;
		background:beige;
		border-radius:5px;
	}
	.content tr th{color:black;}
	.contentQ:hover{cursor:pointer;}
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
        <div id="faqContent">
            <p>FAQ.</p>
            <br><hr>
            <table>
                <tr>
                    <td rowspan="2">
                        <button type="button" id="searchBtn"><img src="resources/images/search_ico.png" alt=""></button>
                        <input type="text" placeholder=" 검색어를 입력하십시오"/>
                    </td>
                    <td><p>더 궁금한 점이 있다면?</p></td>
                    
                </tr>
                <tr>
                    <td><button type="button" id="requestBtn">1:1문의</button></td>
                </tr>
            </table>
            <div id="contentTable">
            	<table class="content">
            	<thead>
            		<tr>	
            			<th width="50px">번호</th>
            			<th width="500px">제목</th>
            		</tr>
            	
            	</thead>
            	</table>
            	<hr>
            <% if(list.isEmpty()){ %>
            			<div></div>
            		<%} else {%>
            		 	<%for(Faq f : list){ %>
            		 	<div id="contentArea">
            		 		<div id="contentNo"><%=f.getFaqNo()%></div>
            		 		<div class="contentQ"><%=f.getQuestion() %></div>
            		 		<div class="contentA"><%=f.getAnswer() %></div>
            		 	</div>
            		 	<%} %>
            		 <%} %>
            </div>
 	
            
        </div>
        <script>
 				$(function(){
 					$(".contentQ").on("click",function(){
 						var p = $(this).next();
 						
 						if(p.css("display") == "none"){
 							
 							$(this).siblings(".contentA").slideUp();
 							
 							p.slideDown();
 						} else{
 							p.slideUp();
 						}
 					});
 				});
 			
 			
 			</script>
   </div>
</div>

		
</body>
</html>