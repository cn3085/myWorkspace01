<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/allCss.css">
</head>
<body>
	<%@ include file="../../Header.jsp" %>
	<section id="content">
        <h1>MyPage</h1>
        <hr>
        <div>
        		<div style="width:200px; height:200px"> <img alt="사진" src="/upload/${dto.photo}"></div>
	            <label for="email">아이디(이메일)</label>
	            <p>${dto.email}</p>
	            <label for="name">이름</label>
	            <p>${dto.name}</p>
	            ${pageContext.request.contextPath}
        </div>
    </section>
</body>
</html>