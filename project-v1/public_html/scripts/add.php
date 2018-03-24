<?php
    $page = $_GET['fn'];
    blank($page);
    function blank($page){
        include 'db.php';
        echo "<form id='addForm' action=\"javascript:submit('".$page."')\">";

        $query = "SHOW COLUMNS FROM ".$page;
        if($result = $mysqli->query($query)){
            while($row = mysqli_fetch_array($result)){
                if($row['Field'] != "ID"){
                    echo $row['Field']." <input type=\"text\" name=\"".$row['Field']."\"><br>";
                }
            }
        }
        else{
            echo "nope";
        }
        echo "<br>";
        echo "<input type=\"submit\" value=\"Submit\">";
        echo "<input type=\"button\" value=\"Cancel\" onclick=\"load('".$page."')\">";

        echo "</form>";
    }

    function submit($page){

    }

    function cancel($page){

    }

    // switch($page) {
    //     case "Teams":
    //         echo $page;
    //         break;
    //     case "Participants":
    //         echo $page;
    //         break;
    //     case "Registration":
    //         echo $page;        
    //         break;
    //     case "Trainers":
    //         echo $page;        
    //         break;
    //     case "Mentors":
    //         echo $page;
    //         break;
    //     case "Interns":
    //         echo $page;        
    //         break;
    //     case "Sponsors":
    //         echo $page;        
    //         break;
    //     case "Participants":
    //         echo $page;        
    //         break;
    //     case "Results":
    //         echo $page;        
    //         break;
    //     default:
    //         echo "not working...";
    // }
?>