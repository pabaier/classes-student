<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php"); 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';

    echo "<h1>Trainers</h1>";
    $query = "SELECT * FROM Trainers tr
              INNER JOIN Teams te
              ON tr.CurrentTeamID = te.ID
              ";
    if($result = $mysqli->query($query)){
        echo "<table class='view' id='sponsorView'>";
        while($row = $result -> fetch_assoc()){
            // echo "<tr><td>".var_dump($row)."</td></tr>";
            echo"<tr><td>".$row['FirstName'].
                "</td><td>".$row['LastName'].
                "</td><td>".$row['Name'].
                "</td><td>"."<a href='addedit.php?fn=edit".
                                "&id=".$row['ID'].
                                "&firstName=".$row['FirstName'].
                                "&lastName=".$row['LastName'].
                                "&currentTeamID=".$row['CurrentTeamID'].
                                "'>edit</a>".
                "</td><td>"."<a href='delete.php?id=" . $row['ID'] .  "'>delete</a>".
                "</td></tr>";
        }
        echo "</table>";
    }
    else{
        echo "unable to connect to server";
    }
?>
