/*
  "age": 28,
  "gender": "Male",
  "email": "aarav.sharma@example.com",
  "department": "Engineering",
  "salary": 720000,
  "isPermanent": true,
  "joiningDate": {
    "$date": "2019-06-15T00:00:00.000Z"
  },
  "skills": [
    "JavaScript",
    "Node.js",
    "MongoDB"
  ],
  "address": {
    "street": "12 MG Road",
    "city": "Bangalore",
    "state": "Karnataka",
    "pinCode": 560001
  }
}


Sample Output:
--------------
[                                                                               
  {                                                                             
    name: 'Aarav Sharma'                                                        
  },                                                                            
  {                                                                             
    name: 'Ananya Iyer'                                                         
  }
]   


Query Reference:
-------------------
printjson() : JS library function to display the JSON Object data.
In db.<collection>.find():
	db -> Refers to the database.
	<collection> -> Your collection name
	find() -> Method to write the selection and projection part of the query.

*/
	
printjson(
	db.employees.find({name:{$regex:/^A/}},{_id:0,name:1})
)

/*
Write a MongoDB query to find employees whose names end with the letter 'a'.


Collection: 'employees'

Reference Document:
----------------------
{
  "employeeId": "E001",
  "name": "Aarav Sharma",
  "age": 28,
  "gender": "Male",
  "email": "aarav.sharma@example.com",
  "department": "Engineering",
  "salary": 720000,
  "isPermanent": true,
  "joiningDate": {
    "$date": "2019-06-15T00:00:00.000Z"
  },
  "skills": [
    "JavaScript",
    "Node.js",
    "MongoDB"
  ],
  "address": {
    "street": "12 MG Road",
    "city": "Bangalore",
    "state": "Karnataka",
    "pinCode": 560001
  }
}


Sample Output:
--------------
[
  { name: 'Aarav Sharma' },
  { name: 'Isha Verma' },
  { name: 'Rohan Mehta' }
]


Query Reference:
-------------------
printjson() : JS library function to display the JSON Object data.
In db.<collection>.find():
	db -> Refers to the database.
	<collection> -> Your collection name
	find() -> Method to write the selection and projection part of the query.

*/
	
printjson(
	db.employees.find({name:{$regex:/a$/}},{_id:0,name:1})
)

/*
Write a MongoDB query to find employees whose name contains the substring 'vi'
(case-insensitive).


Collection: 'employees'

Reference Document:
----------------------
{
  "employeeId": "E001",
  "name": "Aarav Sharma",
  "age": 28,
  "gender": "Male",
  "email": "aarav.sharma@example.com",
  "department": "Engineering",
  "salary": 720000,
  "isPermanent": true,
  "joiningDate": {
    "$date": "2019-06-15T00:00:00.000Z"
  },
  "skills": [
    "JavaScript",
    "Node.js",
    "MongoDB"
  ],
  "address": {
    "street": "12 MG Road",
    "city": "Bangalore",
    "state": "Karnataka",
    "pinCode": 560001
  }
}


Sample Output:
--------------
[ { name: 'Vikram Singh' }, 
  { name: 'Tanvi Kulkarni' } 
]


Query Reference:
-------------------
printjson() : JS library function to display the JSON Object data.
In db.<collection>.find():
	db -> Refers to the database.
	<collection> -> Your collection name
	find() -> Method to write the selection and projection part of the query.

*/
	
printjson(
	db.employees.find({name:{$regex:/vi/,$options:'i'}},{_id:0,name:1})
)

/*
Write a MongoDB query to find employees whose email is from the domain example.com
and the email username ends with 'a'.


Collection: 'employees'

Reference Document:
----------------------
{
  "employeeId": "E001",
  "name": "Aarav Sharma",
  "age": 28,
  "gender": "Male",
  "email": "aarav.sharma@example.com",
  "department": "Engineering",
  "salary": 720000,
  "isPermanent": true,
  "joiningDate": {
    "$date": "2019-06-15T00:00:00.000Z"
  },
  "skills": [
    "JavaScript",
    "Node.js",
    "MongoDB"
  ],
  "address": {
    "street": "12 MG Road",
    "city": "Bangalore",
    "state": "Karnataka",
    "pinCode": 560001
  }
}


Sample Output:
--------------
[
  { name: 'Aarav Sharma', email: 'aarav.sharma@example.com' },
  { name: 'Isha Verma', email: 'isha.verma@example.com' },
  { name: 'Rohan Mehta', email: 'rohan.mehta@example.com' }
]


Query Reference:
-------------------
printjson() : JS library function to display the JSON Object data.
In db.<collection>.find():
	db -> Refers to the database.
	<collection> -> Your collection name
	find() -> Method to write the selection and projection part of the query.

*/
	
