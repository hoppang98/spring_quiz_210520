<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리 (1)</title>
</head>
<body>
	<h1>1. JSTL core 변수</h1>
	<c:set var="number1" value="36" />
	<c:set var="number2" value="3" />
	<strong>첫번째 숫자 : <c:out value="${number1}" /></strong><br>
	<strong>두번째 숫자 : <c:out value="${number2}" /></strong><br>
	
	<h1>JSTL core 연산</h1>
	<strong>
	더하기 : <c:out value="${number1 + number2}" /><br>
	빼기 : <c:out value="${number1 - number2}" /><br>
	곱하기 : <c:out value="${number1 * number2}" /><br>
	나누기 : <c:out value="${number1 / number2}" /><br>
	</strong>
	
	<h1>3. core out</h1>
	<c:out value="<title>core out</title>" /><br>
	
	<h1>4. core if</h1>
	<c:if test="${(number1 + number2 / 2) >= 10}">
		<h1><c:out value="${(number1 + number2) / 2}" /></h1>
	</c:if>
	<c:if test="${(number1 + number2 / 2) < 10}">
		<h3><c:out value="${(number1 / number2) / 2}" /></h3>
	</c:if>
	
	<h1>5. core if</h1>
	<c:set var="multi" value="${number1 * number2}" />
	<c:if test="${multi > 100}">
		<c:out value="<script>alert('너무 큰 수입니다.');</script>" escapeXml="false"/>
	</c:if>
</body> 
</html>