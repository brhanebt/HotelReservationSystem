<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form  action="/HotelReservationSystem/Booking" modelAttribute="bookingFilter" method="POST">

  <h2>Room Reservation<c:url value="/resources/images/hotels-com-vector-logo.png" var="hotels-com-vector-logo"/></h2>
 
<nav class="navbar navbar-default">
<ul class="nav navbar-nav">
<li class="active"><label><spring:message code="startdate.cannotnull."></spring:message></label><form:input type="date" value="${beginningDate}" path="beginningDate"/>

            </li>
               <li class="active"><label><spring:message code="enddate.cannotnull."></spring:message></label><form:input  type="date" value="${endingDate}" path="endingDate"/></li>
              <%--  <form:select path="typeOfRoom">
<form:option value="" label="--- Rooms ---"/>
<form:option value="one" label="one bed room"/>
<form:option value="two" label="two bed room"/>
</form:select></li> --%>
<li><input type="submit" value="Search" /></li>
</ul>

</nav>
</form:form>

<section class="container">
<div class="row">
<c:forEach items="${rooms}" var="room">
<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
<div class="thumbnail">
<div class="caption">
<p><span id="bold"><spring:message code="addRoom.form.label.floorNumber"></spring:message></span>   ${room.floorNumber}</p>
<p><span id="bold"><spring:message code="addRoom.form.label.basePrice"></spring:message></span>   ${room.basePrice}</p>
<p><span id="bold"><spring:message code="addRoom.form.label.numBeds"></spring:message></span>   ${room.numBeds}</p>
<p><span id="bold"><spring:message code="addRoom.form.label.smoking"></spring:message></span>   ${room.smoking? 'Yes ':'No '}</p>
<p><span id="bold"><spring:message code="addRoom.form.label.windows"></spring:message></span>   ${room.windows? 'Yes ':'No '}</p>
<p><span id="bold"><spring:message code="addRoom.form.label.airConditioning"></spring:message></span>   ${room.airConditioning? 'Yes ':'No '}</p>
<a href='<spring:url value="/Billing/billing?id=${room.id}&beginningDate=${beginningDate}&endingDate=${endingDate}"></spring:url>'><span class="btn btn-primary"/><spring:message code="booking.room.reserve"></spring:message></span></a>


</div>
</div>
</div>
</c:forEach>
</div>
</section>