<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.movie.model.vo.Movie" %>    
<%
	Movie m = (Movie)request.getAttribute("m");
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		color:black;
	}
	#movieDetail{
		width:300px;
		font-size:30px;
		font-weight:bold;
		display:inline-block;
		float:left;
	}
	#movieDetail{
		
		margin-top:70px;
		margin-left:150px;
		color:black;
	}
	#movieMainDetail{
		width:900px;
		height:500px;
		margin-top:100px;
		margin-left:250px;
	}
	#movieImgMain{
		width:400px;
		height:400px;
		border:1px solid black;
	}
	#movieName{
		width:400px;
		height:30px;
		border:1px solid black;
		margin-top:-400px;
		margin-left:500px;
		border-radius:10px;
		font-size:20px;
		font-weight:bold;
		vertical-align:middle;
		line-height:1.5em;
		padding:3px;
	}
	#movieReporter{
		width:300px;
		height:30px;
		border:1px solid black;
		margin-top:30px;
		margin-left:500px;
		border-radius:10px;
		vertical-align:middle; 
		line-height:2em;
		font-weight:bold;
		padding:5px;
	}
	#movieInfo{
		border:1px solid black;
		width:300px;
		height:200px;
		border-radius:10px;
		margin-left:500px;
		margin-top:30px;
		font-weight:bold;
		padding:5px;
	}
	#input{
		margin-left:550px;
		margin-top:30px;
	}
	#movieSyno{
		width:500px;
		height:400px;
		border:1px solid black;
		margin-top:30px;
		margin-left:250px;
		text-align:center;
		font-size:15px;
		font-weight:bold;
		padding:10px;
		border-radius:10px;
	}
	#movieStillImg{
		width:600px;
		height:400px;
		border:1px solid black;
		margin-left:800px;
		margin-top:-400px;
	}
	#input button{
		outline:0;
		border:0;
		border-radius:3px;
		background:lightsalmon;
		width:60px;
		height:20px;
		margin:20px;
		align:center
	}
	.replyArea{
		color:black;
		margin:auto;
		width:900px;
		margin-top:80px;
		
	}
	#replyContent{
		width:500px;
		border:none;
		outline:none;
	}
	#addReply{
		width:55px;
		height:80px;
		background:beige;
	}
	.line{border-bottom:1px solid black;}
	

	
</style>

</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<div id="movieDetail">
			<img src="<%=contextPath %>/resources/images/movieChart2.png" width="50px" height="50px" align="center">
			<div id="name1">영화 상세 정보 
				<img src="<%=contextPath %>/resources/images/line.png" width="300px" height="20px" >
			</div>
		</div>
	<br clear="both">
	<form id="movieMainDetail">
		<div id="movieImgMain">
			<img src="">
		</div>
		
		<div id="movieName">
			<p><%=m.getTitle() %></p>
		</div>
		<div id="movieReporter">
			<p>예매율 4.3%  98% (실관람평 : 3,654명)</p>
		</div>
		<div id="movieInfo">
			<p>감독 : <%=m.getDirector() %></p>
			<p>배우 : <%=m.getActor() %></p>
			<p>장르 : 드라마, 전쟁, 코미디 / 기본 : <%=m.getAgeLimit() %>, <%=m.getRuntime() %></p>
			<p>개봉 : date넣기</p>
		</div>
		<div id="input">
			<button>예매하기</button>
			<img src="<%=contextPath %>/resources/images/heart1.png" width="30px" height="30px">
			<button>찜하기</button>
		</div>
	</form>
	
	<div id="movieSyno">
		<p><%=m.getSynopsis() %></p>
	</div>
	<div id="movieStillImg">
		<img>
	</div>
	
		<!--  댓글 관련 영역 -->
	<div class="replyArea"> 
		<!-- 댓글 작성하는 table -->
		<table border="1" align="center"> 
			<tr>
				<th>
				<div>
					<p id="star_grade">
						<a href="#">★</a>
						<a href="#">★</a>
						<a href="#">★</a>
						<a href="#">★</a>
						<a href="#">★</a>
					</p>
				</div>
				</th>
				<td><textarea id="replyContent" rows="3" cols="60" style="resize:none;" placeholder="별점 및 관람평을 작성해주세요"></textarea></td>
				<td><button id="addReply">관람평 작성</button></td>
				
			
			</tr>
		</table>
		
		<br><br>
		<div id="replyListArea">
			<table id="replyList" align="center">

			</table>
		</div>
		<br><br><br><br><br>
	</div>

	<script>
	
	$(function(){
		
		selectReplyList();
		
		window.setInterval(selectReplyList , 10000);
		

	});
		function selectReplyList(){
			var movieNo = <%=m.getMovieNo()%>;
			
			$.ajax({
				url:"rlist.re?movieNo=" + movieNo,
				type:"get",
				success:function(list){
					
					var value ="";
					
					for(var i in list){
						
						value += '<tr class="line">' +
									'<td width="150">' + list[i].id + '</td>' +
									'<td width="100">' + '<img src="<%=contextPath%>/resources/images/star2.png" width="20" height="20">' + list[i].reviewRating + '</td>' +
									'<td width="500">' + list[i].reviewText + '</td>' + 
								'</tr>';
					}
					$("#replyList").html(value);
				},
				error:function(){
					console.log("댓글 리스트 조회 ajax 통신 실패!!");
				}
			});
		}
		
		$("#star_grade a").click(function(){
			$(this).parent(),children("a").removeClass("on");
			$(this).addClass("on").preAll("a").addClass("on");
			return false;
		});
	</script>
	
	
	<br><br><br><br><br><br><br><br><br>
	</div>

</body>
</html>