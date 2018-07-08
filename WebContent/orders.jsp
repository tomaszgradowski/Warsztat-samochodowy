<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="fragments/header.jsp" />


<h3>Zarządzanie zleceniami</h3>


<br>
<br>



<form action="/Warsztat_samochodowy/OrdersDelete" method="get">
	<div class="container">

		<table class="table table-hover table-bordered ">
			<thead>
				<tr>
					<th>Zaznacz</th>
					<th>Id</th>
					<th>repairDate</th>
					<th>repairStartDatePlanned</th>
					<th>employeeId</th>
					<th>problemDescription</th>
					<th>repairDecription</th>
					<th>statusId</th>
					<th>vehicleId</th>
					<th>repairCostForClient</th>
					<th>partCosts</th>
					<th>workHourCost</th>
					<th>workHourQuantity</th>
					<th>Usuń</th>
					<th>Edytuj</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="item" items="${orders}">
					<tr>
						<td><input type="checkbox" name="id" value="${item.id}" /></td>
						<td>${item.id}</td>
						<td>${item.repairDate}</td>
						<td>${item.repairStartDatePlanned}</td>
						<td>${item.employeeId}</td>
						<td>${item.problemDescription}</td>
						<td>${item.repairDecription}</td>
						<td>${item.statusId}</td>
						<td>${item.vehicleId}</td>
						<td>${item.repairCostForClient}</td>
						<td>${item.partCosts}</td>
						<td>${item.workHourCost}</td>
						<td>${item.workHourQuantity}</td>

				
						<td><a
							href="/Warsztat_samochodowy/OrdersDelete?id=${item.id}">Usuń</a></td>
						<td><a
							href="/Warsztat_samochodowy/CustomerUpdate?id=${item.id}&action=update">Edytuj</a></td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

		<br> <a href="/Warsztat_samochodowy/OrdersAdd?action=add"
			class="btn btn-info" role="button">Dodaj nowe zlecenie</a> <input
			class="btn btn-info" type="submit"
			value="Usuń zaznaczone zlecenia" /> <br>
	</div>
</form>
<jsp:include page="fragments/footer.jsp" />
