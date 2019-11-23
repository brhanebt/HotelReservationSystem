<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form  modelAttribute="reservation" action="/HotelReservationSystem/Booking/Booking" method="get">

  <h2>Room Reservation<c:url value="/resources/images/hotels-com-vector-logo.png" var="hotels-com-vector-logo"/></h2>
  
	<nav class="navbar navbar-default">
			<ul class="nav navbar-nav">
			 <li class="active"><label><spring:message code="startdate.cannotnull."></spring:message></label><form:input type="date" path="startDate"/>
	
            </li>
               <li class="active"><label><spring:message code="enddate.cannotnull."></spring:message></label><form:input  type="date" path="endDate"/></li>
               <li class="active"><label><spring:message code="types.of.room"></spring:message></label>
              <%--  <form:select path="typeOfRoom">
			 <form:option value="" label="--- Rooms ---"/>
			 <form:option value="one" label="one bed room"/>
			 <form:option value="two" label="two bed room"/>		 		 
			 </form:select></li> --%>
			<li><input type="button" value="Search" /></li>
			</ul> 
			<a href='<spring:url value="/billing"></spring:url>'><span class="btn btn-primary"/><spring:message code="booking.room.reserve"></spring:message></span></a>
	</nav>
</form:form>
