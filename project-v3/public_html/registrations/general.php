<?php
    include $_SERVER['DOCUMENT_ROOT']."/menu.php"; 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    include $_SERVER['DOCUMENT_ROOT']."/shared/utils.php";
    $page = $_REQUEST['page'];//"trainers";
    $Page = ucfirst($page);

    echo "<h1>".$Page." Registration</h1>";
    $query = "SELECT ".$Page.".FirstName, ".$Page.".LastName, T.TeamsName, ".$Page.".id 
                FROM ".$Page."
                LEFT JOIN Teams_".$Page." as T
                ON ".$Page.".id = T.".$Page."id"             
    ;

    if($result = $mysqli->query($query)){
        $optData = getdbColumn("Teams", "Name");
        echo "<table class='registrations' id='".$page."Registration'>";
        echo "<tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Team</th><th colspan='2'></th>";
        while($row = $result -> fetch_assoc()){
            $tableKey = $row['id'];
            echo "<tr>";
            // echo var_dump($row);
                echo "<form method='post'>";
                echo "<td>";
                    echo $row['FirstName'];
                echo "</td>";
                echo "<td>";
                    echo $row['LastName'];
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
                    echo "<input type='hidden' name='".$page."' value=".$tableKey.">";
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