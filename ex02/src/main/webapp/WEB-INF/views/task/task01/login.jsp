<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그읜 페이지</title>
</head>
<body>
	<form action="/login" method="POST">
	<input type="text" name="id" placeholder="아이디를 입력하세요">
	<input type="password" name="pw" placeholder="패스워드를 입력하세요">
	<button>로그인</button>
	</form>
</body>
</html>