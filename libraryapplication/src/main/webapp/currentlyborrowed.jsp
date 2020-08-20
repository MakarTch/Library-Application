<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Currently Borrowed</title>
<link rel="stylesheet" href="librarystyle.css">
</head>
<body>
<div class="navbar"></div>
<div class="content">
<%out.println(session.getAttribute("pageHeader")); %>

<form action="/putoffborrow">
${displayText}
<input type="submit" value="Submit">
</form>
</div>
</body>
</html>