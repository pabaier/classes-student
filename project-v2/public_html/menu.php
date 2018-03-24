<head>
    <title>MUSC HCC</title>
    <link rel="stylesheet" type="text/css" href="/styles.css">
</head>
<form id='posting' method='get'>
    <div class = 'menu' id = 'dateMenu'>
        Select Year and Season: 
        <select id='year' name='year'>
            <option>All</option>
            <option>2018</option>
            <option>2017</option>
            <option>2016</option>
        </select>
        <select id='season' name='season'>
            <option>All</option>
            <option>Fall</option>
            <option>Spring</option>
        </select>
        <input type="hidden" name ='fn' id='fn' value='add'>
    </div>

    <div class = 'menu' id = 'navMenu'>
        <ul>
            <?php
                $links = fopen($_SERVER['DOCUMENT_ROOT']."/links", "r") or die("Unable to open file!");
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
    <a href='/index.php'><button type="button">Home</button></a>
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

