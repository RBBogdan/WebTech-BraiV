<?php

if (isset($_POST['Submit'])){

$mysqlhost = "localhost";  //Hostname
$mysqluser = "******"; //Username
$mysqlpwd = "******";  //userPassword
$mysqldb = "******";  //MySQL DB

$con = mysql_connect(localhost,$mysqluser,$mysqlpwd);
mysql_select_db($mysqldb, $con);
$formvalue = $_POST['reservationId'];
//is_numeric helps here against SQL injection
if (is_numeric($formvalue)){
$sql = mysql_query("SELECT * FROM Reservations WHERE ID=$formvalue"); 

while($row = mysql_fetch_array($sql))
  {
  echo $row['ID'] . " " . $row['Cinema'] . " " . $row['Movie'] . " " . $row['Seats'] . " " . $row['Name'] . " " . $row['Mail'] . " " . $row['Phone'];
  echo "<br />";
  }

mysql_close($con);
//print($sql);
} else {
print '<script type="text/javascript">'; 
print 'alert("No attacks! Registration ID is numeric value")'; 
print '</script>';  
}
}


 ?>