<?php
$title = "Delete Confirmation";
include('includes/head.inc');
include('includes/nav.inc');

if (!empty($_GET['id'])) {
    require_once('includes/config.inc');
    require_once('includes/DbController.inc');
    $id = $_GET['id'];
    $db = new DbController(HOST, USER, PASS, DB);
    $sql = "SELECT * FROM activities WHERE id = $id";
    $results = $db->getRecords($sql);

    // Start confirmation box
    echo "<div class='confirmation-container'>";

    foreach ($results as $row) {
        echo "<h2>Are you sure you want to delete this record?</h2>";
        echo "<h3>{$row['name']}</h3>";
        echo "<p>{$row['details']}</p>";
        echo "<img src='images/{$row['photo']}' alt='{$row['name']}' class='thumb'>";

        echo "<div class='confirmation-box'>";  // Confirmation box div
        echo "<p class='confirm'>";
        echo "<a href='modify.php'>Cancel</a>";
        echo "&nbsp;";
        // Encode URL to make HTML valid
        $imagename = urlencode("images/{$row['photo']}");
        echo "<a href='delete.php?id={$row['id']}&image=$imagename'>Delete</a>";
        echo "</p>";
        echo "</div>";  // Closing confirmation box div
    }

    // End confirmation container
    echo "</div>";
}

include('includes/footer.inc');
