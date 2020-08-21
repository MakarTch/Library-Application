<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
<link rel="stylesheet" href="librarystyle.css">
<link rel="icon" href="https://www.clipartmax.com/png/middle/155-1559319_learn-open-book-icon-vector.png">

</head>
<body>
<div class="navbar"></div>
<div class="content">
<%out.println(session.getAttribute("pageHeader")); %>
<table style= "background-color:white">
<tr>
<td>
<form action="/userAccount" style= "padding:50px">
	<h2>User Login</h2>
	<label for="userId">User Id</label>
	<input type="number" name="userId" value=1 required><br>
	<label for="password">Password</label>
	<input type="password" name="userPassword" value="password" required><br>
	<input type="submit" value="Log In">
</form>
</td>
<td>
<form action="/adminAccount" style= "padding:50px; ">
	<h2>Admin Login</h2>
	<label for="adminId">Admin Id</label>
	<input type="number" name="adminId" value=1000 required><br>
	<label for="password">Password</label>
	<input type="password" name="adminPassword" value="password" required><br>
	<input type="submit" value="Log In">
</form>
</td>
</tr>
</table>
</div>
</body>
</html>