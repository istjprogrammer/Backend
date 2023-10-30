<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 리스트</h1>
	<a href="<c:url value='/board/write'/>">글쓰기</a>
	<br><br>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>등록자</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>
	<c:forEach var="board" items="${list}">
		<tr>
			<td>${board.bNo}</td>
			<td><a href="<c:url value='/board/read?bNo=${board.bNo}'/>">${board.bTitle}</a></td>
			<td>${board.bWriter}</td>
			<td>${board.bRegdate}</td>
			<td>${board.bViewcnt}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>