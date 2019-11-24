<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div>
		<nav class="navbar navbar-default">
			<ul class="nav navbar-nav">
				<li><a href="home"><spring:message code="user.home" /></a></li>
				<li><a href="<spring:url value='/Rooms' />"><spring:message code="user.rooms" /></a></li>
				<li><a href="<spring:url value='/Booking' />"><spring:message code="user.booking" /></a></li>
				<security:authorize access="isAnonymous()">
					<li><a href="<spring:url value='/user/login' />"><spring:message code="user.login" /></a></li>
					<li><a href="<spring:url value='/user/signup' />"><spring:message code="user.signup" /></a></li>
				</security:authorize>
				<security:authorize access="!isAnonymous()">
					<li><a href="<spring:url value='/user/logout' />"><spring:message code="user.logout" /></a></li>
				</security:authorize>
				<li><a href="<spring:url value='/Customers' />"><spring:message code="user.customers" /></a></li>
			</ul>
	</nav>
</div>