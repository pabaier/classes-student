<?php
    $tableName = $_GET['fn'];
    $query = "select * from ".$tableName;
    $year = $_GET['yr'];
    $season = $_GET['sn'];
    switch($tableName) {
        case "Teams":
            $query = "SELECT Name, Sponsor, Season, Year FROM Teams";
            break;
        case "Participants":
            $query = "SELECT
                     p.FirstName 'First Name', p.LastName 'Last Name', t.Name 'Team Name'
                     FROM Participants p
                     LEFT JOIN Teams t on p.CurrentTeamID = t.ID
                     ;";
            break;
        case "getHint":
            getHint();
            break;
        case "checkValue":
            $cell = $_GET['index'];
            $input = $_GET['value'];
            $time = $_GET['time'];
            checkValue($cell, $input, $time);
            break;
        default:
            $query = "select * from ".$tableName;
    }
    selectQuery($tableName, $query);


    function selectQuery($tableName, $query){
        include 'db.php';
        if($result = $mysqli->query($query)){
            echo "<button type=\"button\" onclick=\"add('".$tableName."')\">Add ".$tableName."</button>";
            echo "<table id='allInfoTable'>";
            if($result->num_rows == 0){
                echo "<tr>";
                $fields = mysqli_fetch_fields($result);
                foreach($fields as $f){
                    echo "<th>".$f->name."</th>";
                }
                echo "</tr>";
            }
            else{
                $flag = true;
                while ($row = $result->fetch_assoc()) {
                    echo "<tr>";
                    if($flag){
                        $keys = array_keys($row);
                        foreach($keys as $value){
                            echo "<th>".$value."</th>";
                        }
                        $flag = false;
                        echo "<th></th><th></th></tr><tr>";
                    }
                    $vals = array_values($row);
                    foreach($vals as $ind){
                        echo "<td>".$ind."</td>";
                    }
                    echo "<td><button type=\"button\" onclick=\"phplog()\">Edit</button></td>";
                    echo "<td><button type=\"button\">Delete</button></td>";
                    echo "</tr>";
                }
            }
            echo "</table>";
        }
        else{
            echo "query did not work";
        }
    }
?>