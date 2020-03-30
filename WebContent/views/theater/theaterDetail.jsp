<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.kh.theater.model.vo.TheaterCBS, java.util.ArrayList, com.kh.room.model.vo.RoomCBS" %>
    
 <% 
 	String msg = (String)session.getAttribute("msg");
 	
 	TheaterCBS t = (TheaterCBS)request.getAttribute("t");
 
 	ArrayList<RoomCBS> r = (ArrayList<RoomCBS>)request.getAttribute("r");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<style>
.outer{
		width:1200px;
		height: 1000px;
		margin-left : 300px;
		margin-top : 50px;
	}
	
	tr th{
		background:darkgray;
		width:150px;
		height:50px;
	}
	    .modal1,.modal2{
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
    
        /* Modal Content/Box */
        .modal1-content, .modal2-content{
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 30%; /* Could be more or less, depending on screen size */                          
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
            width: 70%; /* Could be more or less, depending on screen size */                          
        }
        
         #modalMovieListTable {
         	width:100%;
         }
        
        #modalMovieListTable th{
        	width:50px;
        }
       
        #modalMovieListTable td{
        	background:lightgray;
        	cursor:pointer;
        }
        
        #modalMovieListTable tr{
        	height:30px;
        	
        }
        
        #modalMovieListTable td:hover{
        	opacity:0.5;
        }
        
        .area tr{
        	background:lightgray;
        }
	
</style>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1bbe01a2bfb5819cdbccd3e475fc5f3c"></script>
</head>

<body>


	<%@ include file="../common/adminMenubar.jsp" %>

<div class="outer">


<fieldset>
	<legend><h2>영화관상세정보</h2></legend>
	
	<table class="area">
		<tr>
			<th>영화관 이름</th>
			<td> <%=t.getName() %></td>
		</tr>
	
		<tr>
			<th>영화관 주소</th>
			<td> <%=t.getAddress() %></td>
		</tr>
	
		<tr>
			<th>영화관 전화번호</th>
			<td> <%=t.getPhone() %></td>
		</tr>
	
		<tr>
			<th>주차 안내</th>
			<td><textarea cols="125" rows="10" style="resize:none"><%=t.getParking() %></textarea></td>
		</tr>
	
		<tr>
			<th>교통안내</th>
			<td><textarea cols="125" rows="10" style="resize:none"><%=t.getTransport()%></textarea></td>
		</tr>
	
		<tr>
			<th>영화관 위치</th>
			<td><div id="map" style="width:500px;height:400px;"></div></td>
		</tr>

</table>
<br>
<div class="buttonBar" align="center"><button onclick="popModal1();">상영 등록</button> <button onclick="goUpdateScreen();">상영정보 수정</button> <button onclick="popModal3();">영화관 정보수정</button></div>

</fieldset>

</div>


<script>

	var theaterNo = <%=t.getTheaterNo()%>;  
		
	function goUpdateScreen(){
		
		location.href="<%=request.getContextPath()%>/updateScreen.sc?theaterNo="+theaterNo
	}


</script>



