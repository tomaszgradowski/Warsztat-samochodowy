<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark"> <!-- Links -->
	<ul class="navbar-nav">

			
		<li class="nav-item"><a class="nav-link" href="/Warsztat_samochodowy/index.jsp">Strona główna</a></li>
		
		
		
		
		<!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="/Warsztat_samochodowy/CustomerAll" id="navbardrop" data-toggle="dropdown">
       Zarządzanie klientami
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/Warsztat_samochodowy/CustomerAll">Lista klientów</a>
        <a class="dropdown-item" href="/Warsztat_samochodowy/CustomerAdd?action=add">Dodaj nowego klienta</a>
        <a class="dropdown-item" href="#">Link 3</a>
      </div>
      
      
       <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="/Warsztat_samochodowy/VehicleAll" id="navbardrop" data-toggle="dropdown">
       Zarządzanie pojazdami
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/Warsztat_samochodowy/VehicleAll">Lista pojazdów</a>
        <a class="dropdown-item" href="/Warsztat_samochodowy/VehicleAdd?action=add">Dodaj nowy pojazd</a>
        <a class="dropdown-item" href="#">Link 3</a>
      </div>
      
         <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="/Warsztat_samochodowy/EmployeeAll" id="navbardrop" data-toggle="dropdown">
       Zarządzanie pracownkami
      </a>
       <div class="dropdown-menu">
        <a class="dropdown-item" href="/Warsztat_samochodowy/EmployeeAll">Lista pracowników</a>
        <a class="dropdown-item" href="/Warsztat_samochodowy/EmployeeAdd?action=add">Dodaj nowego pracownika</a>
        <a class="dropdown-item" href="#">Link 3</a>
      </div>    
      
        <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="/Warsztat_samochodowy/EmployeeAll" id="navbardrop" data-toggle="dropdown">
       Zarządzanie zleceniami
      </a>
       <div class="dropdown-menu">
        <a class="dropdown-item" href="/Warsztat_samochodowy/OrdersAll">Lista zleceń</a>
        <a class="dropdown-item" href="/Warsztat_samochodowy/OrdersAdd?action=add">Dodaj nowe zlecenie</a>
        <a class="dropdown-item" href="#">Link 3</a>
      </div>    
      
      
    </li>
	</ul>
	</nav>
	<br>