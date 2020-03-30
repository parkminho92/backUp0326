<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import = "java.util.ArrayList, com.kh.theater.model.vo.*" %>
    
<%
ArrayList<TheaterCBS> list = (ArrayList<TheaterCBS>)request.getAttribute("list");

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
	
	.pagingArea>button{
		border-radius:7px;
	}
	thead tr th{
		width:300px;
	}
	
	.listArea>tbody tr:hover{
		opacity:0.5;
		cursor:pointer;
	}
	
	.listArea>tbody tr td{
		text-align:center;
		width:200px;
	}
	
	.listArea>thead{
		background:darkgray;
	}
	
	.listArea>tbody{
		background:lightgray;
	}
	
	

</style>

</head>
<body>

	<%@ include file ="../common/adminMenubar.jsp" %>
  
	<div class="outer">
		<fieldset>
		<legend><h2>영화관 목록</h2></legend>
		
		<table align="center" class="listArea">
		
		<thead>
			<tr>
				<th>영화관 번호</th>
				<th>영화관 이름</th>
				<th>상영관 수</th>
				<th>지역</th>
				
			</tr>
		</thead>
		
		
		<tbody>
			<%if(list.isEmpty()){ %>
			<tr>
				<td colspan="4"><h3>조회된 리스트가 없습니다.</h3></td>
			</tr>
			
			<%}else{ %>
			
			<%for(TheaterCBS t:list) {%>
			<tr>
				<td><%=t.getTheaterNo() %></td>
				<td><%=t.getName() %></td>
				<td><%=t.getRoomCount() %></td>
				<td><%=t.getSectionName() %></td>
			</tr>
			<%} %>
			<%} %>
		
		
		</tbody>
		
		</table>
		
		<script>
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				
				var theaterNo = $(this).children().eq(0).text();
				
				location.href="<%=request.getContextPath()%>/detail.ta?theaterNo=" + theaterNo;
			});
		});
		
		</script>
		
	
		
	
			
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 (<<) -->
			<button onclick="location.href='<%=request.getContextPath()%>/listTheater.ta';"> &lt;&lt; </button>
			
			<!-- 이전페이지(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/listTheater.ta?currentPage=<%=currentPage-1%>';"> &lt; </button>
			<%} %>
			
			<!-- 페이지 목록 -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(currentPage == p){ %>
				<button disabled> <%=p%> </button>
				<%}else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/listTheater.ta?currentPage=<%=p%>';"> <%= p %> </button>
				<%} %>
			
				
			<%} %>
			
			<!-- 다음페이지(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/listTheater.ta?currentPage=<%=currentPage+1%>';"> &gt; </button>
			<%} %>
			
			
			<!-- 맨 마지막으로 (>>) -->
			<button onclick="location.href='<%=request.getContextPath()%>/listTheater.ta?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div>
		
		
		
		
		</fieldset>
	
	
	
	</div>
	
	
	
	
	

</body>
</html>