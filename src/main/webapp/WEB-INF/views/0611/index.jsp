<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>index.jsp</title>
  <jsp:include page="/WEB-INF/views/include/bs4.jsp" />
</head>
<body>
<p><br><p>
<div class="container">
	<h2>index.jsp</h2>
	<hr>
	<p>
		넘어온 값 : ${data}
	</p>
	<p>
		<a href="${ctp}/0611/test1?mid=hkd1234&pwd=1234" class="btn btn-success">test1.jsp</a>  <!-- get방식 쿼리스트링 -->	
		<a href="${ctp}/0611/test2?mid=kms1234&pwd=4321&age=21&gender=1" class="btn btn-info">test2.jsp</a>	
		<a href="${ctp}/0611/test3?mid=kms1234&pwd=4321&age=21" class="btn btn-warning">test3.jsp</a>	<!-- 값이 안넘어가도 null값 처리 -->
		<a href="${ctp}/0611/test4?mid=lkj1234&pwd=1357&age=25&gender=3" class="btn btn-secondary">test4.jsp</a>	<!-- 값이 안넘어가도 null값 처리 -->
		<a href="${ctp}/0611/test5?mid=lkj1234&pwd=1357&age=25&gender=3" class="btn btn-danger">test5.jsp</a>	<!-- 값이 안넘어가도 null값 처리 -->
		<a href="${ctp}/home" class="btn btn-primary">돌아가기</a>
	</p>
</div>
<p><br><p>
</body>
</html>