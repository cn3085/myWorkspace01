<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/allCss.css">
</head>
<body>
	<%@ include file="Header.jsp" %>
	<form action="memberJoin" method="post" >
	<section id="content">
        <h1>회원가입</h1>
        <hr>
        <div>
	            <label for="email">아이디(이메일)</label>
	            <input type="email" id="email" name="email">
	            <label for="password">비밀번호</label>
	            <input type="password" id="password" name="password">
	            <label for="name">이름</label>
	            <input type="text" id="name" name="name">
	            <label for="photo">사진</label>
	            <input type="file" id="photo">
	            <input type="submit" value="등록" id="submitBtn" style="display: block;">
        </div>
    </section>
    </form>
</body>
</html>