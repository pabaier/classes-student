<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php"); 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    $type = $_REQUEST['type'];
    $Type = ucfirst($type);
    $id = $_REQUEST['id'];
    $firstName = $_REQUEST['FirstName'];
    $lastName = $_REQUEST['LastName'];
    $team = $_REQUEST['Team'];

    echo "<h1>".$firstName." ".$lastName." - ".$team."</h1>";
    echo "<h2>".$Type." Results</h2>";

    $sql = "SELECT * 
    FROM ".$Type."Results
    WHERE Participantsid = '".$id."'";

    if (!$result = $mysqli->query($sql)) {
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
        echo "<a href='/results/startEnd.php?".buildURLValues($_REQUEST)."'>back</a>";
    }
    else{
        while($row = $result -> fetch_assoc()){
            $VisceralFat = $row['VisceralFat'];
            $BMI = $row['BMI'];
            $BodyFatPercent = $row['BodyFatPercent'];
            $LeanMusclePercent = $row['LeanMusclePercent'];

            echo "<form method='post'>";

                echo "Visceral Fat: <input type='text' name='VisceralFat' value='".$VisceralFat."'>";
                echo "<br>";

                echo "Body Mass Index: <input type='text' name='BMI' value='".$BMI."'>";
                echo "<br>";

                echo "Body Fat Percentage(%): <input type='text' name='BodyFatPercent' value='".$BodyFatPercent."'>";
                echo "<br>";

                echo "Lean Muscle Percentage(%): <input type='text' name='LeanMusclePercent' value='".$LeanMusclePercent."'>";
                echo "<br>";

                echo "<br>";

                echo "<input type='hidden' name='type' value='".$type."'>";
                echo "<input type='hidden' name='id' value='".$id."'>";
                echo "<input type='hidden' name='firstName' value='".$firstName."'>";
                echo "<input type='hidden' name='lastName' value='".$lastName."'>";
                echo "<input type='hidden' name='Team' value=".$team.">";

                echo "<input type='submit' formaction='/results/saveStartEnd.php' value='Submit'>";
                echo "<button type='submit' formaction='/results/home.php'>Cancel</button>";
            echo "</form>";
        }
    }


?>