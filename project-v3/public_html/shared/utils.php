<?php
    function checkInput($arrayRequest){
        $values = array_values($arrayRequest);
        return in_array("'",$values) || 
               in_array("\"",$values) || 
               in_array(";",$values) || 
               in_array(")",$values);
    }

    function buildURLValues($arrayRequest){
        $editString = "";
        foreach($arrayRequest as $key => $value){
            $editString .= "&".$key."=".$value."";
        }
        return $editString;
    }

    // use with createOptionsFromAssociativeArray vvv
    function getdbColumn($table, $field){
        include $_SERVER['DOCUMENT_ROOT'].'/db.php';
        $query = "SELECT ".$field." FROM ".$table;
        $return = array();
        if($result = $mysqli->query($query)){
            while($row = $result -> fetch_assoc()){
                foreach($row as $key=>$value){
                    array_push($return, $value);
                }
            }
        }
        else{
            echo "util getdbIDandColumn could not complete the request";
            $return = array("fun", "blue", "knee");
        }
        return $return;
    }

    function createOptionsFromColumn($column, $selected=""){
        $options = "";
        foreach($column as $value){
            $sval = strcasecmp(trim((string)$value), trim((string)$selected));
            if($sval == 0)
                $options = $options."<option name=".$value." value='".$value."' selected='selected'>".$value."</option>";
            else
                $options = $options."<option name=".$value." value='".$value."'>".$value."</option>";
        }
        return $options;
    }




    // use with createOptionsFromAssociativeArray vvv
    function getdbIDandColumn($table, $field){
        include $_SERVER['DOCUMENT_ROOT'].'/db.php';
        $query = "SELECT ID, ".$field." FROM ".$table;
        $return = array();
        if($result = $mysqli->query($query)){
            while($row = $result -> fetch_assoc()){
                $num = $row['ID'];
                $val = $row[$field];
                $return[$num] = $val;
            }
        }
        else{
            echo "util getdbIDandColumn could not complete the request";
            return array("2" => "blue", "3" => "knee");
        }
        return $return;
    }
    // use with getdbIDandColumn or getdbColumn ^^^
    function createOptionsFromAssociativeArray($array, $selected=""){
        $options = "";
        foreach($array as $key=>$value){
            $sval = strcasecmp(trim((string)$value), trim((string)$selected));
            if($sval == 0)
                $options = $options."<option name=".$key." selected='selected'>".$value."</option>";
            else
                $options = $options."<option name=".$key.">".$value."</option>";
        }
        return $options;
    }

    function getHTMLOptionsFromFile($file, $selected){
        $options = "";
        $lines = fopen($_SERVER['DOCUMENT_ROOT']."/info/".$file, "r") or die("Unable to open file!");
            while(!feof($lines)) {
                $line = fgets($lines);
                $sval = strcasecmp(trim((string)$line), trim((string)$selected));
                if($sval == 0)
                    $options = $options."<option selected='selected'>".$line."</option>";
                else
                    $options = $options."<option>".$line."</option>";
            }
        fclose($lines);
        return $options;
    }

    function getHTMLOptionsFromDB($table, $field, $selected = ""){
        include $_SERVER['DOCUMENT_ROOT'].'/db.php';
        $query = "SELECT ".$field." FROM ".$table;
        $vals = array();
        if($result = $mysqli->query($query)){
            while($row = $result -> fetch_assoc()){
                $vals[] = $row[$field];
            }
        }
        else{
            echo "util getHTMLOptionsFromDB could not complete the request";
        }
        $options = "";
        foreach($vals as $value){
            $sval = strcasecmp(trim((string)$value), trim((string)$selected));
            if($sval == 0)
                $options = $options."<option selected='selected'>".$value."</option>";
            else
                $options = $options."<option>".$value."</option>";
        }
        return $options;
    }
?>

