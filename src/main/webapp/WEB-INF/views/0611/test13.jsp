<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test13.jsp</title>
  <jsp:include page="/WEB-INF/views/include/bs4.jsp" />
  <script>
  	'use strict';
  	
  	function fCheck() {
  		let mid = document.getElementById("mid").value;
  		let pwd = document.getElementById("pwd").value;
  		
  		location.href = "${ctp}/0611/test13/"+mid+"/"+pwd;  // 변수니까 따당
  	}
  </script>
</head>
<body>
<p><br><p>
<div class="container">
	<form>  <!--  method="post"를 지워줌 => default가 GET이기 때문에 GET으로 감 => submit으로 하면 자기가 자기를 부르는 것 => 모순 -->
		<table class="table table-bordered">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid" id="mid" value="admin" class="form-control"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" id="pwd" value="1234" class="form-control"></td>
			</tr>
			<tr><td colspan="2" class="text-center">
				<input type="button" value="전송하기" onclick="fCheck()" class="btn btn-success">
				<input type="button" value="돌아가기" onclick="location.href='${ctp}/0611/index';" class="btn btn-warning">
			</td></tr>
		</table>
	</form>
	<hr>
</div>
<p><br><p>
</body>
</html>