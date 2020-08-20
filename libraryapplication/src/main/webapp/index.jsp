<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>This be that home page you already know</h1>
<h5>for all, no change ( only change in header)</h5>
<a href="/aboutus.html">About Us</a>	<!-- Focus on this when doing front end -->
<a href="/location.html">Location</a>	<!-- Focus on this when doing front end -->
<h5>For all, no form for admins and non users</h5>
<a href="/catalog">Catalog</a>
<h5>Only for non users</h5>
<a href="/createaccount.html">Create an account</a>
<a href="/login.html">Log in</a>
<h5>Only for users and admins</h5>
<a href="/logout">Log out</a><br><!-- Yeah I for sure have to figure out how to change the navbar using React -->
<h5>Only for admins</h5>
<a href="/currentlyonhold">Currently on hold</a>
<a href="/currentlyborrowed">Currently borrowed</a>
<p>${user.getUserId()}</p>
<p>${admin.getAdminId()}</p>
<div id="root1"></div>


<!-- yeah so the tricky part is going to be changing the header of this page so that when I'm logged in , the log in button is out
and also vice versa, I know react can do some shit like that. 

yeah so only show the catalog to people who are logged in?

I need to also fuck i forgot, oh yeah, have a account info link that shows where the user has book on hold and what books are due to be return and shit,
interesting actually yeah
 -->
<script>
document.getElementById("root1").innerHTML="Check it out"

</script>
</body>
</html>