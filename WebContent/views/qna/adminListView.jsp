<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.qna.model.vo.*" %>
<%
	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
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
		margin-top:2.5px;
		border-collapse: collapse;
	}
	td{border-bottom: 1px solid gray;}
	.listArea>tbody{
		font-size:15px;
	}
	.listArea>tbody td{
		height:50px;
		text-align:center;
	}
	.listArea>tbody>tr:hover{
		cursor:pointer;
	}
	.pagingArea>button{
		width:30px;
		height:30px;
		text-weight:bold;
	}
</style>
</head>
<body>
	<%@ include file="../common/adminMenubar.jsp" %>
	<div class="outer">
		<h2 align="left">1:1문의</h2>
		<div align="right">
			<button id="allBtn" onclick="replyAll();" type="button" style="border-radius:5px;">전체 보기</button>
			<button id="noBtn" onclick="replyNo();" type="button" style="border-radius:5px;">답변미완료 보기</button>
		</div>
		<table class="listArea">
			<thead>
				<th width="5%">번호</th>
				<th width="13%">구분</th>
				<th width="7%">종류</th>
				<th width="50%">제목</th>
				<th width="10">작성일</th>
				<th width="15%">답변여부</th>
			</thead>
			<tbody id="all">
				<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="6">조회된 리스트가 없습니다.</td>
				</tr>
				<% }else{ %>
					<% for(Qna q : list){ %>
					<tr>
						<td><%= q.getQnaNo() %></td>
						<td><%= q.getType() %></td>
						<td><%= q.getKind() %></td>
						<td><%= q.getTitle() %></td>
						<td><%= q.getRegDate() %></td>
						<td>
							<%if(q.getReplyStatus().equals("Y")) {%>
								답변완료
							<%} else{ %>
								답변미완료
							<%} %>
						</td>
					</tr>
					<% } %>
				<% } %>
			</tbody>
			
			<tbody id="no" style="display:none;">
				<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="6">조회된 리스트가 없습니다.</td>
				</tr>
				<% }else{ %>
					<% for(Qna q : list){ %>
						<%if(q.getReplyStatus().equals("N")) {%>
							<tr>
								<td><%= q.getQnaNo() %></td>
								<td><%= q.getType() %></td>
								<td><%= q.getKind() %></td>
								<td><%= q.getTitle() %></td>
								<td><%= q.getRegDate() %></td>
								<td>답변미완료</td>
							</tr>
						<%} %>
					<% } %>
				<% } %>
			</tbody>
			
			
		</table>
		
		<br>
		
		<div class="pagingArea" align="center">
			<button onclick="location.href='<%= request.getContextPath()%>/adminList.qa';"> &lt;&lt; </button>
			
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= request.getContextPath()%>/adminList.qa?currentPage=<%=currentPage-1%>';"> &lt; </button>
			<%} %>
			
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(currentPage == p){ %>
				<button disabled> <%=p%> </button>
				<%}else{ %>
				<button onclick="location.href='<%= request.getContextPath()%>/adminList.qa?currentPage=<%=p%>';"> <%= p %> </button>
				<%} %>
			
				
			<%} %>
			
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= request.getContextPath()%>/adminList.qa?currentPage=<%=currentPage+1%>';"> &gt; </button>
			<%} %>
			
			<button onclick="location.href='<%= request.getContextPath()%>/adminList.qa?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div>
	</div>
	
	<script>
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				
				var qnaNo = $(this).children().eq(0).text();
				
				location.href="<%= request.getContextPath()%>/adminDetail.qa?qnaNo=" + qnaNo;
			});
		});
		
		function replyAll(){
			$("#all").css("display","");
			$("#allBtn").css("background","gray");	
			$("#no").css("display","none");
			$("#noBtn").css("background","white");
		}
		
		function replyNo(){
			$("#all").css("display","none");
			$("#allBtn").css("background","white");
			$("#no").css("display","");
			$("#noBtn").css("background","gray");
		}
	</script>
</body>
</html>