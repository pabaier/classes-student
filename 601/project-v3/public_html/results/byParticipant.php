<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php"); 
    include $_SERVER['DOCUMENT_ROOT'].'/db.php';

    echo "<h1>Participant Results</h1>";
    $id = $_REQUEST['id'];
    echo "Select Participant:";
    $participantsRaw = getdbIDandColumn2("Participants", "FirstName", "LastName");
    echo "<form method='post'>";
        echo "<select name='id'>";
            foreach($participantsRaw as $key=>$value){
                if($key == $id)
                    echo "<option name='id' value=".$key." selected='selected'>".$value."</option>";
                else
                    echo "<option name='id' value=".$key.">".$value."</option>";
            }
        echo "</select>";
        echo "<input type='submit' formaction='/results/byParticipant.php' value='Go'>";
    echo "</form>";

    if(!empty($id))
    {
        $start = array();
        $end = array();
        $week = array();
        $totalLost = 0;
        $totalLostPercent = 0;

        $query = "CALL ParticipantResults(".$id.")";
        if ($result = $mysqli->query($query)) {
            while($row = $result -> fetch_assoc()){
                $start['Visceral Fat'] = $row['srvf'];
                $end['Visceral Fat'] = $row['ervf'];
                $start['BMI'] = $row['srbmi'];
                $end['BMI'] = $row['erbmi'];
                $start['Body Fat Percent'] = $row['srbfp'];
                $end['Body Fat Percent'] = $row['erbfp'];
                $start['Lean Muscle Percent'] = $row['srlmp'];
                $end['Lean Muscle Percent'] = $row['erlmp'];
                $week[$row['wrwn']] = $row['wrw'];
                $totalLost = $row['weightLost'];
                $totalLostPercent = $row['percent'];
            }
            echo "<table>";
                echo "<tr>";
                    echo "<th>";
                        echo "Start Results";
                    echo "</th>";
                    echo "<th>";
                        echo "End Results";
                    echo "</th>";
                    echo "<th>";
                        echo "Weekly Results";
                    echo "</th>";
                echo "</tr>";
                echo "<tr>";
                    echo "<td>";
                        foreach($start as $key => $value){
                            echo $key.": ".$value."<br>";
                        }
                    echo "</td>";
                    echo "<td>";
                        foreach($end as $key => $value){
                            echo $key.": ".$value."<br>";
                        }
                    echo "</td>";
                    echo "<td>";
                        $perviousWeek = 0;
                        foreach($week as $num => $weight){
                            echo "Week ".$num.": ".$weight;
                            $diff = $weight - $perviousWeek;
                            if($perviousWeek != 0){
                                if($diff <= 0){
                                    $color = 'green';
                                    $op = "";
                                }
                                else {
                                    $color = 'red';
                                    $op = "+";
                                }
                                echo "<span style='color:".$color."'> (".$op.$diff.")</span>";
                            }
                            echo "<br>";
                            $perviousWeek = $weight;
                        }
                        echo "<br>";
                        if($totalLost <= 0){
                            $color = 'green';
                            $op = "";
                        }
                        else{
                            $color = 'red';
                            $op = "+";
                        }
                        echo "Total Weight Lost: <span style='color:".$color."'> (".$op.$totalLost.")</span>";
                        echo "<br>";
                        echo "Total Percentage Lost: ".$totalLostPercent;
                    echo "</td>";
                echo "</tr>";

            echo "</table>";
        }
        else{
            echo "unable to connect to server<br>";
            echo "Errno: " . $mysqli->errno . "</br>";
            echo "Error: " . $mysqli->error . "</br>";
        }
    }
?>
