<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>index.jsp</title>
  <jsp:include page="/WEB-INF/views/include/bs4.jsp" />
  <script>
  	'use strict';
  	
  	function postCheck(no) {
  		if(no == 7) myform.action = "${ctp}/0611/test7";
  		else if(no == 8) myform.action = "${ctp}/0611/test8";  		
  		
  		myform.submit();
  	}
  </script>
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
		<a href="${ctp}/0611/test4?mid=lkj1234&pwd=1357&age=25&gender=3" class="btn btn-secondary">test4.jsp</a>
		<a href="${ctp}/0611/test5?mid=lkj1234&pwd=1357&age=25&gender=3" class="btn btn-danger">test5.jsp</a>
		<a href="${ctp}/0611/test6?mid=snm1234&pwd=1357&age=25&gender=4" class="btn btn-dark">test6.jsp</a>
	</p>
		<hr>
		<!-- <form name="myform" method="post" action=""> -->
		<form name="myform" method="post">
			<table class="table table-bordered">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mid" id="mid" value="admin" class="form-control" required></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd" id="pwd" value="1234" class="form-control" required></td>
				</tr>
				<tr>
					<th>성명</th>
					<td><input type="text" name="name" id="name" value="관리자" class="form-control" required></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input type="text" name="nName" id="nName" value="관리맨" class="form-control" required></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="number" name="age" id="age" value="22" class="form-control" required></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="strGender" id="gender1" value="남자" checked> 남자
						<input type="radio" name="strGender" id="gender2" class="ml-3" value="여자"> 여자
					</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
    	      <input type="button" value="test7.jsp" onclick="postCheck(7)" class="btn btn-outline-success"/>
    	      <input type="button" value="test8.jsp" onclick="postCheck(8)" class="btn btn-outline-primary"/>
    	    </td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="${ctp}/0611/test9" class="btn btn-light">test9.jsp</a>
		<a href="${ctp}/0611/test10" class="btn btn-outline-info">test10.jsp</a>
		<a href="${ctp}/0611/test11" class="btn btn-outline-secondary">test11.jsp</a>
		<hr>(path variable)  <!-- /값1/값2... (post방식 or 암호화,복호화해서 => https://) // ?변1=값1&변2=값2 -->
		<a href="${ctp}/0611/test12/atom1234/1234" class="btn btn-outline-warning">test12.jsp</a>  <!-- /atom1234 경로명 같지만 값임 최종경로는 test12 -->
		<a href="${ctp}/0611/test13" class="btn btn-outline-danger">test13.jsp</a>
		<a href="${ctp}/0611/test14" class="btn btn-outline-secondary">test14.jsp</a>
		<a href="${ctp}/0611/test15" class="btn btn-outline-dark">test15(메시지)</a>
		<hr>
		<a href="${ctp}/home" class="btn btn-primary">돌아가기</a>
</div>
<p><br><p>
</body>
</html>