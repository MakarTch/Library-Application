<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location</title>
<link rel="stylesheet" href="librarystyle.css">
<link rel="icon" href="https://www.clipartmax.com/png/middle/155-1559319_learn-open-book-icon-vector.png">
<style>
#map {
	height: 600px;
	width: 100%;
	margin: 4px;
}
</style>
</head>
<body><!-- Might put the map more on the right then put just 6 (icon of 6 train) to <trainstop> and do that to allof them
	def a possibility, for not this is good, just gotta pad it up when im styling the inner content later. but this is good for now. 
	maybe make font bigger for this page too 
	change this to location and hours-->
<div class="navbar"></div>

<div class="content">
<%out.println(session.getAttribute("pageHeader")); %>
To get to the Central Library:<br>
<span class='mta-bullet mta-2'>2</span><span class='mta-bullet mta-3'> 3</span> to Eastern Pkway Brooklyn Museum<br>
<span class='mta-bullet mta-b'>B</span><span class='mta-bullet mta-q'> Q</span> to 7<sup>th</sup> Ave<br>
B41 Bus to Grand Army Plaza<br>
If you are driving we have a parking lot accessible from Eastern Parkway!<br>
<div id="map"></div>
</div>

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



<script>
	function initMap() {
	  var uluru = {lat: 40.6724973, lng: -73.9682442};
	  var map = new google.maps.Map(document.getElementById('map'), {zoom: 14, center: uluru});
	  var marker = new google.maps.Marker({position: uluru, map: map});
	}
   </script>
<script defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDLrdAi0U57Ot8_pQATHje-nCopx_IwYNo&callback=initMap">
   </script>



</div>
</body>
</html>