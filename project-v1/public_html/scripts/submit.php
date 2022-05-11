<?php
    $page = $_GET['fn'];
    switch($page) {
        case "Teams":
            echo $page;
            break;
        case "Participants":
            $parameters = array(
                'FirstName' => $_GET['FirstName'], 
                'LastName' => $_GET['LastName'],
                'Age' => $_GET['Age'],
                'Gender' => $_GET['Gender'],
                'CurrentTeam' => $_GET['CurrentTeam']
            );
            participants($parameters);
            break;
        case "Registration":
            echo $page;
            registration($parameters);      
            break;
        case "Trainers":
            echo $page;        
            break;
        case "Mentors":
            echo $page;
            mentors($parameters);
            break;
        case "Interns":
            echo $page;
            interns($parameters);       
            break;
        case "Sponsors":
            echo $page;
            sponsors($parameters);      
            break;
        case "Results":
            echo $page;
            results($parameters);       
            break;
        default:
            echo "not working...";
    }
    function registration($parameters){}
    function trainers($parameters){}
    function mentors($parameters){}
    function interns($parameters){}
    function sponsors($parameters){}
    function results($parameters){}
    function participants($p){
        // echo $p['FirstName'];
        // echo $p['LastName'];
        // if($p['Age'] == ''){
        //     echo "age blank";
        // }
        // else{
        //     echo "age not blank";
        // }
        // echo $p['Age'];
        // echo $p['Gender'];
        // echo $p['CurrentTeam'];
        include 'db.php';
        $query = "INSERT INTO
                  Participants (FirstName, LastName, Age, Gender)
                  VALUES (
                      '{$p['FirstName']}',
                      '{$p['LastName']}',
                      {$p['Age']},
                      '{$p['Gender']}'
                      )
                  ";
        if($result = $mysqli->query($query)){
            echo "
                <style onload=\"load('Participants')\"></style>
            ";
        }
        else{
            echo "that didn't work";
            echo $query;
        }
    }
?>