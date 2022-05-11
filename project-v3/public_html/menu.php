<head>
    <title>MUSC HCC</title>
    <link rel="stylesheet" type="text/css" href="/styles.css">
</head>
<form id='posting' method='get'>
    <div class = 'menu' id = 'navMenu'>
        <ul>
            <?php
                include $_SERVER['DOCUMENT_ROOT'].'/shared/utils.php';

                $links = fopen($_SERVER['DOCUMENT_ROOT']."/info/links", "r") or die("Unable to open file!");
                echo "<table class='homepage' id='homepage'>";
                echo "<tr>";
                $sections = array();
                while(!feof($links)) {
                    $name = fgets($links);
                    $sections[] = $name;
                    if(strcmp(trim($name),"teams") == 0){
                        echo "<th colspan=2>";
                    }
                    else{
                        echo "<th colspan=3>";
                    }
                    echo ucfirst($name);
                    echo "</th>";
                }
                fclose($links);
                echo "</tr>";
                echo "<tr>";
                    foreach($sections as $name){
                        echo "<td>";
                            echo "<button type=\"submit\" formaction=\"/".$name."/view.php\">View</button>";
                        echo "</td>";
                        echo "<td>";
                            echo "<button type=\"submit\" formaction=\"/".$name."/addedit.php\">Add</button>";
                        echo "</td>";
                        if(strcmp(trim($name),"teams") != 0){
                            echo "<td>";
                                if(strcmp(trim($name),"sponsors") == 0){
                                    echo "<button type=\"submit\" name='page' value=".$name." formaction=\"/registrations/".$name.".php\">Registrations</button>";
                                }
                                else{
                                    echo "<button type=\"submit\" name='page' value=".$name." formaction=\"/registrations/general.php\">Registrations</button>";
                                }
                            echo "</td>";
                        }
                    }
                echo "</tr>";
                echo "</table>";
            ?>
        </ul>
    </div>
</form>
<br>
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
<br><br>

