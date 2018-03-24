<?php
    include ($_SERVER['DOCUMENT_ROOT']."/menu.php");

    echo "<h1>Add Sponsor</h1>";
    // echo $_REQUEST['year']."  ".$_REQUEST['season']."<br>";
?>
<form method="post">
    Name: <input type="text" name="name"><br>
    Phone Number: <input type="text" name="phone"><br>
    Contact: <input type="text" name="contact"><br>
    Other Information: <input type="text" name="other"><br>
    <br>
    <input type="submit" formaction="/sponsors/addSave.php" value="Submit">
    <button type="submit" formaction="/sponsors/view.php">Cancel</button>
</form>
