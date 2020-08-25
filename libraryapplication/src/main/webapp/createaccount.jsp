<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create an Account</title>
<link rel="stylesheet" href="librarystyle.css">
<link rel="icon" href="https://www.clipartmax.com/png/middle/155-1559319_learn-open-book-icon-vector.png">

</head>
<body>
<div class="navbar"></div>
<div class="content">
<%out.println(session.getAttribute("pageHeader")); %>

<form action="/createaccount">
<label for="firstName">First Name</label>
<input type="text"  name="firstName" autocomplete ="off" required><br>
<label for="lastName">Last Name</label>
<input type="text"  name="lastName" autocomplete ="off" required><br>
<label for="phoneNumber">Contact Number</label>
<input type="text"  name="phoneNumber" autocomplete ="off" required><br><!-- js here for input verification -->
<label for="email">Email</label>
<input type="text" name="email" autocomplete="off" required><br>
<label for="userPassword">Password</label>
<input type="password"  name="userPassword" autocomplete ="off" required><br><!-- js here for input verification -->
<input type="submit" value="Create Account!">
</form>
<h2>Please contact administrator for a new Admin account</h2>
</div>
<%out.println(session.getAttribute("pageFooter"));%>

</body>
</html>
