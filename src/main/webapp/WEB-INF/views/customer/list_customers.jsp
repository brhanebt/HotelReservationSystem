<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<p>
<a href='<spring:url value="/Customer/add" />' class="label label-danger" > <span
		class="glyphicon glyphicon-plus-sign" ></span><spring:message code="addCustomer.form.title.label"/> 
</a>
</p>
			<table class="table table-hover">
				<tr>
					<th><spring:message code="addCustomer.form.firstName.label"/></th>
					<th><spring:message code="addCustomer.form.lastName.label"/></th>
					<th><spring:message code="addCustomer.form.email.label"/></th>
					<th><spring:message code="addCustomer.form.telephone.label"/></th>
					<th><spring:message code="form.table.action"/></th>
				</tr>
				<c:forEach var="item" items="${customers }" >
					<tr>
						<td>${item.firstName}</td>
						<td>${item.lastName}</td>
						<td>${item.email}</td>
						<td>${item.telephone}</td>
						<td>
						<a href='<spring:url value="/Customer/edit/${item.id}" />' class="label label-danger" > <span
								class="glyphicon glyphicon-edit" /></span> <spring:message code="form.edit.field.label"/>
						</a>
						<a href='<spring:url value="/Customer/delete/${item.id}" />' class="label label-danger" > <span
								class="glyphicon glyphicon-remove" ></span><spring:message code="form.field.delete"/> 
						</a>
						</td>
					</tr>
				</c:forEach>
<!-- 				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>{{cart.grandTotal}}</th>
					<th></th>
				</tr> -->
			</table>
