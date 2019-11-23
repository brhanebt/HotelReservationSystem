<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3 class="roomAvail-margin-left"><spring:message code="editCustomer.form.title.label" /></h3>
	<form:form modelAttribute="customer" action="/HotelReservationSystem/Customer/edit" method="POST" class="roomAvail-margin-left">
		<form:hidden  path="id" name="id"/>
		<div class="form-group row pl-3">
			<label for="firstName" class="col-sm-2 col-form-label ml-3"><spring:message
					code="addCustomer.form.firstName.label" />:</label>
			<div class="col-sm-5">
				<form:input name="firstName" class="form-control mr-3"
					path="firstName" id="firstName" value= "${firstName}"/>
				<form:errors path="firstName" cssClass="text-danger" />
			</div>
		</div>
		<div class="form-group row pl-3">
			<label for="lastName" class="col-sm-2 col-form-label ml-3"><spring:message
					code="addCustomer.form.lastName.label" />: </label>
			<div class="col-sm-5">
				<form:input type="text" class="form-control mr-3" path="lastName"
					id="lastName" value="${lastName}"/>
				<form:errors path="lastName" cssClass="text-danger" />
			</div>
		</div>
		<div class="form-group row">
			<label for="email" class="col-sm-2 col-form-label"><spring:message
					code="addCustomer.form.email.label" />: </label>
			<div class="col-sm-5">
				<form:input type="text" class="form-control" id="email" path="email" value= "${email}" />
				<form:errors path="email" cssClass="text-danger" />
			</div>
		</div>
		<div class="form-group row pl-3">
			<label for="telephone" class="col-sm-2 col-form-label ml-3"><spring:message
					code="addCustomer.form.telephone.label" />:</label>
			<div class="col-sm-5">
				<form:input type="text" class="form-control mr-3" id="telephone"
					path="telephone" value= "${customer.telephone}"/>
				<form:errors path="telephone" cssClass="text-danger" />
			</div>
		</div>

		<%-- 		<h4>Address Information</h4>
	<c:forEach items="customer.addresses" var="address" varStatus="status">
		<div class="form-group">
			<div class="col-lg-10">
				<div class="form:input-prepend">
				    <label>Street: </label>
				    <form:input path="address[0].street" cssClass="form-control"/>
					<form:errors path="address[0].street" cssClass="text-danger"/>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-lg-10">
				<div class="form:input-prepend">
				    <label >City: </label>
				    <form:input path="address[0].city" cssClass="form-control"/>
					<form:errors path="address[0].city" cssClass="text-danger"/>
				</div>
			</div>
		</div>	
		<div class="form-group">
			<div class="col-lg-10">
				<div class="form:input-prepend">
				    <label >Apartment: </label>
				    <form:input path="address[0].apartment" cssClass="form-control"/>
					<form:errors path="address[0].apartment" cssClass="text-danger"/>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-lg-10">
				<div class="form:input-prepend">
				    <label >State: </label>
				    <form:input path="address[0].state" cssClass="form-control"/>
					<form:errors path="address[0].state" cssClass="text-danger"/>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-lg-10">
				<div class="form:input-prepend">
				    <label path="address[0].zipCode">Zip Code: </label>
				    <form:input path="address[0].zipCode" cssClass="form-control"/>
					<form:errors path="address[0].zipCode" cssClass="text-danger"/>
				</div>
			</div>
		</div>
	</c:forEach> --%>
		<div class="form-group row">
			<div class="col-sm-6">
				<button type="submit" class="btn btn-primary  mr-1"><spring:message code="form.field.save.label"/></button>
				<a href='<spring:url value="/Customers" />' class="btn btn-primary"> </span> <spring:message code="form.field.cancel.label"/> </a>
			</div>
		</div>
	</form:form>
