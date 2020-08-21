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

Yeah its gonna be like what was I about to say, shit I was daydreaming. jeez.
this is gonna be easy, just a form, create an object, add it to the shit. interesting. ill
prolly end up using thymeleaf for this. it looks really simple. yeah tracking the session of the user vs admin
might be a bit a lot. not crazy bad tho. I just have to display the user/admin name on the top right to replace the login/
create account button. this is gonna be interesting. 
<h3>Enter your new account info</h3>
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
</body>
</html>