<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(<%=t.getLatitude()%>, <%=t.getLongitude()%>),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
		
	
</script>


	   <!-- The Modal -->
    <div id="myModal1" class="modal1">
 
      <!-- Modal content -->
      <div class="modal1-content">
      
      	<form action="insertScreen.sc" type="post">
		<input type="hidden" name ="theaterName" value="<%=t.getName()%>">
		<input type="hidden" name = "section" value="<%=t.getSectionName()%>">
		<input type="hidden" name = "movieNo" id="movieNo" value="">
      		<fieldset>
      		<legend><h2>상영 등록</h2></legend>
      		
      		
      		<table>	
      			
      			
      			<tr>
      				<th>지역</th>
      				<td><%=t.getSectionName()%><input type="hidden" name="sectionNo" value="<%=t.getSectionNo()%>"></td>
      			</tr>
      				
      			<tr>	
      				<th>영화관 이름</th>
      				<td><%=t.getName()%><input type="hidden" name="theaterNo" value="<%=t.getTheaterNo()%>"></td>
      			</tr>
      			
      			<tr>
      				<th>상영관 선택</th>
      				<td>
      				<select name = "roomNo">
      				<%for(RoomCBS ro : r) {%>
      					<option value="<%=ro.getRoomNo()%>"><%=ro.getName()%></option>
      					
      				<%} %>
      				</select>
      				</td>
      			</tr>
      			
      			<tr>
      				<th>영화 선택</th>
      				<td><input type="text" id="selectMovie" name="title" required> <button type="button" onclick="popModal2();"> 검색 </button></td>
      			</tr>
      			
      			<tr>
      				<th>날짜 선택</th>
      				<td><input type="date" required name="rDate"></td>
      			</tr>
      			
      			<tr id="sCount0">
      				<th>회차 선택</th>
      				<td><input type="number" name="sCount" id="sCount" required> <button type="button" onclick="selectTime();">확인</button></td>
      			</tr>
      			
      			
      			
      			
      		</table>
      			
      			<br>
            <div style="background-color:lightgray;text-align: center; padding-bottom: 10px; padding-top: 10px;" >
            	<button>등록</button> <button type="button" onClick="close_pop1();">취소</button>
            </div>
            </fieldset>
        </form>
      </div>
 
    </div>
    
    
    
	   <!-- The Modal -->
    <div id="myModal3" class="modal3">
 
      <!-- Modal content -->
      <div class="modal3-content">
      
      	<form action="<%=request.getContextPath()%>/upDateTheater.ta" type="post">
      		<fieldset>
      		<legend><h2>영화관 정보수정</h2></legend>
      		<table>	
      			<tr>
      				<th>영화관 이름</th>
      				<td><input type="text" name="name" value="<%=t.getName()%>"></td>
      			</tr>
      			
      			<tr>
      				<th>영화관 주소</th>
      				<td><input type="text" name="address" value="<%=t.getAddress()%>"></td>
      			</tr>
      			
      			<tr>
      				<th>영화관 전화번호</th>
      				<td><input type="text" name="phone" value="<%=t.getPhone()%>"></td>
      			</tr>
 				
 				<tr>
      				<th>주차 안내</th>
      				<td><textarea name="parking"cols="125" rows="10" style="resize:none"><%=t.getParking() %></textarea></td>
      			</tr>
      			
      			<tr>
      				<th>교통 안내</th>
      				<td><textarea name="transport" cols="125" rows="10" style="resize:none"><%=t.getTransport()%></textarea></td>
      			</tr> 
      			
      			<tr>
      				<th>위도</th>
      				<td><input type="number" step=0.00001 name="latitude" value="<%=t.getLatitude()%>"></td>
      			</tr>  
      			
      			<tr>
      				<th>경도</th>
      				<td><input type="number" step=0.00001 name="longitude" value="<%=t.getLongitude()%>"></td>
      			</tr>    
      			
      			
      			
      		</table>
      				<input type="hidden" name="theaterNo1" value="<%=t.getTheaterNo()%>">
      			
      			<br>
            <div style="background-color:lightgray;text-align: center; padding-bottom: 10px; padding-top: 10px;" >
            	<button>수정</button> <button type="button" onClick="close_pop3();">취소</button>
            </div>
            </fieldset>
        </form>
      </div>
 
    </div>


      		<script>
      	
      		
      		function selectTime(){
      			
      			var num = $("input[type=number]").val();
      			
      			for(var i=0;i<num;i++){
      				
      				var el = "<tr id='sCount"+ (i+1) + "'class='sCount'><th>"+(i+1)+"회차 시간 선택</th><td><input type ='time' name='rTime' class='rTime' required></td></tr>";
      				
      				$("#sCount" + i).after(el);     		
      				}
      			}
      		
      
      		</script>
      		
    
    <script>
	
	
	 function popModal1() {
        $('#myModal1').show();          
		}
	 
	 function popModal3() {
	        $('#myModal3').show();          
			}
	 function close_pop3(flag) {
	     	$('#myModal3').hide();
	 	}


	//팝업 Close 기능
	function close_pop1(flag) {
     	$('#myModal1').hide();
     	$('.sCount').remove();
     	$('#sCount').val("");
		}
		
	function popModal2() {
		$('#myModal2').show();
		
		$.ajax({
			url:"<%=request.getContextPath()%>/modalMovieList.ta",
			data:{},
			type:"post",
			success: function(list){
				
				var value="";
				
				for(var i=0; i<list.length;i++){
					value += "<tr>" + "<th>" + (i+1) + "</th>" +
									  "<td onclick='selectMovie();'>" + list[i].title + "</td>" + 
									  "<td>" + "<input type='hidden' value= '" + list[i].movieNo + "'>" + "</td>"+
							 "</tr>"
							 
							 
				}
				
				$("#modalMovieListTable").html(value);
				
				
			},
			
			error: function(){
				
				console.log("ajax 통신 실패");
			}
			
			
		});
		
	}
	
	function selectMovie(){
		var movieName = $(event.target).text();
		
		var movieNo = $(event.target).next().children().eq(0).val();
		
					console.log(movieNo);
	
		
		
		$("#selectMovie").val(movieName);
		$("#movieNo").val(movieNo);
		$("#myModal2").hide();
		
	}
	
	
	
	function close_pop2(flag) {
		$('#myModal2').hide();
	}
	
    </script>
    
 	   <!-- The Moda2 -->
    <div id="myModal2" class="modal2">
 
      <!-- Modal2 content -->
      <div class="modal2-content">
      		<fieldset>
      		<legend><h2>상영목록</h2></legend>
      		
      		<table id= "modalMovieListTable">	
      			
      		</table>
      		<br>
            <div style="background-color:lightgray;text-align: center;padding-bottom: 10px;padding-top: 10px;" >
            	<button type="button" onClick="close_pop2();">취소</button>
            </div>
            </fieldset>
       
      </div>
 
    </div>   

</body>
</html>