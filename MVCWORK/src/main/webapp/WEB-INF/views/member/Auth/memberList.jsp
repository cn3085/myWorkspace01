<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%-- <% List<OpDTO> list =(List<OpDTO>)request.getAttribute("list"); %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/allCss.css">
<style>
	table{
		width:500px;
	}
	
	
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>

	<%@ include file="../../Header.jsp" %> 
	<section id="content">
        <h1>Member List</h1>
        <hr>
        <div>
	        <table border="1">
	        	<thead>
		        	<tr>
						<th>아이디</th><th>패스워드</th><th>이름</th><th>관리</th>        	
		        	</tr>
	        	</thead>
	        	<tbody id="tableContent">
			        <c:forEach var="list" items="${list}" >
			        	<tr>
			        	<td><c:out value="${list.email}"/></td>
			        	<td><c:out value="${list.password}"/></td>
			        	<td><c:out value="${list.name}"/></td>
			        	<td><a href="#" class="edit">수정</a> / <a href="#" class="delete">삭제</a></td>
			        	</tr>
			        </c:forEach>
		        </tbody>
	        </table>
        </div>
    </section>
    
    <div id="pop" style="border: 1px solid black; width:210px; height: 200px; background-color: bisque; visibility: hidden; position: absolute; top: 100px; left: 100px;">
        <span style="float: right;" id="close">닫기</span>
        <br>
        <hr>
        <p>아이디 :<span></span></p>
        <label for="">비밀번호</label><input id="pwd" type="text" style="display: block;">
        <label for="">이름</label><input id="name" type="text" style="display: block;">
        <button id="editBtn">수정</button>
    </div>
    
    <script>
	    window.onload=function(){
	        $(document).on('click','.delete',Delete);
	        $(document).on('click','.edit',Edit);
	        $('#close').click(Close);
	        $('#editBtn').click(EditAction);
	        var email;
	    }
	    
	    function Edit(){
	        $('#pop').css("visibility","visible");
	        
	        email=$(this).parent().parent().children(':eq(0)').text();
	        
	        var pwd=$(this).parent().parent().children(':eq(1)').text();
	        var name=$(this).parent().parent().children(':eq(2)').text();
	        $('#pop>p>span').text(email);
	        $('#pwd').val(pwd);
	        $('#name').val(name);
	    }//edit끝
	    
	        
	    function Delete(){
			if(!confirm("해당 회원의 정보를 삭제하시겠습니까?")){
				return false;
			}else{
				email=$(this).parent().parent().children(':eq(0)').text();
				$.ajax({
					url : '/member/Auth/memberRemove',
					dataType : 'json'
					,type : 'get'
					,data: {email:email}
					,success : function(data) {
						console.log(data)
						$('#tableContent').empty();
						$.each(data, function(i, val) {
							console.log($(this))
							$('#tableContent').append(
									'<tr><td>'
											+val.email+ '</td><td>'
											+val.password+ '</td><td>'
											+val.name+ '</td>'
											+ '<td><a href="#" class="edit">수정</a> / <a href="#" class="delete">삭제</a></td>');
						})
					},
					error : function(data) {
						console.log('error')
					}
				})
			}
	    }//delete 끝
	    
	    function Close(){
	        $('#pop').css("visibility","hidden");
	    }
	    
	    function EditAction(){
	    	var password= $('#pwd').val();
	    	var name = $('#name').val();
	    	console.log("패수워드 : "+password);
	    	console.log("이름 : "+name);
	    	$.ajax({
				url : '/member/Auth/memberEdit',
				dataType : 'json'
				,data: {email:email, password:password, name:name}
				,success : function(data) {
					console.log(data)
					$('#tableContent').empty();
					$.each(data, function(i, val) {
						console.log($(this))
						$('#tableContent').append(
								'<tr><td>'
										+val.email+ '</td><td>'
										+val.password+ '</td><td>'
										+val.name+ '</td>'
										+ '<td><a href="#" class="edit">수정</a> / <a href="#" class="delete">삭제</a></td>');
					})
				},
				error : function(data) {
					console.log('error')
				}
			})
	    }
    </script>
</body>
</html>