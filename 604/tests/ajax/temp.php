<?php
    $servername="localhost";
    $username="CSIS604h";
    $password="8709";
    $db="CSIS604h";
    $conn = new mysqli($servername, $username, $password, $db);

        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }

    echo "Connected successfully<br><br>";

?>