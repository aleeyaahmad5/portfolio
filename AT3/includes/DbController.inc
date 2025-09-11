<?php
ini_set('display_errors', 1);
error_reporting(E_ALL);

class DbController
{
    private $conn;

    public function __construct($host, $user, $pass, $db)
    {
        // Establish the database connection
        $this->conn = new mysqli($host, $user, $pass, $db);
        if ($this->conn->connect_error) {
            die("Connection failed: " . $this->conn->connect_error);
        }
    }

    // Clean up user input to prevent SQL injection
    public function cleanUp($value)
    {
        return trim($this->conn->real_escape_string($value));
    }

    // Insert a new record into the database
    public function insertQuery($sql, $name, $venue, $topic, $details, $photo)
    {
        try {
            $stmt = $this->conn->prepare($sql);
        } catch (Throwable $th) {
            $this->logError($this->conn->error);
            exit("An error occurred.");
        }

        $stmt->bind_param("sssss", $name, $venue, $topic, $details, $photo);
        $stmt->execute();

        return $stmt->affected_rows;
    }

    // Upload an image to the server
    public function uploadImage($temp, $dest)
    {
        try {
            if (move_uploaded_file($temp, $dest)) {
                return true; // Image successfully moved
            } else {
                throw new Exception("Failed to move the image to the destination.");
            }
        } catch (Exception $e) {
            $this->logError($e->getMessage());
            return false;
        }
    }

    // Log SQL errors to a custom error log file
    private function logError($error)
    {
        error_log("SQL Error: $error" . PHP_EOL, 3, "log/my-errors.log");
    }

    // Close the database connection
    public function closeConnection()
    {
        $this->conn->close();
    }

    //AT3 Below
    // Retrieve records from the database
    public function getRecords($sql)
    {
        $resultset = [];
        $result = $this->conn->query($sql);
        while ($row = $result->fetch_assoc()) {
            $resultset[] = $row;
        }
        return $resultset;
    }

    // Delete a record from the database
    public function deleteRecord($sql, $id)
    {
        $stmt = $this->conn->prepare($sql);
        if (!$stmt) {
            exit("Prepare failed: " . $this->conn->error);
        }
        $stmt->bind_param("i", $id);
        $stmt->execute();
        if ($stmt->affected_rows > 0) {
            return true;
        }
        return false;
    }

    // Update a record in the database
    public function updateRecord($sql, $name, $venue, $topic, $details, $id)
    {
        $stmt = $this->conn->prepare($sql);
        if (!$stmt) {
            exit("Prepare failed: " . $this->conn->error);
        }
        $stmt->bind_param("ssssi", $name, $venue, $topic, $details, $id);
        $stmt->execute();
        if ($stmt->affected_rows > 0) {
            return true;
        }
        return false;
    }
}
