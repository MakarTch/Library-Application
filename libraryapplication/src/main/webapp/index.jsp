<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="librarystyle.css">
<link rel="icon" href="https://www.clipartmax.com/png/middle/155-1559319_learn-open-book-icon-vector.png">
<style>

img {
  vertical-align: middle;/* not really necessary*/
}

.container {
  position: relative;
}

.prev,
.next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  padding: 16px;
  margin-top: -50px;
  color: white;
  font-weight: bold;
  font-size: 20px;
  border-radius: 0 3px 3px 0;
  user-select: none;
  -webkit-user-select: none;
  background-color:black;
}

.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

.prev:hover,
.next:hover {
	transition:0.5s;
  background-color: rgba(0, 0, 0, 0.5);
}
</style>
</head>
<body>
<img src="libraryimage.jpg" alt="checkin_pic" width="69%" style=" display:block;margin-left:15.5%;">
<%out.println(session.getAttribute("pageHeader")); %>

<div class="content">

<h1>Welcome to the Central Library website!</h1>
		<hr style="margin: 5px">

<p>The purpose of this website is to make the process of finding a book, putting it on hold, retrieving it from the library, then finally 
returning it back to the library a very simple and straight forward process. Log in as a user and go through our catalog and check off the books 
that you want to put on hold! 
After that, come to the library to retrieve your book(s) and one of our admins will make sure to log your book as borrowed. Then come
back to the library with your book(s) to return when you're done reading. Our admin will mark your book(s) as returned and place all books back 
into our catalog! 
</p>

<p>If you're not feeling up to all the work of creating a new account, you may log in as a user with a User ID of <i>1</i> and password of <i>password</i>. 
To use Admin privileges you may log in with Admin ID of <i>1000</i> and password of <i>password</i>.</p>

<!-- 
-->
<div class="container">
  <div class="mySlides">
    <img src="DSC05934.JPG" style="width:100%; border-radius:5px">
  </div>

  <div class="mySlides">
    <img src="DSC05961.JPG" style="width:100%; border-radius:5px">
  </div>
    
  <div class="mySlides">
    <img src="DSC05967.JPG" style="width:100%; border-radius:5px">
  </div>
  
  <div class="mySlides">
    <img src="libraryimage2.JPG" style="width:100%; border-radius:5px">
  </div>
    
  <a class="prev" onclick="plusSlides(-1)">&#171;</a>
  <a class="next" onclick="plusSlides(1)">&#187;</a>

  
</div>
</div>


<%out.println(session.getAttribute("pageFooter"));%>
<script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
  captionText.innerHTML = dots[slideIndex-1].alt;
}
</script>
</body>
</html>

