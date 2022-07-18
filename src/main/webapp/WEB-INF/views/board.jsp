<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>fastcampus</title>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<div id="menu">
	<ul>
	    <li id="logo">fastcampus</li>
	    <li><a href="<c:url value='/'/>">Home</a></li>
	    <li><a href="<c:url value='/board/list'/>">Board</a></li>
	    <li><a href="<c:url value='/login/login'/>">login</a></li>    
	    <li><a href="<c:url value='/register/add'/>">Sign in</a></li>
	    <li><a href=""><i class="fas fa-search small"></i></a></li>
	</ul> 
</div>
<div>

    <h2>게시물 ${mode == "new" ? "글쓰기" : "읽기"}</h2>
    <form action="" id="form">
        <input type="hidden" name="bno"  value="${boardDto.bno}" >
        <input type="text" name="title" value="${boardDto.title}" ${mode =="new" ? "" : 'readonly="readonly"'}>
        <textarea name="content" id="" cols="30" rows="30" ${mode =="new" ? "" : 'readonly="readonly"'} >${boardDto.content}</textarea>
        <butoon type="butoon" id="writeBtn" class="btn">등록</butoon>
        <butoon type="butoon" id="modifyBtn" class="btn">수정</butoon>
        <butoon type="butoon" id="removeBtn" class="btn">삭제</butoon>
        <butoon type="butoon" id="listBtn" class="btn">목록</butoon>

    </form>
</div>
<script type="text/javascript">

var msg = "${msg}";

if(msg == "WRT_ERR"){
	alert("게시물 등록에 실패했습니다.");
}

$(document).ready(function(){ // main()
    $("#listBtn").on("click", function(){
    	alert("listBtn click");
        location.href="<c:url value='/board/list?page=${page}&pageSize=${pageSize}'/>";
    });
    
    
     
     $("#removeBtn").on("click", function(){
     	alert("removeBtn click");
     	if(!confirm("정말로 삭제하시겠습니까?")) return;
     	var form = $('#form');
       	form.attr("action","<c:url value='/board/remove'/>?page=${page}&pageSize=${pageSize}");
    	form.attr("method","post");
    	form.submit(); 
     });
     
     $("#writeBtn").on("click", function(){
      	alert("writeBtn click");
      	var form = $('#form');
        form.attr("action","<c:url value='/board/write'/>");
     	form.attr("method","post");
     	form.submit(); 
      });
     
     $("#modifyBtn").on("click", function(){
       	alert("modifyBtn click");
       	//1.읽기 상태이면 수정상태로 변경
        var form = $('#form');
        var isReadOnly = $("input[name=title]").attr('readonly');
        
        if(isReadOnly == 'readonly'){
        	$("input[name=title]").attr("readonly",false);
        	$("textarea").attr('readonly',false);
        	$("h2").html("게시글 수정");
        	return;
        	
        }
       	
       	//2.수정 상태이면 수정된 내용 서버로 전송
        form.attr("action","<c:url value='/board/modify'/>");
      	form.attr("method","post");
      	form.submit(); 
       });
	 
     
});

</script>

</body>
</html>