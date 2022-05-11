<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    include $_SERVER['DOCUMENT_ROOT'].'/shared/utils.php';
    
    $page = "teams";
    $sql = "UPDATE ".ucfirst($page)." 
            SET Name='".$_REQUEST['Name']."',
                Sponsor='".$_REQUEST['Sponsor']."',
                Year=".$_REQUEST['Year'].",
                Season='".$_REQUEST['Season']."'
            WHERE ID=".$_REQUEST['id'];
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
        echo "<a href='/".$page."/addedit.php?fn=edit&id=".
                                $_REQUEST['id'].
                                "&name=".$_REQUEST['Name'].
                                "&sponsor=".$_REQUEST['Sponsor'].
                                "&Season=".$_REQUEST['Season'].
                                "&Year=".$_REQUEST['Year'].
                                "&year=".$_REQUEST['year'].
                                "&season=".$_REQUEST['season']."'>back</a>";
    }
    else{
        // echo "<script>window.location='/".$page."/view.php?year=".$_REQUEST['year']."&season=".$_REQUEST['season']."'; </script>";
        echo "<script>window.location='".urlBuilder($page, "view", $_REQUEST['year'], $_REQUEST['season'])."'; </script>";        
    }

?>