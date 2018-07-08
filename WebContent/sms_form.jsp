<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="fragments/header.jsp" />


<h3>Zarządzanie klientami</h3>


<br>
<br>


<div class="container">
	<h2>Podaj dane nowego klienta</h2>



	<form action="/Warsztat_samochodowy/sendSMS" method="post" id="form">

		<div class="form-group">
			<label for="telnumber">Numer telefonu:</label> <input type="text"
				class="form-control" id="telnumber" name="telnumber"
				value="${telnumber}">
		</div>

		<div class="form-group">
			<textarea name="smstext" form="form" placeholder="Wpisz treść sms" cols="100" rows="4"></textarea>
		</div>

		<input type="hidden" class="form-control" id="id" placeholder="id"
			name="id" value="${id}">

		<button type="submit" class="btn btn-info">Wyślij sms</button>
	</form>


</div>


<jsp:include page="fragments/footer.jsp" />
