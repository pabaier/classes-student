<?php
    $q = strtolower($_GET['q']);
    // Normally this data would be pulled from a database by PHP...
    if(strcasecmp($q, 'a') == 0) {
        echo "Ava";
    }
    else if(strcasecmp($q, 'b') == 0) {
        echo "Beth";
    }
    else{
        echo "";
    }

    $servername="localhost";
    $username="the username";
    $password="password";
    $db="the data base";

?>