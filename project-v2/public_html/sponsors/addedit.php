<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php");

    $func = ucfirst($_GET['fn']);
    $page = "sponsors";
    $name = "";$phone="";$contact="";$other="";
    $buttonVal = "Submit";
    $nextPage = "addSave.php";
    switch ($_GET['fn']){
        case 'edit':
            $row = getInfo($page);
            $name = $row['Name'];
            $phone= $row['PhoneNumber'];
            $contact= $row['Contact'];
            $other= $row['Other'];
            $buttonVal = "Update";
            $nextPage = "updateSave.php";
            break;
    }

    echo "<h1>".$func." Sponsor</h1>";
    // echo $_REQUEST['year']."  ".$_REQUEST['season']."<br>";
    echo "<form method='post'>";
    if($_GET['fn'] == 'edit'){
        echo "Name: ".$name."<br>";
        echo "<input type='hidden' name ='name' value='".$name."'>";
    }
    else{
        echo "Name: <input type='text' name='name' value='".$name."'><br>";
    }
    echo "Phone Number: <input type='text' name='phone' value='".$phone."'><br>";
    echo "Contact: <input type='text' name='contact' value='".$contact."'><br>";
    echo "Other Information: <input type='text' name='other' value='".$other."'><br>";
    echo "<br>";
    echo "<input type='submit' formaction='/".$page."/".$nextPage."' value='".$buttonVal."'>";
    echo "<button type='submit' formaction='/".$page."/view.php'>Cancel</button>";
    echo "</form>";

    function getInfo($page){
        include $_SERVER['DOCUMENT_ROOT'].'/db.php';
        $query = "SELECT * FROM ".ucfirst($page)."
                  WHERE Name='".$_REQUEST['name']."'";
        if($result = $mysqli->query($query)){
            return $result -> fetch_assoc();
        }
        else{
            echo "could not find team with that name";
        }
    }
?>