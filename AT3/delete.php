<?php
$title = "Delete Record";
include('includes/head.inc');
include('includes/nav.inc');

$error = false;

// Check if ID and image are provided
if (!empty($_GET['id']) && !empty($_GET['image'])) {
    $id = $_GET['id'];
    $image = $_GET['image'];

    require_once('includes/config.inc');
    require_once('includes/DbController.inc');

    // Create a new instance of the DbController
    $db = new DbController(HOST, USER, PASS, DB);

    // SQL query to delete the record
    $sql = "DELETE FROM activities WHERE id = ?";
    if ($db->deleteRecord($sql, $id)) {
        echo "<p>Record deleted successfully.</p>";
        // Delete the associated image file if it exists
        if (file_exists($image)) {
            unlink($image);
        }
    } else {
        $error = true;
    }
} else {
    $error = true;
}

// Display an error message if the deletion failed
if ($error) {
    echo "<p>Error: Record NOT deleted.</p>";
}

include('includes/footer.inc');
