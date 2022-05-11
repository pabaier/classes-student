<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php");

    $func = ucfirst($_REQUEST['fn']);
    $page = "teams";
    $name = "";$sponsor="";
    $season = $_REQUEST['season'];
    $year = $_REQUEST['year'];
    $buttonVal = "Submit";
    $nextPage = "addSave.php";
    switch ($_REQUEST['fn']){
        case 'edit':
            $name = $_REQUEST['name'];
            $sponsor= $_REQUEST['sponsor'];
            $season= $_REQUEST['Season'];
            $year= $_REQUEST['Year'];
            $buttonVal = "Update";
            $nextPage = "editSave.php";
            break;
    }

    echo "<h1>".$func." ".ucfirst($page)."</h1>";
    echo "<form method='post'>";
    echo "Name: <input type='text' name='Name' value='".$name."'>";
    echo "<br>";
    
    echo "Sponsor: <select id='Sponsor' name='Sponsor'>";
    echo getHTMLOptionsFromDB("Sponsors", "Name", $sponsor);
    echo "</select>";
    echo "<br>";

    echo "Year: <select id='Year' name='Year'>";
    echo getHTMLOptionsFromFile("years", $year);
    echo "</select>";
    echo "<br>";

    echo "Season: <select id='Season' name='Season'>";
    echo getHTMLOptionsFromFile("seasons", $season);
    echo "</select>";
    echo "<br>";
    echo "<input type='hidden' name ='year' value='".$_REQUEST['year']."'>";
    echo "<input type='hidden' name ='season' value='".$_REQUEST['season']."'>";
    echo "<input type='hidden' name ='id' value='".$_REQUEST['id']."'>";

    echo "<br>";
    echo "<input type='submit' formaction='/".$page."/".$nextPage."' value='".$buttonVal."'>";
    echo "<button type='submit' formaction='/".$page."/view.php'>Cancel</button>";
    echo "</form>";
?>