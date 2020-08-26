<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Currently Borrowed</title>
<link rel="stylesheet" href="librarystyle.css">
<link rel="icon" href="https://www.clipartmax.com/png/middle/155-1559319_learn-open-book-icon-vector.png">

</head>
<body>
<img src="libraryimage.jpg" alt="checkin_pic" width="69%" style=" display:block;margin-left:15.5%;">
<%out.println(session.getAttribute("pageHeader")); %>
<div class="content">
<h1>Currently Borrowed</h1>
<hr style="margin:5px">
<p> Check off the books and press submit when customer is <b style="color:red">in store</b> and ready to return the book(s)</p>
<form action="/putoffborrow">
${displayText}
<input type="submit" value="Submit">
</form>
</div>
<%out.println(session.getAttribute("pageFooter"));%>

</body>
</html>