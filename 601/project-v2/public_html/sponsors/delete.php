<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    $page = "sponsors";

    $sql = "DELETE FROM Sponsors WHERE Name='".$_REQUEST['name']."'";  
    if (!$result = $mysqli->query($sql)) {
        $errno = $mysqli->errno;
        switch ($errno){
            case '1064':
                echo "Sorry you cannot use that name. It has Invalid characters";
                break;
            case '1062':
                echo "A team with the name ".$_REQUEST['name']." already exists";
                break;
            case '1451':
                echo "You cannot delete this sponsor because they sponsor a team";
                echo "<br>";
                echo "Remove them as a sponsor and try again";
                break;
            default:
                echo "Errno: " . $mysqli->errno . "</br>";
                echo "Error: " . $mysqli->error . "</br>";
        }
        echo "<br>";
        echo "<a href='/".$page."/view.php?year=".$_REQUEST['year']."&season=".$_REQUEST['season']."'>back</a>";
    }
    else
        echo "<script>window.location='/".$page."/view.php?year=".$_REQUEST['year']."&season=".$_REQUEST['season']."'; </script>";
?>
