<?php
function executeQuery($query) {
	if(empty($query)){
		return false;
	}
	else{
		$result = mysql_query($query) or die("Error".mysql_error());
	}
	return $result;
}

?>
