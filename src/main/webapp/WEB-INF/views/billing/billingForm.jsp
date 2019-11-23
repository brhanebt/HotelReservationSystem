<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form modelAttribute="payment" action="/HotelReservationSystem/Billing/billing" method="get">
			<fieldset>
				<legend>Billing Information</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="firstName"><spring:message code="billing.firstName.can.notbe.null"></spring:message></label>
					<div class="col-lg-10">
						<form:input id="firstName" path="firstName" type="text" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="lastName"><spring:message code="billing.lastName.can.notbe.null"></spring:message></label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="noOnCard"><spring:message code="billing.numberOnCard.can.notbe.null"></spring:message></label>
					<div class="col-lg-10">
						<form:input id="noOnCard" path="noOnCard" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="securityCode"><spring:message code="billing.ExpireDate.Not.Null"></spring:message></label>
					<div class="col-lg-10">
						<form:input id="securityCode" path="securityCode" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="expireDate"><spring:message code="billing.ExpireDate.Not.Null"></spring:message></label>
					<div class="col-lg-10">
						<form:input id="expireDate" path="expireDate" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="email"><spring:message code="billing.Email.Not.Null"></spring:message></label>
					<div class="col-lg-10">
						<form:input id="email" path="email" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="phoneNumber"><spring:message code="billing.phoneNum.Not.Null"></spring:message></label>
					<div class="col-lg-10">
						<form:input id="phoneNumber" path="phoneNumber" type="text"
							class="form:input-large" />
					</div>
				</div>
			
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add" name="_eventId_customerInfoCollected" />
						<button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Proceed Payment</button>
					</div>
				</div>

			</fieldset>
		</form:form>
