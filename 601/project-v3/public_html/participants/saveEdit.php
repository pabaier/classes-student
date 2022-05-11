<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    include $_SERVER['DOCUMENT_ROOT'].'/shared/utils.php';
    
    $page = "participants";
    $sql = "UPDATE ".ucfirst($page)." 
            SET 
                FirstName='".$_REQUEST['FirstName']."',
                LastName='".$_REQUEST['LastName']."',
                Age='".$_REQUEST['Age']."',
                Gender='".$_REQUEST['Gender']."'
            WHERE id='".$_REQUEST['id']."'
            ";
    if (!$result = $mysqli->query($sql)) {
        $errno = $mysqli->errno;
        switch ($errno){
            case '1064':
                echo "Sorry you have entered some invalid characters";
                break;
            case '1062':
                echo $page." with the name ".$_REQUEST['name']." already exists";
                break;
            default:
                echo "Errno: " . $mysqli->errno . "</br>";
                echo "Error: " . $mysqli->error . "</br>";
        }
        echo "<br>";
        echo "<a href='/".$page."/addedit.php?fn=edit".buildURLValues($_REQUEST)."'>back</a>";
    }
    else{
        echo "<script>window.location='/".$page."/view.php?'; </script>";
    }

?>