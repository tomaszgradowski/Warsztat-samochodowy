<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="fragments/header.jsp" />


<h3>Zarządzanie pracownikami</h3>


<br>
<br>


<form action="/Warsztat_samochodowy/EmployeeDelete" method="get">
	<div class="container">

		<table class="table table-hover table-bordered ">
			<thead>
				<tr>
					<th>Zaznacz</th>
					<th>Id</th>
					<th>name</th>
					<th>surname</th>
					<th>adress</th>
					<th>telNumber</th>
					<th>note</th>
					<th>workHourCosts</th>


					<th>Usuń</th>
					<th>Edytuj</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="item" items="${employee}">
					<tr>
						<td><input type="checkbox" name="id" value="${item.id}" /></td>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.surname}</td>
						<td>${item.adress}</td>
						<td>${item.telNumber}</td>
						<td>${item.note}</td>
						<td>${item.workHourCosts}</td>
					
						<td><a
							href="/Warsztat_samochodowy/EmployeeDelete?id=${item.id}">Usuń</a></td>
						<td><a
							href="/Warsztat_samochodowy/EmployeeUpdate?id=${item.id}&name=${item.name}&surname=${item.surname}&adress=${item.adress}
							&telNumber=${item.telNumber}&note=${item.note}&workHourCosts=${item.workHourCosts}&&action=update">Edytuj</a></td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

		<br> <a href="/Warsztat_samochodowy/EmployeeAdd?action=add"
			class="btn btn-info" role="button">Dodaj nowego pracownika</a> <input
			class="btn btn-info" type="submit"
			value="Usuń zaznaczonych pracowników" /> <br>
	</div>
</form>
<jsp:include page="fragments/footer.jsp" />
