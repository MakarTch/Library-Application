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