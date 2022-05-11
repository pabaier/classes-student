<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    include $_SERVER['DOCUMENT_ROOT'].'/shared/utils.php';
 
    $page = "sponsors";
    $sql = "INSERT INTO ".ucfirst($page)."(
        Name,
        PhoneNumber,
        Email,
        ContactPerson,
        Other
        )
        VALUES 
            ('"
               . $_REQUEST['Name']."','"
               . $_REQUEST['PhoneNumber']."','"
               . $_REQUEST['Email']."','"
               . $_REQUEST['ContactPerson']."','"
               . $_REQUEST['Other'] . "'
            )";
    if (!$result = $mysqli->query($sql)) {
        $errno = $mysqli->errno;
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
        echo "<a href='/".$page."/addedit.php?fn=add'>back</a>";
    }
    else{
        echo "<script>window.location='/".$page."/view.php?'; </script>";
    }

?>