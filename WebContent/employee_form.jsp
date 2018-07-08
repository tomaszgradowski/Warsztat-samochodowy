<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="fragments/header.jsp" />


<h3>Zarządzanie pracownikami</h3>


<br>
<br>
<c:if test="${action == 'add' }"> 
<div class="container">
	<h2>Podaj dane nowego pracownika</h2>


<%-- 	<c:if test="${action == 'add' }"> --%>
		<form action="/Warsztat_samochodowy/EmployeeAdd" method="post">

			<div class="form-group">
				<label for="name">Imię:</label> <input type="text"
					class="form-control" id="name"
					placeholder="Podaj imię pracownika:" name="name" value="${name}">
			</div>

			<div class="form-group">
				<label for="surname">Nazwisko:</label> <input type="text"
					class="form-control" id="surname"
					placeholder="Podaj nazwisko pracownika:" name="surname"
					value="${surname}">
			</div>

			<div class="form-group">
				<label for="adress">Adres:</label> <input type="text"
					 class="form-control" id="adress"
					placeholder="Podaj adres pracownika" name="adress" value="${adress}">
			</div>

			<div class="form-group">
				<label for="telNumber">Numer telefonu:</label> <input
					type="text" class="form-control" id="telNumber"
					placeholder="Podaj numer telefonu" name="telNumber"
					value="${telNumber}">
			</div>

			<div class="form-group">
				<label for="note">Notatka:</label> <input
					type="text" class="form-control" id="note"
					placeholder="Wpisz notatkę" name="note"
					value="${note}">
			</div>
			
			<div class="form-group">
				<label for="workHourCosts">Podaj koszt roboczogodziny:</label> <input
					type="number" min="0" step="0.01" class="form-control" id="workHourCosts"
					placeholder="Wpisz notatkę" name="workHourCosts"
					value="${workHourCosts}">
			</div>




			<button type="submit" class="btn btn-info">Dodaj pracownika</button>
		</form>
		</div>
	</c:if>

przekazane id to ${id}


	<c:if test="${action=='update'}">
	
	<div class="container">
	<h2>Zaktualizuj dane nowego pracownika</h2>
		<form action="/Warsztat_samochodowy/EmployeeUpdate" method="post">

						<div class="form-group">
				<label for="name">Imię:</label> <input type="text"
					class="form-control" id="name"
					placeholder="Podaj imię pracownika:" name="name" value="${name}">
			</div>

			<div class="form-group">
				<label for="surname">Nazwisko:</label> <input type="text"
					class="form-control" id="surname"
					placeholder="Podaj nazwisko pracownika:" name="surname"
					value="${surname}">
			</div>

			<div class="form-group">
				<label for="adress">Adres:</label> <input type="text"
					 class="form-control" id="adress"
					placeholder="Podaj adres pracownika" name="adress" value="${adress}">
			</div>

			<div class="form-group">
				<label for="telNumber">Numer telefonu:</label> <input
					type="text" class="form-control" id="telNumber"
					placeholder="Podaj numer telefonu" name="telNumber"
					value="${telNumber}">
			</div>

			<div class="form-group">
				<label for="note">Notatka:</label> <input
					type="text" class="form-control" id="note"
					placeholder="Wpisz notatkę" name="note"
					value="${note}">
			</div>
			
			<div class="form-group">
				<label for="workHourCosts">Notatka:</label> <input
					type="number" min="0" step="0.01" class="form-control" id="workHourCosts"
					placeholder="Wpisz notatkę" name="workHourCosts"
					value="${workHourCosts}">
			</div>

		
					<div class="form-group">	
				<input type="hidden"
					class="form-control" id="id"
					placeholder="id" name="id"
					value="${id}" >
			</div>

			<button type="submit" class="btn btn-info">Zmień dane pracownika</button>
		</form>
		</div>
	</c:if>







<jsp:include page="fragments/footer.jsp" />
