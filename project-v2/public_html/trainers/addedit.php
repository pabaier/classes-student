<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php");
    include $_SERVER['DOCUMENT_ROOT'].'/shared/utils.php';

    $func = ucfirst($_GET['fn']);
    $page = "trainers";
    $firstName = "";$lastName="";$team="";
    $buttonVal = "Submit";
    $nextPage = "addSave.php";
    switch ($_GET['fn']){
        case 'edit':
            $firstName = $_GET['firstName'];
            $lastName= $_GET['lastName'];
            $team= $_GET['currentTeamID'];
            $buttonVal = "Update";
            $nextPage = "editSave.php";
            break;
    }

    echo "<h1>".$func." ".ucfirst($page)."</h1>";
    echo "<form method='post'>";
    echo "First Name: <input type='text' name='firstName' value='".$firstName."'><br>";
    echo "Last Name: <input type='text' name='lastName' value='".$lastName."'><br>";
    echo "Team: <select>";
    $options = getdbIDandColumn("Teams", "Name");
        foreach($options as $id => $name){
            echo "<option id=".$id.">".$name."</option>"; 
        }
    echo "</select>";
    echo "<br>";
    echo "<br>";
    echo "<input type='submit' formaction='/".$page."/".$nextPage."' value='".$buttonVal."'>";
    echo "<button type='submit' formaction='/".$page."/view.php'>Cancel</button>";
    echo "</form>";
?>