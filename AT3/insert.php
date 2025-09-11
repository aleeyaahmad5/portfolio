<?php
// Include header and navigation
$title = "Tourism Victoria - Insert Record";
include_once "includes/head.inc";
include_once "includes/nav.inc";
?>

<main>
    <form method="post" action="insert.php" enctype="multipart/form-data">
        <?php
        if ($_SERVER['REQUEST_METHOD'] == 'POST') {
            include_once 'includes/config.inc';
            include_once 'includes/DbController.inc';

            $db = new DbController(HOST, USER, PASS, DB);

            // Clean and validate inputs
            $name = $db->cleanUp($_POST['name']);
            $venue = $db->cleanUp($_POST['venue']);
            $topic = $db->cleanUp($_POST['topic']);
            $details = $db->cleanUp($_POST['details']);
            $photo = $_FILES['photo']['name'];
            $temp = $_FILES['photo']['tmp_name'];
            $error = $_FILES['photo']['error'];

            // Move uploaded photo to the images folder
            if ($error == 0) {
                $targetDir = 'images/';
                $targetFile = $targetDir . basename($photo);
                move_uploaded_file($temp, $targetFile);
            }

            // Insert the record into the database
            $sql = "INSERT INTO activities (name, venue, topic, details, photo) VALUES (?, ?, ?, ?, ?)";
            if ($db->insertQuery($sql, $name, $venue, $topic, $details, $photo)) {
                echo "<p>New activity successfully inserted into the database.</p>";
            } else {
                echo "<p>Failed to insert the activity into the database.</p>";
            }
        }
        ?>

        <label for="name">Activity Name:</label>
        <input type="text" name="name" id="name" required><br><br>

        <label for="venue">Venue:</label>
        <input type="text" name="venue" id="venue" required><br><br>

        <label for="topic">Topic:</label>
        <input type="text" name="topic" id="topic" required><br><br>

        <label for="details">Details:</label>
        <textarea name="details" id="details" rows="5" cols="50" required></textarea><br><br>

        <label for="photo">Upload Photo:</label>
        <input type="file" name="photo" id="photo" required><br><br>

        <input type="submit" name="submit" value="Insert">
    </form>


</main>

<?php include_once "includes/footer.inc"; ?>