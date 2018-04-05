<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    include $_SERVER['DOCUMENT_ROOT'].'/shared/utils.php';
    $team = "'".$_REQUEST['Team']."'";
    if(strcmp($_REQUEST['Team'], "null")==0){
        $team = "null";
    }

    $sql = "UPDATE Teams_".ucfirst($_REQUEST["table"])."
    SET TeamsName = ".$team."
    WHERE SponsorsName ='".$_REQUEST['sponsors']."'";
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
        echo "<a href='/registrations/".$_REQUEST['table'].".php'>back</a>";
    }
    else{
        echo "<script>window.location='/registrations/".$_REQUEST['table'].".php'; </script>";
    }

?>