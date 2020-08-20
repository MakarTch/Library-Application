<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Catalog</title>
<link rel="stylesheet" href="librarystyle.css">
</head>
<body>
<div class="navbar"></div>
<div class="content">
<form action="/putonhold">
<%out.println(session.getAttribute("pageHeader")); %>
${displayText}
<input type="submit" value="Put on Hold!">
</form>
</div>
</body>
</html>
<!-- oh snap imma have to make it a thing not to show the submit button if the user isnt logged in, or just not let them see the catalog
argh also they can't put on hold a book that they already have on hold
shit I also gotta subtract 1 from the book in the books table
Also stop people from submitting if they havent selected anything -->