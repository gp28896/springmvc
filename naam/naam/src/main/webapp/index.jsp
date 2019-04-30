
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>sbeve</title>
	</head>
	<body>
		<a href="user/register.htm"><input type="submit" value="Sign Up"></a><br/><br><br>
		<h2>Login</h2>
		<form action="user/login" method="post">
			<input name="username" size="30" required="required" placeholder="username"/>
			<br>
			<input type="password" name="password" size="30" required="required" placeholder="password"/>
			<br>
			<input type="submit" value="Login" />
		</form>
	
	
	</body>
</html>
	
