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
	float:right;
	height: 600px;
	width: 59%;
	margin: 4px;
}
</style>
</head>
<body>
<img src="libraryimage.jpg" alt="checkin_pic" width="69%" style=" display:block;margin-left:15.5%;">

<%out.println(session.getAttribute("pageHeader")); %>
<div class="content">
<h1>Location & Directions</h1>
		<hr style="margin: 5px">
		<div style="float: left; width: 40%;">
			<h4>To get to the Central Library:</h4>
			<p>
				<span class='mta-bullet mta-2'>2</span><span
					class='mta-bullet mta-3'> 3</span> to Eastern Pkway Brooklyn Museum
			</p>
			 <p><span class='mta-bullet mta-b'>B</span><span
				class='mta-bullet mta-q'> Q</span> to 7<sup>th</sup> Ave</p>
			<p>B41 Bus to Grand Army Plaza</p> 
			<p>If you are driving we have a parking lot accessible from Eastern Parkway!</p>

			<h4>Hours:</h4>
			<table style="padding: 10px 0; margin: 0;">
				<tr style="border-bottom: none">
					<td>Monday</td>
					<td>10:00 AM - 4:00 PM</td>
				</tr>
				<tr style="border-bottom: none">
					<td>Tuesday</td>
					<td>1:00 PM - 7:00 PM</td>
				</tr>
				<tr style="border-bottom: none">
					<td>Wednesday</td>
					<td>10:00 AM - 4:00 PM</td>
				</tr>
				<tr style="border-bottom: none">
					<td>Thursday</td>
					<td>1:00 PM - 7:00 PM</td>
				</tr>
				<tr style="border-bottom: none">
					<td>Friday</td>
					<td>10:00 AM - 4:00 PM</td>
				</tr>
				<tr style="border-bottom: none">
					<td>Saturday</td>
					<td>10:00 AM - 4:00 PM</td>
				</tr>
				<tr style="border-bottom: none">
					<td>Sunday</td>
					<td>Closed</td>
				</tr>
			</table>
		</div>
		<div id="map"></div>
	</div>

<%out.println(session.getAttribute("pageFooter"));%>
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

</body>
</html>