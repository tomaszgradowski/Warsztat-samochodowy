<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="fragments/header.jsp" />


<h3>Zarządzanie klientami</h3>


<br>
<br>


<div class="container">
	<h2>Podaj dane nowego klienta</h2>


	<c:if test="${action == 'add' }">
		<form action="/Warsztat_samochodowy/CustomerAdd" method="post">
			<div class="form-group">
				<label for="name">Imię:</label> <input type="text"
					class="form-control" id="name" placeholder="Podaj imię:"
					name="name" value="${name}">
			</div>
			<div class="form-group">
				<label for="surname">Nazwisko:</label> <input type="text"
					class="form-control" id="surname" placeholder="Podaj nazwisko"
					name="surname" value="${surname}">
			</div>
			<div class="form-group">
				<label for="birthdate">Data urodzenia:</label> <input type="date"
					class="form-control" id="birthdate"
					placeholder="Podaj datę urodzenia" name="birthdate"
					value="${birthdate}">
			</div>

			<div class="form-group">
				<label for="telnumber">Numer telefonu:</label> <input type="text"
					class="form-control" id="telnumber"
					placeholder="Podaj numer telefonu" name="telnumber"
					value="${telnumber}">
			</div>

			<button type="submit" class="btn btn-info">Dodaj klienta</button>
		</form>
	</c:if>



	<c:if test="${action=='update'}">
		<form action="/Warsztat_samochodowy/CustomerUpdate" method="post">
			<div class="form-group">
				<label for="name">Imię:</label> <input type="text"
					class="form-control" id="name" placeholder="Podaj imię:"
					name="name" value="${name}">
			</div>
			<div class="form-group">
				<label for="surname">Nazwisko:</label> <input type="text"
					class="form-control" id="surname" placeholder="Podaj nazwisko"
					name="surname" value="${surname}">
			</div>
			<div class="form-group">
				<label for="birthdate">Data urodzenia:</label> <input type="date"
					class="form-control" id="birthdate"
					placeholder="Podaj datę urodzenia" name="birthdate"
					value="${birthdate}"> <input type="hidden"
					class="form-control" id="id" placeholder="id" name="id"
					value="${id}">
			</div>

			<div class="form-group">
				<label for="telnumber">Numer telefonu:</label> <input type="text"
					class="form-control" id="telnumber" placeholder="Podaj numer telefonu"
					name="telnumber" value="${telnumber}">
			</div>

			<button type="submit" class="btn btn-info">Zaktualizuj dane
				klienta</button>
		</form>
	</c:if>




</div>


<jsp:include page="fragments/footer.jsp" />
