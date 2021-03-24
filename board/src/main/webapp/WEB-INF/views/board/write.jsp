<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
<body>

<form method="post">

<label>제목</label>
<input type="text" name="title" /><br>

<label>작성자</label>
<input type="text" name="writer" /><br>

<label>내용</label>
<textarea rows="5" cols="50" name="content"></textarea><br>

<button type="submit">작성</button>

</form>

</body>
</html>