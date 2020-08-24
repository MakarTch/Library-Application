<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>insert user name info?</title>
<link rel="stylesheet" href="librarystyle.css">
<link rel="icon" href="https://www.clipartmax.com/png/middle/155-1559319_learn-open-book-icon-vector.png">

</head>
<body>
<div class="navbar"></div>
<div class="content">
${pageHeader}
<h3>What you have on hold</h3>
${OnHoldDisplayText}
<h3>What you are currently borrowing</h3>
${BorrowedDisplayText}
</div>
</body>
</html>