<?php
    // require 'db.php';
    $tableName = "sudoku";

    // $sql = "delete from Students where id = " . $_REQUEST['id'];

    // if (!$result = $conn->query($sql)) {
    //     echo "Error: Our query failed to execute and here is why: </br>";
    //     echo "Query: " . $sql . "</br>";
    //     echo "Errno: " . $conn->errno . "</br>";
    //     echo "Error: " . $conn->error . "</br>";
    //     exit;
    // }

    $fn = $_GET['fn'];
    $level = $_GET['level'];
    switch ($fn) {
        case "genBoard":
            genBoard($level);
            break;
        default:
            echo "error: " . $fn;
    }

    $box1 = array(1,2,3,10,11,12,19,20,21);
    $box2 = array(4,5,6,13,14,15,22,23,24);
    $box3 = array(7,8,9,16,17,18,25,26,27);
    $box4 = array(28,29,30,37,38,39,46,47,48);
    $box5 = array(31,32,33,40,41,42,49,50,51);
    $box6 = array(34,35,36,43,44,45,52,53,54);
    $box7 = array(55,56,57,64,65,66,73,74,75);
    $box8 = array(58,59,60,67,68,69,76,77,78);
    $box9 = array(61,62,63,70,71,72,79,80,81);

    function genBoardStrings($level) {
        $board = '0';
        $nextNum = rand(1,9);
        if(check($board, $nextNum)){
            $board.=$nextNum;
        }
        // if(strlen($board))
    }

    function check($board, $nextNum){
        return true;
    }


    // *******************



    function genBoard($level) {
        $return = "";
        // global $level;       
        $grid = array();
        for($row = 1; $row <= 9; $row++){
            $reset = false;
            $grid[$row] = array();
            for($col = 1; $col <= 9; $col++){
                $nextInt = rand(1,9);
                if($attempts > 1000){
                    $reset = true;
                    break;
                }
                else if(
                        checkRow($grid, $row, $nextInt) && 
                        checkCol($grid, $col, $nextInt) &&
                        checkBox($grid, $row, $col, $nextInt)
                        ){
                    $grid[$row][$col] = $nextInt;
                    $return.=$nextInt;
                    $attempts = 0;
                }
                else{
                    $col--;
                    $attempts++;
                }
            }
            if($reset){
                $grid = array();
                $col = 10;
                $row = 0;
                $attempts = 0;
                $return="";
            }
        }
        $return = str_replace($level, '0', $return);
        // $mysqli->query("INSERT INTO sudoku(state) VALUES ($return)");
        echo $return;
    }

    function checkRow($grid, $row, $val){
        for($c = 1; $c<=count($grid[$row]); $c++){
            if($grid[$row][$c] == $val) {
                return false;
            }
        }
        return true;
    }
    
    function checkCol($grid, $col, $val){
        for($r = 1; $r<=9; $r++){
            if($grid[$r][$col] == $val) {
                return false;
            }
        }
        return true;
    }

    function checkBox($grid, $row, $col, $val){
        $box = getBox($row, $col);
        for($r = $box["rowStart"]; $r <= $box["rowEnd"]; $r++){
            for($c = $box["colStart"]; $c <= $box["colEnd"]; $c++){
                if($grid[$r][$c] == $val)
                    return false;
            }
        }
        return true;
    }

    function getBox($row, $col){
        $box = Array("rowStart" => 0,
                    "rowEnd" => 0,
                    "colStart" => 0,
                    "colEnd" => 0
                    );

        if($row<=3){
            $box["rowStart"] = 1;
            $box["rowEnd"] = 3;
        }
        else if($row<=6){
            $box["rowStart"] = 4;
            $box["rowEnd"] = 6;
        }
        else{
            $box["rowStart"] = 7;
            $box["rowEnd"] = 9;
        }

        if($col<=3){
            $box["colStart"] = 1;
            $box["colEnd"] = 3;
        }
        else if($col<=6){
            $box["colStart"] = 4;
            $box["colEnd"] = 6;
        }
        else{
            $box["colStart"] = 7;
            $box["colEnd"] = 9;
        }
        return $box;
    }

    function getBlanks($level, $return){

    }



?>