<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><tiles:insertAttribute name="title" /></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value='/resource/css/gof.css'/>" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<section class="container">
<div class="pull-right" style="padding-right:50px">
<a href="?language=en">English</a>|<a href="?language=zh">Chinese</a>
</div>
</section>
<div class="container">
<div class="jumbotron">
<div class="header">
<ul class="nav nav-pills pull-right">
<tiles:insertAttribute name="navigation" />
</ul>
</div>
<h1>
<tiles:insertAttribute name="heading" />
</h1>
<p>
<tiles:insertAttribute name="tagline" />
</p>
</div>
<div class="row">
<tiles:insertAttribute name="content" />
</div>
<div class="footer">
<tiles:insertAttribute name="footer" />
</div>
</div>
</body>
</html>