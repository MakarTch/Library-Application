<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Currently On Hold</title>
<link rel="stylesheet" href="librarystyle.css">
<link rel="icon" href="https://www.clipartmax.com/png/middle/155-1559319_learn-open-book-icon-vector.png">

</head>
<body>
<div class="navbar"></div>
<div class="content">
<%out.println(session.getAttribute("pageHeader")); %>

<h2> Check off the books when customer is <b style="color:red">in store</b> and ready to take the book(s)</h2>
<form action="/putonborrow">
${displayText }
<input type="submit" value="Put into Borrow">
</form>
</div>
</body>
</html>