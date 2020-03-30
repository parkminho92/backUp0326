<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.ArrayList, com.kh.movie.model.vo.*" %>
    
<%
	

	ArrayList<MovieCBS> list = (ArrayList<MovieCBS>)request.getAttribute("list");

	PageInfo pi = (PageInfo)request.getAttribute("pi");

	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	
	for(int i=0;i<list.size();i++){
		
	if(list.get(i).getModifyName()== null){
		
		list.get(i).setModifyName("p_logo.png");
				
		}
	}
	


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
	
	#list{
		width:100%;
	
	}
	
	.title{
		text-align:center;
		font-weight:bold;
	}
	
	#list tr td{
	text-align:center;
	width:200px;
		
	}
	
	#list tr td:hover{

	cursor:pointer;
	}
	
	.pagingArea>button{
		border-radius:7px;
	}
	
		    .modal1{
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
        .modal1-content{
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 70%; /* Could be more or less, depending on screen size */                          
        }
        
        #movieDetail{
        	width:100%;
        	height:100%;
        	
       
        }
        
        #movieDetail>tr th{
        	width:20%;
        	height:100px;
        	background:darkgray;
        	text-align:center;
        }
        
        #movieDetail>tr>td{
        	width:40%;
        	height:100px;
        	background:lightgray;
        	text-align:center;
        }
        
        #mainImage{
        	width:350px;
        	height:400px;
        	margin-left:0;
        	margin-right:0;
        	margin-top:10px;
        	margin-bottom:10px;
        	border-spacing:10px;
       
        }
        
       #subImage1, #subImage2, #subImage3, #subImage4 {
       		width:100%;
       		height:100%;
       	
       }
        
        .beforeUpdateColor{
        	
        	background:lightgray;
        	border:none;
        	
        
        }
        .modalTitle{
        	border:none;
        	font-size:20px;
        	background:none;
        	font-weight:bold;
        }
        
       #subImageTable{
       		width:400px;
       		height:500px;
       		margin:auto;
       		border-spacing: 5px;
       		
      	}
      	
      	#genreUpdate tr td{
      		margin:auto;
      		width:200px;
      		height:50px;
      		text-align:left;
      	}
        
  

