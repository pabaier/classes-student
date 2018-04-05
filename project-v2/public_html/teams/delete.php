<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';

    $sql = "DELETE FROM Teams WHERE ID='".$_REQUEST['id']."'";  
    if (!$result = $mysqli->query($sql)) {
        echo $_REQUEST['id'];
        echo "Errno: " . $mysqli->errno . "</br>";
        echo "Error: " . $mysqli->error . "</br>";
        exit;

    }

    // <script>window.location='/teams/view.php'; </script>
    echo "<script>window.location='/teams/view.php?year=".$_REQUEST['year']."&season=".$_REQUEST['season']."'; </script>";
?>
