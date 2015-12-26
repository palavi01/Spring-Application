<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='/WEB-INF/c.tld' prefix='c'%>
<%@ taglib uri='/WEB-INF/fmt.tld' prefix='fmt'%>
<%@ taglib uri='/WEB-INF/spring.tld' prefix='spring'%>
<%@ taglib uri='/WEB-INF/spring-form.tld' prefix='form'%>
<%@ taglib uri='/WEB-INF/tiles-jsp.tld' prefix='tiles'%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//System.out.println("BasePath = "+basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="ov" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<title>Forgot Password Page</title>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		$('#phone').hide();
		$('#roll').hide();
		
	});

	function reg_type(type) {
		if (type == 'teacher') {
			$('#phone').show();
			$('#roll').hide();
		
		} else if (type == 'student') {
			$('#phone').hide();
			$('#roll').show();
			
		}
	}
</script>
<body>
	<form:form action="forgotpassword" method="post" commandName="forgotPasswordForm">
		<table align="center">
			<tr>
				<td><input type="radio" name="type" value="teacher"
					onclick="reg_type('teacher')">Teacher</td>
				<td><input type="radio" name="type" value="student"
					onclick="reg_type('student')">Student</td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><form:input path="username" /></td>
			</tr>

			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>

			<tr id="phone">
				<td>Phone Number</td>
				<td><form:input path="phone_number" /></td>
			</tr>

			<tr id="roll">
				<td>Roll Number</td>
				<td><form:input path="roll" /></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Forgot Password"></td>
			</tr>
		</table>


	</form:form>
</body>
</html>