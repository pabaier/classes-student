<?php
    include ('db.php');
    $fn = $_GET['fn'];
    switch($fn) {
        case "loadBoard":
            loadBoard();
            break;
        case "genBoard":
            $level = $_GET['level'];
            genBoard($level);
            break;
        case "getHint":
            getHint();
            break;
        case "checkValue":
            $cell = $_GET['index'];
            $input = $_GET['value'];
            $time = $_GET['time'];
            checkValue($cell, $input, $time);
            break;
        default:
            echo "error: " . $fn;
    }

    // sql helpers
    function setTime($time){
        require 'db.php';
        $sql = "UPDATE sudoku SET lastMove = '$time'";
        mysqli_real_query($conn, $sql);
        $conn->close();
    }
    function getTime(){
        require 'db.php';
        $sql = "SELECT lastMove FROM sudoku";
        mysqli_real_query($conn, $sql);
        $result = mysqli_use_result($conn);
        $time = mysqli_fetch_row($result)[0];
        mysqli_free_result($result);
        $conn->close();
        return $time;
    }
    function getAnswer(){
        require 'db.php';
        $sql = "SELECT answer FROM sudoku";
        mysqli_real_query($conn, $sql);
        $result = mysqli_use_result($conn);
        $answer = mysqli_fetch_row($result)[0];
        mysqli_free_result($result);
        $conn->close();
        return $answer;
    }
    function getState(){
        require 'db.php';
        $sql = "SELECT state FROM sudoku";
        mysqli_real_query($conn, $sql);
        $result = mysqli_use_result($conn);
        $state = mysqli_fetch_row($result)[0];
        while(strlen($state) < 81){
            $state = "0".$state;
        }
        mysqli_free_result($result);
        $conn->close();
        return $state;
    }
    function updateState($cell, $input){
        require 'db.php';
        $state = getState();
        $state[$cell] = $input;
        $sql = "UPDATE sudoku SET state = $state";
        mysqli_real_query($conn, $sql);
        $conn->close();
    }
    function sqlInsert($board, $answer){
        require 'db.php';
        $time = getTime();
        mysqli_real_query($conn, "delete from sudoku");
        $sql = "INSERT INTO sudoku (state, answer) VALUES ($board, $answer)";
        mysqli_real_query($conn, $sql);
        setTime($time);
        $conn->close();
    }

    // checkers
    function checkWin(){
        $state = getState();
        for($i = 0; $i < strlen($state); $i++){
            if($state[$i] == '0'){
                    return false;
                }
            }
        return true;
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

    // utils
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
    function setDifficulty(&$grid, &$stringBoard, $level){
        for($i = 0; $i < 9; $i++){
            $bounds = getBoxByNumber($i + 1);
            for($j = 0; $j < $level; $j++){
                $randRow = rand($bounds[rowStart], $bounds[rowEnd]);
                $randCol = rand($bounds[colStart], $bounds[colEnd]);
                $previousValue = $grid['row'.$randRow][$randCol];
                if($previousValue == 0){
                    $j--;
                }
                else{
                    $grid['row'.$randRow][$randCol] = 0;
                    $stringIndex = $randRow * 10 + $randCol - $randRow;
                    $stringBoard[$stringIndex] = "0";
                }
            }
        }
    }

    // heavy lifting
    function getHint(){
        $ans = getAnswer();
        $state = getState();
        $indxs = array();
        for($i = 0; $i < strlen($state); $i++){
            if($state[$i] == 0){
                $indxs[] = $i;
            }
        }
        $rand = rand(0,count($indxs) - 1);
        $cell = $indxs[$rand];
        $value = $ans[$cell];
        updateState($cell, $value);
        $res = array("cell" => $cell , "value" => $value, "winner" => checkWin());
        echo json_encode($res);
    }
    function loadBoard(){
        $state = getState();
        $boardString = "";
        $boardArray = array();
        $counter = 0;
        for($row = 0; $row < 9; $row++){
            $boardArray['row'.$row] = array();
            for($col = 0; $col < 9; $col++){
                array_push($boardArray['row'.$row],$state[$counter]);
                $counter++;
            }
        }
        $boardArray['time'] = getTime();
        $boardJson = json_encode($boardArray);
        echo $boardJson;
    }
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
                        $boardString.="$nextInt";
                        $attempts = 0;
                    }
                else{
                    $col--;
                    $attempts++;
                }
            }
            if($reset){
                $boardArray = array();
                $boardString = "";
                $return="";
                $col = 10;
                $row = -1;
                $attempts = 0;
            }
        }
        $boardArray['time'] = getTime();
        $boardStringAnswer = $boardString;
        setDifficulty($boardArray, $boardString, $level);
        sqlInsert($boardString, $boardStringAnswer);
        $boardJson = json_encode($boardArray);
        echo $boardJson;
    }
    function checkValue($cell, $input, $time){
        $answer = getAnswer();
        if($answer[$cell] == $input){
            updateState($cell, $input);
            $result = true;
        }
        else{
            $result = false;
        }
        setTime($time);
        $res = array("result" => $result, "winner" => checkWin());
        echo json_encode($res);
    }
?>