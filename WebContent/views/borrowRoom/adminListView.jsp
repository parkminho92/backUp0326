<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.borrow_room.model.vo.*" %>
<%
	ArrayList<BorrowRoom> list = (ArrayList<BorrowRoom>)request.getAttribute("list");
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
		width:75%;
		height:100%;
		float:left;
		margin:auto;
		margin-top:30px;
		margin-left:5%;
	}
	.listArea{
		width:100%;
		border-top:2px solid gray;
	}
	.listArea>tbody{
		font-size:20px;
	}
	.listArea>tbody td{
		height:50px;
		text-align:center;
	}
	.listArea>tbody>tr:hover{
		cursor:pointer;
	}
</style>
</head>
<body>
	
	<%@ include file="../common/admin.jsp" %>
	<div class="outer">
		<h2 align="left">대관문의</h2>
		<table class="listArea">
			<thead>
				<th width="10%">글번호</th>
				<th width="70%">제목</th>
				<th width="20%"></th>
			</thead>
			<tbody>
				<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="3">조회된 리스트가 없습니다.</td>
				</tr>
				<% }else{ %>
					<% for(BorrowRoom b : list){ %>
					<tr>
						<td><%= b.getBorrowRoomNo() %></td>
						<td><%= b.getTitle() %></td>
						<td>
							
						</td>
					</tr>
					<% } %>
				<% } %>
			</tbody>
		</table>
		
		<br>
		
		<div class="pagingArea" align="center">
			<button onclick="location.href='<%=contextPath%>/adminList.br';"> &lt;&lt; </button>
			
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%=contextPath%>/adminList.br?currentPage=<%=currentPage-1%>';"> &lt; </button>
			<%} %>
			
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(currentPage == p){ %>
				<button disabled> <%=p%> </button>
				<%}else{ %>
				<button onclick="location.href='<%=contextPath%>/adminList.br?currentPage=<%=p%>';"> <%= p %> </button>
				<%} %>
			
				
			<%} %>
			
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else{ %>
			<button onclick="location.href='<%=contextPath%>/adminList.br?currentPage=<%=currentPage+1%>';"> &gt; </button>
			<%} %>
			
			<button onclick="location.href='<%=contextPath%>/adminList.br?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div>
	</div>
	
	<script>
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				
				var borrowNo = $(this).children().eq(0).text();
				
				location.href="<%=contextPath%>/adminDetail.br?borrowNo=" + borrowNo;
			});
		});
	</script>
</body>
</html>