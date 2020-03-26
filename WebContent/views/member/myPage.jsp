<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
    
    
body {
  color: #666;
  background: #f5f6f7;
}   
#jb-container {
  width: 1000px;
  height: 900px;
  margin: 0px auto;
  margin-top:30px;
  padding: 20px;
  border: none;
}
#jb-header {
  padding: 20px;
  margin-bottom: 20px;
  border: 1px solid #bcbcbc;
  height:100px;
}
#jb-content {
  width: 500px;
  padding: 20px;
  margin-bottom: 70px;
  float: left;
  border: 1px solid #bcbcbc;
  height:300px;
  margin-top:40px;
}
#jb-sidebar {
  width: 350px;
  padding: 20px;
  margin-bottom: 70px;
  float: right;
  border: 1px solid #bcbcbc;
  height:300px;
  margin-top:40px;
}
#jb-sidebar h2 {
  margin-top: -10px;
  text-align: center;
}
#jb-sidebar h3 {
  text-align: center;
}
#jb-content h2 {
  margin-top: -10px;
  text-align: center;
}
#jb-content h3 {
  text-align: center;
}
#jb-footer {
  clear: both;
  padding: 20px;
  text-align: center;
}
#pick {
  width: 170px;
  height: 280px;
  float: left;
  cursor: pointer;
}
#watched {
  width: 170px;
  height: 280px;
  float: right;
  cursor: pointer;
}
#bookpicture {
  width: 240px;
  height: 240px;
  float: left;
}
#bookdetail {
  width: 240px;
  height: 240px;
  float: right;
}
</style>
</head>
<body>

	<%@ include file="../common/myPagebar.jsp"%>



  <div id="jb-container">
        <div id="jb-header">
          <h1>환영합니다!</h1>
        </div>
        <div id="jb-content" style="text-align: center;">
          <h2>예약정보</h2>
          <hr>
            <div id="bookpicture" onclick="location.href='#';">
              <h3>영화명</h3>
            </div>
            <div id="bookdetail" onclick="location.href='#';">
              <h3>예약정보</h3>
            </div>
            <button id="bookmore" style="margin-top:1%;" onclick="location.href='#';">더보기</button>
        </div>
        <div id="jb-sidebar">
          <h2>My 영화</h2>
          <hr>
            <div id="pick" onclick="location.href='pickMovie.do'">
              <h3>내가 찜한 영화</h3>
            </div>
            <div id="watched" onclick="location.href='watchedMovie.do'">
              <h3>내가 본 영화</h3>
            </div>
        </div>

        <div id=jb-footer>
        <div class="question">
	        <table class="question_tb">
	    		<thead>
		    		<h2><span>1:1 문의</span></h2>
		    			<hr>	
			    			<tr>
			        			<th width="650">제목</th>
			        			<th width="150">등록일</th>
			        			<th width="150">상태</th>
			    			</tr>
			    			<tr>
			        			<td width="650">테스트</td>
			        			<td width="150">2020-02-22</td>
			        			<td width="150">처리중</td>
			    			</tr>
	    		</thead>
	  		</table>
	    		<button id="Question_more" type="submit">더보기</button>
	  		</div>
  		</div>
      </div>
</body>
</html> 