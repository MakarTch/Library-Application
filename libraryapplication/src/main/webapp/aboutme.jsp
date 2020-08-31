<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Me</title>
<link rel="stylesheet" href="librarystyle.css">
<link rel="icon" href="https://www.clipartmax.com/png/middle/155-1559319_learn-open-book-icon-vector.png">
</head>
<body>
<img src="libraryimage.jpg" alt="checkin_pic" width="69%" style=" display:block;margin-left:15.5%;">
<%out.println(session.getAttribute("pageHeader")); %>

<div class="content">

<h1>About me</h1>
<hr style="margin:5px">
<div style="float:left;width:100%;padding:10px;">
	  <img src="DSC04908 (2).JPG" alt="checkin_pic" style="width:50%;float:right;margin-left:20px;border-radius:5px" >

<p>Hi! My name is Makar, I hope you're enjoying the website so far. You can check out my code <a href="https://github.com/MakarTch/Library-Application/tree/master/libraryapplication/src/main" target="_blank">here</a> for the site. I am using MySQL, Java with Spring MVC, Spring Data JPA and Hibernate, HTML, CSS, and JavaScript, and I took the pictures in the home slideshow by myself as well!</p>
<p>I am a recent graduate of the Jump Program at Cognixia which was an intensive 10 week course geared towards creating full-stack Java developers. I am currently employed by Cognixia, but I am looking for a new role as a junior Java developer or full stack developer. If you have any questions or would like to reach out to me please don't hesitate to message me on <a href="https://www.linkedin.com/in/makar-tchekalenkov/" target="_blank">LinkedIn</a> or my email: Makar.Tchekalenkov@gmail.com. I hope you have a great day!</p>
<p>-Makar Tchekalenkov</p>
</div>

</div>
<%out.println(session.getAttribute("pageFooter"));%>
</body>
</html>