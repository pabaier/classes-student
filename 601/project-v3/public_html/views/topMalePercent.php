<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php"); 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';

    echo "<h1>Top Male Percentage Weight Lost</h1>";
    $query = "SELECT * FROM topTenMenPercent";

    if($result = $mysqli->query($query)){
        echo "<table class='views' id='topMalePercent'>";
        echo "<tr>
                <th></th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Team</th>
                <th>Percent Weight Lost</th>
              </tr>";
        $i = 1;
        while($row = $result -> fetch_assoc()){
            echo "<tr>";
                echo "<td>";
                    echo $i.".";
                echo "</td>";
                echo "<td>";
                    echo $row['FirstName'];
                echo "</td>";
                echo "<td>";
                    echo $row['LastName'];
                echo "</td>";
                echo "<td>";
                    echo $row['Team'];
                echo "</td>";
                echo "<td>";
                    echo $row['percent']."%";
                echo "</td>";
            echo "</tr>";
            $i++;
        }
        echo "</table>";
    }
    else{
        echo "unable to connect to server<br>";
        echo "Errno: " . $mysqli->errno . "</br>";
        echo "Error: " . $mysqli->error . "</br>";
    }
?>
