<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php"); 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';

    $sql = "SELECT * FROM PartsWithTeams";

    if ($result = $mysqli->query($sql)) {
        echo "<table class='results' id='start'>";
        echo "<tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Team</th>
                <th colspan=2>Results</th>
              </tr>";
        while($row = $result -> fetch_assoc()){
            $firstName = $row['FirstName'];
            $lastName = $row['LastName'];
            $team = $row['TeamsName'];
            $id = $row['id'];
            $urlString = "id=".$id."&FirstName=".$firstName."&LastName=".$lastName."&Team=".$team;
            echo "<tr>";
                echo "<td>";
                    echo $firstName;
                echo "</td>";
                echo "<td>";
                    echo $lastName;
                echo "</td>";
                echo "<td>";
                    echo $team;
                echo "</td>";
                echo "<td>";
                    echo "<a href='/results/startEnd.php?".$urlString."&type=Start'>Start</a>";
                echo "</td>";
                echo "<td>";
                    echo "<a href='/results/startEnd.php?".$urlString."&type=End'>End</a>";
                echo "</td>";
            echo "</tr>";
        }
        echo "</table>";
    }
    else{
        echo var_dump($_REQUEST)."<br>";
        $errno = $mysqli->errno;
        echo "Errno: " . $mysqli->errno . "</br>";
        echo "Error: " . $mysqli->error . "</br>";
        echo $sql."<br>";
        switch ($errno){
            case '1064':
                echo "Sorry you have entered some invalid characters";
                break;
            case '1062':
                echo $page." with the name ".$_REQUEST['Name']." already exists";
                break;
            default:
                echo "Errno: " . $mysqli->errno . "</br>";
                echo "Error: " . $mysqli->error . "</br>";
        }
        echo "<br>";
        echo "<a href='index.php'>home</a>";
    }


?>