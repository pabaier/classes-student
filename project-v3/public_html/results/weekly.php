<?php
    //NEED TO: DELETE WEEK, SORT BY COLUMNS

    include ($_SERVER['DOCUMENT_ROOT']."/menu.php"); 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    $week = $_REQUEST['week'];
    $weeks = array();

    echo "<h1>Weekly Results - week ".$week."</h1>";


    $sql = "SELECT WeekNumber AS week FROM WeeklyResults GROUP BY week";
    if ($result = $mysqli->query($sql)) {
        while($row = $result -> fetch_assoc()){
            $weeks[]=$row['week'];
        }
    }
    else{
        echo "<br>";
        echo "Errno: " . $mysqli->errno . "</br>";
        echo "Error: " . $mysqli->error . "</br>";
    }
    echo "<form method='get'>";
        echo "Select Week: ";
        echo "<select name='week'>";
        foreach($weeks as $w){
            if($w == $week){
                echo "<option name='week' value='".$w."' selected>".$w."</option>";
            }
            else{
                echo "<option name='week' value='".$w."'>".$w."</option>";
            }
        }
        echo "</select>";
        echo "<input type='hidden' name='previousWeek' value=".$week.">";
        echo "<input type='submit' formaction='/results/weekly.php' value='Go'>";
        echo "<input type='submit' formaction='/results/addDeleteWeek.php' name='op' value='Add Week'>";
        echo "<input type='submit' formaction='/results/addDeleteWeek.php' name='op' value='Delete Week'>";

    echo "</form>";

    $sqlOne = "CALL weeklyResult ('".$week."')";
    if ($result = $mysqli->query($sqlOne)) {
        echo "<table class='weekly' id='week".$week."'>";
        echo "<tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Team Name</th>
                <th>Weight</th>
                <th colspan='2'></th></tr>";
        while($row = $result -> fetch_assoc()){
            $firstName = $row['FirstName'];
            $lastName = $row['LastName'];
            $teamsName = $row['TeamsName'];
            $weight = $row['Weight'];
            $id = $row['id'];
            echo "<tr>";
                echo "<form method='post'>";
                echo "<td>";
                    echo $firstName;
                echo "</td>";
                echo "<td>";
                    echo $lastName;
                echo "</td>";
                echo "<td>";
                    echo $teamsName;
                echo "</td>";
                echo "<td>";
                    echo "<input type='text' name='Weight' value='".$weight."' maxlength='6' size='6'>";
                echo "</td>";
                echo "<td>";
                    echo "<input type='hidden' name='week' value='".$week."'>";
                    echo "<input type='hidden' name='id' value='".$id."'>";
                    echo "<input type='submit' formaction='/results/saveWeight.php' value='save'>";
                echo "</td>";
                echo "</form>";
            echo "</tr>";
        }
        echo "</table>";
    }
?>