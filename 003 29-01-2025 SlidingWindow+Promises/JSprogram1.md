# Food Delivery App Workflow Simulation

## Problem Description

Simulate the workflow of a food delivery app with the following tasks:
- **First Concurrent Activities:** Fetch menu data from the server and check customer details.
- **Sequential Activities:** Prepare the food and package it.
- **Second Concurrent Activities:** Assign a delivery person and update the delivery status.

Each task takes different amounts of time, and some tasks can happen concurrently while others need to happen sequentially.

### Requirements
- Use `async/await` and promises to model the system.
- **Task 1:** Fetch menu data from the server should take 2 seconds.
- **Task 2:** Check customer details should take 1.5 seconds.
- **Task 3:** Prepare the food should take 3 seconds.
- **Task 4:** Package the food should take 2 seconds.
- **Task 5:** Assign a delivery person should take 1 second.
- **Task 6:** Update the delivery status should take 1.5 seconds.
- Handle any errors that may occur (e.g., if the delivery fails).

### Expected Output
```
Starting process for order 123...
Fetching menu data...
Checking details for customer ID: 456...
Menu data fetched.
Details verified for customer ID: 456.
Preparing food for order 123...
Food for order 123 prepared.
Packaging food for order 123...
Food for order 123 packaged.
Assigning a delivery person for order 123...
Updating delivery status for order 123...
Delivery person assigned for order 123.
Delivery status updated for order 123.
Order 123 process completed!
Passed
```

## Solution

```javascript
function fetchMenu() {
  return new Promise((resolve) => {
    console.log("Fetching menu data...");

    setTimeout(() => {
      let menuData = true;

      if (menuData) {
        resolve("Menu data fetched.");
      } else {
        // reject
      }
    }, 2000);
  });
}

function checkCustomerDetails(customerId) {
  return new Promise((resolve) => {
    console.log(`Checking details for customer ID: ${customerId}...`);

    setTimeout(() => {
      let customerData = true;

      if (customerData) {
        resolve(`Details verified for customer ID: ${customerId}.`);
      } else {
        // reject
      }
    }, 1500);
  });
}

function prepareFood(orderId) {
  return new Promise((resolve) => {
    console.log(`Preparing food for order ${orderId}...`);

    setTimeout(() => {
      let foodPrepData = true;

      if (foodPrepData) {
        resolve(`Food for order ${orderId} prepared.`);
      } else {
        // reject
      }
    }, 3000);
  });
}

function packageFood(orderId) {
  return new Promise((resolve) => {
    console.log(`Packaging food for order ${orderId}...`);

    setTimeout(() => {
      let packageFoodData = true;

      if (packageFoodData) {
        resolve(`Food for order ${orderId} packaged.`);
      } else {
        // reject
      }
    }, 2000);
  });
}

function assignDeliveryPerson(orderId) {
  return new Promise((resolve) => {
    console.log(`Assigning a delivery person for order ${orderId}...`);

    setTimeout(() => {
      let assignmentData = true;

      if (assignmentData) {
        resolve(`Delivery person assigned for order ${orderId}.`);
      }
    }, 1000);
  });
}

function updateDeliveryStatus(orderId) {
  return new Promise((resolve) => {
    console.log(`Updating delivery status for order ${orderId}...`);
    setTimeout(() => {
      resolve(`Delivery status updated for order ${orderId}.`);
    }, 1500); // Simulates a 1.5-second delay
  });
}

async function processOrder(orderId, customerId) {
  console.log(`Starting process for order ${orderId}...`);

  const [menuFetched, customerVerified] = await Promise.all([
    fetchMenu(),
    checkCustomerDetails(customerId),
  ]);
  console.log(menuFetched);
  console.log(customerVerified);

  const foodPrepared = await prepareFood(orderId);
  console.log(foodPrepared);

  const foodPackaged = await packageFood(orderId);
  console.log(foodPackaged);

  const [deliveryAssigned, statusUpdated] = await Promise.all([
    assignDeliveryPerson(orderId),
    updateDeliveryStatus(orderId),
  ]);
  console.log(deliveryAssigned);
  console.log(statusUpdated);

  console.log(`Order ${orderId} process completed!`);
}

async function solution() {
  const startTime = Date.now();
  await processOrder(123, 456);
  const endTime = Date.now();
  const elapsedTime = endTime - startTime;
  if (elapsedTime <= 9000) {
    console.log(`Passed`);
  } else {
    console.log(`Failed`);
  }
}

solution();
```
