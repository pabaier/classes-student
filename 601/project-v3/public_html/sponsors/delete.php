<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    $page = "sponsors";

    $sql = "DELETE FROM ".ucfirst($page)." WHERE Name='".$_REQUEST['Name']."'";  
    if (!$result = $mysqli->query($sql)) {
        echo $_REQUEST['Name'];
        echo "Errno: " . $mysqli->errno . "</br>";
        echo "Error: " . $mysqli->error . "</br>";
        echo "<br>";
        echo "<a href='/".$page."/view.php'>back</a>";
    }
    else{
        echo "<script>window.location='/".$page."/view.php'; </script>";
    }
?>
