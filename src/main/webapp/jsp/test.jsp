<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Hello World</p>
<c:url value="/img/jkljl.png"/>
	<c:forEach var="a" items="${vsadgsdgfds}">
		<li>
			<div class="items__info">
				<div class="pdname">
					<a>${a.productName}</a>
				</div>
				<ul class="size">
					<c:forEach var="sizeName" items="${a.size}">
						<li><a><span>${sizeName}</span></a></li>
					</c:forEach>
				</ul>
				<ul class="size">
					<c:forEach var="colorName" items="${a.colors}">
						<li><a><span>${colorName}</span></a></li>
					</c:forEach>
				</ul>	
			</div>
		</li>
	</c:forEach>




</body>
</html>