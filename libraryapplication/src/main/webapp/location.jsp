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
<body>
<div class="navbar"></div>
<div class="content">
<%out.println(session.getAttribute("pageHeader")); %>
<div id="map"></div>
The Central Library is accessible from multiple public transit methods:<br>
Take the 2 or 3 train to Eastern Pkway Brooklyn Museum<br>
Take the B or Q train to 7th Ave<br>
Take the B41 bus to Grand Army Plaza<br>
If you are driving we have a parking lot accessible from Eastern Parkway!


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