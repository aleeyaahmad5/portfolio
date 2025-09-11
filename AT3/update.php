<?php
$title = "Update Confirmation";
include('includes/head.inc');
include('includes/nav.inc');
echo "<div id='message'>";
$error = false;

if (!empty($_POST['id'])) {
    require_once('includes/config.inc');
    require_once('includes/DbController.inc');
    $db = new DbController(HOST, USER, PASS, DB);

    foreach ($_POST as $key => $val) {
        $$key = trim($val);
    }

    $sql = "UPDATE activities SET name=?, venue=?, topic=?, details=? WHERE id=?";
    $update = $db->updateRecord($sql, $name, $venue, $topic, $details, $id); // Pass parameters to the update function

    if ($update) {
        echo "<p>Record $name updated<p>"; // Show the updated name
    } else {
        $error = true;
    }
} else {
    $error = true;
}

if ($error) {
    echo "<p>Record NOT updated<p>";
}
echo "</div>";
include('includes/footer.inc');
