<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="fragments/header.jsp" />


<h3>Zarządzanie klientami</h3>


<br>
<c:if test="${customerChecked == false}">
Nie wybrano klienta
</c:if>
<br>


<form action="/Warsztat_samochodowy/VehicleSetCustomer" method="post">
<div class="container">

	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
				<th>Wybierz</th>
				<th>Id</th>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Birth date</th>
				<th>tel number</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="item" items="${customer}">
				<tr>
					<td><input type="radio" name="customer_id" value="${item.id}"/></td>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.surName}</td>
					<td>${item.birthDate}</td>
					<td>${item.telNumber}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
	<br>
	
	<input class="btn btn-info" type="submit" value="Przypisz wybranego klienta"/>
<br>
</div>
</form>
<jsp:include page="fragments/footer.jsp" />
