<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
    src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
    crossorigin="anonymous"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            var payment = $('.choose_payment ul li'); 
            
            payment.find('>a').on('click', function(){
                payment.removeClass('active');
                $(this).parent().addClass('active');
            });
        });
      </script>

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
	 #reserved_choose3 .script_movie{ position:relative; background:#333; float: left; width: 30%; height:640px; border-right:1px solid #eee; box-sizing: border-box; padding:60px 0 50px;}
	 #reserved_choose3 .script_movie .title { position: absolute; left: 0; top:0; background: #5E5E5E; padding: 10px; color:#fff;}
	 #reserved_choose3 .script_movie .reserved_poster { width: 200px; height: 300px; background: lightpink; margin:0 auto;}
	 #reserved_choose3 .script_movie .reserved_poster > img { width: 100%; height: 100%;}
	 #reserved_choose3 .script_movie .reserved_movie_title { margin-top: 30px; color:#fff; padding:0 30px;}
	 #reserved_choose3 .script_movie .reserved_movie_title span{width:26px; height:26px; line-height:26px; margin-right:5px; border-radius:50%; font-weight: 700; display:inline-block; font-size:11px; color:#fff; text-align:center;}
	 #reserved_choose3 .script_movie .reserved_movie_title span.grade_0{background:#5BC77E;}
	 #reserved_choose3 .script_movie .reserved_movie_title span.grade_12{background:#4DD6FF;}
	 #reserved_choose3 .script_movie .reserved_movie_title span.grade_15{background:#FFC134;}
	 #reserved_choose3 .script_movie .reserved_movie_title span.grade_18{background:#ED4C6B;}
	 .reserved_movie ul{margin-top:20px; padding:0 30px;}
	 .reserved_movie ul li{color:#fff; font-weight: 700; margin-bottom:10px;}
	 .reserved_movie .seat_info { color:#fff; font-weight:700; font-size:20px; text-align:center;margin-top:30px;}
	
	#reserved_choose3 .script_payment{position: relative; background:#333; float: left; width: 70%; height:640px; box-sizing: border-box; padding:60px 15px 50px;}
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
	    
	 .ticket_cost{ font-size: 25px; text-align: center; color:#fff; font-weight: 700; margin-top:-60px;}
	 .ticket_cost p{ padding: 10px;}
	
	 .btns .move_step{margin-top: 30px; float: right;}
	 .btns .move_step button{ width: 100px; height: 35px; line-height: 35px; text-align: center; border-radius: 5px; border:0; font-size: 15px; margin-right: 100px;}
	    
	     
    </style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<c:set var="adultCount" value="${param.adult}"/>
	<c:set var="youthCount" value="${param.youth}"/>
	<c:set var="seniorCount" value="${param.senior}"/>
	<c:set var="disabledCount" value="${param.disabled}"/>
	<c:set var="totalCost" value="${param.totalCost}"/>
	

<div class="layout">

        <div id="reserved">
            <div id="reserved_menu">
                <ul>
                    <li>01. 영화선택</li>
                    <li>02. 인원/좌석</li>
                    <li class="on">03. 결제</li>
                    <li>04. 결제완료</li>
                </ul>
            </div>

            <div id="reserved_choose3">
                <div class="script_movie">
                    <div class="title">선택확인</div>
                    <div class="reserved_poster">
                        <img src="${contextPath}/resources/images/${screenInfo.modifyName}" alt="" />
                    </div>
                    <div class="reserved_movie">
                        <div class="reserved_movie_title">
                        <span class="grade_${screenInfo.ageLimit}">
                        	${screenInfo.ageLimit==0 ? 'All':screenInfo.ageLimit}
                        </span>
                        <strong>${screenInfo.movieTitle}</strong>
                        </div>
                        <ul>
                            <li>상영일시 : <fmt:formatDate value="${screenInfo.screenDate}" pattern="yyyy/MM/dd HH:mm"/></li>
                            <li>영화관 : ${screenInfo.theaterName}</li>
                            <li>인원: 
                            	<fmt:formatNumber value="${adultCount + youthCount + seniorCount + disabledCount}"/>명
                           	</li>
                        </ul>
                        <div class="seat_info"> 좌석: <jsp:include page="seatName.jsp"/>
                        </div>
                    </div>
                </div>
                <div class="script_payment">
                    <div class="title">결제수단</div>
                    <div class="choose_payment">
                        <ul>
                            <li><a>신용카드</a>
                                <div>
                                    <ul>
                                        <li><a href="#" onclick="payMethod(this)">신한카드</a></li>
                                        <li><a href="#" onclick="payMethod(this)">우리카드</a></li>
                                        <li><a href="#" onclick="payMethod(this)">국민카드</a></li>
                                        <li><a href="#" onclick="payMethod(this)">농협카드</a></li>
                                        <li><a href="#" onclick="payMethod(this)">삼성카드</a></li>
                                        <li><a href="#" onclick="payMethod(this)">기타카드</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li><a>간편결제</a>
                                <div>
                                    <ul>
                                        <li><a href="#" onclick="payMethod(this)">카카오페이</a></li>
                                        <li><a href="#" onclick="payMethod(this)">삼성페이</a></li>
                                        <li><a href="#" onclick="payMethod(this)">페이코</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li><a href="#" onclick="payMethod(this)">핸드폰</a></li>
                        </ul>
    
                    </div>

                    <div class="ticket_cost">
                    	<p> 결제 방식을 선택하여 주십시오.<br> </p>
                   		 <p> 총 금액 : 
                    		<fmt:formatNumber value="${totalCost}" pattern="#0,000"/>원
                    	</p>
                    </div>
                    <div class="btns">
                        <div class="move_step">
                            <button>&lt; prev</button>
                        </div> 
                    </div>
                </div>
                
            </div>

        </div>
    </div>

<form id="form" action="${contextPath}/reservedOne.do" role="form" method="post">
	<input type="hidden" name="adultCount" value="${adultCount}"/>
	<input type="hidden" name="youthCount" value="${youthCount}"/>
	<input type="hidden" name="seniorCount" value="${seniorCount}"/>
	<input type="hidden" name="disabledCount" value="${disabledCount}"/>"/>
	<input type="hidden" name="totalCost" value="${totalCost}"/>
	<input type="hidden" name="screenNo" value="${screenInfo.screenNo}"/>
	<c:forEach items="${seatNo}" var="s">
		<input type="hidden" name="seatNo" value="${s}"/>
	</c:forEach>
	<input type="hidden" name="payMethod" value=""/>
</form>


<script>
	var form = document.getElementById('form');
	
$(document).ready(function(){
	
	
	
});
	
	function payMethod(method){
		var method = $(method).text();
		if(confirm(method+"로 결제하시겠습니까?")){
			alert("결제완료!");
			form.payMethod.value = method;
			form.action = '${contextPath}/reservedSix.do';
			form.method = 'post';
			form.submit();
		}else{
			return alert("다시 선택해주십시오.");
		}
	}



</script>

<%@ include file="/views/common/footer.jsp" %>
</body>
</html>