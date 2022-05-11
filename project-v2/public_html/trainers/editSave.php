<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    
    $page = "trainers";
    $sql = "UPDATE ".ucfirst($page)." 
            SET PhoneNumber='".$_REQUEST['phone']."',
                Contact='".$_REQUEST['contact']."',
                Other='".$_REQUEST['other']."'
            WHERE Name='".$_REQUEST['name']."'
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
        echo "<a href='/".$page."/addedit.php?fn=edit&name=".$_REQUEST['name']."'>back</a>";
    }
    else{
        echo "<script>window.location='/".$page."/view.php'; </script>";
    }

?>