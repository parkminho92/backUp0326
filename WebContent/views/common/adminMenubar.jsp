<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


</head>


<style>
    div{
        box-sizing: border-box;
        
        }

    #wrap{
        width: 1000px;
        height: 1000px;
    }
    #top{
        width: 100%;
        height: 60px;
        background-color: darkgray;
      
    }
    #mode{
        float: right;
        font-size: 20px;
    }

    #body{
        width: 100%;
        height: 88%;

    }
    #navbar{
        width: 200px;
        height: 700px;
        float: left;
        line-height: 80px;
        
    }

    .listBtn{
        width: 200px;
        height: 40px;
        border-radius: 10px;
        cursor: pointer;

    }
    .listBtn:hover{
        background-color: gray;
    }
    .menu{
        text-align: center;
        font-size: 15px;
        font-weight: bold;
        line-height: 50px;
        display: none;
        border-bottom: 1px solid gray;
        border-right: 1px solid gray;
        border-bottom-right-radius: 10px;
    }

    .menu label{
        cursor: pointer;
    }
   




</style>
<body>
  
       

    <div id="top">
         <div><img src="로고.png"width="60px;"><div id="mode">관리자 모드</div></div>
         
    </div>

 
            <script>
            
            
            
            	function goInsertMovie(){
            			location.href = "<%= request.getContextPath()%>/insertMovieForm.mv"
            			
            			}
            		
            	function goOnMovie(){
            			location.href = "<%=request.getContextPath()%>/listOnMovie.mv"
            			}
            	
            	function goComingMovie(){
            			location.href = "<%=request.getContextPath()%>/listComingMovie.mv"
            			}
            	
            	function goOffMovie(){
            			location.href = "<%=request.getContextPath()%>/listOffMovie.mv"
            			
            			}
            	
            	function goListTheater(){
            			location.href = "<%=request.getContextPath()%>/listTheater.ta"
            		
            	}
            	
            	function goInsertTheater(){
            			location.href = "<%=request.getContextPath()%>/InsertTheaterForm.ta"
            		
            	}
            
            
            </script>
            

        <div id="navbar">
            <button class="listBtn">영화관리</button>
            <div class="menu">
                <label onclick="goInsertMovie();">새영화등록</label><br>
                <label onclick="goOnMovie();">현재상영작</label><br>
                <label onclick="goComingMovie();">상영예정작</label><br>
                <label onclick="goOffMovie();">지난상영작</label>
            </div>
            
            <button class="listBtn">영화관 관리</button>
            <div class="menu">
                <label onclick="goListTheater();">영화관 목록</label><br>
                <label onclick="goInsertTheater();">영화관 등록</label><br> 
            </div>
            
            <button class="listBtn">회원관리</button>
            <div class="menu">
                <label>회원 리스트</label><br>
                <label>블랙 리스트</label><br>
                
            </div>
            
              <button class="listBtn">예매관리</button>
            <div class="menu">
                <label>예매내역확인</label><br>
               
            </div>
            <button class="listBtn">게시물관리</button>
            <div class="menu">
                <label>1:1 문의</label><br>
                <label>FAQ</label><br>
                <label>공지사항</label><br>
                <label>리뷰</label><br>
                <label>대관문의</label><br>
                <label>분실물관리</label><br>
                <label>광고관리</label>
            </div>
            <button class="listBtn">통계관리</button>
            <div class="menu">
                <label>방문자 통게</label><br>
                <label>장르별 영화예매 통계</label><br>
                <label>성별 영화 예매 통계</label><br>
                <label>나이별 영화 예매 통계</label><br>
                <label>매출 통계</label>
            </div>
            

        </div>

        <script>
 
        
            $(document).ready(function(){
                
                $(".listBtn").on("click",function(){
                    var m = $(this).next();


                    if(m.css("display")=="none"){
                        $(this).siblings(".menu").slideUp();
                        m.slideDown();

                    }else{
                        m.slideUp();
                    }


                });

                $("label").on("click",function(){
                    $(this).css("backgroundColor","gray").css("color","white");
                    $(this).siblings().css("backgroundColor","white").css("color","black");
                    

                });

            });


        </script>


      

        
     
   




   









    
</body>
</html>