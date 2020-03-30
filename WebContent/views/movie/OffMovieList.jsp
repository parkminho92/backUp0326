<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.ArrayList, com.kh.movie.model.vo.*" %>
    
<%

	String msg = (String)session.getAttribute("msg");
	
	ArrayList<MovieCBS> list = (ArrayList<MovieCBS>)request.getAttribute("list");

	PageInfo pi = (PageInfo)request.getAttribute("pi");

	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.outer{
		width:1200px;
		height: 800px;
		margin-left : 300px;
		margin-top : 50px;
	}
	
	#list{
		width:100%;
	
	}
	
	.title{
		text-align:center;
		font-weight:bold;
	}
	
	#list tr td{
	text-align:center;
	width:200px;
		
	}
	
	.pagingArea>button{
		border-radius:7px;
	}
	tbody tr:hover{
		opacity:0.5;
		cursor:pointer;
	}
	
	tbody tr td{
		text-align:center;
		width:200px;
	}
	
	thead{
		background:darkgray;
	}
	
	tbody{
		background:lightgray;
	}
	
	    .modal1{
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }
    
        /* Modal Content/Box */
        .modal1-content{
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 20%; /* Could be more or less, depending on screen size */                          
        }
        
         .modal2{
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }
    
        /* Modal Content/Box */
        .modal2-content{
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 20%; /* Could be more or less, depending on screen size */                          
        }
        
	

</style>
</head>
<body>

	<%@ include file="../common/adminMenubar.jsp" %>
	
	<script>
		$(function(){
		
		var msg = "<%=msg%>";
		
		if(msg != "null"){
			alert(msg);
	
		<% session.removeAttribute("msg");%>
		}
			
		});
	</script>
	
	
	
	<div class="outer">
		<fieldset>
		<legend><h2>지난 상영작</h2></legend>
		
		<table align="center" id="offMovieList">
			<thead>
				<tr>
					<th>영화번호</th>
					<th>영화제목</th>
					<th>상영시간</th>
					<th>관람연령</th>
					<th>개봉일</th>
				</tr>
			</thead>
		
			<tbody id="list">			
					<%if(list.isEmpty()){%>
				<tr>
					<td colspan="5"><h3>조회된 리스트가 없습니다.</h3></td>
				</tr>	
		
					<%}else{%>
				
					<%for(MovieCBS m : list) {%>
				
					<tr>
						<td><%=m.getMovieNo() %></td>
						<td><%=m.getTitle() %></td>
						<td><%=m.getRuntime()%> 분</td>
						<td><%=m.getAgeLimit()%>세 이상</td>
						<td><%=m.getOnDate() %></td>
					</tr>
				<%} %>
			
						<%} %>
			</tbody>
		
		</table>
		
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 (<<) -->
			<button onclick="location.href='<%=request.getContextPath()%>/listOffMovie.mv';"> &lt;&lt; </button>
			
			<!-- 이전페이지(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/listOffMovie.mv?currentPage=<%=currentPage-1%>';"> &lt; </button>
			<%} %>
			
			<!-- 페이지 목록 -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(currentPage == p){ %>
				<button disabled> <%=p%> </button>
				<%}else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/listOffMovie.mv?currentPage=<%=p%>';"> <%= p %> </button>
				<%} %>
			
				
			<%} %>
			
			<!-- 다음페이지(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/listOffMovie.mv?currentPage=<%=currentPage+1%>';"> &gt; </button>
			<%} %>
			
			
			<!-- 맨 마지막으로 (>>) -->
			<button onclick="location.href='<%=request.getContextPath()%>/listOffMovie.mv?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div>
		
		</fieldset>
	</div>
	
	<div id="myModal1" class="modal1">
	
		<div class="modal1-content">
		
		<fieldset>
			<legend><h2>지난 상영작 설정</h2></legend>
			
		
			<div id="modalFooter" style='background-color:lightgray; text-align: center; padding-bottom: 10px; padding-top: 10px;' align="center">
				<button id="rerunBtn">재상영</button> <button id="deleteBtn">영구삭제</button> <button id="cancelBtn1">취소</button>
			
			</div>
		</fieldset>
		
		
		</div>
	
	
	
	</div>
	
	<div id="myModal2" class="modal2">
	
		<div class="modal2-content">
		<form action="<%=request.getContextPath()%>/rerunMovie.mv" method="get">
		<fieldset>
			<legend><h2>재상영 여부</h2></legend>
			상영종료 날짜 입력 : <input type="date" name="rerunDate" required><br><br>
						   <input type="hidden" id="movieNo"name="movieNo" value="">
		
			<div id="modalFooter" style='background-color:lightgray; text-align: center; padding-bottom: 10px; padding-top: 10px;' align="center">
				<button>확인</button> <input type="button" id="cancelBtn2" value="취소">
			
			</div>
		</fieldset>
		</form>
		
		</div>
	
	
	
	</div>
	
	<script>
		$(function(){
			
			$("#list").on("click","tr",function(){
				var movieNo = $(this).children().eq(0).text();
				
				$("#movieNo").val(movieNo);
				
				$("#myModal1").show();
				});
			
			$("#modalFooter").on("click","#rerunBtn",function(){
					
				$("#myModal2").show();
				});
				
			$("#cancelBtn1").on("click",function(){
				$("#myModal1").hide();
				});
			
			$("#cancelBtn2").on("click",function(){
				$("#myModal1").hide();
				$("#myModal2").hide();
				});
			
			$("#deleteBtn").on("click", function(){
				
				if(confirm("정말로 삭제하시겠습니까?")){
					
					location.href="<%=request.getContextPath()%>/deleteMovie.mv?movieNo="+movieNo;
				}else{
					
					return;
				}
				
				});
	
			
		
		});
		
		
		
	
	</script>
	
	
	
	
	

</body>
</html>