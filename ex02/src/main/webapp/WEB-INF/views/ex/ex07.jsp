<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EX07</title>
</head>
<body>
	<c:set var="total" value="${studentVO.kor+studentVO.eng+studentVO.math} "/>
	<c:set var="avg" value="${total/3}"/>
	<table border="1">
		<tr>
		<th>��ȣ</th>
		<th>����</th>
		<th>����</th>
		<th>����</th>
		<th>����</th>
		<th>���</th>
		</tr>
		<tr>
		<td><c:out value="${studentVO.num}"/> </td>
		<td><c:out value="${studentVO.kor}"/> </td>
		<td><c:out value="${studentVO.eng}"/> </td>
		<td><c:out value="${studentVO.math}"/> </td>
		<td><c:out value="${total}��"/> </td>
		<td><c:out value="${avg}��"/> </td>
		</tr>
	</table>
</body>
</html>