<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php");

    $page = "interns";

    $func = $_REQUEST['fn'];
    $buttonVal = "Submit";
    $nextPage = "saveAdd.php";

    $id = "";
    $firstName = "";
    $lastName = "";
    $type = "";

    echo "<h1>".ucfirst($func)." ".ucfirst($page)."</h1>";
    echo "<form method='post'>";

    switch ($func){
        case 'edit':
            $id = $_REQUEST['id'];
            $firstName = $_REQUEST['FirstName'];
            $lastName= $_REQUEST['LastName'];
            $type = $_REQUEST['Type'];
            
            $buttonVal = "Update";
            $nextPage = "saveEdit.php";
            echo "<br>";
            echo "<input type='hidden' name='id' value='".$id."'>";
            break;
        default:
            echo "<input type='hidden' name='id' value='".$id."'>";
            echo "<br>";
            break;
    }

    echo "First Name: <input type='text' name='FirstName' value='".$firstName."'>";
    echo "<br>";

    echo "Last Name: <input type='text' name='LastName' value='".$lastName."'>";
    echo "<br>";

    echo "Type: <input type='text' name='Type' value='".$type."'>";
    echo "<br>";
    
    echo "<br>";
    echo "<input type='submit' formaction='/".$page."/".$nextPage."' value='".$buttonVal."'>";
    echo "<button type='submit' formaction='/".$page."/view.php'>Cancel</button>";
    echo "</form>";
?>
