<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.ArrayList, com.kh.movie.model.vo.*" %>
    
<%
	
	ArrayList<Movie> list = (ArrayList<Movie>)request.getAttribute("list");

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
	

</style>
</head>
<body>

	<%@ include file="../common/adminMenubar.jsp" %>
	
	
	<div class="outer">
		<fieldset>
		<legend><h2>지난 상영작</h2></legend>
		
		<table align="center">
			<thead>
				<tr>
					<th>영화번호</th>
					<th>영화제목</th>
					<th>상영시간</th>
					<th>관람연령</th>
					<th>개봉일</th>
				</tr>
			</thead>
		
			<tbody>			
					<%if(list.isEmpty()){%>
				<tr>
					<td colspan="5"><h3>조회된 리스트가 없습니다.</h3></td>
				</tr>	
		
					<%}else{%>
				
					<%for(Movie m : list) {%>
				
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
	
	

</body>
</html>