printjson(
	db.employees.find({$and:[{email:{$regex:/example.com/}},{name:{$regex:/a$/}}]},{name:1,email:1,_id:0})
)

/*
Write a MongoDB query to find employees who live in cities whose name starts 
with 'B' or 'C'.


Collection: 'employees'

Reference Document:
----------------------
{
  "employeeId": "E001",
  "name": "Aarav Sharma",
  "age": 28,
  "gender": "Male",
  "email": "aarav.sharma@example.com",
  "department": "Engineering",
  "salary": 720000,
  "isPermanent": true,
  "joiningDate": {
    "$date": "2019-06-15T00:00:00.000Z"
  },
  "skills": [
    "JavaScript",
    "Node.js",
    "MongoDB"
  ],
  "address": {
    "street": "12 MG Road",
    "city": "Bangalore",
    "state": "Karnataka",
    "pinCode": 560001
  }
}


Sample Output:
--------------
[                                                                               
  {                                                                             
    name: 'Aarav Sharma',                                                       
    address: {                                                                  
      city: 'Bangalore'                                                         
    }                                                                           
  }                                                                             
]  


Query Reference:
-------------------
printjson() : JS library function to display the JSON Object data.
In db.<collection>.find():
	db -> Refers to the database.
	<collection> -> Your collection name
	find() -> Method to write the selection and projection part of the query.

*/
	
printjson(
	db.employees.find({$or:[{"address.city":{$regex:/B/}},{"address.city":{$regex:/C/}}]},{_id:0,name:1,"address.city":1})
)

/*
Write a MongoDB query to find employees whose skills include exactly 6-character words.


Collection: 'employees'

Reference Document:
----------------------
{
  "employeeId": "E001",
  "name": "Aarav Sharma",
  "age": 28,
  "gender": "Male",
  "email": "aarav.sharma@example.com",
  "department": "Engineering",
  "salary": 720000,
  "isPermanent": true,
  "joiningDate": {
    "$date": "2019-06-15T00:00:00.000Z"
  },
  "skills": [
    "JavaScript",
    "Node.js",
    "MongoDB"
  ],
  "address": {
    "street": "12 MG Road",
    "city": "Bangalore",
    "state": "Karnataka",
    "pinCode": 560001
  }
}


Sample Output:
--------------
[ { name: 'Neha Reddy', skills: [ 'Python', 'Django' ] } ]


Query Reference:
-------------------
printjson() : JS library function to display the JSON Object data.
In db.<collection>.find():
	db -> Refers to the database.
	<collection> -> Your collection name
	find() -> Method to write the selection and projection part of the query.

*/
	
printjson(
	db.employees.find({skills:{$regex:/\b\w{6}\b/}},{_id:0,name:1,skills:1})
)
/*
Write a MongoDB query to find employees whose pin code has a repeated digit (e.g., 440001).


Collection: 'employees'

Reference Document:
----------------------
{
  "employeeId": "E001",
  "name": "Aarav Sharma",
  "age": 28,
  "gender": "Male",
  "email": "aarav.sharma@example.com",
  "department": "Engineering",
  "salary": 720000,
  "isPermanent": true,
  "joiningDate": {
    "$date": "2019-06-15T00:00:00.000Z"
  },
  "skills": [
    "JavaScript",
    "Node.js",
    "MongoDB"
  ],
  "address": {
    "street": "12 MG Road",
    "city": "Bangalore",
    "state": "Karnataka",
    "pinCode": 560001
  }
}


Sample Output:
--------------
[
  { name: 'Aarav Sharma', address: { pinCode: '560001' } },
  { name: 'Isha Verma', address: { pinCode: '110001' } },
  { name: 'Rohan Mehta', address: { pinCode: '400001' } },
]


Query Reference:
-------------------
printjson() : JS library function to display the JSON Object data.
In db.<collection>.find():
	db -> Refers to the database.
	<collection> -> Your collection name
	find() -> Method to write the selection and projection part of the query.

*/
	
printjson(
	db.employees.find({"address.pinCode":{$regex:/(\d)\1/}},{_id:0,name:1,"address.pinCode":1})
)

