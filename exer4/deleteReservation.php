<?php
if (isset($_POST['Delete'])){


$mysqlhost = "localhost";  //Hostname
$mysqluser = "******"; //Username
$mysqlpwd = "******";  //userPassword
$mysqldb = "******";  //MySQL DB

$con = mysql_connect(localhost,$mysqluser,$mysqlpwd);
mysql_select_db($mysqldb, $con);
$formvalue = $_POST['reservationId'];
//is_numeric helps here against SQL injection
if (is_numeric($formvalue)){
mysql_query("DELETE FROM Reservations WHERE ID=$formvalue");

mysql_close($con);
}
}

  ?>