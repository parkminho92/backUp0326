<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.wrap {
    width: 1000px;
    margin-top:50px;
	margin-left:auto;
	margin-right:auto;
}
.btnWrap {
    margin-top: 20px;
    text-align: center;
}
.block {
	display: block;
}
.button {
	border: 1px solid #254069;
	display: inline-block;
	vertical-align: middle;
	min-width: 90px;
	height: 40px;
	margin: 0 3px;
	padding: 0 20px;
	border-radius: 3px;
	color: #254069;
	font-size: 13px;
	text-align: center;
	line-height: 38px;
	cursor: pointer;
}
.button-color01 {
	border-color: #db6a29e7;
	color: #fff;
	background-color: #db6a29e7;
}
.button-color02 {
	border-color: #c7bcb6e7;
	color: #fff;
	background-color: #c7bcb6e7;
}
:first-child.button {
	margin-left: 0px;
}
.movieinfo {
    padding: 30%;
    text-align: center;
    font-size: 20px;
}
.movieinfo h3 {
    font-size: 35px;
    margin-bottom: -5px;
}
.title2 {
    padding-bottom: 5%;
}
.title2 h1{
    font-size: 50px;
    font-weight: bolder;
    padding-bottom: 10px;
}
.sort {
    padding-bottom: 5px;
}
</style>

</head>
<body>

	<%@ include file="../common/myPagebar.jsp"%>

	<div class="wrap">
 <div class="title1">
    <div class="title2">
        <h1>My 영화</h1>
    </div>
    <div class="sort">
        <button class="button button-color02 block" id="mypick" type="button" onclick="location.href='pickMovie.do'">내가 '찜'한 영화</button>
        <button class="button button-color02 block" id="mywatched" type="button" onclick="location.href='watchedMovie.do'">내가 본 영화</button>
    </div>
    </div>
    <hr style="border:1px solid#878787; height: 2px !important; display: block !important; width: 100% !important;"/>
    <div class="movieinfo">
           <p><h3>※</h3><br>
           영화 관람 내역이 존재하지 않습니다.
           <p>
    </div>
    <hr style="border:1px solid#878787; height: 2px !important; display: block !important; width: 100% !important;"/>
    <div class="btnWrap">
        <button class="button button-color01 block" id="idback" type="button">이전화면</button>
        <button class="button button-color01 block" id="idnext" type="submit">영화 찜하러 가기</button>
    </div>

</div>



</body>
</html> 