</style>
</head>
<body>
	
	<%@ include file="../common/adminMenubar.jsp" %>
	
	
	
	<div class="outer">
	
	<fieldset>
	<legend><h2>상영예정작</h2></legend>
	<table id="list">
	
		<%if(list.isEmpty()){%>
			<tr>
				<td colspan="5"><h3>조회된 리스트가 없습니다.</h3></td>
			</tr>	
		
		<%}else{%>
			
			<!--  -->
			<%if(list.size() <= 5){ %>
				<tr>
				<% for(int i=0;i<list.size();i++){ MovieCBS m = list.get(i);
				
				%>
				
					
					
					<td>
					<input type="hidden" value="<%=m.getMovieNo()%>">
					<input type="hidden" value="<%=m.getTitle()%>">
					<input type="hidden" value="<%=m.getDirector()%>">
					<input type="hidden" value="<%=m.getActor()%>">
					<input type="hidden" value="<%=m.getAgeLimit()%>">
					<input type="hidden" value="<%=m.getRuntime()%>">
					<input type="hidden" value="<%=m.getSynopsis()%>">
					<input type="hidden" value="<%=m.getOnDate()%>">
					<input type="hidden" value="<%=m.getModifyName()%>">
					<img src="<%=request.getContextPath()%>/resources/poster_upfiles/<%=m.getModifyName() %>" width="200px" height="200px"><p class="title"><%=m.getTitle()%></p></td>
	
				<%} %>
				</tr>
				
			
			
			<%}else{ %>
				<tr>
				<% for(int i=0;i<5;i++){ MovieCBS m = list.get(i);%>
					
					<td>
					<input type="hidden" value="<%=m.getMovieNo()%>">
					<input type="hidden" value="<%=m.getTitle()%>">
					<input type="hidden" value="<%=m.getDirector()%>">
					<input type="hidden" value="<%=m.getActor()%>">
					<input type="hidden" value="<%=m.getAgeLimit()%>">
					<input type="hidden" value="<%=m.getRuntime()%>">
					<input type="hidden" value="<%=m.getSynopsis()%>">
					<input type="hidden" value="<%=m.getOnDate()%>">
					<input type="hidden" value="<%=m.getModifyName()%>">
					
					<img src="<%=request.getContextPath()%>/resources/poster_upfiles/<%=m.getModifyName() %>" width="200px" height="200px"><p class="title"><%=m.getTitle()%></p>
					
					</td>
					
					
					
				<%} %>
				</tr>
				
				<tr>
				<% for(int i=5;i<list.size();i++){ MovieCBS m = list.get(i);%>
					<td>
					<input type="hidden" value="<%=m.getMovieNo()%>">
					<input type="hidden" value="<%=m.getTitle()%>">
					<input type="hidden" value="<%=m.getDirector()%>">
					<input type="hidden" value="<%=m.getActor()%>">
					<input type="hidden" value="<%=m.getAgeLimit()%>">
					<input type="hidden" value="<%=m.getRuntime()%>">
					<input type="hidden" value="<%=m.getSynopsis()%>">
					<input type="hidden" value="<%=m.getOnDate()%>">
					<input type="hidden" value="<%=m.getModifyName()%>">
					<img src="<%=request.getContextPath()%>/resources/poster_upfiles/<%=m.getModifyName() %>" width="200px" height="200px"><p class="title"><%=m.getTitle()%></p>
					
					
					
					</td>
				<%} %>
				</tr>
			
			<%} %>
			
		<%} %>		
		
				
	</table>
	<br>
	<!-- 페이징바 영역 -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 (<<) -->
			<button onclick="location.href='<%=request.getContextPath()%>/listComingMovie.mv';"> &lt;&lt; </button>
			
			<!-- 이전페이지(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/listComingMovie.mv?currentPage=<%=currentPage-1%>';"> &lt; </button>
			<%} %>
			
			<!-- 페이지 목록 -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(currentPage == p){ %>
				<button disabled> <%=p%> </button>
				<%}else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/listComingMovie.mv?currentPage=<%=p%>';"> <%= p %> </button>
				<%} %>
			
				
			<%} %>
			
			<!-- 다음페이지(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/listComingMovie.mv?currentPage=<%=currentPage+1%>';"> &gt; </button>
			<%} %>
			
			
			<!-- 맨 마지막으로 (>>) -->
			<button onclick="location.href='<%=request.getContextPath()%>/listComingMovie.mv?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div>
	</fieldset>
	
	</div>
	
						   <!-- The Modal -->
    <div id="myModal1" class="modal1">
 
      <!-- Modal content -->
      <div class="modal1-content">
  
      	<form action="<%=request.getContextPath()%>/updateMovie.mv" method="post">
      		
      		<fieldset id="modalFieldset">
      		<table id = "movieDetail"></table>
      		
      		
      		
      		<br>
            <div id = "modalFooter"style="background-color:lightgray;text-align: center;padding-bottom: 10px;padding-top: 10px;" >
           	<input type="button" id="check" value="확인"> <input type="button" id="updateMovie" value="수정"> <button id="confirmUpdateMovie" type="submit" style="display:none">업데이트하기</button> <input type="button" id="deleteMovie" value="삭제">
            </div>
            </fieldset>
        </form>
      </div>
 
    </div>
	
		
	
	
		<script>
		
			$(function(){
				
				
			
				$("#list").on("click","td",function(){
						var movieNo = $(this).children().eq(0).val();
						var title = $(this).children().eq(1).val();
						var director = $(this).children().eq(2).val();
						var actor = $(this).children().eq(3).val();
						var ageLimit = $(this).children().eq(4).val();
						var runtime = $(this).children().eq(5).val();
						var synopsis = $(this).children().eq(6).val();
						var onDate = $(this).children().eq(7).val();
						var modifyName = $(this).children().eq(8).val();
						
						
					  $.ajax({
						 url:"<%=request.getContextPath()%>/getGenre.mv",
						data:{movieNo:movieNo},
						type:"get",
						dataType:"text",
						success: function(result){
							
							$("#genre").val(result);
							
						},
						
						error: function(){
							
							console.log("ajax통신실패");
						}
						  
					  });
					 
						
					 
					  $("#myModal1").show(); 
					  
					  $("#movieDetail").before("<legend><h2><input type='hidden' name='movieNo' value='" + movieNo +"'><input type='text' class='modalTitle' name='title' size='auto;' readonly style = 'text-align :center' value='" + title + "'></h2></legend>");
					  $("#movieDetail").append("<tr><th>감독</th><td><input type='text' class='beforeUpdateColor' name='director' readonly style = 'text-align :center' value='" + director + "'></td><td id='mainImageArea' rowspan='3' width='300px;'><img id='mainImage' src='&lt;%request.getRequestContextPath()%&gt;/resources/poster_upfiles/" + modifyName +"'></td></tr>" +
							  				   "<tr><th>배우</th><td><input type='text' class='beforeUpdateColor' name='actor' readonly style = 'text-align :center' size=100%' value='" + actor + "'></td></tr>" +
					  						   "<tr><th>장르</th><td><input type='text' id='genre' class='beforeUpdateColor' readonly style = 'text-align :center' value=''></td></tr>" +
							  				   "<tr><th>관람연령</th><td><input type='number' class='beforeUpdateColor' readonly style = 'text-align :center' name='ageLimit' value='" + ageLimit + "'></td><td id='subImageArea' rowspan='4'><table id='subImageTable'><tr><td id='image1'></td><td id='image2'></td></tr><tr><td id='image3'></td><td id='image4'></td></tr></table></td></tr>" +
							  				   "<tr><th>상영시간</th><td><input type='number' class='beforeUpdateColor' readonly style = 'text-align :center' name='runtime'  value='" + runtime + "'></td></tr>" +
							  				   "<tr><th>줄거리</th><td><textarea name='synopsis' cols='100' rows='13'  class='beforeUpdateColor' readonly style='resize:none; border:none; margin-top:20px;' >" + synopsis + "</textarea></td></tr>" +
							  				   "<tr><th>상영시작일</th><td><input type='Date' class='beforeUpdateColor' readonly style = 'text-align :center' name='onDate' value='" + onDate + "'></td></tr>")
					
					  $.ajax({
						 url:"<%=request.getContextPath()%>/getImages.mv",
						 data:{movieNo:movieNo},
						 type:"get",
						 success: function(image){
							 
							 var num1 = image[0];
							 var num2 = image[1];
							 var num3 = image[2];
							 var num4 = image[3];
							 
							 $("#image1").html("<img id='subImage1' src='&lt;%request.getRequestContextPath()%&gt;/resources/poster_upfiles/" + num1 +"'>");
							 $("#image2").html("<img id='subImage2' src='&lt;%request.getRequestContextPath()%&gt;/resources/poster_upfiles/" + num2 +"'>");
							 $("#image3").html("<img id='subImage3' src='&lt;%request.getRequestContextPath()%&gt;/resources/poster_upfiles/" + num3 +"'>");
							 $("#image4").html("<img id='subImage4' src='&lt;%request.getRequestContextPath()%&gt;/resources/poster_upfiles/" + num4 +"'>");
							 
							
							
							 },
						 error: function(){
							 console.log("ajax통신실패");
						 }
						  
					  });
					  
					 
					
				});
				
				
				$("#myModal1").on("click","#check",function(){
					
					$("#myModal1").hide();
					$("legend").remove();
					$("#movieDetail").empty();
					$("#confirmUpdateMovie").hide();
					$("#updateMovie").show();
					$(this).val("확인");
					
				})
				
				
				$("#modalFooter").on("click","#updateMovie",function(){
				
					$("#modalFieldset>legend>h2>input").removeAttr("readonly");
					$("#movieDetail>tr>td>input, #movieDetail>tr>td>textarea").removeClass("beforeUpdateColor").removeAttr("readonly");
					$("#movieDetail #genre").hide();
					$("#movieDetail").children("tr").eq(2).children("td").append(
							
							"<table id='genreUpdate'>"+
							"<tr>"+
								"<td><input type='checkbox' name='genre' value='1'>스포츠</td>"+
								"<td><input type='checkbox' name='genre' value='2'>범죄</td>"+
								"<td><input type='checkbox' name='genre' value='3'>드라마</td>"+
								"<td><input type='checkbox' name='genre' value='4'>다큐멘터리</td>"+
							"</tr>"+
							
							"<tr>"+
								"<td><input type='checkbox' name='genre' value='5'>코미디</td>"+
								"<td><input type='checkbox' name='genre' value='6'>스릴러</td>"+
								"<td><input type='checkbox' name='genre' value='7'>전쟁</td>"+
								"<td><input type='checkbox' name='genre' value='8'>애니메이션</td>"+
							"</tr>"+
							
							"<tr>"+
								"<td><input type='checkbox' name='genre' value='9'>가족</td>"+
								"<td><input type='checkbox' name='genre' value='10'>판타지</td>"+
								"<td><input type='checkbox' name='genre' value='11'>액션</td>"+
								"<td><input type='checkbox' name='genre' value='12'>SF</td>"+
							"</tr>"+
							
							"<tr>"+
								"<td><input type='checkbox' name='genre' value='13'>로맨스/멜로</td>"+
								"<td><input type='checkbox' name='genre' value='14'>로맨스/코미디</td>"+
								"<td colspan='2'></td>"+
							"</tr>" + "</table>"
							
					
					)
					$("#updateMovie").hide();
					$("#confirmUpdateMovie").show();
					$("#check").val("취소");
					
				});
			
			
			
			});
			
		
		</script>
		
	
</body>
</html>