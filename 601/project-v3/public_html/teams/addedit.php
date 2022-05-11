<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php");

    $page = "teams";

    $func = $_REQUEST['fn'];
    $buttonVal = "Submit";
    $nextPage = "saveAdd.php";

    $name = "";
    $meetingTime = "";

    echo "<h1>".ucfirst($func)." ".ucfirst($page)."</h1>";
    echo "<form method='post'>";

    switch ($func){
        case 'edit':
            $name = $_REQUEST['Name'];
            $meetingTime= $_REQUEST['MeetingTime'];
            
            $buttonVal = "Update";
            $nextPage = "saveEdit.php";
            echo $name;
            echo "<br>";
            echo "<input type='hidden' name='Name' value='".$name."'>";
            break;
        default:
            echo "Name: <input type='text' name='Name' value='".$name."'>";
            echo "<br>";
            break;
    }

    echo "Meeting Time: <input type='text' name='MeetingTime' value='".$meetingTime."'>";
    echo "<br>";
    
    echo "<br>";
    echo "<input type='submit' formaction='/".$page."/".$nextPage."' value='".$buttonVal."'>";
    echo "<button type='submit' formaction='/".$page."/view.php'>Cancel</button>";
    echo "</form>";
?>
