<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="fragments/header.jsp" />


<h3>Zarządzanie klientami</h3>


<br>
<br>

<form action="/Warsztat_samochodowy/CustomerDelete" method="get">
<div class="container">

	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
				<th>Zaznacz</th>
				<th>Id</th>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Birth date</th>
				<th>Numer telefonu</th>
				<th>Lista pojazdów</th>
				<th>Usuń</th>
				<th>Edytuj</th>
				<th>Wyślij sms</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="item" items="${customer}">
				<tr>
					<td><input type="checkbox" name="id" value="${item.id}"/></td>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.surName}</td>
					<td>${item.birthDate}</td>
					<td>${item.telNumber}</td>
					<td><a	href="/Warsztat_samochodowy/VehicleShowByCustomerId?id=${item.id}">Lista pojazdów</a></td>
					<td><a	href="/Warsztat_samochodowy/CustomerDelete?id=${item.id}">Usuń</a></td>
					<td><a	href="/Warsztat_samochodowy/CustomerUpdate?id=${item.id}&telnumber=${item.telNumber}&name=${item.name}&surname=${item.surName}&birthdate=${item.birthDate}&action=update">Edytuj</a></td>
					<td><a	href="/Warsztat_samochodowy/SendSMS?id=${item.id}&telnumber=${item.telNumber}">Wyślij sms</a></td>

				</tr>
			</c:forEach>

		</tbody>
	</table>
	
	<br>
<a href="/Warsztat_samochodowy/CustomerAdd?action=add"
	class="btn btn-info" role="button">Dodaj nowego klienta</a>
	
	<input class="btn btn-info" type="submit" value="Usuń zaznaczonych użytkowników"/>
<br>
</div>
</form>
<jsp:include page="fragments/footer.jsp" />
