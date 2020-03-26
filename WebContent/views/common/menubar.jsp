<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*,
				com.kh.member.model.vo.Member, 
				com.kh.menubar.controller.SectionDto, 
				com.kh.menubar.controller.TheaterDto, 
				com.kh.section.model.dao.SectionFlatDto, 
				com.kh.section.model.service.SectionService" %>
<% 
	String contextPath = request.getContextPath();
	Member loginUser = (Member)session.getAttribute("loginUser");
	
	// Flat DTO로 조회 
	List<SectionFlatDto> sectionFlat = new SectionService().selectSectionDto();
	
	Map<Integer, SectionDto> sectionMap = new HashMap<>();
	// 데이터 변환
	for(SectionFlatDto flatDto: sectionFlat) {
		SectionDto sectionDto  = null;
		if (sectionMap.get(flatDto.getSectionNo()) == null) {
			// 처음 생성 하는 지역
			sectionDto = new SectionDto(flatDto.getSectionNo(), flatDto.getSectionName());
			sectionMap.put(flatDto.getSectionNo(), sectionDto);
		} else {
			// 이미 생성된 지역
			sectionDto = sectionMap.get(flatDto.getSectionNo());
		}
		TheaterDto theaterDto = new TheaterDto(flatDto.getTheaterNo(), flatDto.getTheaterName());
		sectionDto.addTheaterDto(theaterDto);
	}
	List<SectionDto> sections = new ArrayList<>(sectionMap.values());
	
	
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menubar.jsp</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css">
<script src="${contextPath}/resources/js/jquery-1.11.2.min.js"></script>
<script src="${contextPath}/resources/js/common.js"></script>
<style>

/*레이아웃*/
#wrap{min-width:1200px;}
/*헤더*/
#header {position: relative; height:114px; border-bottom:1px solid #eee;}
#header .logo{ position: absolute; z-index: 3; top: 12px;  left: 50%; margin-left: -109px; text-indent: -9999em; background: url(<%= contextPath%>/resources/images/p_logo.png) no-repeat center center;background-size:100% auto;}
#header .logo{ display:block; width:219px; height:67px;}
#header .logo a { display:block;}
#header .gnb{position: relative; width: 1300px; height: 70px;  margin: 0 auto; border-bottom: 1px solid #B2B2B2;}
#header .gnb > ul {margin-top:40px;}
#header .gnb > ul:after {content:""; display:block; clear:both;}
#header .gnb > ul > li {float:left;}
#header .gnb > ul > li > a {display:block; font-size:12px; color:#656565;}

#header .gnb .g_menu {float:right;}
#header .gnb .g_menu > li {margin-left:14px;}

#header #nav{width:1000px; margin:3px auto 0; text-align: center;}
#nav>ul>li{display:inline-block; vertical-align: top; margin: 0 30px;}
#nav>ul>li>a{display:block; position: relative; height:40px; line-height:40px; padding:0 24px; font-size:14px; letter-spacing: 0.1em; white-space: nowrap;}
#nav>ul>li>ul{display:none; position: absolute; z-index:2; left:0; right:0; top:114px; height:38px; text-align: center; background-color:#f8f8f8;}
#nav>ul>li>ul>li{display:inline-block; margin:0 10px;}
#nav>ul>li>ul>li>a{display:block; height:38px; line-height:38px; padding:0 5px; color:#666;}
#nav>ul>li>ul>li>ul{display:none; position: absolute; z-index:2; left:0; right:0; top:38px;padding:10px 0; text-align: center; background-color: #000; opacity: 0.7;}
#nav>ul>li>ul>li>ul>li{display:inline-block; margin:0 5px;}
#nav>ul>li>ul>li>ul>li>a{display:block; color:#fff; height:18px; line-height:18px; padding:0 5px;}

</style>
</head>
<body id="main">
	<div id="wrap">
		<!--헤더 S-->
		<div id="header">
			<h1 class="logo"><a href="${contextPath}">Pictures</a></h1>
			<div class="gnb">
				<ul class="g_menu">
				<% if(loginUser == null){ %>
				<!-- 회원가입/로그인 버튼 -->
					<li><a href="#">회원가입</a></li>
					<li><a href="#">로그인</a></li>
				<%} else{ %>
				<!-- 관리자페이지 버튼 -->
				<% if(loginUser.getId().equals("admin")){ %>
					<li><a href="#">관리자</a></li>
				<%} %>
				<!-- 마이페이지/로그아웃 버튼 -->
					<li><a href="#">마이페이지</a></li>
					<li><a href="#">로그아웃</a></li>
				<%} %>
				</ul>
			</div>
			<div id="nav">
				<ul>
					<li>
						<a href="${contextPath}/reservedOne.do">예매</a>
					</li>
					<li>
						<a href="#">영화</a>
						<ul>
							<li>
								<a href="#">영화순위</a>
							</li>
							<li>
								<a href="#">상영작</a>
							</li>
							<li>
								<a href="#">할인안내</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#">영화관</a>
						<ul>
							<% for(SectionDto section : sections){ %>
								<li>
									<a> <%= section.getSectionName() %></a>
									<ul>
										<% for(TheaterDto theater : section.getTheaters()){%>
										<li>
											<a onclick="theaterDetail('<%= theater.getTheaterNo() %>');"><%= theater.getTheaterName() %></a>
										</li>
										<% } %>
									</ul>
								</li>
							<% } %>
						</ul>
					</li>
					<li>
						<a href="#">고객센터</a>
						<ul>
							<li>
								<a href="#">공지사항</a>
							</li>
							<li>
								<a href="#">FAQ</a>
							</li>
							<li>
								<a href="#">일대일문의</a>
							</li>
							<li>
								<a href="#">대관문의</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
		<!--헤더 E-->

	</div>
<form id="theaterDetail" action="<%=contextPath%>/detailView.th" method="post">
	<input type="hidden" name="theaterNo"/>
</form>

<script>
	function theaterDetail(no){
		var form = document.getElementById("theaterDetail");
		form.theaterNo.value = no;
		form.method="post";
		form.submit();
	};
</script>
</body>
</html>