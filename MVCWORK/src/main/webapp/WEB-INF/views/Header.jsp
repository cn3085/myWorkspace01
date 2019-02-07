<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<header>
        <h1><a href="/">Open Project</a></h1>
        <div>
            <nav>
                <ul>
                	<c:set value="${sessionScope.id}" var="LoginStatus"/>
                    <c:choose>
	                    <c:when test="${LoginStatus == null }" >
	                    	<li><a href="memberJoinForm">회원가입</a></li>
	                    </c:when>
                    	<c:otherwise>
                    		<li style="color:DarkGrey;">회원가입</li>
                    	</c:otherwise>
                    </c:choose>
                    <c:choose>
                    	<c:when test="${LoginStatus == null }" >
                    		<li><a href="login">로그인</a></li>
                    	</c:when>
                    	<c:otherwise>
                    		<li><a href="logout" id="logOut">로그아웃</a></li>
                    	</c:otherwise>
                    </c:choose>
                    <li><a href="#">회원마이페이지(회원)</a></li>
                    <li><a href="#">회원리스트(회원)</a></li>
                </ul>
            </nav>
        </div>
    </header>
</body>
</html>