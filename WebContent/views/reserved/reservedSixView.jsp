<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <style>
        *{margin:0; padding:0;}
        .layout { position: relative; padding:0 15px; width:1000px; margin:0 auto; }
        ul li{list-style:none;}
        #reserved{ height: 800px;}
        #reserved>div{ overflow:hidden;}
        #reserved_menu{ margin: 10px 0;}
        #reserved_menu ul li{
            background-color: lightgray;
            color: rgba(70, 60, 60, 0.493);
            border-radius: 5px;
            float: left;    width: 25%;
            text-align: center;
            height: 30px;
            line-height: 30px;
        }
        #reserved_menu ul li.on{
            background-color: rgb(68, 68, 68);
            color: orange;
            text-decoration: bold;
        }
	 #reserved_choose3{ padding: 10px; background:#eee; overflow: hidden;}
	 #reserved_choose3 .script_movie{ position:relative; background:#333; float: left; width: 35%; height:640px; box-sizing: border-box; padding:60px 0 50px;}
     #reserved_choose3 .script_movie .title { position: absolute; left: 0; top:0; background: #5E5E5E; padding: 10px; color:#fff;}
	 #reserved_choose3 .script_movie .reserved_poster {width: 280px; height: 400px; background: lightpink; margin:0 auto; margin-top:50px;}
	 #reserved_choose3 .script_movie .reserved_poster > img { width: 100%; height: 100%;}

    #reserved_choose3 .script_reserved{ position:relative; background:#333; float: left; width: 35%; height:640px; border-right:1px solid #eee; box-sizing: border-box; padding:60px 0 50px;}
    #reserved_choose3 .script_reserved .reserved_movie_title {margin-top: 30px; color:#fff; padding:0 30px;}
	 #reserved_choose3 .script_reserved .reserved_movie_title span{width:26px; height:26px; line-height:26px; margin-right:5px; border-radius:50%; font-weight: 700; display:inline-block; font-size:11px; color:#fff; text-align:center;}
	 #reserved_choose3 .script_reserved .reserved_movie_title span.grade_0{background:#5BC77E;}
	 #reserved_choose3 .script_reserved .reserved_movie_title span.grade_12{background:#4DD6FF;}
	 #reserved_choose3 .script_reserved .reserved_movie_title span.grade_15{background:#FFC134;}
	 #reserved_choose3 .script_reserved .reserved_movie_title span.grade_18{background:#ED4C6B;}
    .script_reserved p {color:#ddd; font-size: 20px; font-weight: 700; padding: 30px;}
	.script_reserved ul {margin-top:20px; padding:0 30px;}
	.script_reserved ul li{color:#ddd; font-weight: 700; margin-bottom:10px;}

	#reserved_choose3 .script_payment{position: relative; background:#333; float: left; width: 30%; height:640px; box-sizing: border-box; padding:60px 15px 50px;}
	#reserved_choose3 .script_payment .title { position: absolute; left: 0; top:0; background: #5E5E5E; padding: 10px; color:#fff;}
	#reserved_choose3 .script_payment .choose_payment>ul>li {margin-bottom:35px; height:115px}
	#reserved_choose3 .script_payment .choose_payment ul li a {margin: 20px 0; background-color: #fff; text-decoration:none; color: #333; font-weight: 700; display: block; cursor: pointer; width:100px; height: 40px; line-height: 40px; text-align: center;}
	#reserved_choose3 .script_payment .choose_payment ul li a:hover {background:orange;}
	#reserved_choose3 .script_payment .choose_payment ul li div ul li {margin: 10px 5px 5px 0; color: whitesmoke; display: inline-block; width: 100px; height: 40px; line-height: 40px; text-align: center;}
	#reserved_choose3 .script_payment .choose_payment ul li div ul li a {margin:0;}
	#reserved_choose3 .script_payment .choose_payment ul li div ul li a:hover{ background: lightyellow;}
	
	#reserved_choose3 .script_payment .choose_payment>ul>li.active>a{background:orange;}
	#reserved_choose3 .script_payment .choose_payment>ul>li>div {display: none;}
	#reserved_choose3 .script_payment .choose_payment>ul>li.active>div {display: block;}
	    
	 .ticket_cost{ font-size: 20px; text-align: center; color:#ddd; font-weight: 700; margin-top: 20px;}
	
	.ticket_cost ul li {padding: 10px;}
	 .btns .move_step{margin-top: 30px; float: right;}
	 .btns .move_step button{ width: 100px; height: 35px; line-height: 35px; text-align: center; border-radius: 5px; border:0; font-size: 15px;}
	 .btns .move_step button:nth-child(2){background: orangered; font-weight: 700; color: white;}
	    
    </style>
    
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

    
<div class="layout">

    <div id="reserved">
        <div id="reserved_menu">
            <ul>
                <li>01. 영화선택</li>
                <li>02. 인원/좌석</li>
                <li>03. 결제</li>
                <li class="on">04. 결제완료</li>
            </ul>
        </div>

        <div id="reserved_choose3">
            <div class="script_movie">
                <div class="title">예매확인</div>
                <div class="reserved_poster">
                    <img src="${contextPath}/resources/images/${screenInfo.modifyName}" alt="" />
                </div>
            </div>
            <div class="script_reserved">
                <div class="reserved_movie">

                    <div class="reserved_movie_title">
                    	<span class="grade_${screenInfo.ageLimit}">
                        	${screenInfo.ageLimit==0 ? 'All':screenInfo.ageLimit}
                        </span>
                        <strong>${screenInfo.movieTitle}</strong>
                    </div>
                    <ul>
                        <li>예매번호 : ${reserveInfo.reservedNo} </li>
                        <li>상영일시 : <fmt:formatDate value="${screenInfo.screenDate}" pattern="yyyy/MM/dd HH:mm"/> </li>
                        <li>영화관 : ${screenInfo.theaterName}</li>
                        <li>인원: 
                        		<fmt:formatNumber value="${param.adultCount + param.youthCount + param.seniorCount + param.disabledCount}"/>명 </li>
                        <li>좌석:
                        	<jsp:include page="seatName.jsp"/>
                        </li>
                        
                    </ul>
                    <p>예매해주셔서 감사합니다. <br>
                        	즐거운 시간 되시기바랍니다.
                    </p>
                    <p>결제취소를 원하시는 경우, <br>
                       	 마이페이지를 이용해주십시오.</p>
                </div>
            </div>
            <div class="script_payment">
                <div class="title">결제확인</div>
                <div class="choose_payment">
                    
                </div>
                <div class="ticket_cost">
                    <ul>
                        <li>결제번호 : ${paymentInfo.paymentNo}</li>
                        <li>결제방식 : ${paymentInfo.type}</li>
                        <li>결제금액 : 
                        	<fmt:formatNumber value="${paymentInfo.amount}" pattern="#0,000"/>원
                        </li>

                    </ul>

                </div>
                <div class="btns">
                    <div class="move_step">
                        <button type="button" onclick="location.href='${contextPath}'">결제확인</button>
                    </div> 
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="/views/common/footer.jsp" %>
</body>
</html>