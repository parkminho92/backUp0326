<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.kh.section.model.vo.*" %>    
    
<%


	ArrayList<SectionCBS> list = (ArrayList<SectionCBS>)request.getAttribute("section");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
	.outer{
			width:1200px;
			height: 1000px;
			margin-left : 300px;
			margin-top : 50px;
		}
		
	.line{
			background:lightgray;
			
	}
	
	#info{
		border-spacing: 30px;
		
	}
	
	button{
		border-radius: 10%;
	}
		
	
	
	
</style>	

<%@ include file = "../common/adminMenubar.jsp" %>


<div class="outer">
<fieldset>
<legend><h2>상영정보</h2></legend>
	<table id="info">
		<tr>
			<td id="sectionArea" class="line"> 
				<% for(SectionCBS s : list) {%>
				<input type="hidden" value="<%=s.getSectionNo()%>">
				<button class="sectionBtn" style="width:100px; height:50px;margin:20px;"><%=s.getName()%></button><br>
				
				<%} %>
			</td>
			
			<td id="theaterArea" class="line">
			
			</td>
			
			<td id="movieArea" class="line">
			
			</td>
			
			<td id="screenInfoArea" class="line">
			
			</td>
			
		</tr>
	</table>
</fieldset>
</div>



<script>

		$(function(){
			
			var sectionNo="";
			
			$("#sectionArea").on("click","button", function(){
				
				$("#theaterArea").children().remove();
				$("#movieArea").children().remove();
				$("#screenInfoArea").children().remove();
				
			var sectionNo = $(this).prev().val();
			
			$.ajax({
				
				url:"<%=request.getContextPath()%>/callTheater.ta",
				data:{sectionNo:sectionNo},
				type:"get",
				success: function(result){
					
					
					for(var i=0;i<result.length;i++){
						$("#theaterArea").append("<input type='hidden' value='" + result[i].theaterNo + "'><button class='theaterBtn' style='width:100px; height:50px;margin:20px;'>" + result[i].name + "</button><br>");
						
					}	
				},
				
				error: function(){
					console.log("ajax통신실패");
				}
				
				
			});
			
			
			
			});	
			
				var theaterNo = "";
		 	
			$("#theaterArea").on("click","button", function(){
				
				$("#movieArea").children().remove();
				$("#screenInfoArea").children().remove();
				
				var theaterNo = $(this).prev().val();
				$.ajax({
					url:"<%=request.getContextPath()%>/callMovie.mv",
					data:{theaterNo:theaterNo},
					type:"get",
					success: function(result){
						
						for(var i=0;i<result.length;i++){
							
							console.log(result[i].movieNo);
							
							$("#movieArea").append("<input type='hidden' value='"+ result[i].movieNo +"'><button class='movieInfoBtn' style='width:200px; height:50px;margin:20px;'>" + result[i].title + "</button><br>");
						}
					},
					error: function(){
						
						console.log("ajax 통신 실패");
					}
					
				});
				
				
			});
			
			var movieNo = "";
			
			$("#movieArea").on("click","button", function(){
				
				$("#screenInfoArea").children().remove();
				
				var movieNo = $(this).prev().val();
				
				$.ajax({
					url:"<%=request.getContextPath()%>/callScreenInfo.sc",
					data:{movieNo:movieNo},
					type:"get",
					success: function(result){
						
						for(var i=0;i<result.length;i++){
							
							$("#screenInfoArea").append("<button style='width:200px; height:50px;margin:20px;'>"+ result[i].name + "<br>" + result[i].screenDate1 + "</button><br>");
						}
					},
					
					error: function(){
						
						console.log("ajax 통신 실패");
					}
					
					
				});
				
				
			});
			
		
		});
			
			
		



</script>


</body>
</html>