<?php
ini_set('display_errors', 1);
error_reporting(E_ALL);

require_once('includes/config.inc');
require_once('includes/DbController.inc');
$title = "Tourism Victoria - Modify Record";
include('includes/head.inc');
include('includes/nav.inc');

// Create a new instance of the DbController
$db = new DbController(HOST, USER, PASS, DB);

// SQL query to retrieve all records from the activities table
$sql = "SELECT id, name, venue, topic, details, photo FROM activities";
$results = $db->getRecords($sql);
?>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Venue</th>
        <th>Topic</th>
        <th>Details</th>
        <th>Image</th>
        <th colspan="2">Actions</th>
    </tr>
    <?php
    foreach ($results as $row) {
        echo "<tr>";
        echo "<td>{$row['id']}</td>";
        echo "<td>{$row['name']}</td>";
        echo "<td>{$row['venue']}</td>";
        echo "<td>{$row['topic']}</td>";
        echo "<td>{$row['details']}</td>";
        echo "<td><img class='thumb' src='images/{$row['photo']}' alt='{$row['name']}'></td>";
        echo "<td><a class='link' href='update_form.php?id={$row['id']}'>Update</a></td>";
        echo "<td><a class='link' href='delete_confirm.php?id={$row['id']}'>Delete</a></td>";
        echo "</tr>";
    }
    ?>
</table>

<?php include('includes/footer.inc'); ?>