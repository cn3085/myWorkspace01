<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/allCss.css">
</head>
<body>
    <%@ include file="Header.jsp" %>
	<h1>여기는 메인 페이지입니다.</h1>
	${id}
	${dto}			
			
</body>
</html>