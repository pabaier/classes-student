<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php");

    $page = "sponsors";

    $func = $_REQUEST['fn'];
    $buttonVal = "Submit";
    $nextPage = "saveAdd.php";

    $name = "";
    $phoneNumber = "";
    $email = "";
    $contactPerson = "";
    $other = "";

    echo "<h1>".ucfirst($func)." ".ucfirst($page)."</h1>";
    echo "<form method='post'>";

    switch ($func){
        case 'edit':
            $name = $_REQUEST['Name'];
            $phoneNumber= $_REQUEST['PhoneNumber'];
            $email = $_REQUEST['Email'];
            $contactPerson= $_REQUEST['ContactPerson'];
            $other= $_REQUEST['Other'];
            
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

    echo "Phone Number: <input type='text' name='PhoneNumber' value='".$phoneNumber."'>";
    echo "<br>";

    echo "Email: <input type='text' name='Email' value='".$email."'>";
    echo "<br>";

    echo "Contact Person: <input type='text' name='ContactPerson' value='".$contactPerson."'>";
    echo "<br>";

    echo "Other: <input type='text' name='Other' value='".$other."'>";
    echo "<br>";
    
    echo "<br>";
    echo "<input type='submit' formaction='/".$page."/".$nextPage."' value='".$buttonVal."'>";
    echo "<button type='submit' formaction='/".$page."/view.php'>Cancel</button>";
    echo "</form>";
?>
