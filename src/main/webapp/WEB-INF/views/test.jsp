<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
    <h2>comment test</h2>
    <button id="sendBtn" type="button">SEND</button>
    <h2>Data From Server :</h2>
    <div id="commentList">EEE</div>
    <script>
    	let bno = 223;
    	let showList = function(){
                $.ajax({
                    type:'GET',       // 요청 메서드
                    url: '/ch4/comments?bno='+bno,  // 요청 URI
                    success : function(result){
							$("#commentList").html(result.bno); 
                        $("#commentList").html(result.bno);    // 서버로부터 응답이 도착하면 호출될 함수
                        alert("received="+result);       // result는 서버가 전송한 데이터
                    },
                    error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
                }); // $.ajax()
    		
    		
    	}
        $(document).ready(function(){
            $("#sendBtn").click(function(){
            	showList(bno);
                alert("the request is sent")
            });
        });
        
        
    </script>
</body>
</html>