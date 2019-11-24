<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div>
	<nav class="navbar navbar-default">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">GoF</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#"><spring:message code="user.home"/></a></li>
				<li><a href="<spring:url value='#' />"><spring:message code="user.rooms"/></a></li>
				<li><a href="<spring:url value='#' />"><spring:message code="user.booking"/></a></li>
				<security:authorize access="!isAnonymous()">
					<li><a href="<spring:url value='#' />"><spring:message code="user.login"/></a></li>
					<li><a href="<spring:url value='#' />"><spring:message code="user.signup"/></a></li>
				</security:authorize>
				<security:authorize access="isAnonymous()">
					<li><a href="<spring:url value='/user/logout' />"><spring:message code="user.logout"/></a></li>
				</security:authorize>
			</ul>
	</nav>
</div>
<div>
	<h1><spring:message code="user.hello" />, ${user.userName}. <spring:message code="user.homepage" />!</h1>
</div>
