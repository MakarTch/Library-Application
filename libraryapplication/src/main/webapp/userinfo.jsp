<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${userName}'s Info</title>
<link rel="stylesheet" href="librarystyle.css">
<link rel="icon" href="https://www.clipartmax.com/png/middle/155-1559319_learn-open-book-icon-vector.png">

</head>
<body>
<img src="libraryimage.jpg" alt="checkin_pic" width="69%" style=" display:block;margin-left:15.5%;">
${pageHeader}
<div class="content">
<h1>${userName}'s Info</h1>
<hr style="margin:5px">
<h3>Account information</h3>
${accountInfo}
<h3>What you have on hold</h3>
${OnHoldDisplayText}
<h3>What you are currently borrowing</h3>
${BorrowedDisplayText}
</div>
<%out.println(session.getAttribute("pageFooter"));%>

</body>
</html>