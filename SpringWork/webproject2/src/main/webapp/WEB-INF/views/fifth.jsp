<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	좋아하는 등장인물<br>
	<c:forEach var="i" items="${SOLO}">
		${i}<br>
	</c:forEach>
	
	<br><br>
	좋아하는 과일 : ${f1}, ${f2}, ${f3}
	<br><br>
	좋아하는 요일 : ${day[0]}, ${day[1]}, ${day[2]}
</html>