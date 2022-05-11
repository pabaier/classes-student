<?php
    $password="dabrown0408";
    $servername="127.0.0.1";
    $username="paulb165";
    $db="paulb165_hcc";
    $mysqli = new mysqli($servername, $username, $password, $db);

    if ($mysqli->connect_errno) {
        echo "Errno: " . $mysqli->connect_errno . "</br>";
        echo "Error: " . $mysqli->connect_error . "</br>";
        exit;
    }
?>