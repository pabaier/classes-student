<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php"); 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';

    $id = $_REQUEST['id'];
    $weekNumber = $_REQUEST['week'];
    $weight = $_REQUEST['Weight'];
    if(empty($weight))
        $weight = "NULL";

    $sql = "UPDATE WeeklyResults
            SET Weight = ".$weight."
            WHERE Participantsid=".$id."
            AND WeekNumber=".$weekNumber;
    if (!$result = $mysqli->query($sql)) {
        echo "<br><br>";
        switch ($errno){
            case '1064':
                echo "Sorry you have entered some invalid characters";
                break;
            case '1062':
                echo $page." with the name ".$_REQUEST['Name']." already exists";
                break;
            case '1054':
                echo "All inputs should be numbers - no letters allowed. Try Again ;)";
                break;
            default:
                echo "Errno: " . $mysqli->errno . "</br>";
                echo "Error: " . $mysqli->error . "</br>";
        }
        echo "<br>";
        echo "<a href='/results/weekly.php?week=".$weekNumber."'>back</a>";
    }
    else{
        echo "<script>window.location='/results/weekly.php?week=".$weekNumber."'; </script>";
    }

?>