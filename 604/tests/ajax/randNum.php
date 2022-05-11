<?php

    $q = $_REQUEST["q"];
    $grid = array();
    $allNums = "<table>";
    for($row = 1; $row <= 9; $row++){
        $rowNums = "<tr>";
        $grid[$row] = array();
        for($col = 1; $col <= 9; $col++){
            $grid[$row][$col] = rand(1,9);
            $rowNums.="<td>" . rand(1,9) . "</td>";
        }
        $rowNums.="</td>";
        $allNums.=$rowNums;
    }
    // echo rand(1, 9);
    // echo "{$grid[1][1]}, {$grid[1][2]}"
    // echo "random: " . rand(1,9) . " is random."
    echo $allNums;
?>