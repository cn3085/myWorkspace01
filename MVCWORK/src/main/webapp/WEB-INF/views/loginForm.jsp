<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/allCss.css">
        ${msg}
</head>
<body>
	<%@ include file="Header.jsp" %>
	<form action="loginAction" method="post" >
	<section id="content">
        <h1>로그인</h1>
        <hr>
        <div>
	            <label for="email">아이디(이메일)</label>
	            <input type="text" id="email" name="email">
	            <label for="pwd">비밀번호</label>
	            <input type="password" id="password" name="password">
	            <input type="submit" value="로그인" id="submitBtn" style="display: block;">
        </div>
    </section>
    </form>
</body>
</html>