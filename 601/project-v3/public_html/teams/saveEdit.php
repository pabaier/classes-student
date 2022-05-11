<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    include $_SERVER['DOCUMENT_ROOT'].'/shared/utils.php';
    
    $page = "teams";
    $sql = "UPDATE ".ucfirst($page)." 
            SET MeetingTime='".$_REQUEST['MeetingTime']."'
            WHERE Name='".$_REQUEST['Name']."'
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