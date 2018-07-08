<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="fragments/header.jsp" />


<h3>Zarządzanie zleceniami</h3>


<br>
<br>
<c:if test="${action == 'add' }">
	<div class="container">
		<h2>Podaj dane nowego zlecenia</h2>

		private Date repairDate; private Date repairStartDatePlanned; private
		Date repairStartDate; private int employeeId; private String
		problemDescription; private String repairDecription; private int
		statusId; private int vehicleId; private double repairCostForClient;
		private double partCosts; private double workHourCost; private double
		workHourQuantity;


		<%-- 	<c:if test="${action == 'add' }"> --%>
		<form action="/Warsztat_samochodowy/OrdersAdd" method="post">

			<div class="form-group">
				<label for="repairDate">Data przyjęcia do naprawy:</label> <input
					type="date" class="form-control" id="repairDate"
					placeholder="Podaj datę przyjęcia do naprawy" name="repairDate"
					value="${repairDate}">
			</div>

			<div class="form-group">
				<label for="repairStartDatePlanned">Planowana data
					rozpoczęcia naprawy::</label> <input type="date" class="form-control"
					id="repairStartDatePlanned"
					placeholder="Podaj planowaną datę rozpoczęcia naprawy:"
					name="repairStartDatePlanned" value="${repairStartDatePlanned}">
			</div>

			<div class="form-group">
				<label for="repairStartDate">Data roczpoczęcia naprawy:</label> <input
					type="date" class="form-control" id="repairStartDate"
					placeholder="Podaj datę rozpoczęcia naprawy" name="repairStartDate"
					value="${repairStartDate}">
			</div>

			<div class="form-group">
				<label for="employeeId">Przypisz pracownika do zlecenia:</label> <select
					class="form-control" name="employeeId">
					<option value=null></option>
					<c:forEach var="item" items="${employee}">
						<option value="${item.id}">id: ${item.id}, imię: ${item.name}, nazwisko: ${item.surname} </option>

					</c:forEach>
				</select>
			</div>


			<div class="form-group">
				<label for="problemDescription">Opis problemu:</label> <input type="text"
					class="form-control" id="problemDescription"
					placeholder="Opisz problem" name="problemDescription"
					value="${problemDescription}">
			</div>

			<div class="form-group">
				<label for="repairDecription">Opis naprawy:</label> <input type="text"
					class="form-control" id="repairDecription" placeholder="Opisz naprawę"
					name="repairDecription" value="${repairDecription}">
			</div>



			<div class="form-group">
				<label for="statusId">Przypisz status zlecenia:</label> <select
					class="form-control" name="statusId">
					<option value=null></option>
					<c:forEach var="item" items="${status}">
						<option value="${item.id}">id: ${item.id}, status: ${item.type}</option>

					</c:forEach>
				</select>
			</div>



			<div class="form-group">
				<label for="vehicleId">Przypisz status zlecenia:</label> <select
					class="form-control" name="vehicleId">
					<option value=null></option>
					<c:forEach var="item" items="${vehicle}">
						<option value="${item.id}">id: ${item.id}, marka: ${item.model}, numer rejestracyjny: ${item.registration_number}</option>

					</c:forEach>
				</select>
			</div>




			<div class="form-group">
				<label for="workHourCosts">Podaj koszt roboczogodziny:</label> <input
					type="number" min="0" step="0.01" class="form-control"
					id="workHourCosts" placeholder="Wpisz notatkę" name="workHourCosts"
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
					class="form-control" id="name" placeholder="Podaj imię pracownika:"
					name="name" value="${name}">
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
					placeholder="Podaj adres pracownika" name="adress"
					value="${adress}">
			</div>

			<div class="form-group">
				<label for="telNumber">Numer telefonu:</label> <input type="text"
					class="form-control" id="telNumber"
					placeholder="Podaj numer telefonu" name="telNumber"
					value="${telNumber}">
			</div>

			<div class="form-group">
				<label for="note">Notatka:</label> <input type="text"
					class="form-control" id="note" placeholder="Wpisz notatkę"
					name="note" value="${note}">
			</div>

			<div class="form-group">
				<label for="workHourCosts">Notatka:</label> <input type="number"
					min="0" step="0.01" class="form-control" id="workHourCosts"
					placeholder="Wpisz notatkę" name="workHourCosts"
					value="${workHourCosts}">
			</div>


			<div class="form-group">
				<input type="hidden" class="form-control" id="id" placeholder="id"
					name="id" value="${id}">
			</div>

			<button type="submit" class="btn btn-info">Zmień dane
				pracownika</button>
		</form>
	</div>
</c:if>







<jsp:include page="fragments/footer.jsp" />
