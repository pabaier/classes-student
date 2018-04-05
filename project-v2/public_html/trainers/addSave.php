<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
 
    $page = "trainers";
    $sql = "INSERT INTO 
                Sponsors(Name,PhoneNumber,Contact,Other)
            VALUES 
                ('" . $_REQUEST['name'] . "','" 
                    . $_REQUEST['phone'] . "','"
                    . $_REQUEST['contact'] . "','"
                    . $_REQUEST['other'] . "'
                )
            ";
    if (!$result = $mysqli->query($sql)) {
        $errno = $mysqli->errno;
        switch ($errno){
            case '1064':
                echo "Sorry you cannot use that name. It has Invalid characters";
                break;
            case '1062':
                echo "A team with the name ".$_REQUEST['name']." already exists";
                break;
            default:
                echo "Errno: " . $mysqli->errno . "</br>";
                echo "Error: " . $mysqli->error . "</br>";
        }
        echo "<br>";
        echo "<a href='/".$page."/addedit.php?fn=add'>back</a>";
        // exit;
    }
    else{
        echo "<script>window.location='/".$page."/view.php'; </script>";
    }

?>