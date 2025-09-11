<?php $title = "Tourism Victoria - Contact Us"; ?>

<?php include_once "includes/head.inc"; ?>
<?php include_once "includes/nav.inc"; ?>

<main>
    <form class="contact-form">
        <h2>Contact Us</h2>
        <label for="name">Full Name</label>
        <input type="text" id="name" required>
        <label for="email">Email Address</label>
        <input type="email" id="email" required>
        <label for="subject">Subject of Enquiry</label>
        <input type="text" id="subject" required>
        <label for="enquiry">Detailed Description of Enquiry</label>
        <textarea id="enquiry" placeholder="Write your message here..." required></textarea>
        <button type="submit">Send Message</button>
    </form>


</main>
<?php include_once "includes/footer.inc"; ?>