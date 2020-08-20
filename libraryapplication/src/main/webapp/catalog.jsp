<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Catalog</title>
</head>
<body>
<form action="/putonhold">
${displayText}
<input type="submit" value="Put on Hold!">
</form>
</body>
</html>
<!-- oh snap imma have to make it a thing not to show the submit button if the user isnt logged in, or just not let them see the catalog
argh also they can't put on hold a book that they already have on hold
shit I also gotta subtract 1 from the book in the books table
Also stop people from submitting if they havent selected anything -->