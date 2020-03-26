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
	
	#tableA{
		width:100%;
	}
	
	.title{
		width:200px;
	}


	#genre{
		border: 1px solid;
	}
	
	#tableA tr{
		height:50px;
	}
	
	#tableA input[type=file]{
		width:100px;
	}
	
	#genre td{
	
	width:130px;
	height:40px;
		
	
	}


	}


</style>

</head>
<body>
	


<%@ include file="../common/adminMenubar.jsp" %>

	<script>
	
	$(function(){
		var msg = "<%=msg%>";
		
		if(msg == "영화등록 실패 했습니다."){
			
			alert(msg);
			
			
		}
	});
	</script>


	<div class="outer">
<form action="<%=request.getContextPath()%>/insertMovie.mv" method="post" enctype="multipart/form-data">
	
	<fieldset>
	<legend><h2>새 영화 등록</h2></legend>
	<br>
	
		<div id="fileArea">
			<input type="file" name="file1" id="file1" required onchange="loadImg(this,1);">
			<input type="file" name="file2" id="file2" required onchange="loadImg(this,2);">
			<input type="file" name="file3" id="file3" required onchange="loadImg(this,3);">
			<input type="file" name="file4" id="file4" required onchange="loadImg(this,4);">
			<input type="file" name="file5" id="file5" required onchange="loadImg(this,5);">
		</div>
		
		<script>
			$(function(){
				
				$("#fileArea").hide();
				
				$("#mainPoster").click(function(){
					$("#file1").click();
				});
				
				$("#stillCut1").click(function(){
					$("#file2").click();
				});
				
				$("#stillCut2").click(function(){
					$("#file3").click();
				});
				
				$("#stillCut3").click(function(){
					$("#file4").click();
				});
				
				$("#stillCut4").click(function(){
					$("#file5").click();
				});
				
			});
				
				function loadImg(inputFile,num){
					
					if(inputFile.files.length ==1){
						
						var reader = new FileReader();
						
						reader.readAsDataURL(inputFile.files[0]);
						
						reader.onload = function(e){
							
							switch(num){
							case 1 : $("#mainPoster").attr("src",e.target.result); break;
							case 2 : $("#stillCut1").attr("src",e.target.result); break;
							case 3 : $("#stillCut2").attr("src",e.target.result); break;
							case 4 : $("#stillCut3").attr("src",e.target.result); break;
							case 5 : $("#stillCut4").attr("src",e.target.result); break;
							
							}
							
							
						}
						

				}
				
				
			}
			
			
		
		
		</script>
		
	<table id="tableA">
	
		<tr>
			<th>포스터 등록</th>
			<td><img id="mainPoster" width="150" height="120"></td>
			<td><img id="stillCut1" width="150" height="120"></td>
			<td><img id="stillCut2" width="150" height="120"></td>
			<td><img id="stillCut3" width="150" height="120"></td>
			<td><img id="stillCut4" width="150" height="120"></td>
		
		</tr>
		
	
		<tr>
			<th class="title">영화 제목</th>
			<td colspan="5"><input type="text" name="title" required size="100px"></td>
		</tr>
		
		<tr>
			<th class="title">감독</th>
			<td colspan="5"><input type="text" name="director" required></td>
		</tr>
		
		<tr>
			<th  class="title">출연진</th>
			<td colspan="5"><input type="text" name="actor" required size="100px"></td>
		</tr>
		
		<tr>
			<th  class="title">개봉 예정일</th>
			<td colspan="5"><input type="date" name="onDate" required></td>
		</tr>
		
		<tr>
			<th class="title">상영 시간</th>
			<td colspan="5"><input type="number" name="runtime" required></td>
		</tr>
		
		<tr>
			<th class="title">관람 연령</th>
			<td colspan="5">
			<select name="ageLimit" required>
				<option value=0>전체이용가</option>
				<option value=12>12세이상</option>
				<option value=15>15세이상</option>
				<option value=18>18세이상</option>
			</select>
			</td>
		</tr>
		
		<tr>
			<th class="title">줄거리</th>
			<td colspan="5">
				<textarea cols="100" rows="20"style="resize:none" name="synopsis" required></textarea>
			</td>
		</tr>
		
		<tr>
			<th class="title">장르</th>
			<td colspan="5">
				<table id="genre">
				<tr>
					<td><input type="checkbox" name="genre" value="1">스포츠</td>
					<td><input type="checkbox" name="genre" value="2">범죄</td>
					<td><input type="checkbox" name="genre" value="3">드라마</td>
					<td><input type="checkbox" name="genre" value="4">다큐멘터리</td>
				</tr>
				
				<tr>
					<td><input type="checkbox" name="genre" value="5">코미디</td>
					<td><input type="checkbox" name="genre" value="6">스릴러</td>
					<td><input type="checkbox" name="genre" value="7">전쟁</td>
					<td><input type="checkbox" name="genre" value="8">애니메이션</td>
				</tr>
				
				<tr>
					<td><input type="checkbox" name="genre" value="9">가족</td>
					<td><input type="checkbox" name="genre" value="10">판타지</td>
					<td><input type="checkbox" name="genre" value="11">액션</td>
					<td><input type="checkbox" name="genre" value="12">SF</td>
				</tr>
				
				<tr>
					<td><input type="checkbox" name="genre" value="13">로맨스/멜로</td>
					<td><input type="checkbox" name="genre" value="14">로맨스/코미디</td>
					<td colspan="2"></td>
				</tr>
				
				
				</table>
			
			</td>
		</tr>
		
	</table>
	
	<div align="center"><button type="submit" onclick="return genreValidate();">등록</button></div>
	
	</fieldset>
	
</form>
	</div>

	<script>
	
		function genreValidate(){
			var genre = $('input[name="genre"]:checked').length;
			
			if(genre>0){
				
				return true;
				
			}else{
				
				alert("장르를 하나 이상 선택해주세요.");
				return false;
			}
		}
			
		
		
	
	</script>
	


</body>
</html>