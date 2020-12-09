<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 목록</title>
<c:set var="path" value="${pageContext.request.contextPath}" />
</head>
<body>
	<h2>회원 목록</h2>
	<table border="1" width="800">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일자</th>
		</tr>

		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.userId}</td>
				<td><a href="${path}/member/view.do?userId=${row.userId}">
						${row.userName } </a></td>
				<td>${row.userEmail}</td>
				<td>${row.userRegdate}</td>

			</tr>

		</c:forEach>

	</table>
</body>
</html>