/*Mr. Kejriwal purchased a digital clock, it shows the time in "hh:mm" 24 hr format.
Due to technical issue, in the place of some digits of displays '#' symbol.

As Mr Kejriwal is an IIT student also, he got an idea to find the number of 
valid times by replacing '#' with valid digits between 0-9.

You are given the time as a string T.
Your task is to help Mr Kejriwal to find the number of possible valid times.

NOTE:
-----
The valid time is in the range of 00:00 to 23:59.


Input Format:
-------------
A string T, the time in the (24-hr) format as "hh:mm" 

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
#6:00

Sample Output-1:
----------------
2

Explanation:
------------
The valid times after replacing # with 0 or 1, are "06:00", "16:00". 


Sample Input-2:
---------------
0#:0#

Sample Output-2:
----------------
100

Explanation:
------------
To make the given time valid, replace 1st # with 0-9 digits and 2nd with the same.
So, totally we have 100 ways.
*/

import java.util.*;

public class DSAprogram1 {
    public static int sol(String inp) {
        char h1 = inp.charAt(0);
        char h2 = inp.charAt(1);
        char m1 = inp.charAt(3);
        char m2 = inp.charAt(4);
        
        int count = 1;

        if(h1 == '#') {
            int h = 0;

            for(int i = 0; i <= 2; i++) {
                if(h2 == '#') {
                    if(i == 2) {
                        h += 4; // if 2#, then # (0 - 3) 
                    } else {
                        h += 10; // if 2#, then # (0 - 9)
                    }
                } else {
                    int hh2 = h2 - '0';
                    if(i < 2 || (i == 2 && hh2 <= 3)) {
                        h++;
                    }
                }
            }

            count *= h;
        } else if(h2 == '#') { // for x#:
            if(h1 == '2') { // 2# #(0-3)
                count *= 4;
            } else {
                count *= 10;
            }
        }

        if(m1 == '#') count *= 6; // :#x # == 6
        if(m2 == '#') count *= 10; // :x# # == 10

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inp = sc.nextLine();
        System.out.println(sol(inp));
        sc.close();
    }
}

// import java.util.*;

// public class DigitalClockSolution {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String time = sc.nextLine();
//         System.out.println(countValidTimes(time));
//         sc.close();
//     }
    
//     public static int countValidTimes(String time) {
//         // Extract each position
//         char h1 = time.charAt(0);
//         char h2 = time.charAt(1);
//         // Skip the colon at position 2
//         char m1 = time.charAt(3);
//         char m2 = time.charAt(4);
        
//         // Initialize the count as 1 (we'll multiply by valid options for each position)
//         int count = 1;
        
//         // Handle first hour digit (h1)
//         if (h1 == '#') {
//             // We need to consider each valid possibility for h1
//             int h1Options = 0;
            
//             // Try each possible value for h1 (0, 1, 2)
//             for (int i = 0; i <= 2; i++) {
//                 // Check if this creates a valid time with h2
//                 if (h2 == '#') {
//                     // h2 is also a #, so we need to count valid h2 options for each h1
//                     if (i == 2) {
//                         // If h1 is 2, h2 can be 0-3
//                         h1Options += 4;
//                     } else {
//                         // If h1 is 0 or 1, h2 can be 0-9
//                         h1Options += 10;
//                     }
//                 } else {
//                     // h2 is a digit, check if it makes a valid hour with this h1
//                     int hour2 = h2 - '0';
//                     if (i < 2 || (i == 2 && hour2 <= 3)) {
//                         h1Options++;
//                     }
//                 }
//             }
//             count *= h1Options;
//         } else if (h2 == '#') {
//             // h1 is fixed, but h2 is #
//             int h1Digit = h1 - '0';
//             if (h1Digit <= 1) {
//                 // If h1 is 0 or 1, h2 can be 0-9
//                 count *= 10;
//             } else if (h1Digit == 2) {
//                 // If h1 is 2, h2 can be 0-3
//                 count *= 4;
//             }
//         }
        
//         // Handle first minute digit (m1)
//         if (m1 == '#') {
//             // m1 can be 0-5
//             count *= 6;
//         }
        
//         // Handle second minute digit (m2)
//         if (m2 == '#') {
//             // m2 can be 0-9
//             count *= 10;
//         }
        
//         return count;
//     }
// }