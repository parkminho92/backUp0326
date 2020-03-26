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
	.outer{
		width:75%;
		height:100%;
		float:left;
		margin:auto;
		margin-top:30px;
		margin-left:5%;
	}
</style>
</head>
<body>
	<%@ include file="../common/admin.jsp" %>
	<div class="outer">
		<table>
			<tr>
				<th>회원번호</th>
				<td colspan="4"><%=b.getMemberNo() %></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td colspan="4"><%=b.getEmail() %></td>
			</tr>
			<tr>
				<th>회원번호</th>
				<td>성인 : <%=b.getAdultCount() %></td>
				<td>청소년 : <%=b.getYouthCount() %></td>
				<td>노인 : <%=b.getSeniorCount() %></td>
				<td>장애인 : <%=b.getDisabledCount() %></td>
			</tr>
			<tr>
				<th>희망일자</th>
				<td colspan="4"><%=b.getHopeDate() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="4"><%=b.getTitle() %></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="4">
					<textarea readonly rows="3" cols="60" style="resize:none;" readonly>
					<%=b.getContent() %>
					</textarea>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>