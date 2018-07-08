<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="fragments/header.jsp" />


<h3>
	Lista pojazdów
	<c:if test="${customer_id >0 }">klienta o id ${customer_id}</c:if>
</h3>


<br>
<br>

<form action="/Warsztat_samochodowy/VehicleDelete" method="get">
	<div class="container">

		<table class="table table-hover table-bordered ">
			<thead>
				<tr>
					<th>Zaznacz</th>
					<th>Id</th>
					<th>Model</th>
					<th>Brand</th>
					<th>Year</th>
					<th>Registration number</th>
					<th>Car Review Date</th>
					<th>Customer_id</th>
					<th>Usuń</th>
					<th>Edytuj</th>
					<th>Przypisz do klienta</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="item" items="${vehicle}">
					<tr>
						<td><input type="checkbox" name="id" value="${item.id}" /></td>
						<td>${item.id}</td>
						<td>${item.model}</td>
						<td>${item.brandName}</td>
						<td>${item.year}</td>
						<td>${item.registrationNumber}</td>
						<td>${item.carReviewDate}</td>
						<td>${item.customerId}</td>
						<td><a
							href="/Warsztat_samochodowy/VehicleDelete?id=${item.id}">Usuń</a></td>
						<td><a
							href="/Warsztat_samochodowy/VehicleUpdate?id=${item.id}&model=${item.model}&brandName=${item.brandName}&year=${item.year}&registrationNumber=${item.registrationNumber}&carReviewDate=${item.carReviewDate}&customerId=${item.customerId}&action=update">Edytuj</a></td>
						<td><a
							href="/Warsztat_samochodowy/VehicleSetCustomer?id=${item.id}&model=${item.model}&brandName=
							${item.brandName}&year=${item.year}&registrationNumber=${item.registrationNumber}
							&carReviewDate=${item.carReviewDate}&customerId=${item.customerId}&customerChecked=true">Przypisz do klienta</a></td>
						
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<br> <a href="/Warsztat_samochodowy/VehicleAdd?action=add"
			class="btn btn-info" role="button">Dodaj nowy pojazd</a> <input
			class="btn btn-info" type="submit" value="Usuń zaznaczone pojazdy" />
		<br>
	</div>
</form>
<jsp:include page="fragments/footer.jsp" />
