<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php"); 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    $type = $_REQUEST['type'];
    $Type = ucfirst($type);
    $id = $_REQUEST['id'];
    $firstName = $_REQUEST['FirstName'];
    $lastName = $_REQUEST['LastName'];
    $VisceralFat = $_REQUEST['VisceralFat'];
    if(empty($VisceralFat))
        $VisceralFat = "NULL";
    $BMI = $_REQUEST['BMI'];
    if(empty($BMI))
        $BMI = "NULL";
    $BodyFatPercent = $_REQUEST['BodyFatPercent'];
    if(empty($BodyFatPercent))
        $BodyFatPercent = "NULL";
    $LeanMusclePercent = $_REQUEST['LeanMusclePercent'];
    if(empty($LeanMusclePercent))
        $LeanMusclePercent = "NULL";
    $lastPageFail = $_REQUEST['lastPageFail'];
    $lastPageSuccess = $_REQUEST['lastPageSuccess'];
    $currentPage = "/results/saveStartEnd.php";
    $team = $_REQUEST['Team'];

    // $sql = "INSERT INTO ".$Type."Results(Participantsid, VisceralFat, BMI, BodyFatPercent, LeanMusclePercent)
    //         VALUES ('". $id."','".$VisceralFat."','".$BMI."','".$BodyFatPercent."','".$LeanMusclePercent."')";

    $sql = "UPDATE ".$Type."Results SET 
                        VisceralFat=".$VisceralFat.",
                        BMI=".$BMI.",
                        BodyFatPercent=".$BodyFatPercent.",
                        LeanMusclePercent=".$LeanMusclePercent."
                        WHERE Participantsid=".$id;
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
                echo "All inputs should be numbers - no letters allowed. Try Again ;)";
                // echo "Errno: " . $mysqli->errno . "</br>";
                // echo "Error: " . $mysqli->error . "</br>";
        }
        echo "<br>";
        echo "<a href='".$lastPageSuccess."?Team=".$team."'>back</a>";
    }
    else{
        echo "<script>window.location='".$lastPageSuccess."?Team=".$team."'; </script>";
    }

?>