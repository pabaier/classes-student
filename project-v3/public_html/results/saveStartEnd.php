<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php"); 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';

    $type = $_REQUEST['type'];
    $Type = ucfirst($type);
    $id = $_REQUEST['id'];
    $firstName = $_REQUEST['FirstName'];
    $lastName = $_REQUEST['LastName'];
    $team = $_REQUEST['Team'];
    $urlString = "id=".$id."&FirstName=".$firstName."&LastName=".$lastName."&Team=".$team."&type=".$type;

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
        }
        echo "<br>";
        echo "<a href='/results/startEnd.php?".$urlString."'>back</a>";
    }
    else{
        echo "<script>window.location='/results/home.php'; </script>";
    }

?>