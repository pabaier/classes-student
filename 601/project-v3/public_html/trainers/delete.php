<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    $page = "trainers";

    $sql = "DELETE FROM ".ucfirst($page)." WHERE id='".$_REQUEST['id']."'";  
    if (!$result = $mysqli->query($sql)) {
        echo $_REQUEST['id'];
        echo "Errno: " . $mysqli->errno . "</br>";
        echo "Error: " . $mysqli->error . "</br>";
        echo "<br>";
        echo "<a href='/".$page."/view.php'>back</a>";
    }
    else{
        echo "<script>window.location='/".$page."/view.php'; </script>";
    }
?>
