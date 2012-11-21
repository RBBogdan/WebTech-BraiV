<%@ page import="java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercise 4</title>
<LINK href="cinemasAroundStyle.css" rel="stylesheet" type="text/css">

</head>
<body>
	<a class="brand">Reservations</a>
	<form action="ReservationService" method = "POST" >
		Reservation ID: <input type="text" name="reservationId" id="resid" >
		<input type="Submit" name="action" value="Show" class="btn btn-primary">
		<input type="Submit" name="action" value="Delete reservation" class = "btn btn-primary">
	</form>
</body>
</html>