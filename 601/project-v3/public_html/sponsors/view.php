<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php"); 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    $page = "sponsors";

    echo "<h1>".ucfirst($page)."</h1>";
    $query = "SELECT * FROM ".ucfirst($page);

    if($result = $mysqli->query($query)){
        echo "<table class='view' id='".$page."View'>";
        echo "<tr>
                <th>Name</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th>Contact Person</th>
                <th>Other</th>
                <th colspan=2></th></tr>";
        while($row = $result -> fetch_assoc()){
            echo "<tr>";
            $editString = "";
            foreach($row as $key => $value){
                echo "<td>".$value."</td>";
                $editString .= "&".$key."=".$value."";
            }
            echo "<td><a href='addedit.php?fn=edit".$editString."'>edit</a></td>";
            echo "<td><a href='delete.php?Name=".$row['Name']."'>delete</a></td>";
            echo "</tr>";
        }
        echo "</table>";
    }
    else{
        echo "unable to connect to server<br>";
        echo "Errno: " . $mysqli->errno . "</br>";
        echo "Error: " . $mysqli->error . "</br>";
    }
?>
