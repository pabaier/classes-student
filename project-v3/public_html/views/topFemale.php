<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php"); 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';

    echo "<h1>Top Female Weight Lost</h1>";
    $query = "SELECT * FROM topTenWomen";

    if($result = $mysqli->query($query)){
        echo "<table class='views' id='topFemale'>";
        echo "<tr>
                <th></th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Team</th>
                <th>Weight Lost</th>
              </tr>";
        $i = 1;
        while($row = $result -> fetch_assoc()){
            $color = 'green';
            $op = "";
            $diff = $row['weightLost'];
            if($diff > 0){
                $color = 'red';
                $op = "+";
            }
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
                    echo "<span style='color:".$color."'>".$op.$row['weightLost']."</span>";
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
