<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>This be that home page shit you already know</h1>

<a href="/aboutus.html">About Us</a>	<!-- Focus on this when doing front end -->
<a href="/location.html">Location</a>	<!-- Focus on this when doing front end -->
<a href="/catalog">Catalog</a>
<a href="/createaccount.html">Create an account</a>
<a href="/login.html">Log In</a>
<a href="/logout">Log out</a>

<p>${user.getUserId()}</p>
<p>${admin.getAdminId()}</p>

<!-- yeah so the tricky part is going to be changing the header of this page so that when I'm logged in , the log in button is out
and also vice versa, I know react can do some shit like that. 
 -->
</body>
</html>