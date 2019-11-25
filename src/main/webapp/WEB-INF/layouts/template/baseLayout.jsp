<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><tiles:insertAttribute name="title" /></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value='/resource/css/gof.css'/>" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<section class="container">
		<div class="pull-right" style="padding-right: 50px">
			<a href="<spring:url value="?lang=en" />"><spring:message code="language.English" /></a> | <a
				href="<spring:url value="?lang=zh_CN" />"><spring:message code="language.Chinese" /></a>
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
		<nav class="navbar navbar-inverse">
		
		
		<ul class="nav navbar-nav">
		<li><a href="<spring:url value='/Booking' />"><spring:message code="user.booking" /></a></li>
					<c:if test="${not userLogin}">
						<li><a href="<spring:url value='/user/login' />"><spring:message code="user.login" /></a></li>
						<li><a href="<spring:url value='/user/signup' />"><spring:message code="user.signup" /></a></li>
					</c:if>
			<c:if test="${userLogin}">
			<li><a href="<spring:url value='/Rooms' />"><spring:message code="user.rooms" /></a></li>
			<li><a href="<spring:url value='/Customers' />"><spring:message code="user.customers" /></a></li>	
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<spring:url value='/user/logout' />"><spring:message code="user.logout" /></a></li>
				</ul>
		</c:if>
					</ul>
	</nav>
		<div class="row">
			<tiles:insertAttribute name="content" />
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>