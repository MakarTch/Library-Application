<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Put on Hold!</title>
<link rel="stylesheet" href="librarystyle.css">
</head>
<body>
<div class="navbar"></div>
<div class="content">
<%out.println(session.getAttribute("pageHeader")); %>

<h1>Your ${books} been put on hold!</h1>

</div>
</body>
</html>