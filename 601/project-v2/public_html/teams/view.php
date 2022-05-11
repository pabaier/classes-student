<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php"); 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';

    echo "<h1>Teams</h1>";
    $seasonString = "";
    if (strcmp($_REQUEST['year'], "All") != 0) {
        $seasonString = " WHERE Year = ".$_REQUEST['year'];
        if (strcmp($_REQUEST['season'], "All") != 0) {
            $seasonString = $seasonString." AND Season = '".$_REQUEST['season']."'";
        }
    }
    else if (strcmp($_REQUEST['season'], "All") != 0) {
        $seasonString = " WHERE Season = '".$_REQUEST['season']."'";
    }
    $query = "SELECT * FROM Teams".$seasonString;
    if($result = $mysqli->query($query)){
        echo "<table class='view' id='sponsorView'>";
        while($row = $result -> fetch_assoc()){
            echo "<tr><td>".$row['Name'].
                "</td><td>".$row['Sponsor'].
                "</td><td>".$row['Season'].
                "</td><td>".$row['Year'].
                "</td><td>"."<a href='addedit.php?fn=edit&id=".
                                $row['ID'].
                                "&name=".$row['Name'].
                                "&sponsor=".$row['Sponsor'].
                                "&Season=".$row['Season'].
                                "&Year=".$row['Year'].
                                "&year=".$_REQUEST['year'].
                                "&season=".$_REQUEST['season']."'>edit</a>".
                "</td><td>"."<a href='delete.php?id=".$row['ID']."&year=".$_REQUEST['year']."&season=".$_REQUEST['season']."'>delete</a>".
                "</td></tr>";
        }
        echo "</table>";
    }
    else{
        echo "unable to connect to server";
    }
?>
