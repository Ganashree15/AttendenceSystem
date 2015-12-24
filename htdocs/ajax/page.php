<?php

session_start();
if(empty($_SESSION['username'])) {
	header('Location: index.php');
} else {
	echo "Welcome finally". $_SESSION['username'];
}


?>