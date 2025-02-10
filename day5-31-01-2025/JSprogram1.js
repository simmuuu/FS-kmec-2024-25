/*
You are managing a library's nested array of book collections. Each collection is 
an array containing book objects. Each book object includes the following properties:
	title (string): The title of the book.
	borrowed (boolean): A flag indicating whether the book is currently borrowed.

Your task is to perform the following operations:
  - Find the Collection: Locate the collection containing a specific book title 
    using findIndex.
  - Remove the Book: Once the collection is identified, find the book within 
    the collection using findIndex and remove it using splice.
  - Flatten the Library: Combine all collections into a single-level array using 
    the flat method.

Expected Output:
----------------
Output:
Flattened Library: [
    { title: "The Great Gatsby", borrowed: false },
    { title: "Moby Dick", borrowed: true },
    { title: "Animal Farm", borrowed: false },
    { title: "To Kill a Mockingbird", borrowed: true },
    { title: "The Catcher in the Rye", borrowed: false }
]

*/

const library = [
    [
        { title: "The Great Gatsby", borrowed: false },
        { title: "Moby Dick", borrowed: true }
    ],
    [
        { title: "1984", borrowed: false },
        { title: "Animal Farm", borrowed: false }
    ],
    [
        { title: "To Kill a Mockingbird", borrowed: true },
        { title: "The Catcher in the Rye", borrowed: false }
    ]
];

const bookToRemove = "1984";

// flatten library
const flatLib = library.flat()

const remInd = flatLib.findIndex((book) => book.title === bookToRemove)
if(remInd != -1) {
    flatLib.splice(remInd, 1)
}

console.log(flatLib)