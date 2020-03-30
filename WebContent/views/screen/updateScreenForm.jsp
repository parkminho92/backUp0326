<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "com.kh.screen.model.vo.ScreenCBS , java.util.ArrayList"%>
    
    
 <%
 	ArrayList<ScreenCBS> list = (ArrayList<ScreenCBS>)request.getAttribute("list");
 	int theaterNo = (Integer)request.getAttribute("theaterNo");
 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.outer{
		width:1200px;
		height: 1000px;
		margin-left : 300px;
		margin-top : 50px;
	}
	
	.modal3{
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }
        
        .modal3-content{
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 30%; /* Could be more or less, depending on screen size */                          
        }
	
</style>
</head>


<body>
	
	<%@ include file="../common/adminMenubar.jsp" %>
	
	<div class="outer">
	
	<fieldset>
		<legend><h2>상영 영화정보 보기</h2></legend>
		
		<table border="1px solid">
			<tr>
				<td id="movieArea">
			<%for(ScreenCBS sc : list) {%>
					<input type="hidden" value="<%=sc.getMovieNo()%>">
					<button style="width:200px; height:50px; margin:20px"><%=sc.getTitle()%></button><br>
			<%} %>
				</td>
				
				<td id="screenInfoArea">
				
				</td>
			
			
			
		
		
		</table>
	
	</fieldset>
	
	</div>
	
	
	  <!-- The Modal -->
    <div id="myModal3" class="modal3">
 
      <!-- Modal content -->
      <div class="modal3-content">
      
      		<form action="<%=request.getContextPath()%>/realUpdateScreen.sc">
      	
      		<fieldset>
      		<legend><h2>상영 정보수정</h2></legend>
      		
      		<input type="text" name="movieNo" id="movieNo" value="">
      		<input type="text" name="screenDate" id="screenDate" value="">
      		<input type="number" name="screenNo" id="screenNo" value="">
      		<input type="hidden" name="theaterNo" value="theaterNo">
      		<input type="hidden" id="roomNo"name="roomNo" value="">
      		
      		
      	
      			
            <div style="background-color:lightgray;text-align: center; padding-bottom: 10px; padding-top: 10px;" >
            	<button>수정</button> <button type="button" onClick="close_pop3();">취소</button>
            </div>
            </fieldset>
       
      		</form>
      </div>
 
    </div>
	
	
	<script>
	
	 	function close_pop3(flag) {
	     	$('#myModal3').hide();
	 	}
	
		$(function(){
			
			$("#screenInfoArea").on("click","button",function(){
				
				var roomName = $(this).children().eq(0).text();
				$("#roomName").val(roomName);
				console.log(roomName);
				
				var screenDate = $(this).children().eq(1).text();
				$("#screenDate").val(screenDate);
				console.log(screenDate);
				
				var screenNo = $(this).prev().val();
				$("#screenNo").val(screenNo);
				
				
				console.log(screenNo);
			 	$("#myModal3").show();
			 	
				
				
			});
			
			
			
		});
	
	
	
	</script>
	
	
	
	<script>
		
	$(function(){
			
		var movieNo = "";
		
		$("#movieArea").on("click","button", function(){
			
			$("#screenInfoArea").children().remove();
			var movieNo = $(this).prev().val();
			$("#movieNo").val(movieNo);
			
			
			$.ajax({
				
				url:"<%=request.getContextPath()%>/callScreenInfo.sc",
				data:{movieNo:movieNo, theaterNo:<%=theaterNo%>},
				type:"get",
				success: function(result){
					
					for(var i=0;i<result.length;i++){
						
						$("#screenInfoArea").append("<input type='hidden' value='" + result[i].screenNo + "'><button style='width:200px; height:50px;margin:20px;'><div>"+ result[i].name +"</div><div>" + result[i].screenDate1 + "</div></button><br>");
						
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