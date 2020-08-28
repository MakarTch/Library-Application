<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create an Account</title>
<link rel="stylesheet" href="librarystyle.css">
<link rel="icon" href="https://www.clipartmax.com/png/middle/155-1559319_learn-open-book-icon-vector.png">

</head>
<body>
<img src="libraryimage.jpg" alt="checkin_pic" width="69%" style=" display:block;margin-left:15.5%;">
<%out.println(session.getAttribute("pageHeader")); %>
<div class="content">
<h1>Create an Account</h1>
<hr style="margin:5px">
<div style=" display:block; text-align:center;margin-top:10px"> 
<form action="/createaccount" style="display: inline-block; margin-left: auto; margin-right: auto;text-align:left;">
<label for="firstName">First Name</label>
<input type="text"  name="firstName" autocomplete ="off" required><br>
<label for="lastName">Last Name</label>
<input type="text"  name="lastName" autocomplete ="off" required><br>
<label for="phoneNumber">Contact Number</label>
<input type="text"  name="phoneNumber" autocomplete ="off" required><br>
<label for="email">Email</label>
<input type="text" name="email" autocomplete="off" required><br>
<label for="userPassword">Password</label>
<input type="password"  name="userPassword" autocomplete ="off" required><br>
<input type="submit" value="Create Account!">
 </form>
</div>
<h2>Please contact administrator for a new Admin account</h2>
</div>
<%out.println(session.getAttribute("pageFooter"));%>

</body>
</html>
