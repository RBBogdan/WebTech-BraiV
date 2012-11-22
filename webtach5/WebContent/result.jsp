<%@ page import="java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercise 5 - Reservations Management - Reservation Viewer</title>
<LINK href="cinemasAroundStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h2><a class="brand"> Reservation Info </a></h2>
	<br /><br />
	<%
		if(request.getAttribute("reservation") instanceof ArrayList) {
			out.print("<table id=\"reservationInfo\" class=\"table\"><tr>");
			ArrayList<String> result = (ArrayList<String>) request.getAttribute("reservation");

			for (String st : result) {
				out.println("<td>" + st + "</td>");
			}
			out.print("</table></tr>");
		}
	%>
	<br /><br />
	<input type = "button" name = "Print" id = "printButton" value="Print reservation" class ="btn btn-primary" />
	<input type = "button" name = "Back" id = "backButton" value="Back" class ="btn btn-primary" onclick="history.back()" />
</body>
</html>