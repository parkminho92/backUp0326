<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body, html{
		background-color:white!important;
		
	}
#listArea{
		
		float:left;
		margin-top: 200px;
		margin-left:100px;
		width:200px;
		height:350px;
		color:white;
		border-radius:10px;
	}
	.list{
		display:block;
		border-radius:10px;
		margin-top:30px;
		background-color:#e83a4e;
		width:150px;
		height:30px;
		text-align:center;
		vertical-align:middle;
		margin-left:auto;
		margin-right:auto;
		font-size:15px;
		font-family: 'Nanum Gothic', sans-serif;
		font-weight:bold;
	}
	.outer{
		margin-top:100px;
	
	}
	#headNo{
		font-weight:bold;
		font-size:30px;
		text-decoration:underline;
		width:200px;
		height:100px;
		float:left;
		margin-left:450px;
		color:black;
	}
	.insertForm{
		margin-top:30px;
		width:800px;
		height:830px;
		float:left;
		font-size:30px;
		border:1px solid black;
		margin-left:500px;
		color:black;
	}
	#insertFormTable tr td{
		padding:5px;
		margin-top:50px;
		color:black;
	}
	#insertFormTable tr td select ,#insertFormTable tr td input, #insertFormTable textarea{color:black;}
	 ul li{list-style: none;}
        #noticeMenu {position:absolute; width:250px; left:0; top:40px; }
        #noticeMenu h2{width:100%; height:100px; background:#9C0E0E; color:#fff; text-align: center; line-height:100px;}
        #noticeMenu ul {border-left:1px solid #ddd; border-right:1px solid #ddd;}
        #noticeMenu ul li{border-bottom:1px solid #ddd; padding:15px; box-sizing: border-box;}
        #noticeMenu ul li a{display:block; text-decoration:none; color:#616060; }
        #noticeMenu ul li a img{display:inline-block; vertical-align: middle; margin-right:15px;}
        #noticeMenu ul li a span{display:inline-block; vertical-align: middle;}
	#noticeMenu{
		margin-left:200px;
		margin-top:200px;
	}
	
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	

   
        <div id="noticeMenu">
            <h2>고객센터</h2>
            <<ul>
                <li><a href="<%=contextPath%>/qnaList.qa"><img src="resources/images/req1.png" alt=""><span>1:1문의</span></a></li>
                <li><a href="<%=contextPath%>/faq.fq"><img src="resources/images/req2.png" alt="">FAQ</a></li>
                <li><a href="<%=contextPath%>/list.no"><img src="resources/images/req3.png" alt="">공지사항</a></li>
                <li><a href="<%=contextPath%>/lost.lo"><img src="resources/images/req4.png" alt="">분실물찾기</a></li>
                <li><a href="<%=contextPath%>/bRoom.br"><img src="resources/images/req5.png" alt="">대관문의</a></li>
            </ul>
        </div>

	<div class="outer" id="noticeList">
			<br>
			<h2 align="center"><div id="headNo">1:1문의하기.</div></h2>
			<br>
			
			<br>
			<div class="insertForm">
			<form id="insertForm" action="<%=contextPath %>/insertQna.qa" method="post">
				<table align="center" id="insertFormTable">
					<tr>
						<td>분류</td>
						<td colspan="3">
							<select name="type">
								<option value="1">영화</option>
								<option value="2">예매/결제</option>
								<option value="3">홈페이지/모바일</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>종류</td>
						<td id="kind">
							<select name="kind">
								<option value="1">건의</option>
								<option value="2">문의</option>
								<option value="3">칭찬</option>
								<option value="4">불만</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>비밀글 등록</td>
						<td>
						<input type="checkbox" value="Y" name="checkPwd" onclick="changBox();">비밀번호
						<input type="text" name="secretPwd">
						</td>
						
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="3"></td>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="content" cols="100" rows="30" style="resize:none"></textarea>
						</td>
					</tr>
					<%-- <input type="hidden" name="writer" value="<%=loginUser.getId() %>"> --%>
				</table>
				<div class="btns" align="center">
					<button type="reset">취소하기</button>
					<button type="submit" onclick="insertQna();">등록하기</button>
				</div>
			</form>
			</div>
		</div>
		
	<script>
	
	function changBox(){
		var checkbox = document.getElementsByName("checkPwd");
		var $check = checkbox[0];
		
		if($check.checked){
			$check.value = 'Y';
		}else{
			$check.value = 'N';
		}
		console.log($check.value);
		
	}
	</script>



</body>
</html>