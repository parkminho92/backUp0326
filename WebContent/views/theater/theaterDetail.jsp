<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.kh.theater.model.vo.TheaterCBS, java.util.ArrayList, com.kh.room.model.vo.RoomCBS" %>
    
 <% 
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
	    .modal {
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
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 30%; /* Could be more or less, depending on screen size */                          
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
<div class="buttonBar" align="center"><button onclick="popModal();">상영등록</button> <button>정보수정</button></div>

</fieldset>

</div>

<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(<%=t.getLatitude()%>, <%=t.getLongitude()%>),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
		
		
</script>


	   <!-- The Modal -->
    <div id="myModal" class="modal">
 
      <!-- Modal content -->
      <div class="modal-content">
      
      	<form>
      		<fieldset>
      		<legend>상영 등록</legend>
      		<table>	
      			
      			
      			<tr>
      				<th>지역</th>
      				<td><%=t.getSectionName() %> </td>
      			</tr>
      				
      			<tr>	
      				<th>영화관 이름</th>
      				<td><%=t.getName() %></td>
      			</tr>
      			
      			<tr>
      				<th>상영관 선택</th>
      				<td>
      				<select>
      				<%for(RoomCBS ro : r) {%>
      					<option value="<%=ro.getName()%>"><%=ro.getName()%></option>
      				<%} %>
      				</select>
      				</td>
      			</tr>
      			
      			<tr>
      				<th>영화 선택</th>
      				<td><input type="text"></td>
      			</tr>
      			
      			<tr>
      				<th>날짜 선택</th>
      				<td><input type="date"></td>
      			</tr>
      			
      			<tr id="sCount">
      				<th>회차 선택</th>
      				<td><input type="number"> <button type="button" onclick="selectTime();">확인</button></td>
      			</tr>
      			
      			
      		</table>
      		
      		<script>
      		
      		function selectTime(){
      			
      			var num = $("input[type=number]").val();
      			
      			for(var i=0;i<num;i++){
      				
      				$("#sCount").after("<tr><th id='title'></th><td><input type ='time'></td></tr>")
      				$("#title").text(function())
      			}
      			
      			
      		}
      			
      		
      		</script>
      			
      	
      		<br>
            <div style="background-color:lightgray;text-align: center;padding-bottom: 10px;padding-top: 10px;" >
            	<button>등록</button> <button type="button" onClick="close_pop();">취소</button>
            </div>
            </fieldset>
        </form>
      </div>
 
    </div>
    
    <script>
	
	
	 function popModal() {
        $('#myModal').show();   
       
		};


	//팝업 Close 기능
	function close_pop(flag) {
     	$('#myModal').hide();
	};
    
    </script>

</body>
</html>