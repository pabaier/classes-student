<head>
    <title>MUSC HCC</title>
    <link rel="stylesheet" type="text/css" href="/styles.css">
</head>
<form id='posting' method='get'>
    <div class = 'menu' id = 'dateMenu'>
        Select Year and Season: 
        <?php
            include $_SERVER['DOCUMENT_ROOT'].'/shared/utils.php';
            $currentYear = "";
            $currentSeason = "";
            if(array_key_exists('year', $_REQUEST)){
                $currentYear = (int)$_REQUEST['year'];
                $currentSeason = $_REQUEST['season'];
            }
            echo "<select id='year' name='year'>";
            echo "<option>All</option>";
            echo getHTMLOptionsFromFile("years", $currentYear);
            echo "</select>";

            echo "<select id='season' name='season'>";
            echo "<option>All</option>";
            echo getHTMLOptionsFromFile("seasons", $currentSeason);
            echo "</select>";
        ?>
        <input type="hidden" name ='fn' id='fn' value='add'>
    </div>

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
                    echo "</li>";
                }
                fclose($links);
            ?>
        </ul>
    </div>
    <?php
        echo "<a href='/index.php?year=".$_REQUEST['year']."&season=".$_REQUEST['season']."'><button type='button'>Home</button></a>";
    ?>
</form>

<script>
    function goto(url){
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", url + "?fn=" + yearSeason(), true);
        xhttp.send();
        // xhttp.onreadystatechange = function() {
        //     if (this.readyState == 4 && this.status == 200) {
        //     }
        // };
    }

    function yearSeason(){
        var yearEl = document.getElementById('year');
        var seasonEl = document.getElementById('season');
        var year = document.getElementById('year').options[yearEl.selectedIndex].value;
        var season = document.getElementById('season').options[seasonEl.selectedIndex].value;
        return "&yr=" + year + "&sn=" + season;
    }

    
</script>

