<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
*, ::after, ::before {
box-sizing: border-box;
-moz-box-sizing: border-box;
-webkit-box-sizing: border-box;
}
a {
text-decoration: none;
}
table {
position: relative;
width: 100%;
border-spacing: 0;
border-collapse: collapse;
}
button, input[type=button], input[type=reset], input[type=submit] {
overflow: visible;
padding: 0;
border: none;
background: 0 0;
}
[type=radio] {
-webkit-appearance: radio;
-moz-appearance: radio;
appearance: radio;
}
.enroll {
display: none;
position: absolute;
top: 120px;
left: 50%;
z-index: 110;
width: 800px;
padding: 60px 60px 70px;
background-color: #fff;
}
.btnWrap {
min-height: 40px;
margin-top: 30px;
text-align: center;
}
.button-color01 {
border-color: #3086c9;
color: #fff;
background-color: #3086c9;
}
.button-sizeL {
min-width: 114px;
height: 50px;
padding: 0 10px;
line-height: 48px;
}
.checkBlock {
position: relative;
margin-top: 20px;
}
.checkBlock-all {
margin-bottom: 65px;
background-color: #f4f5f7;
}
.checkBlock + .checkBlock {
margin-top: 40px;
}
.checkBlock .labelTxt {
color: #222;
font-family: "Noto Sans KR Medium","Noto Sans KR",sans-serif;
font-size: 18px;
font-weight: 500;
border: 1px solid #ddd;
display: block;
width: 100%;
padding: 16px 0;
text-align: center;
transition: border-color .2s, color .2s, background-color .2s;
}
[class*=agreeform] > input, [class*=feFo] > select {
position: absolute;
top: 0px;
right: 0px;
bottom: 0px;
left: 0px;
width: 100%;
height: 100%;
margin: 0;
padding: 0;
}
/* enrollField */
.enrollField {
position: relative;
margin-top: 20px;
}
.enrollField .info {
color: #db0000;
font-family: "Noto Sans KR Light","Noto Sans KR",sans-serif;
font-size: 14px;
font-weight: 300;
margin: -24px 0 8px;
text-align: right;
}
.enrollField table {
border-top: 2px solid #222;
border-bottom: 1px solid #ddd;
}
.enrollField td, .enrollField th {
vertical-align: middle;
height: 71px;
padding: 10px 0 10px;
border-top: 1px solid #ddd;
}
.enrollField th {
padding-right: 5px;
padding-left: 20px;
color: #222;
text-align: left;
}
.enrollField td div + div {
padding-top: 10px;
}
.enrollField th .essential {
display: inline-block;
margin: 0 8px 0 -14px;
color: #db0000;
}
/* joining */
.joining .heading {
margin-bottom: 30px;
}
.joining .enrollField .input {
width: 285px;
font-size: 14px;
}
.joining .enrollField td {
padding-right: 10px;
}
.joining .enrollField td {
padding-right: 10px;
}
.joining .enrollField .info {
margin-top: 0px;
margin-bottom: 5px;
font-size: 14px;
}
.joining .enrollField {
width: 680px;
}
.joining .term .inner {
width: 100%;
height: 85px;
padding: 20px 30px;
}
/* 남/여  */
.joining .enrollField span.optionGroup {
margin-left: 15px;
}
.labelTxt + label {
margin-left: 12px;
}
/* 회원가입 타이틀 */
.enroll .head .title {
color: #000;
font-family: "Noto Sans KR Medium","Noto Sans KR",sans-serif;
font-size: 34px;
font-weight: 500;
line-height: 1.29;
}
</style>


</head>
<body>

	<%@ include file="../common/menubar.jsp"%>

<div id="wrap">
	<section class="enroll enroll-join" id="enrollJoin" style="margin-left: -400px; display: block;">
		<div class="head">
			<h1 class="title">회원가입</h1>
		</div>
<!-- //head -->
<!-- body -->
		<div class="body" style="margin-top: 80px;"></div>
<!-- joining -->
		<div class="joining scroll">
			<form name="joinForm" id="memberVo" action="<%=request.getContextPath()%>/insert.me" method="post" >

