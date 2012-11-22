<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercise 5 - Reservations Management - Error: Something was not found</title>
<LINK href="cinemasAroundStyle.css" rel="stylesheet" type="text/css" />
</head>
<body class="AllignCenter">
	<center>
		<br />
		<img align="middle" border="0" src="doh-404.gif" alt="FOUR - OH - FOUR" />
		<br />
		<br />
		<h1>Problem occurred: <%out.println(request.getAttribute("problem"));%></h1>
		<br />
		<br />
		<input type = "button" name = "Back" id = "backButton" value="Back" class ="btn btn-primary" onclick="history.back()" />
		<br />
	</center>
</body>
</html>