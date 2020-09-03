<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
<link rel="stylesheet" href="librarystyle.css">
<link rel="icon" href="https://www.clipartmax.com/png/middle/155-1559319_learn-open-book-icon-vector.png">

</head>
<body>
<img src="libraryimage.jpg" alt="checkin_pic" width="69%" style=" display:block;margin-left:15.5%;">
<%out.println(session.getAttribute("pageHeader")); %>
<div class="content">
<h1>Log In</h1>
<hr style="margin:5px">
<table style= "background-color:white">
<tr>
<td>
<form action="/userAccount" style= "padding:50px">
	<h2>User Login</h2>
	<label for="userId">User Id</label>
	<input type="number" name="userId" required><br>
	<label for="password">Password</label>
	<input type="password" name="userPassword" required><br>
	<input type="submit" value="Log In">
</form>
</td>
<td>
<form action="/adminAccount" style= "padding:50px; ">
	<h2>Admin Login</h2>
	<label for="adminId">Admin Id</label>
	<input type="number" name="adminId" required><br>
	<label for="password">Password</label>
	<input type="password" name="adminPassword" required><br>
	<input type="submit" value="Log In">
</form>
</td>
</tr>
</table>
<h2 style="color:red; text-align:center">Error logging in, please make sure your user id and password are correct</h2>

</div>
<%out.println(session.getAttribute("pageFooter"));%>

</body>
</html>