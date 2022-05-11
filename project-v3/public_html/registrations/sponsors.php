<?php
    include $_SERVER['DOCUMENT_ROOT']."/menu.php"; 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    $page = "sponsors";

    echo "<h1>".ucfirst($page)." Registration</h1>";
    $query = "SELECT Sponsors.Name, tx.TeamsName 
                FROM Sponsors
                LEFT JOIN Teams_".ucfirst($page)." as tx
                ON Sponsors.Name = tx.SponsorsName"             
    ;

    if($result = $mysqli->query($query)){
        $optData = getdbColumn("Teams", "Name");
        echo "<table class='registrations' id='".$page."Registration'>";
        echo "<tr>
                <th>Sponsor</th>
                <th>Team</th><th colspan='2'></th>";
        while($row = $result -> fetch_assoc()){
            $tableKey = $row['Name'];
            $editString = "";
            $editString .= "&Name=".$tableKey;
            $editString .= "&TeamsName=".$row['TeamsName'];

            echo "<tr>";
                echo "<form method='post'>";
                echo "<td>";
                    echo $tableKey;
                echo "</td>";
                echo "<td>";
                    echo "<select name='Team'>";
                    echo "<option value='null'></option>";
                    echo createOptionsFromColumn($optData, $row['TeamsName']);
                    echo "</select>";
                echo "</td>";
                echo "<td>";
                    echo "<input type='submit' formaction='save.php' value='save'>";
                    echo "<input type='hidden' name='pageName' value='".$page."'>";
                    echo "<input type='hidden' name='".$page."' value='".$tableKey."'>";
                echo "</td>";
                echo "</form>";
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