<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<c:url value='/finalproject/board/write'/>">글쓰기</a>
	<h1>글쓰기</h1>
	<form>
		제목 : <input type="text" name="bTitle"/><br><br>
		글쓴이 : <input type="text" name="bWriter"/><br><br>
		내용 : <textarea rows="5" cols="50" name="bContent"></textarea><br><br>
		<input type = "submit" value="글쓰기"/>
	</form>
</body>
</html>