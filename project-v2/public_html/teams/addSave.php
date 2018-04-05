<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
 
    $page = "teams";
    $sql = "INSERT INTO 
                Teams(Name,Sponsor,Season,Year)
            VALUES 
                ('" . $_REQUEST['Name'] . "','" 
                    . $_REQUEST['Sponsor'] . "','"
                    . $_REQUEST['Season'] . "','"
                    . $_REQUEST['Year'] . "'
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
        echo "<script>window.location='/".$page."/view.php?year=".$_REQUEST['year']."&season=".$_REQUEST['season']."'; </script>";
    }

?>