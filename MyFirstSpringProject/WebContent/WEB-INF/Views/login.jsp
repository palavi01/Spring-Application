<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="ov" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri='/WEB-INF/c.tld' prefix='c' %>
<%@ taglib uri='/WEB-INF/fmt.tld' prefix='fmt' %>
<%@ taglib uri='/WEB-INF/spring.tld' prefix='spring' %>
<%@ taglib uri='/WEB-INF/spring-form.tld' prefix='form' %>
<%@ taglib uri='/WEB-INF/tiles-jsp.tld' prefix='tiles' %>
<title>Login Page</title>
</head>
<body>
	<form:form action ="login" method ="post" commandName ="loginForm">
		<table align ="center">
			<tr>
				<td>User Name</td>
				<td><form:input path="username" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><form:password path="password" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Login"></td>
			</tr>
			<tr>
				<td><a href="<ov:url value="/registerdummylink"/>">New user!!!Sign Up Here</a></td>
			</tr>
			<tr>
				<td><a href="<ov:url value="/forgotpassworddummylink"/>">Forgot Password???</a><br /></td>
			</tr>

		</table>


	</form:form>
</body>
</html>