<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title>일면 모음</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    
    <style type="text/css">
        html, body { margin: 0; padding: 0; height: 100%; overflow-x: hidden; overflow-y: hidden; }

        iframe {
            position: static;
            top:0px; left: 0; width: 100%; height: 95%;
            border: none; 
            box-sizing: border-box; -moz-box-sizing: border-box; -webkit-box-sizing: border-box;
        }
    </style>

	<script src="/js/jquery-3.3.1.js"></script>
	<script src="/js/bootstrap.js"></script>
	
	<link href="/css/bootstrap.css" rel="stylesheet">
	
	<script>
		$(function() {
			$("#slrclub").click(function() {
				$("#contentsFrame").attr("src","/contents/slrclub");
				
				$(this).parent().attr("class","active");
			});

			$("#bobae").click(function() {
				$("#contentsFrame").attr("src","/contents/bobae");
				
				$(this).parent().attr("class","active");
			});
			
			$("#ppomppu").click(function() {
				$("#contentsFrame").attr("src","/contents/ppomppu");
				
				$(this).parent().attr("class","active");
			});
		});
	</script>
</head>
<body>
	<!--/* <xmp> */-->
	<!-- header start -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	  <a class="navbar-brand" href="/">FirstPage</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarColor01">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link">Home</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" id="slrclub">SLR</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" id="bobae">보배드림</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" id="ppomppu">뽐뿌</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	<!-- header end -->
	
	<iframe id="contentsFrame" src="/contents/slrclub">
	
</body>
</html>