<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="fragments/header.jsp" />


<h3>Zarządzanie Pojazdami</h3>


<br>
<br>


<div class="container">
	<h2>Podaj dane nowego pojazdu</h2>


	<c:if test="${action == 'add' }">
		<form action="/Warsztat_samochodowy/VehicleAdd" method="post">

			<div class="form-group">
				<label for="model">Model:</label> <input type="text"
					class="form-control" id="model"
					placeholder="Podaj model samochodu:" name="model" value="${model}">
			</div>

			<div class="form-group">
				<label for="brand_name">Marka:</label> <input type="text"
					class="form-control" id="brand_name"
					placeholder="Podaj markę samochodu:" name="brand_name"
					value="${brand_name}">
			</div>

			<div class="form-group">
				<label for="year">Rok produkcji:</label> <input type="number"
					min="1900" max="2018" step="1" class="form-control" id="year"
					placeholder="Podaj rok produkcji" name="year" value="${year}">
			</div>

			<div class="form-group">
				<label for="registration_number">Numer rejestracyjny:</label> <input
					type="text" class="form-control" id="registration_number"
					placeholder="Podaj numer rejestracyjny" name="registration_number"
					value="${registration_number}">
			</div>

			<div class="form-group">
				<label for="car_review_date">Data następnego przeglądu:</label> <input
					type="date" class="form-control" id="car_review_date"
					placeholder="Podaj datę kolejnego przeglądu" name="car_review_date"
					value="${car_review_date}">
			</div>

			<div class="form-group">
				<label for="customer_id">Wybierz właściciela pojazdu:</label> <select
					class="form-control" name="customer_id">
					<option value=null></option>
					<c:forEach var="item" items="${customer}">
						<option value="${item.id}">id: ${item.id}, imię: ${item.name}, nazwisko: ${item.surName} </option>

					</c:forEach>
				</select>
			</div>

			<button type="submit" class="btn btn-info">Dodaj pojazd</button>
		</form>
	</c:if>



	<c:if test="${action=='update'}">
		<form action="/Warsztat_samochodowy/VehicleUpdate" method="post">
przekazane id to ${id}





			<div class="form-group">
				<label for="model">Model:</label> <input type="text"
					class="form-control" id="model"
					placeholder="Podaj model samochodu:" name="model" value="${model}">
			</div>

			<div class="form-group">
				<label for="brandName">Marka:</label> <input type="text"
					class="form-control" id="brand_name"
					placeholder="Podaj markę samochodu:" name="brandName"
					value="${brandName}">
			</div>

			<div class="form-group">
				<label for="year">Rok produkcji:</label> <input type="number"
					min="1900" max="2018" step="1" class="form-control" id="year"
					placeholder="Podaj rok produkcji" name="year" value="${year}">
			</div>

			<div class="form-group">
				<label for="registrationNumber">Numer rejestracyjny:</label> <input
					type="text" class="form-control" id="registrationNumber"
					placeholder="Podaj numer rejestracyjny" name="registrationNumber"
					value="${registrationNumber}">
			</div>

			<div class="form-group">
				<label for="carReviewDate">Data następnego przeglądu:</label> <input
					type="date" class="form-control" id="carReviewDate"
					placeholder="Podaj datę kolejnego przeglądu" name="carReviewDate"
					value="${carReviewDate}">
			</div>

			<div class="form-group">
				<label for="customerId">Wybierz właściciela pojazdu:</label> <select
					class="form-control" name="customerId">
						<option value=null></option>
					<c:forEach var="item" items="${customer}">
						<option value="${item.id}">id: ${item.id}, imię: ${item.name}, nazwisko: ${item.surName} </option>

					</c:forEach>
				</select>
				
				
				<input type="hidden"
					class="form-control" id="id"
					placeholder="id" name="id"
					value="${id}" >
			</div>

			<button type="submit" class="btn btn-info">Zmień dane pojazdu</button>
		</form>
	</c:if>




</div>


<jsp:include page="fragments/footer.jsp" />
