<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<h3 class="roomAvail-margin-left">
		<spring:message code="viewCustomer.form.title.label" />
	</h3>
		<div class="form-group row pl-3">
			<label class="col-sm-2 col-form-label ml-3"><spring:message
					code="addCustomer.form.firstName.label" />:</label>
				${customer.firstName}
		</div>
		<div class="form-group row pl-3">
			<label class="col-sm-2 col-form-label ml-3"><spring:message
					code="addCustomer.form.lastName.label" />: </label>
				${customer.lastName}
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label"><spring:message
					code="addCustomer.form.email.label" />: </label>
				${customer.email}
		</div>
		<div class="form-group row pl-3">
			<label class="col-sm-2 col-form-label ml-3"><spring:message
					code="addCustomer.form.telephone.label" />:</label>
				${customer.telephone}

		</div>
		<a href='<spring:url value="/Customers" />' 
		class="btn btn-primary"> </span> <spring:message code="form.back.to.list.label"/> </a>
		<a href='<spring:url value="/Customer/edit/${customer.id}" />' class="btn btn-primary"> </span> <spring:message code="form.edit.field.label"/> </a>
