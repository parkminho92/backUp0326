<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body, html{
		background-color:white !important;
		
	}

      ul li{list-style: none;}
        #noticeMenu {position:absolute; width:250px; left:0; top:40px; }
        #noticeMenu h2{width:100%; height:100px; background:#9C0E0E; color:#fff; text-align: center; line-height:100px;}
        #noticeMenu ul {border-left:1px solid #ddd; border-right:1px solid #ddd;}
        #noticeMenu ul li{border-bottom:1px solid #ddd; padding:15px; box-sizing: border-box;}
        #noticeMenu ul li a{display:block; text-decoration:none; color:#616060; }
        #noticeMenu ul li a img{display:inline-block; vertical-align: middle; margin-right:15px;}
        #noticeMenu ul li a span{display:inline-block; vertical-align: middle;}


	.outer{
		margin-top:100px;
		color:black;
		color:black;
	
	}
	#headNo{
		font-weight:bold;
		font-size:30px;
		text-decoration:underline;
		width:200px;
		height:100px;
		color:black;
		margin-left:450px;
	}
	.insertForm{
		margin-top:10px;
		width:800px;
		height:1000px;
		float:left;
		font-size:30px;
		border:1px solid black;
		color:black;
		margin-left:500px;
	}
	#insertFormTable{
		padding:5px;
		margin-top:50px;
		color:black;
	}
	#insertFormTable tr td , #insertFormTable tr th, #insertFormTable input ,#insertFormTable select option{color:black; padding:5px;}
	#insertFormTable textarea{color:black;}
	#noticeMenu{margin-left:200px; margin-top:200px;}
	
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	     <div id="noticeMenu">
            <h2>고객센터</h2>
            <ul>
                <li><a href=""><img src="<%=contextPath %>/resources/images/req1.png" alt=""><span>1:1문의</span></a></li>
                <li><a href=""><img src="<%=contextPath %>/resources/images/req2.png" alt="">FAQ</a></li>
                <li><a href=""><img src="<%=contextPath %>/resources/images/req3.png" alt="">공지사항</a></li>
                <li><a href=""><img src="<%=contextPath %>/resources/images/req4.png" alt="">분실물찾기</a></li>
                <li><a href=""><img src="<%=contextPath %>/resources/images/req5.png" alt="">대관문의</a></li>
            </ul>
        </div>
  
	


	<div class="outer" id="noticeList">
			<br>
			<h2 align="center"><div id="headNo">대관문의</div></h2>
			<br>
			
 
			<div class="insertForm">
			<form id="insertForm" method="post" action="<%=contextPath%>/insertBroom.br">
				<table align="center" id="insertFormTable">
					
					<tr>
						<td>이메일</td>
						<td><input type="email" name="bemail"></td>
					</tr>
					<tr>
						<td>인원</td>
						<td>
							<div>
								청소년 <input type="number" width="30px" value="" name="yno" min="0" max="100">
							</div>
							<div>
								성인 <input type="number" width="30px" value="" name="ano" min="0" max="100">
							</div>
							<div>
								시니어 <input type="number" width="30px" value="" name="sno" min="0" max="100">
							</div>
							<div>
								장애인 <input type="number" width="30px" value="" name="dno" min="0" max="100">
							</div>
						</td>
					</tr>
					<tr>
						<td>희망일</td>
						<td><input type="date" name="bdate"></td>
					</tr>
					
					<tr>
						<td>비밀글 등록</td>
						<td><input type="checkbox" value="Y" name="checkPwd" onclick="changeBox();">비밀번호<input type="text" name="secretPwd"></td>
						
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="btitle"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="3"></td>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="bcontent" cols="100" rows="20" style="resize:none"></textarea>
						</td>
					</tr>
				</table>
				<br>
				<div class="btns" align="center">
					<button type="reset">취소하기</button>
					<button type="submit" onclick="insertBroom();">등록하기</button>
				</div>
			</form>
			</div>
		</div>
	
	<script>
		function changeBox(){
			var checkbox = document.getElementsByName("checkPwd");
			var $check = checkbox[0];
			
			if($check.checked){
				$check.value = 'Y';
			} else{
				$check.value = 'N';
			}
			console.log($check.value);
		}
	</script>



</body>
</html>