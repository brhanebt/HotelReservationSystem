<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="main">
	<div class="basic">
		<form:form modelAttribute="registration" method="POST">
			<fieldset>
				<legend>
					<spring:message code="user.signUp" />
				</legend>
				<table style="with: 30%; padding-left: 28%;">
					<tr>
						<td width="150"><spring:message code="user.firstname" />:</td>
						<td width="200"><form:input type="text" path="user.firstName" /></td>
						<td width="250"><form:errors path="user.firstName"
								cssClass="text-danger" /></td>
					</tr>
					<tr>
						<td><spring:message code="user.lastname" />:</td>
						<td><form:input type="text" path="user.lastName" /></td>
						<td><form:errors path="user.lastName" cssClass="text-danger" /></td>
					</tr>
					<tr>
						<td><spring:message code="user.email" />:</td>
						<td><form:input type="text" path="user.email" /></td>
						<td><form:errors path="user.email" cssClass="text-danger" /></td>
					</tr>
					<tr>
						<td><spring:message code="user.username" />:</td>
						<td><form:input type="text" path="user.userName" /></td>
						<td><form:errors path="user.userName" cssClass="text-danger" /></td>
					</tr>
					<tr>
						<td><spring:message code="user.password" />:</td>
						<td><form:input type="password" path="user.password" /></td>
						<td><form:errors path="user.password" cssClass="text-danger" /></td>
					</tr>
					<tr>
						<td><spring:message code="user.verifypassword" />:</td>
						<td><form:input type="password" path="verifyPassword" /></td>
						<td><form:errors path="verifyPassword" cssClass="text-danger" /></td>
					</tr>
					<tr>
					<tr>
						<td><spring:message code="user.phonenumber" />:</td>
						<td><form:input type="text" path="user.mobile" /></td>
						<td><form:errors path="user.mobile" cssClass="text-danger" /></td>
					</tr>
					<tr>
						<td><spring:message code="user.role" />:</td>
						<td><c:forEach var="role" items="${roles}">
								<form:checkbox path="rolesArr" value="${role}" label="${role}" />
								<br>
							</c:forEach></td>
						<td><form:errors path="rolesArr" cssClass="text-danger" /></td>
					</tr>
				</table>
				<br>
				<div style="padding-left: 41%;">
					<p>
						<input type="submit"
							value="<spring:message code="user.register" />" /><br>
					</p>
				</div>
			</fieldset>
		</form:form>
	</div>
</div>
