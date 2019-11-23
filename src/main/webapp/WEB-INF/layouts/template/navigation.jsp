<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div>
		<nav class="navbar navbar-default">
			<ul class="nav navbar-nav">
				<li><a href="home">Home</a></li>
				<li><a href="<spring:url value='/Rooms' />">Rooms</a></li>
				<li><a href="<spring:url value='/Booking' />">Booking</a></li>
				<security:authorize access="isAnonymous()">
					<li><a href="<spring:url value='/user/login' />">Login</a></li>
					<li><a href="<spring:url value='/user/signup' />">SignUp</a></li>
				</security:authorize>
				<security:authorize access="!isAnonymous()">
					<li><a href="<spring:url value='/user/logout' />">LogOut</a></li>
				</security:authorize>
				<li><a href="<spring:url value='/Customers' />">Customers</a></li>
			</ul>
	</nav>
</div>