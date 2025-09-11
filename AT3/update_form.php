<?php
$title = "Update Form";
include('includes/head.inc');
include('includes/nav.inc');

if (!empty($_GET['id'])) {
    $id = $_GET['id'];
    require_once('includes/config.inc');
    require_once('includes/DbController.inc');
    $db = new DbController(HOST, USER, PASS, DB);
    $sql = "SELECT * FROM activities WHERE id = $id";
    $result = $db->getRecords($sql);

    foreach ($result as $row) {
?>
<form class="main-form" method="post" action="update.php">
    <h3>Update Activity Details: <?php echo $row['name']; ?></h3>
    <input type="hidden" name="id" value="<?php echo $row['id']; ?>">
    <label>Name</label>
    <input type="text" name="name" value="<?php echo $row['name']; ?>">
    <label>Venue</label>
    <input type="text" name="venue" value="<?php echo $row['venue']; ?>">
    <label>Topic</label>
    <input type="text" name="topic" value="<?php echo $row['topic']; ?>">
    <label>Description</label>
    <textarea cols="50" rows="5" name="details"><?php echo $row['details']; ?></textarea>
    <input type="submit" name="submit" value="Update">
</form>

<?php
    }
}
include('includes/footer.inc');
?>