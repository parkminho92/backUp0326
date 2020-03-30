<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.*" %>
<%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
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
	button:hover{cursor:pointer;}
</style>
</head>
<body>
	<%@ include file="../common/adminMenubar.jsp" %>
	<div class="outer">
		<h2 align="left">회원 관리</h2>
		<div align="right">
			<button id="allBtn" onclick="show();" type="button" style="border-radius:5px;">전체 회원 보기</button>
			<button id="yesBtn" onclick="yes();" type="button" style="border-radius:5px;">가입중인 회원 보기</button>
			<button id="noBtn" onclick="no();" type="button" style="border-radius:5px;">탈퇴한 회원 보기</button>
			<button id="blackBtn" onclick="black();" type="button" style="border-radius:5px;">블랙리스트 회원 보기</button>
		</div>
		<table class="listArea">
			<thead>
				<th>회원번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>회원등급</th>
				<th>성별</th>
				<th>회원가입일</th>
				<th>탈퇴여부</th>
			</thead>
			<tbody id="all">
				<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="7">조회된 리스트가 없습니다.</td>
				</tr>
				<% }else{ %>
					<% for(Member m : list){ %>
					<tr>
						<td><%= m.getMemberNo() %></td>
						<td><%= m.getId() %></td>
						<td><%= m.getName() %></td>
						<td>
							<%switch(m.getGrade()){ 
								case "N":%>Normal<%break;
								case "B":%>Bronze<%break;
								case "S":%>Silver<%break;
								case "G":%>Gold<%break;
								case "P":%>Platinum<%break;
								default:%>Non-Grade<%break;
							} %>
						</td>
						<td>
							<%if(m.getGender().equals("M"))	{ %>
								남성
							<%}else{ %>
								여성
							<%} %>
						</td>
						<td><%= m.getSignupDate() %></td>
						<td>
							<%if(m.getStatus().equals("N")) {%>
								가입중
							<%} else{ %>
								탈퇴함
							<%} %>
						</td>
					</tr>
					<% } %>
				<% } %>
			</tbody>
			<tbody id="yes" style="display:none;">
				<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="7">조회된 리스트가 없습니다.</td>
				</tr>
				<% }else{ %>
					<% for(Member m : list){ %>
						<%if(m.getStatus().equals("N")) {%>
							<tr>
								<td><%= m.getMemberNo() %></td>
								<td><%= m.getId() %></td>
								<td><%= m.getName() %></td>
								<td>
									<%switch(m.getGrade()){ 
										case "N":%>Normal<%break;
										case "B":%>Bronze<%break;
										case "S":%>Silver<%break;
										case "G":%>Gold<%break;
										case "P":%>Platinum<%break;
										default:%>Non-Grade<%break;
									} %>
								</td>
								<td>
									<%if(m.getGender().equals("M"))	{ %>
										남성
									<%}else{ %>
										여성
									<%} %>
								</td>
								<td><%= m.getSignupDate() %></td>
								<td>가입중</td>
							</tr>
						<%} %>
					<% } %>
				<% } %>
			</tbody>
			
			<tbody id="no" style="display:none;">
				<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="7">조회된 리스트가 없습니다.</td>
				</tr>
				<% }else{ %>
					<% for(Member m : list){ %>
						<%if(m.getStatus().equals("Y")) {%>
							<tr>
								<td><%= m.getMemberNo() %></td>
								<td><%= m.getId() %></td>
								<td><%= m.getName() %></td>
								<td>
									<%switch(m.getGrade()){ 
										case "N":%>Normal<%break;
										case "B":%>Bronze<%break;
										case "S":%>Silver<%break;
										case "G":%>Gold<%break;
										case "P":%>Platinum<%break;
										default:%>Non-Grade<%break;
									} %>
								</td>
								<td>
									<%if(m.getGender().equals("M"))	{ %>
										남성
									<%}else{ %>
										여성
									<%} %>
								</td>
								<td><%= m.getSignupDate() %></td>
								<td>탈퇴함</td>
							</tr>
						<%} %>
					<% } %>
				<% } %>
			</tbody>
			
			<tbody id="black" style="display:none;">
				<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="7">조회된 리스트가 없습니다.</td>
				</tr>
				<% }else{ %>
					<% for(Member m : list){ %>
						<%if(m.getBlackStatus().equals("Y")) {%>
							<tr>
								<td><%= m.getMemberNo() %></td>
								<td><%= m.getId() %></td>
								<td><%= m.getName() %></td>
								<td>
									<%switch(m.getGrade()){ 
										case "N":%>Normal<%break;
										case "B":%>Bronze<%break;
										case "S":%>Silver<%break;
										case "G":%>Gold<%break;
										case "P":%>Platinum<%break;
										default:%>Non-Grade<%break;
									} %>
								</td>
								<td>
									<%if(m.getGender().equals("M"))	{ %>
										남성
									<%}else{ %>
										여성
									<%} %>
								</td>
								<td><%= m.getSignupDate() %></td>
								<td>
									<%if(m.getStatus().equals("N")) {%>
										가입중
									<%} else{ %>
										탈퇴함
									<%} %>
								</td>
							</tr>
						<%} %>
					<% } %>
				<% } %>
			</tbody>
			
			
		</table>
		
		<br>
		
		<div class="pagingArea" align="center">
			<button onclick="location.href='<%= request.getContextPath()%>/adminList.me';"> &lt;&lt; </button>
			
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= request.getContextPath()%>/adminList.me?currentPage=<%=currentPage-1%>';"> &lt; </button>
			<%} %>
			
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(currentPage == p){ %>
				<button disabled> <%=p%> </button>
				<%}else{ %>
				<button onclick="location.href='<%= request.getContextPath()%>/adminList.me?currentPage=<%=p%>';"> <%= p %> </button>
				<%} %>
			
				
			<%} %>
			
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= request.getContextPath()%>/adminList.me?currentPage=<%=currentPage+1%>';"> &gt; </button>
			<%} %>
			
			<button onclick="location.href='<%= request.getContextPath()%>/adminList.me?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div>
	</div>
	
	<script>
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				
				var memberNo = $(this).children().eq(0).text();
				
				location.href="<%= request.getContextPath()%>/adminDetail.me?memberNo=" + memberNo;
			});
		});
		
		function show(){
			$("#all").css("display","");
			$("#allBtn").css("background","gray");
			$("#yes").css("display","none");
			$("#yesBtn").css("background","white");
			$("#no").css("display","none");
			$("#noBtn").css("background","white");
			$("#black").css("display","none");
			$("#blackBtn").css("background","white");
		}
		
		function yes(){
			$("#all").css("display","none");
			$("#allBtn").css("background","white");
			$("#yes").css("display","");
			$("#yesBtn").css("background","gray");
			$("#no").css("display","none");
			$("#noBtn").css("background","white");
			$("#black").css("display","none");
			$("#blackBtn").css("background","white");
		}
		
		function no(){
			$("#all").css("display","none");
			$("#allBtn").css("background","white");
			$("#yes").css("display","none");
			$("#yesBtn").css("background","white");
			$("#no").css("display","");
			$("#noBtn").css("background","gray");
			$("#black").css("display","none");
			$("#blackBtn").css("background","white");
		}
		function black(){
			$("#all").css("display","none");
			$("#allBtn").css("background","white");
			$("#yes").css("display","none");
			$("#yesBtn").css("background","white");
			$("#no").css("display","none");
			$("#noBtn").css("background","white");
			$("#black").css("display","");
			$("#blackBtn").css("background","gray");
		}
	</script>
</body>
</html>