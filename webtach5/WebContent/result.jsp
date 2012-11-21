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
	<a class="brand">Reservation Info</a>
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
	<br><br>
	<input type = "button" name = "Print" value="Print reservation" class ="btn btn-primary" >
	<input type = "button" name = "Back" value="Back" class ="btn btn-primary" onclick="history.back()">
</body>
</html>