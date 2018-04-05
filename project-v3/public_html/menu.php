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
                        echo "<button type=\"submit\" formaction=\"/registrations/".$name.".php\">Registrations</button>";
                    }
                    echo "</li>";
                }
                fclose($links);
            ?>
        </ul>
    </div>
</form>

<a href='/index.php?'><button type='button'>Home</button></a>

