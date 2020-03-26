<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		height:1600px;
		width:1200px;
		margin:auto;
		margin-top:50px;
		
	}
	#movieChart{
		width:50px;
		height:50px;
		margin-top:70px;
		margin-left:50px;
		color:black;
	}
	#name1{
		width:200px;
		font-size:30px;
		font-weight:bold;
		display:inline-block;
		float:left;
	}
	
	#movieMain{
		border:1px solid black;
		width:450px;
		height:650px;
		margin-top:100px;
		position:static;
		
	}
	.movieSub{
		border:1px solid black;
		width:300px;
		height:300px;
	}
	
	#movieSub1{
		margin-top:-655px;
		margin-left:550px;
	}
	#movieSub2{
		margin-left:900px;
		margin-top:-300px;
	}
	#movieSub3{
		margin-left:550px;
		margin-top:50px;
	}
	#movieSub4{
		margin-left:900px;
		margin-top:-300px
		}
	#commingSoon{
		width:50px;
		height:50px;
		margin-top:100px;
		margin-left:50px;
		color:black;
	}
		#name2{
		width:200px;
		font-size:30px;
		font-weight:bold;
		display:inline-block;
		float:left;
		color:black;
	}
	.commingMovieChart{
		border:1px solid black;
		width:250px;
		height:250px;
		float:left;
		margin:20px;
	}
	#nowList{
		width:300px;
		height:400px;
		border:1px solid black;
		margin-left:950px;
		margin-top:-500px;
	}

</style>
</head>
<body>


	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
	<br clear="both">
	<div id="movieChart">
		<img src="<%=contextPath %>/resources/images/movieChart2.png" width="50px" height="50px" align="center">
		<div id="name1">Movie Chart
		<img src="<%=contextPath %>/resources/images/line.png" width="300px" height="20px" >
		</div>
	</div>
		<br clear="both">

						<!-- Thumbnails -->
							<form action="<%=contextPath%>/movieDetail.mo">
								<div class="movie" id="movieMain">
									<input type="hidden" value="1">
									<img src="<%=contextPath %>/resources/images/movie1.jpg" width="450px" height="550px">
								</div>
								
								<div class="movieSub movie" id="movieSub1">
									<input type="hidden" value="2">
									<img src="<%=contextPath %>/resources/images/movie1.jpg" width="300" height="250">
								</div>
								<div class="movieSub movie" id="movieSub2">
									<input type="hidden" value="3">
									<img src="<%=contextPath %>/resources/images/movie1.jpg" width="300" height="250">
								</div>
								<div class="movieSub movie" id="movieSub3">
									<input type="hidden" value="4">
									<img src="<%=contextPath %>/resources/images/movie1.jpg" width="300" height="250">
								</div>
								<div class="movieSub movie" id="movieSub4">
									<input type="hidden" value="5">
									<img src="<%=contextPath %>/resources/images/movie1.jpg" width="300" height="250">	
								</div>
							
							</form>
							
							<br clear="both"><br>
							
				<script>
				
					$(".movie").click(function(){
						
						var value = $(this).children().eq(0).val();
						
						console.log(value);
						
						location.href="<%=contextPath%>/movieDetail.mo?movieNo=" + value;
						
					});
				
				</script>
							
		<div id="commingSoon">					
			<img src="<%=contextPath %>/resources/images/movieChart2.png" width="50px" height="50px" align="center">
			<div id="name2">CommingSoon
				<img src="<%=contextPath %>/resources/images/line.png" width="300px" height="20px" >
			</div>
		</div>		
		<br clear="both"><br><br>
		
		
		<form>
			<div class="commingMovieChart" id="commingMovie1">
				<img src="">
			</div>
			<div class="commingMovieChart" id="commingMovie2">
				<img src="">
			</div>
			<div class="commingMovieChart" id="commingMovie3">
				<img src="">
			</div>
			<br clear="both">
			<div class="commingMovieChart" id="commingMovie4">
				<img src="">
			</div>
			<div class="commingMovieChart" id="commingMovie5">
				<img src="">
			</div>
			<div class="commingMovieChart" id="commingMovie6">
				<img src="">
			</div>
			
		</form>
		
		<br clear="both">
		<div id="nowList"></div>
</div>
		<br><br><br><br><br>
						
						
</body>
</html>