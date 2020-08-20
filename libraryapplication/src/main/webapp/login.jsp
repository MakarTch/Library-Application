<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
<link rel="stylesheet" href="librarystyle.css">
</head>
<body>
<div class="navbar"></div>
<div class="content">
<%out.println(session.getAttribute("pageHeader")); %>

<form action="/userAccount">
	<label for="userId">User Id</label>
	<input type="number" name="userId" value=1 required><br>
	<label for="password">Password</label>
	<input type="password" name="userPassword" value="password" required><br>
	<input type="submit" value="Log In">
</form><br>
<form action="/adminAccount">
	<label for="adminId">Admin Id</label>
	<input type="number" name="adminId" value=1000 required><br>
	<label for="password">Password</label>
	<input type="password" name="adminPassword" value="password" required><br>
	<input type="submit" value="Log In">	
</form>
</div>
</body>
</html>