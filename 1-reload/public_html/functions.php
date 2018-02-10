<?php
    require 'db.php';

    $fn = $_GET['fn'];
    $level = $_GET['level'];
    switch($fn) {
        case "genBoard":
            genBoard($level);
            break;
        default:
            echo "error: " . $fn;
    }

    // $box1 = array(1,2,3,10,11,12,19,20,21);
    // $box2 = array(4,5,6,13,14,15,22,23,24);
    // $box3 = array(7,8,9,16,17,18,25,26,27);
    // $box4 = array(28,29,30,37,38,39,46,47,48);
    // $box5 = array(31,32,33,40,41,42,49,50,51);
    // $box6 = array(34,35,36,43,44,45,52,53,54);
    // $box7 = array(55,56,57,64,65,66,73,74,75);
    // $box8 = array(58,59,60,67,68,69,76,77,78);
    // $box9 = array(61,62,63,70,71,72,79,80,81);
    // $box1 = array(0,1,2,9,10,11,18,19,20);
    // $box2 = array(3,4,5,12,13,14,21,22,23);
    // $box3 = array(6,7,8,15,16,17,24,25,26);
    // $box4 = array(27,28,29,36,37,38,45,46,47);
    // $box5 = array(30,31,32,39,40,41,48,49,50);
    // $box6 = array(33,34,35,42,43,44,51,52,53);
    // $box7 = array(54,55,56,63,64,65,72,73,74);
    // $box8 = array(57,58,59,66,67,68,75,76,77);
    // $box9 = array(60,61,62,69,70,71,78,79,80);

    function genBoard($level) {
        $boardString = "";
        $boardArray = array();
        for($row = 0; $row < 9; $row++){
            $reset = false;
            $boardArray['row'.$row] = array();
            for($col = 0; $col < 9; $col++){
                $nextInt = rand(1,9);
                if($attempts > 1000){
                    $reset = true;
                    break;
                }
                else if(
                    checkRow($boardArray, $row, $nextInt) && 
                    checkCol($boardArray, $col, $nextInt) &&
                    checkBox($boardArray, $row, $col, $nextInt)
                    ){
                        array_push($boardArray['row'.$row],$nextInt);
                        $boardString.=$nextInt;
                        $attempts = 0;
                    }
                else{
                    $col--;
                    $attempts++;
                }
            }
            if($reset){
                $boardArray = array();
                $return="";
                $col = 10;
                $row = -1;
                $attempts = 0;
            }
        }
        // $return = str_replace($level, '0', $return);
        setDifficulty($boardArray);
        $boardJson = json_encode($boardArray);
        echo $boardJson;
    }

    function setDifficulty(&$grid){
        for($i = 0; $i < 9; $i++){
            $bounds = getBoxByNumber($i);
            $randRow = rand($bounds[rowStart], $bounds[rowEnd]);
            $randCol = rand($bounds[colStart], $bounds[colEnd]);
            $grid['row'.$randRow][$randCol] = 0;
        }
    }

    function checkRow($grid, $row, $val){
        for($c = 0; $c<count($grid['row'.$row]); $c++){
            if($grid['row'.$row][$c] == $val) {
                return false;
            }
        }
        return true;
    }
    
    function checkCol($grid, $col, $val){
        for($r = 0; $r < count($grid); $r++){
            if($grid['row'.$r][$col] == $val) {
                return false;
            }
        }
        return true;
    }

    function checkBox($grid, $row, $col, $val){
        $box = getBox($row, $col);
        for($r = $box["rowStart"]; $r <= $box["rowEnd"]; $r++){
            for($c = $box["colStart"]; $c <= $box["colEnd"]; $c++){
                if($grid['row'.$r][$c] == $val)
                    return false;
            }
        }
        return true;
    }

    function getBoxByNumber($number){
        
        switch($number) {
            case 1:
                $box = getBox(0,0);
                break;
            case 2:
                $box = getBox(0,3);
                break;
            case 3:
                $box = getBox(0,6);
                break;
            case 4:
                $box = getBox(3,0);
                break;
            case 5:
                $box = getBox(3,3);
                break;
            case 6:
                $box = getBox(3,6);
                break;
            case 7:
                $box = getBox(6,0);
                break;
            case 8:
                $box = getBox(6,3);
                break;
            case 9:
                $box = getBox(6,6);
                break;
        }
        return $box;
    }

    function getBox($row, $col){
        $box = Array("rowStart" => 0,
                    "rowEnd" => 0,
                    "colStart" => 0,
                    "colEnd" => 0
                    );

        if($row<3){
            $box["rowStart"] = 0;
            $box["rowEnd"] = 2;
        }
        else if($row<6){
            $box["rowStart"] = 3;
            $box["rowEnd"] = 5;
        }
        else{
            $box["rowStart"] = 6;
            $box["rowEnd"] = 8;
        }

        if($col<3){
            $box["colStart"] = 0;
            $box["colEnd"] = 2;
        }
        else if($col<6){
            $box["colStart"] = 3;
            $box["colEnd"] = 5;
        }
        else{
            $box["colStart"] = 6;
            $box["colEnd"] = 8;
        }
        return $box;
    }
?>