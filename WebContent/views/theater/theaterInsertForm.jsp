<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	String msg = (String)request.getAttribute("msg");
 
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
	
	table{
		width:100%;
	}
	
	th{
		width:150px;
	}
	
	tr{
		height:50px;
	}
	
	


</style>
</head>
<body>

	<%@ include file="../common/adminMenubar.jsp" %>	
	
	<script>
	
	$(function(){
		
		var msg = "<%=msg%>";
		
		if(msg == "영화관 등록에 실패했습니다."){
			
			alert(msg);
		}
			
		
	});
	
	
	
	
	</script>
	
	
	<div class="outer">
	
	<form action="<%=request.getContextPath()%>/insertTheater.ta" method="post">
	
	<fieldset>
	<legend><h2>영화관등록</h2></legend>
	
	<table>
		<tr>
			<th>시/도</th>
			<td>
				<select name="sectionNo" required>
					<option>선택하세요</option>
					<option value="1">서울</option>
					<option value="2">경기/인천</option>
					<option value="3">충청</option>
					<option value="4">전라</option>
					<option value="5">경상</option>
					<option value="6">강원</option>
					<option value="7">제주</option>
			   	</select>						
			</td>
		</tr>
		
		<tr>
			<th>영화관 명</th>
			<td><input type="text" name="tName" required></td>
		</tr>
		
		<tr>
			<th>영화관 주소</th>
			<td><input type="text" name="tAddress" required size="100px"></td>
		</tr>
		
		<tr>
			<th>상영관 수</th>
			<td><input type="number" name="roomCount" required></td>
		</tr>
		
		<tr>
			<th>전화번호</th>
			<td><input type="tel" name="tel" required placeholder="-입력"></td>
		</tr>
	
	
		<tr>
			<th>주차 안내</th>
			<td><textarea rows="10" cols="50" style="resize:none" name="parkingInfo" required></textarea></td>
		</tr>
		
		<tr>
			<th>교통 안내</th>
			<td><textarea rows="10" cols="50" style="resize:none" name="transInfo" required></textarea></td>
		</tr>
		
		<tr>
			<th>경도</th>
			<td><input type="number" step=0.00001 name="longitude"></td>
		<tr>
		
		<tr>
			<th>위도</th>
			<td><input type="number" step=0.00001 name="latitude"></td>
		<tr>
		
		
		
		
	</table>
	
	<br>
	
	<div align="center">
	<button type="submit">등록</button> <button type="reset">초기화</button>
	</div>
	</fieldset>
	</form>
	</div>
	
</body>
</html>