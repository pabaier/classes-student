<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    include $_SERVER['DOCUMENT_ROOT'].'/shared/utils.php';
    $team = "'".$_REQUEST['Team']."'";
    if(strcmp($_REQUEST['Team'], "null")==0){
        $team = "null";
    }
    $pageName = $_REQUEST["pageName"];
    $regTableKey = $_REQUEST[$pageName];
    $regTableColumn = ucfirst($pageName)."id";
    if(strcmp($pageName, "sponsors") == 0){
        $regTableColumn = ucfirst($pageName)."Name";
    }


    $sql = "UPDATE Teams_".ucfirst($pageName)."
    SET TeamsName = ".$team."
    WHERE ".$regTableColumn."='".$regTableKey."'";
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
        if(strcmp($pageName, "sponsors") == 0){
            echo "<a href='/registrations/".$pageName.".php'>back</a>";
        }
        else{
            echo "<a href='/registrations/general.php?page=".$pageName."'>back</a>";
        }
    }
    else{
        if(strcmp($pageName, "sponsors") == 0){
            echo "<script>window.location='/registrations/".$pageName.".php'; </script>";
        }
        else{
            echo "<script>window.location='/registrations/general.php?page=".$pageName."'; </script>";
        }
    }

?>