<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3 class="roomAvail-margin-center">
		<c:out value=" ${message}"></c:out>
	</h3>
	<a href='<spring:url value="/Room/addRoom"></spring:url>'><span class="btn btn-primary btn-sm"/><spring:message code="rooms.list.addNewBook"></spring:message></span></a>
	<c:if test="${not empty rooms}">
	<h3 class="roomAvail-margin-center">
		<spring:message code="rooms.list.display.title"></spring:message>
	</h3>
	
       
	<table class="table table-hover">
	<tr>
            <th><c:out value="Id" /></th>
            <th><c:out value="Floor Number" /></th>
            <th><c:out value="Base Price" /></th>
            <th><c:out value="Number of Beds" /></th>
            <th><c:out value="Room Number" /></th>
            <th><c:out value="Smoking" /></th>
            <th><c:out value="Windows" /></th>
       </tr>
    <c:forEach items="${rooms}" var="room">
        <tr>
            <td><c:out value="${room.id}" /></td>
            <td><c:out value="${room.floorNumber}" /></td>
            <td><c:out value="${room.basePrice}" /></td>
            <td><c:out value="${room.numBeds}" /></td>
            <td><c:out value="${room.roomNumber}" /></td>
            <td><c:out value="${room.smoking}" /></td>
            <td><c:out value="${room.windows}" /></td>
            
           	<td>
            <a href='<spring:url value="/Room/edit/${room.id}"></spring:url>' class="label label-warning"> <span
							class="glyphicon glyphicon-warning" /></span> <spring:message code="rooms.list.edit"></spring:message>
					</a>
            </td>
            <td>
            <a href='<spring:url value="/Room/delete/${room.id}"></spring:url>' class="label label-danger"> <span class="glyphicon glyphicon-remove" /></span> <spring:message code="rooms.list.delete"></spring:message></a>
            </td>
        </tr>
    </c:forEach>
</table>
</c:if>
