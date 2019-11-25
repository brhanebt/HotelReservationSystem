<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="main">
	<div class="basic">
		<form:form modelAttribute="user" method="POST">
			<fieldset>
				<legend>
					<spring:message code="user.login" />
				</legend>
				<table style="with: 30%; padding-left: 28%;">
					<tr>
						<td width="100"><spring:message code="user.username" />:</td>
						<td width="200"><form:input id="userName" path="userName"
								type="text" /></td>
						<td width="250"><form:errors path="userName"
								cssClass="text-danger"></form:errors></td>
					</tr>
					<tr>
						<td><spring:message code="user.password" />:</td>
						<td><form:input id="password" path="password" type="password" /></td>
						<td><form:errors path="password" cssClass="text-danger"></form:errors></td>
					</tr>
				</table>
				<br>
				<div style="padding-left: 40%;">
					<input type="submit"
						value="<spring:message
								code="user.login" />" /><br>
					<label style="color: red">${errorMsg}</label>
				</div>
			</fieldset>
		</form:form>
	</div>
</div>
