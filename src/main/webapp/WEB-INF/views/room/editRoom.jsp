<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3 class="roomAvail-margin-center">
		<spring:message code="editRoom.form.title"></spring:message>
	</h3>
	<div id="result" style="display: none">
		<p id="success"></p>
		<p id="errors"></p>
	</div>
	<form:form class="roomAvail-margin-left" id="editRoom"
		modelAttribute="room" action="/HotelReservationSystem/Room/editRoom" method="post">
		<div class="form-group row pl-3">
			<label for="id" class="col-sm-2 col-form-label ml-3"><spring:message
					code="addRoom.form.label.id"></spring:message></label>
			<div class="col-sm-2">
				<form:input path="id" class="form-control mr-3"
					id="idTxtFld" placeholder="ID" value="${id}"/>
				<form:errors path="id" class="form-control mr-3"
					cssClass="error" id="idErrFld" />
			</div>
		</div>
		<div class="form-group row pl-3">
			<label for="roomNumber" class="col-sm-2 col-form-label ml-3"><spring:message
					code="addRoom.form.label.roomNumber"></spring:message></label>
			<div class="col-sm-2">
				<form:input path="roomNumber" class="form-control mr-3"
					id="roomNumberTxtFld" placeholder="Room Number" value="${roomNumber}"/>
				<form:errors path="roomNumber" class="form-control mr-3"
					cssClass="error" id="roomNumberErrFld" />
			</div>
		</div>
		<div class="form-group row pl-3">
			<label for="floorNumber" class="col-sm-2 col-form-label ml-3"><spring:message
					code="addRoom.form.label.floorNumber"></spring:message></label>
			<div class="col-sm-2">
				<form:input type="number" path="floorNumber"
					class="form-control mr-3" id="floorNumberTxtFld"
					placeholder="Floor Number"  value="${floorNumber}"/>
				<form:errors path="floorNumber" class="form-control mr-3"
					cssClass="error" id="floorNumberErrFld" />
			</div>
		</div>
		<div class="form-group row">
			<label for="basePrice" class="col-sm-2 col-form-label"><spring:message
					code="addRoom.form.label.basePrice"></spring:message></label>
			<div class="col-sm-2">
				<form:input type="number" path="basePrice" class="form-control"
					id="basePriceTxtFld" placeholder="Base Price" value="${basePrice}"/>
				<form:errors path="basePrice" class="form-control" cssClass="error"
					id="basePriceErrFld" />
			</div>
		</div>
		<div class="form-group row pl-3">
			<label for="numBeds" class="col-sm-2 col-form-label ml-3"><spring:message
					code="addRoom.form.label.numBeds"></spring:message></label>
			<div class="col-sm-2">
				<form:input type="number" path="numBeds" class="form-control mr-3"
					id="numBedsErrFld"  value="${numBeds}"/>
				<form:errors path="numBeds" class="form-control mr-3"
					cssClass="error" id="numBedsErrFld" />
			</div>
		</div>
		<div class="form-group row">
			<label for="smoking" class="col-sm-2 col-form-label ml-3"><spring:message
					code="addRoom.form.label.smoking"></spring:message></label>
			<div class="col-sm-2">
				<div class="form-check">
					<form:checkbox class="form-check-input" path="smoking"
						id="smokingCheckBox" />
					<label class="form-check-label" for="smoking"> <spring:message
							code="addRoom.form.checkBox"></spring:message>
					</label>
				</div>
			</div>
		</div>
		<div class="form-group row">
			<label for="airConditioning" class="col-sm-2 col-form-label ml-3"><spring:message
					code="addRoom.form.label.airConditioning"></spring:message></label>
			<div class="col-sm-2">
				<div class="form-check">
					<form:checkbox class="form-check-input" path="airConditioning"
						id="airConditionAvailableTxtFld" />
					<label class="form-check-label" for="airConditionAvailableChkBx">
						<spring:message code="addRoom.form.checkBox"></spring:message>
					</label>
				</div>
			</div>
		</div>
		<div class="form-group row">
			<label for="windows" class="col-sm-2 col-form-label ml-3"><spring:message
					code="addRoom.form.label.windows"></spring:message></label>
			<div class="col-sm-2">
				<div class="form-check">
					<form:checkbox class="form-check-input" path="windows"
						id="windowAvailable" />
					<label class="form-check-label" for="windows"> <spring:message
							code="addRoom.form.checkBox"></spring:message>
					</label>
				</div>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-2">
				<input type="submit" class="btn btn-primary" value="Save Room">
				<input type="reset" class="btn btn-primary" value="Reset"
					onclick="reset();return false;">
			</div>
		</div>
	</form:form>
