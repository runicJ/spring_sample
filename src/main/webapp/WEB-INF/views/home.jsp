<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<%-- <%@ page session="false" %> --%>
<html>
<head>
	<title>Home</title>
  <jsp:include page="/WEB-INF/views/include/bs4.jsp" />
  <script>
  	'use strict';
  	
  	if('${msg}' != null && '${msg}' != '') alert("${msg}");
  </script>
</head>
<body>
<p><br><p>
<div class="container">
	<h1>	
		Hello world!
	</h1>	

	<P>  The time on the server is ${serverTime}. </P>
	<hr>
	<p>
	  <a href="${ctp}/0611/index" class="btn btn-success">index.jsp</a> |
	  <a href="${ctp}/logTest" class="btn btn-info">로그연습</a> |
	  <a href="${ctp}/aop/aopMenu" class="btn btn-primary">AOP연습</a> |
	</p>
</div>
</body>
</html>
