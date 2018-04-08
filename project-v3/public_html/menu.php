<head>
    <title>MUSC HCC</title>
    <link rel="stylesheet" type="text/css" href="/styles.css">
</head>
<h3>Setup</h3>
<form id='posting' method='get'>
    <div class = 'menu' id = 'navMenu'>
        <ul>
            <?php
                include $_SERVER['DOCUMENT_ROOT'].'/shared/utils.php';

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
<table class='homepage' id='homepage'>
    <tr>
        <th colspan=3>Results</th><th colspan=4>Leader Board</th>
    </tr>
    <tr>
        <td>
            <a href="/results/home.php">Start/End</a>
        </td>
        <td>
            <a href="/results/weekly.php?type=Weekly&week=1">Weekly</a>
        </td>
        <td>
            <a href="/results/byParticipant.php">By Participant</a>
        </td>
        <td>
            <a href="/views/topMale.php">Male Top 10 Lbs</a>
        </td>
        <td>
            <a href="/views/topFemale.php">Female Top 10 Lbs</a>
        </td>
        <td>
            <a href="/views/topMalePercent.php">Male Top 10 %</a>
        </td>
        <td>
            <a href="/views/topFemalePercent.php">Female Top 10 %</a>
        </td>
    </tr>
</table>

