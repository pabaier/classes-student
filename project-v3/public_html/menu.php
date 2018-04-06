<head>
    <title>MUSC HCC</title>
    <link rel="stylesheet" type="text/css" href="/styles.css">
</head>
<form id='posting' method='get'>
    <div class = 'menu' id = 'navMenu'>
        <ul>
            <?php
                $links = fopen($_SERVER['DOCUMENT_ROOT']."/info/links", "r") or die("Unable to open file!");
                while(!feof($links)) {
                    $name = fgets($links);
                    echo "<li>";
                    echo ucfirst($name);
                    echo "<button type=\"submit\" formaction=\"/".$name."/view.php\">View</button>";
                    echo "<button type=\"submit\" formaction=\"/".$name."/addedit.php\">Add</button>";
                    if(strcmp(trim($name),"teams") != 0){
                        if(strcmp(trim($name),"sponsors") == 0){
                            echo "<button type=\"submit\" name='page' value=".$name." formaction=\"/registrations/".$name.".php\">Registrations</button>";
                        }
                        else{
                            echo "<button type=\"submit\" name='page' value=".$name." formaction=\"/registrations/general.php\">Registrations</button>";
                        }
                    }
                    echo "</li>";
                }
                fclose($links);
            ?>
        </ul>
    </div>
</form>
<br>

<?php
    include $_SERVER['DOCUMENT_ROOT'].'/shared/utils.php';

    $optData = getdbColumn("Teams", "Name");
            echo "<form method='post'>";
            echo "Enter Results: ";
            echo "<select name='Team'>";
            echo createOptionsFromColumn($optData, $row['TeamsName']);
            echo "</select>";
            echo "<input type='submit' formaction='/views/byTeam.php' value='Go'>";
            echo "<input type='hidden' name='pageName' value='".$page."'>";
            echo "<input type='hidden' name='".$page."' value=".$tableKey.">";
            echo "</form>";
?>

<br><a href='/index.php?'><button type='button'>Home</button></a>