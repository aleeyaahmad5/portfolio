<?php
require_once('includes/config.inc');
require_once('includes/DbController.inc');
$title = "Activity Details";
include_once('includes/head.inc');
include_once('includes/nav.inc');

if (!isset($_GET['id'])) {
    echo "<p>Invalid request</p>";
    exit();
}

$db = new DbController(HOST, USER, PASS, DB);
$sql = "SELECT * FROM activities WHERE id = {$_GET['id']}";
$records = $db->getRecords($sql);

if (!empty($records)) {
    foreach ($records as $row) {
        echo "<section class='details'>";
        echo "<h2>{$row['name']}</h2>";
        echo "<img src='images/{$row['photo']}' alt='{$row['topic']}'>";
        echo "<p><strong>Venue:</strong> {$row['venue']}</p>";
        echo "<p><strong>Topic:</strong> {$row['topic']}</p>";
        echo "<p><strong>Description:</strong> {$row['details']}</p>";
        echo "<a href='modify.php?id={$row['id']}'>Edit Activity</a>"; // Link to modify the activity
        echo "</section>";
    }
} else {
    echo "<p>No details found for the specified activity.</p>";
}

include('includes/footer.inc');
