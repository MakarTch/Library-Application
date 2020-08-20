<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Currently On Hold</title>
</head>
<body>
<h2> Check off the books when customer is <b style="color:red">in store</b> and ready to take the book(s)</h2>
<form action="/putonborrow">
${displayText }
<input type="submit" value="Put into Borrow">
</form>
</body>
</html>