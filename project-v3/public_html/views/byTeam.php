<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php"); 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    // include $_SERVER['DOCUMENT_ROOT'].'/shared/utils.php';

    // echo var_dump($_REQUEST);
    $team = $_REQUEST['Team'];

    $query = "SELECT * 
            FROM Participants as P
            INNER JOIN Teams_Participants as TP
            ON P.id = TP.Participantsid
            INNER JOIN Teams as T
            ON TP.TeamsName = T.Name
            WHERE Name = '".$team."'";

    if($result = $mysqli->query($query)){
        echo "<h1>".$team."</h1>";
        echo "<table class='view' id='byTeam'>";
        echo "<tr><th>First Name</th><th>Last Name</th><th>Age</th><th>Gender</th><th colspan=3></th></tr>";
        while($row = $result -> fetch_assoc()){
            echo "<tr>";
            $fn = $row['FirstName'];
            $ln = $row['LastName'];
            $age = $row['Age'];
            $gen = $row['Gender'];
            $id = $row['id'];
            echo "<td>".$fn."</td>";
            echo "<td>".$ln."</td>";
            echo "<td>".$age."</td>";
            echo "<td>".$gen."</td>";
            echo "<td><a href='/results/startEnd.php?FirstName=".$fn."&LastName=".$ln."&id=".$id."&Team=".$team."&lastPage=/views/byTeam.php&type=start'>Start</a></td>";
            echo "<td><a href='/results/startEnd.php?FirstName=".$fn."&LastName=".$ln."&id=".$id."&Team=".$team."&lastPage=/views/byTeam.php&type=end'>End</a></td>";
            echo "<td><a href='/results/startEnd.php?FirstName=".$fn."&LastName=".$ln."&id=".$id."'>Weekly</a></td>";
            echo "</tr>";
        }
        echo "</table>";
    }
    else{
        echo "unable to connect to server<br>";
        echo "Errno: " . $mysqli->errno . "</br>";
        echo "Error: " . $mysqli->error . "</br>";
    }


?>