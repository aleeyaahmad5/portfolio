<?php
// Database connection constants
if ($_SERVER['SERVER_NAME'] == 'localhost') {
    define('HOST', 'localhost');
    define('USER', 'root');
    define('PASS', '');
    define('DB', 'tourism_victoria');
} else {
    define('HOST', 'talsprddb02.int.its.rmit.edu.au');
    define('USER', 's4093344');
    define('PASS', 'p20051211!');
    define('DB', 's4093344');
}
