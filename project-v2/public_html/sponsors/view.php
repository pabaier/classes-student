<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php"); 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';

    echo "<h1>Sponsors</h1>";
    $query = "SELECT * FROM Sponsors";
    if($result = $mysqli->query($query)){
        echo "<table class='view' id='sponsorView'>";
        while($row = $result -> fetch_assoc()){
            echo "<tr><td>".$row['Name'].
                "</td><td>".$row['PhoneNumber'].
                "</td><td>".$row['Contact'].
                "</td><td>".$row['Other'].
                "</td><td>"."<a href='addedit.php?fn=edit&name=".$row['Name']."&year=".$_REQUEST['year']."&season=".$_REQUEST['season']."'>edit</a>".
                "</td><td>"."<a href='delete.php?name=".$row['Name']."&year=".$_REQUEST['year']."&season=".$_REQUEST['season']."'>delete</a>".
                "</td></tr>";
        }
        echo "</table>";
    }
    else{
        echo "unable to connect to server";
    }
?>
