<?php
    $servername="localhost";
    $username="CSIS604h";
    $password="8709";
    $db="CSIS604h";
    $conn = new mysqli_connect($servername, $username, $password, $db);

        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }

    // echo "Connected successfully<br><br>";

    // $mysqli = new mysqli('127.0.0.1', 'aspeno55_reg_use', 'snow123', 'aspeno55_registration');
    // if ($mysqli->connect_errno) {
    // echo "Error: Failed to make a MySQL connection, here is why: </br>";
    // echo "Errno: " . $mysqli->connect_errno . "</br>";
    // echo "Error: " . $mysqli->connect_error . "</br>";
    
    // exit;
    // }

?>