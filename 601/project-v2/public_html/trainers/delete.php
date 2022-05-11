<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';

    $sql = "DELETE FROM Sponsors WHERE Name='".$_REQUEST['name']."'";  
    if (!$result = $mysqli->query($sql)) {
        echo $_REQUEST['name'];
        echo "Errno: " . $mysqli->errno . "</br>";
        echo "Error: " . $mysqli->error . "</br>";
        exit;

    }

?>
<script>window.location='/sponsors/view.php'; </script>