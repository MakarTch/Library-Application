<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="librarystyle.css">
<link rel="icon" href="https://www.clipartmax.com/png/middle/155-1559319_learn-open-book-icon-vector.png">
</head>
<body>

<div class="navbar"></div>
<div class="content">

<%out.println(session.getAttribute("pageHeader")); %>
<h1>Welcome to the library!</h1>

<div class="footer">
  <div style="padding:20px 0;width:30%;float:left">
    <img src="https://upload.wikimedia.org/wikipedia/en/thumb/7/7c/New_York_Public_Library_logo.svg/1200px-New_York_Public_Library_logo.svg.png" width=90%>
  </div>
  <div style="margin:20px;padding:20px 0;width:30%;float:left">
  	10 Grand Army Plaza<br>
    Brooklyn, NY 11238<br>
    (718)-230-2100<br>
  </div>
  <div style="padding:20px 0;width:30%;float:left">
  	<table>
    	<tr>
        	<td>Monday</td>
            <td>10:00 AM - 4:00 PM</td>
        </tr>
        <tr>
        	<td>Tuesday</td>
            <td>1:00 PM - 7:00 PM</td>
        </tr>
        <tr>
        	<td>Wednesday</td>
            <td>10:00 AM - 4:00 PM</td>
        </tr>
        <tr>
        	<td>Thursday</td>
            <td>1:00 PM - 7:00 PM</td>
        </tr>
        <tr>
        	<td>Friday</td>
            <td>10:00 AM - 4:00 PM</td>
        </tr>
        <tr>
        	<td>Saturday</td>
            <td>10:00 AM - 4:00 PM</td>
        </tr>
        <tr>
        	<td>Sunday</td>
            <td>Closed</td>
        </tr>
    </table>
  </div>
</div>

</div>
<script>
document.getElementById("root1").innerHTML="Check it out"
</script>
</body>
</html>

<!-- 
<!DOCTYPE html>
<html>
<head>
<style>
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: grey;
   color: black;
   padding:0 30px;
   /*text-align: center;*/
   /*padding:40px 40px;*/
}
</style>
</head>
<body>

<h2>Fixed/Sticky Footer Example</h2>
<p>The footer is placed at the bottom of the page.</p>

<div class="footer">
  <div style="padding:20px 0;width:30%;float:left">
  	1000 Fourth ave<br> Seattle WA 98104-1109<br>347-987-1235
  </div>
  <div style="padding:20px 0;width:30%;float:left">
  	here
  </div>
  <div style="padding:20px 0;width:30%;float:left">
  	and here
  </div>
</div>

</body>
</html> 

 -->