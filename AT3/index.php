<?php $title = "Tourism Victoria - Home"; ?>

<?php include_once "includes/head.inc"; ?>
<?php include_once "includes/nav.inc"; ?>

<main>

    <!-- <section>
        <h2>Sunnymead Hotel</h2>
        <img src="images/SunnymeadHotel_Hotels.jpg" alt="Sunnymead Hotel" width="500" height="500">
        <h3>Hotels</h3>
        <p>
            Sunnymead Hotel is full of fun, colour and personality. Located on the Great
            Ocean Road in the heart of Aireys Inlet, a small coastal town with a vibrant
            culture enjoyed by foodies, art lovers and nature seekers.
        </p>
    </section>
    <section>
        <h2>Kangaroo Ridge Retreat</h2>
        <img src="images/KangarooRidgeRetreat_RetreatsAndLodges.jpg" alt="Kangaroo Ridge Retreat" width="500"
            height="500">
        <h3>Retreats and Lodges</h3>
        <p>
            Kangaroo Ridge Retreat is the cure for that persistent case of wanderlust.
            Retreats for one or two people are designed to restore and revitalise every
            one of the five senses. Here is a hidden place to unearth a curated cabin
            experience for the curious, wanderers and dreamers.
        </p>
    </section>
    <section>
        <h2>Chocolate Gannets</h2>
        <img src="images/ChocolateGannets_Cottages.jpg" alt="Chocolate Gannets" width="500" height="500">
        <h3>Cottages</h3>
        <p>
            Chocolate Gannets offers luxury accommodation on the Great Ocean Road. Nestled
            on the shores of Apollo Bay, the secluded villas are famous for their meditative
            sea views, effortless luxury, spa tubs and enviable beachfront position. The
            ultimate honeymoon or romantic escape for couples celebrating anniversaries
            and engagements. Or a peaceful nature retreat for families.
        </p>
    </section> -->



    <?php
    require_once('includes/config.inc');
    require_once('includes/DbController.inc');

    $db = new DbController(HOST, USER, PASS, DB);
    $sql = "SELECT * FROM activities";
    $records = $db->getRecords($sql);

    if (!empty($records)) {
        foreach ($records as $row) {
            echo "<section>";
            echo "<h2>{$row['name']}</h2>";
            echo "<p><a href='details.php?id={$row['id']}'>Read More</a></p>";
            echo "<img src='images/{$row['photo']}' alt='{$row['topic']}' width='500' height='500'>";
            echo "<h3>{$row['venue']}</h3>";
            echo "<p>{$row['details']}</p>";
            echo "</section>";
        }
    } else {
        echo "<p>No activities found.</p>";
    }
    ?>


</main>

<?php include_once "includes/footer.inc"; ?>