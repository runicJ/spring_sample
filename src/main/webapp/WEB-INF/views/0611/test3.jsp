<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test3.jsp</title>
  <jsp:include page="/WEB-INF/views/include/bs4.jsp" />
</head>
<body>
<p><br><p>
<div class="container">
	<h2>이곳은 test3.jsp 입니다.</h2>
	<hr>
	<p>
		아이디 : ${mid}<br>
		비밀번호 : ${pwd}<br>
		나이 : ${age}<br>
		성별 : ${gender}<br>
	</p>
	<hr>
	<p>
		<a href="${ctp}/0611/index" class="btn btn-primary">돌아가기</a>
	</p>
</div>
<p><br><p>
</body>
</html>