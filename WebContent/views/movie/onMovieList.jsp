<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.ArrayList, com.kh.movie.model.vo.*" %>
    
<%
	
	ArrayList<MovieCBS> list = (ArrayList<MovieCBS>)request.getAttribute("list");

	PageInfo pi = (PageInfo)request.getAttribute("pi");

	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	
	for(int i=0;i<list.size();i++){
		
	if(list.get(i).getModifyName()==null){
		
		list.get(i).setModifyName("p_logo.png");
				
		}
	}
	


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
	#list tr td:hover{
		opacity:0.5;
		cursor:pointer;
	}
	
	.pagingArea>button{
		border-radius:7px;
	}
	
	
	

</style>
</head>
<body>
	
	<%@ include file="../common/adminMenubar.jsp" %>
	
	<div class="outer">
	
	<fieldset>
	<legend><h2>현재상영작</h2></legend>
	<table id="list">
	
		<%if(list.isEmpty()){%>
			<tr>
				<td colspan="5"><h3>조회된 리스트가 없습니다.</h3></td>
			</tr>	
		
		<%}else{%>
			
			<!--  -->
			<%if(list.size() <= 5){ %>
				<tr>
				<% for(int i=0;i<list.size();i++){ MovieCBS m = list.get(i);
				
				%>
				
					
					
					<td><img src="<%=request.getContextPath()%>/resources/poster_upfiles/<%=m.getModifyName() %>" width="200px" height="200px"><p class="title"><%=m.getTitle()%></p></td>
	
				<%} %>
				</tr>
				
			
			
			<%}else{ %>
				<tr>
				<% for(int i=0;i<5;i++){ MovieCBS m = list.get(i);%>
					
					<td><img src="<%=request.getContextPath()%>/resources/poster_upfiles/<%=m.getModifyName() %>" width="200px" height="200px"><p class="title"><%=m.getTitle()%></p></td>
	
				<%} %>
				</tr>
				
				<tr>
				<% for(int i=5;i<list.size();i++){ MovieCBS m = list.get(i);%>
					<td><img src="<%=request.getContextPath()%>/resources/poster_upfiles/<%=m.getModifyName() %>" width="200px" height="200px"><p class="title"><%=m.getTitle()%></p></td>
				<%} %>
				</tr>
			
			<%} %>
			
			
			
			
		<%} %>		
				
	</table>
	<br>
	<!-- 페이징바 영역 -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 (<<) -->
			<button onclick="location.href='<%=request.getContextPath()%>/listOnMovie.mv';"> &lt;&lt; </button>
			
			<!-- 이전페이지(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/listOnMovie.mv?currentPage=<%=currentPage-1%>';"> &lt; </button>
			<%} %>
			
			<!-- 페이지 목록 -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(currentPage == p){ %>
				<button disabled> <%=p%> </button>
				<%}else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/listOnMovie.mv?currentPage=<%=p%>';"> <%= p %> </button>
				<%} %>
			
				
			<%} %>
			
			<!-- 다음페이지(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/listOnMovie.mv?currentPage=<%=currentPage+1%>';"> &gt; </button>
			<%} %>
			
			
			<!-- 맨 마지막으로 (>>) -->
			<button onclick="location.href='<%=request.getContextPath()%>/listOnMovie.mv?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div>
	</div>
	</fieldset>
	
	</div>
	
</body>
</html>