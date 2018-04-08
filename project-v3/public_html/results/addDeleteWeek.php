<?php
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';
    include $_SERVER['DOCUMENT_ROOT'].'/shared/utils.php';

    if(strcmp($_REQUEST['op'], "Delete Week") == 0){
        // delete week
        $weekToDelete = $_REQUEST['week'];
        $weekToReturnTo = $_REQUEST['previousWeek'];
        if($weekToDelete == 1){
                echo "Sorry you cannot delete week 1";
                echo "<br>";
                echo "<a href='/results/weekly.php?week=".$weekToReturnTo."'>back</a>";    
        }
        else{
            if($weekToDelete == $weekToReturnTo)
                $weekToReturnTo = ($weekToDelete-1);

            $sql = "DELETE FROM WeeklyResults WHERE WeekNumber=".$weekToDelete;
            if ($result = $mysqli->query($sql)) {
                echo "<script>window.location='/results/weekly.php?week=".$weekToReturnTo."'; </script>";
            }
            else{
                $errno = $mysqli->errno;
                switch ($errno){
                    case '1064':
                        echo "Sorry you have entered some invalid characters";
                        break;
                    case '1062':
                        echo $page." with the name ".$_REQUEST['name']." already exists";
                        break;
                    default:
                        echo "Errno: " . $mysqli->errno . "</br>";
                        echo "Error: " . $mysqli->error . "</br>";
                }
                echo "<br>";
                echo "<a href='/results/weekly.php?week=".$weekToReturnTo."'>back</a>";
            }
        }
    }
    else{
        $newWeek = $mysqli->query("Select getNewWeek();")->fetch_array(MYSQLI_NUM)[0];
        $sqlOne = "CALL addWeek ()";
        if ($result = $mysqli->query($sqlOne)) {
            echo "<script>window.location='/results/weekly.php?week=".$newWeek."'; </script>";
        }
        else{
            $errno = $mysqli->errno;
            switch ($errno){
                case '1064':
                    echo "Sorry you have entered some invalid characters";
                    break;
                case '1062':
                    echo $page." with the name ".$_REQUEST['name']." already exists";
                    break;
                default:
                    echo "Errno: " . $mysqli->errno . "</br>";
                    echo "Error: " . $mysqli->error . "</br>";
            }
            echo "<br>";
            echo "<a href='/results/weekly.php?week=".$weekToReturnTo."'>back</a>";
        }
    }

?>