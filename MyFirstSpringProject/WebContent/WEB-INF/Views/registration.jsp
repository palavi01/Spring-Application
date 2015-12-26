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
<title>Registration Page</title>
</head>
<script type="text/javascript">
	$(document).ready(function() 
	{
		$('#phone').hide();
		$('#roll').hide();
		$('#t_id').hide();
		$('#s_id').hide();
		$('#username').val('');
		$('#password').val('');
		$('#name').val('');
		$('#phone1').val('');
		$('#roll1').val('');
		$('#teacher_id').val(0);
		$('#student_id').val(0);
	});

	function reg_type(type) 
	{
		if(type == 'teacher')
		{
			$('#phone').show();
			$('#roll').hide();
			$('#t_id').hide();
			$('#s_id').show();
			$('#roll1').val('');
			$('#teacher_id').val(0);
			$('#username').val('');
			$('#password').val('');
			$('#name').val('');
		}
		else if(type == 'student')
		{
			$('#phone').hide();
			$('#roll').show();
			$('#t_id').show();
			$('#s_id').hide();
			$('#student_id').val(0);
			$('#phone1').val('');
			$('#username').val('');
			$('#password').val('');
			$('#name').val('');
		}
	}
</script>
<body>
	<form:form action="register" method="post" commandName="registerForm">
		<table align="center">
			<tr>
				<td><input type="radio" name="type" value="teacher"
					onclick="reg_type('teacher')">Teacher</td>
				<td><input type="radio" name="type" value="student"
					onclick="reg_type('student')">Student</td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><form:input path="username" id="username"/></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><form:password path="password" id="password"/></td>
			</tr>

			<tr>
				<td>Name</td>
				<td><form:input path="name" id="name"/></td>
			</tr>

			<tr id ="phone">
				<td>Phone Number</td>
				<td><form:input path="phone_number" id="phone1"/></td>
			</tr>

			<tr id ="roll">
				<td>Roll Number</td>
				<td><form:input path="roll" id="roll1"/></td>
			</tr>
			<tr id ="t_id">
				<td>Please Select Teacher</td>
				<td><select name="teacher_id" id="teacher_id">
					<option value="0">------- Select --------</option>
						<option value="1">Teacher1</option>
						<option value="2">Teacher2</option>
						<option value="3">Teacher3</option>
						<option value="4">Teacher4</option>
				</select></td>
			</tr>
			<tr id ="s_id">
				<td>Please Select Student</td>
				<td><select name="student_id" id ="student_id">
						<option value="0">------- Select --------</option>
						<option value="1">Student1</option>
						<option value="2">Student2</option>
						<option value="3">Student3</option>
						<option value="4">Student4</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Sign Up"></td>
			</tr>
		</table>


	</form:form>
</body>
</html>