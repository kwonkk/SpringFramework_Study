<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>적용된 항목</title>
</head>
<body>
	<table border="1" style="margin: 0 auto">
		<tr>
			<th>상품 번호</th>
			<th>상품명</th>
			<th>상품 원가</th>
			<th>상품 가격</th>
			<th>적용된 할인률</th>
		</tr>
		<tr>
			<td><c:out value="${product.productNumber}"/></td>
			<td><c:out value="${product.productName}"/></td>
			<td><c:out value="${originPrice}원"/></td>
			<td><c:out value="${product.productPrice}원"/></td>
			<td><c:out value="${product.discountRate}%"/></td>
		</tr>
	</table>
</body>
</html>