/*
In this assignment, you will simulate the workflow of a movie booking app that 
has the following tasks:
	First Concurrent Activities:
		- Fetch available movies from the server.
		- Check user details (e.g., whether they are logged in or not).

	Sequential Activities:
		- Choose a movie to book.
		- Select showtime for the movie.
		- Make payment for the booking.
		
	Second Concurrent Activities:
		- Send confirmation email
		- Send confirmation SMS

Each task takes different amounts of time, and some tasks can happen concurrently 
while others need to happen sequentially.

Requirements:
=============
Use async/await and promises to model the system.
	Task 1: Fetch available movies from the server should take 2 seconds.
	Task 2: Check user details should take 1.5 seconds.
	Task 3: Choose a movie to book should take 1 second.
	Task 4: Select showtime for the movie should take 1.5 seconds.
	Task 5: Make payment for the booking should take 2 seconds.
	Task 6: Send confirmation email should take 1.5 seconds.
	Task 7: Send confirmation SMS should take 1 second.
Handle any errors that may occur (for example, if the booking fails).

Hint:
-----
You will need to:
Use Promise.all() for concurrent tasks.
Use await for sequential tasks.

Expected Output:
===============
Starting booking process for user ID 101...
Fetching available movies...
Checking user details for user ID: 101...
User ID 101 verified.
Choosing a movie...
Movie chosen: Movie A
Selecting showtime for Movie A...
Showtime for Movie A selected.
Making payment...
Payment successful.
Sending email confirmation...
Sending SMS confirmation...
Email confirmation sent.
SMS confirmation sent.
Booking process completed for user 101.
Booking Successful

*/

function fetchAvailableMovies() {
    return new Promise((resolve) => {
      console.log("Fetching available movies...");
      setTimeout(() => {
        resolve(["Movie A", "Movie B", "Movie C", "Movie D"]);
      }, 2000); // Simulate 2 seconds delay
    });
  }
  
  function checkUserDetails(userId) {
    return new Promise((resolve) => {
      console.log(`Checking user details for user ID: ${userId}...`);
      // Write your logic here
    });
  }
  
  function chooseMovie(movieList) {
    return new Promise((resolve) => {
      console.log("Choosing a movie...");
      // Write your logic here ( choose Movie A )
    });
  }
  
  function selectShowtime(movie) {
    return new Promise((resolve) => {
      console.log(`Selecting showtime for ${movie}...`);
      // Write your logic here
    });
  }
  
  function makePayment() {
    return new Promise((resolve) => {
      console.log("Making payment...");
      // Write your logic here (e.g.,refer sample output)
    });
  }
  
  function sendEmailConfirmation() {
    return new Promise((resolve) => {
      console.log("Sending email confirmation...");
      // Write your logic here
    });
  }
  
  function sendSMSConfirmation() {
    return new Promise((resolve) => {
      console.log("Sending SMS confirmation...");
      // Write your logic here
    });
  }
  
  // Main function to process the movie booking
  async function processBooking(userId) {
    console.log(`Starting booking process for user ID ${userId}...`);
  
    // First Concurrent Activities: Fetch available movies and check user details
    const [movies, userVerified] = await Promise.all([
      fetchAvailableMovies(),
      checkUserDetails(userId),
    ]);
    console.log(userVerified);
  
    // Sequential Activities: Choose movie and select showtime
    const movieChosen = await chooseMovie(movies);
    console.log(`Movie chosen: ${movieChosen}`);
    
    const showtimeSelected = await selectShowtime(movieChosen);
    console.log(showtimeSelected);
  
    // Second Sequential Activity: Make payment
    const paymentStatus = await makePayment();
    console.log(paymentStatus);
  
    // Concurrent Activities: Send email and SMS confirmations
    const [emailStatus, smsStatus] = await Promise.all([
      sendEmailConfirmation(),
      sendSMSConfirmation(),
    ]);
    console.log(emailStatus);
    console.log(smsStatus);
  
    console.log(`Booking process completed for user ${userId}.`);
  }
  
  
  async function solution() { 
  const startTime = Date.now();
  // Test the process for a specific user
  await processBooking(101);
  const endTime = Date.now();
  // Calculate the elapsed time
  const elapsedTime = endTime - startTime;
      if(elapsedTime>=4000 && elapsedTime<=9000){
          console.log(`Booking Successful`);
      }
      else {
          console.log(`Booking Failure`);
      }
  }
  
  solution();
  
  