<!-- enrollField -->
		<div class="enrollField">
			<p class="info"><span class="essential">*</span> 표시 항목은 필수입력사항입니다.</p>
				<table>
					<colgroup>
						<col style="width: 150px;">
						<col style="width: auto;">
					</colgroup>
					<tbody>
						<tr>
							<th scope="row"><span class="essential">*</span>아이디</th>
							<td>
								<input name="id" title="아이디" class="input id" required="" type="text" placeholder="영문, 숫자 포함 6글자 이상">
								<!-- 사용불가 or 불일치 시 : input 'error' 클래스 -->
							</td>
						</tr>
						<tr>
							<th scope="row"><span class="essential">*</span>비밀번호</th>
							<td>
								<input name="pwd" title="비밀번호" class="input pwd" id="pwd1" required="" type="password" placeholder="영문 + 숫자 조합으로 8자 이상">
							</td>
						</tr>
						<tr>
							<th scope="row"><span class="essential">*</span>비밀번호 확인</th>
							<td>
								<input name="pwdChk" title="비밀번호 확인" class="input pwdChk" id="pwd2" required="" type="password" placeholder="영문 + 숫자 조합으로 8자 이상">
								<div class="alert alert-success" id="alert-success" style="float:right;">비밀번호가 일치합니다.</div> 
								<div class="alert alert-danger" id="alert-danger" style="float:right;">비밀번호가 일치하지 않습니다.</div>
							</td>
						</tr>
						<tr>
							<th scope="row"><span class="essential">*</span>이름</th>
							<td>
								<input name="name" title="이름" class="input name" type="text" maxlength="20" required="">
							</td>
						</tr>
						<tr>
						<th scope="row"><span class="essential">*</span>생년월일</th>
							<td>
								<input name="birth" title="생년월일" class="input birth" type="text" maxlength="8" placeholder="ex) 19800320" required="">
							</td>
						</tr>
						<th scope="row"><span class="essential">*</span>이메일</th>
							<td>
								<input name="email" title="이메일" class="input mail" required="" type="email" maxlength="50" required="">
							</td>
						</tr>
						<tr>
						<th scope="row"><span class="essential">*</span>휴대폰번호</th>
							<td>
								<input name="phone" title="휴대폰번호" class="input phone" type="tel" maxlength="11" placeholder="휴대폰번호 (숫자만)" required="">
							</td>
						</tr>
						<tr>
						<th scope="row">전화번호</th>
							<td>
								<input name="tel" title="전화번호" class="input tel" type="tel" maxlength="11" placeholder="전화번호 (숫자만)">
							</td>
						</tr>
						<th scope="row"><span class="essential">*</span>성별</th>
							<td>
								<span class="optionGroup">
                                    <label for="gender"><input name="gender" title="남성" id="gender" type="radio" value="M" style="margin-right: 13px;">남성</label>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<label for="gender"><input name="gender" title="여성" id="gender" type="radio" value="F" style="margin-right: 13px;">여성</label>
								</span>
							</td>
						</tr>
					</tbody>
				</table>
            </div>

            <div class="btnWrap">
                <button class="button button-sizeL button-color01" id="joinSubmitBtn" type="submit">회원가입</button>
            </div>
            <!-- //btnWrap -->

    </form>           
    </div>
    <!-- //body -->
</section>
</div>


<script type="text/javascript"> 
	$(function(){ $("#alert-success").hide(); 
	$("#alert-danger").hide(); 
	$("input").keyup(function(){ var pwd1=$("#pwd1").val(); 
	var pwd2=$("#pwd2").val(); 
	if(pwd1 != "" || pwd2 != ""){ 
		if(pwd1 == pwd2){ 
			$("#alert-success").show(); 
			$("#alert-danger").hide(); 
			$("#joinSubmitBtn").removeAttr("disabled"); 
		}else { 
			$("#alert-success").hide(); 
			$("#alert-danger").show(); 
			$("#joinSubmitBtn").attr("disabled", "disabled"); 
			} 
		} 
	}); 
}); 
</script>

</body>
</html> 
