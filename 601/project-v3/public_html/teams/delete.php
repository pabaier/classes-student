<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    $page = "teams";

    $sqlOne = "CALL updateRegs ('".$_REQUEST['Name']."')";
    if (!$result = $mysqli->query($sqlOne)) {
        echo $_REQUEST['Name'];
        echo "<br>";
        echo "FIRST";
        echo "<br>";
        echo "Errno: " . $mysqli->errno . "</br>";
        echo "Error: " . $mysqli->error . "</br>";
        echo "<br>";
        echo "<a href='/".$page."/view.php'>back</a>";
    }
    else{
        $sql = "DELETE FROM ".ucfirst($page)." WHERE Name='".$_REQUEST['Name']."'";  
        if (!$result = $mysqli->query($sql)) {
            echo $_REQUEST['Name'];
            echo "<br>";
            echo "SECOND";
            echo "<br>";
            echo "Errno: " . $mysqli->errno . "</br>";
            echo "Error: " . $mysqli->error . "</br>";
            echo "<br>";
            echo "<a href='/".$page."/view.php'>back</a>";
        }
        else{
            echo "<script>window.location='/".$page."/view.php'; </script>";
        }
    }
?>

