<?php
$mysqlhost = "localhost";  //Hostname
$mysqluser = "******"; //Username
$mysqlpwd = "******";  //userPassword
$mysqldb = "******";  //MySQL DB
 
 /* MySQL connect  */ 
@mysql_connect($mysqlhost, $mysqluser, $mysqlpwd)
or die("Connection failed");

@mysql_select_db($mysqldb) 
or die("Could not load DB");


?>
