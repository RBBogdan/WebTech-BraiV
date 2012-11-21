<?php
require("_mysql.php");
require("_functions.php");


if(isset($_POST['action'])){
	if($_POST['action'] == "getReservedSeats"){
		getReservedSeats($_POST['cinema'], $_POST['movie']);	
	}
	else if($_POST['action'] == "doReservation"){
		doReservation($_POST['cinema'], $_POST['movie'], $_POST['seats'], $_POST['name'], $_POST['mail'], $_POST['phone']);
	}
}

function getReservedSeats($cinema, $movie){
	$erg = executeQuery("SELECT Seats FROM Reservations WHERE Cinema = '".$cinema."' AND Movie = '".$movie."'");  
	while($result=mysql_fetch_array($erg)) {
		$db_seats=$result['Seats'];
		echo $db_seats.";";
	}
}


function doReservation($cinema, $movie, $seats, $name, $mail, $phone){
	executeQuery("INSERT INTO Reservations (Cinema, Movie, Seats, Name, Mail, Phone) VALUES (\"".$cinema."\", \"".$movie."\", \"".$seats."\", \"".$name."\", \"".$mail."\", \"".$phone."\")");    
}


?>