<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<section class="container">
<div class="row">
<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
<p><span class="bold"><spring:message code="addRoom.form.label.basePrice"></spring:message></span>${room.basePrice}</p>
<p><span class="bold"><spring:message code="addRoom.form.label.numBeds"></spring:message></span> ${room.numBeds}</p>
<p><span class="bold"><spring:message code="billing.details.dateDiff"></spring:message></span> ${dateDiff}</p>
<p><span class="bold"><spring:message code="billing.startDate"></spring:message></span> ${beginningDate}</p>
<p><span class="bold"><spring:message code="billing.endDate"></spring:message></span> ${endingDate}</p>
<p><span class="bold"><spring:message code="billing.totalPrice"></spring:message></span> ${room.basePrice*(dateDiff)}</p>
</div>
</div>
</section>

<form:form modelAttribute="billing" action="/HotelReservationSystem/Billing/payment" method="POST">
			<fieldset>
				<legend>Billing Information</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="firstName"><spring:message code="billing.firstName.can.notbe.null"></spring:message></label>
					<div class="col-lg-10">
						<form:input id="firstName" path="firstName" type="text" class="form:input-large" />
						<form:errors path="firstName"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="lastName"><spring:message code="billing.lastName.can.notbe.null"></spring:message></label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text" class="form:input-large" />
						<form:errors path="lastName"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="noOnCard"><spring:message code="billing.numberOnCard.can.notbe.null"></spring:message></label>
					<div class="col-lg-10">
						<form:input id="noOnCard" path="noOnCard" type="text"
							class="form:input-large" />
							<form:errors path="noOnCard"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="securityCode"><spring:message code="billing.securityCode"></spring:message></label>
					<div class="col-lg-10">
						<form:input id="securityCode" path="securityCode" type="text"
							class="form:input-large" />
							<form:errors path="noOnCard"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="expireDate"><spring:message code="billing.ExpireDate.Not.Null"></spring:message></label>
					<div class="col-lg-10">
						<form:input id="expireDate" path="expireDate" type="text"
							class="form:input-large" />
							<form:errors path="expireDate"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="email"><spring:message code="billing.Email.Not.Null"></spring:message></label>
					<div class="col-lg-10">
						<form:input id="email" path="email" type="text"
							class="form:input-large" />
							<form:errors path="email"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="phoneNumber"><spring:message code="billing.phoneNum.Not.Null"></spring:message></label>
					<div class="col-lg-10">
						<form:input id="phoneNumber" path="phoneNumber" type="text"
							class="form:input-large" />
							<form:errors path="phoneNumber"/>
					</div>
				</div>
			
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<a href="<spring:url value='/Booking'/>" class="btn btn-danger"><spring:message code="billing.back"></spring:message></a>
						<input type="submit" class="btn btn-primary" value="Proceed Paymenet"/>
					</div>
				</div>

			</fieldset>
		</form:form>
