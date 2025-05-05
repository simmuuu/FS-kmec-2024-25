## Question 1
```
/*
In an institution there is a special keyboard.
It contains only one row of 26-keys, keys[]

The order of keys will be given, You need to findout the time taken to type a word.

The rules to find the time is as follows:
Initially you will be at first key .i.e, keys[0].
To type a character, you have to move to a key having desired character, key[j].
Time taken to type the character from key at ith index to key at jth index is |i - j|.

You will be given two strings, Keys and Word W.
Your task is to find how much time it takes to type the Word W 
using the given order of keys

NOTE: You have to use only one finger to type the word.

Input Format:
-------------
Line-1: A String Keys order.
Line-2: A String word W to type.

Output Format:
--------------
An integer T, time to type the word.


Sample Input-1:
---------------
poiuytrewqasdfghjklmnbvcxz
kmit

Sample Output-1:
----------------
39


Sample Output-2:
----------------
abcdefghijklmnopqrstuvwxyz
code

Sample Output-2:
----------------
26

*/
```

## Question 2
```
/*
You are given two words W1 and W2.
You need find all the mapping of W2 in W1, and 
return all the statrting indices of the mappings.

The mapping of the words w2 and w1 is as follows:
	- A shuffled word contains all the characters as original word.
	The length of the words and occurrence count of each character are same.
	- find shuffled word of W2 as a substring in W1, and 
	return the starting index of substring.


Input Format:
-------------
Single line space separated strings, two words.

Output Format:
--------------
Print the list of integers, indices.


Sample Input-1:
---------------
abcabcabc abc
 
Sample Output-1:
----------------
[0, 1, 2, 3, 4, 5, 6]



Sample Input-2:
---------------
bacacbacdcab cab

Sample Output-2:
----------------
[0, 3, 4, 5, 9]

*/
```

## Question 3
```
/*
A courier company has to deliver N items with different heights.
All the items have to deliver to one building only.

The building has K rooms inside indexed 0,1,..-K-1, and the heights
of the rooms are different. All the rooms connected with each other and 
has only one entry point,  e.g, you can reach room-1 from room-0 only, 
room-2 from room-1 only, ..so on.

Now the task of the delivery agent is to keep the items inside the building.

To keep the items into the rooms, delivery agent has to follow these rules:
 - Agent can't keep, two goods in same room.
 - As there is only one entry point, If the height of some room is 
   less than the height of an item, then the item will be stopped before
   that room, so are the items behind it.
 - Agent can rearrange the order of items to keep them inside the building.
   
Return the maximum number of items, the delivery agent can keep inside the building.

Input Format:
-------------
Line-1 -> two integers N and K, number of items and number of rooms.
Line-2 -> N space separated integers, heights of the items.
Line-3 -> K space separated integers, heights of the rooms.

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
4 5
4 3 4 1
5 3 3 4 1

Sample Output-1:
----------------
3

Explanation:
------------
We can first keep the item of height 1 in room 4. 
Then we can keep the item of height 3 in either of the 3 rooms 1, 2, or 3.
Lastly, we can keep one box of height 4 in room 0.
There is no way we can keep all 4 items in the building.


Sample Input-2:
---------------
5 4
1 2 2 3 4
3 4 1 2

Sample Output-2:
----------------
3

Explanation:
------------
Notice that it's not possible to keep the item of height 4 into the building,
since it cannot pass the first room of height 3.
Also, for the last two rooms, 2 and 3, only items of height 1 can kept.
In room 2 or 3, keep item of height 1.
In room 1, keep item of height 2.
Finally in room 0, keep item of height 3. 
We can keep 3 items maximum.
*/
```

## Question 4
```
Ramesh and Suresh are playing a game.
Initially, Ramesh has a secret number, and Suresh has to guess that number.
Ramesh now checks, How many digits of the guess number match 
the secret number exactly, if both the digit and position are matched, 
indicate them as Apples. If the digit is matched and position is different, 
indicate them as Bananas.

Ramesh will give a hint to Suresh as follows:
e.g., secret number= 1231, and guess number = 4213
Only digit=2 is matching, so apple is 1, banana is 2
Ramesh tell the answer as 1A2B

You are given secrect number and guess number as strings,
Your task to help Ramesh, to find and return the HINT.

NOTE: The length of the both secrect and guess number is same, 
		contains only digits.

Input Format:
-------------
Two strings, secret and guess

Output Format:
--------------
Print the string, the HINT.


Sample Input-1:
---------------
1807 7810

Sample Output-1:
----------------
1A3B

Explanation: 
------------
1 Apple and 3 Banana. Apple is 8, Banana are 0, 1 and 7.


Sample Input-2:
---------------
1123 0111

Sample Output-2:
----------------
1A1B

Explanation: 
------------
The 1st 1 in Suresh guess is an Apple, the 2nd or 3rd 1 is B.
```