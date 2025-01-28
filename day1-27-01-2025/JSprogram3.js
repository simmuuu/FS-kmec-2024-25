/*
You are given a date-time string dt in the format YYYY-MM-DDTHH:MM:SS (24-hour format). 
Your task is to convert this date-time string into the following format:

Input Format:
-------------
Line-1: A single date-time string in the format YYYY-MM-DDTHH:MM:SS (24-hour format).

Output Format:
--------------
Line-1: The formatted date-time string in the format :
DaySuffix MonthName, Year Hour:Minute:SecondAM/PM.

Sample Input-1:
---------------
2019-07-18T16:34:21

Sample Output-1:
----------------
18th July, 2019 04:34:21PM


Sample Input-2:
---------------
2022-03-01T23:59:59

Sample Output-2:
----------------
1st March, 2022 11:59:59PM

NOTE:
The output should include:
	Day with an ordinal suffix (e.g., 18th)
	Month as a word (e.g., July)
	12-hour time format with AM/PM

*/

const d = new Date("2019-07-18T16:34:21")

let date = d.getDate()
const month = d.toLocaleString("en-US", { month: "long" })
const year = d.getFullYear()
const time = d.toLocaleString("en-US", {
  hour: "2-digit",
  minute: "2-digit",
  second: "2-digit",
  hourCycle: "h12"
}).replace(" ", "")

if(date > 3 && date < 21) {
  date += 'th'
} else {
  switch(date % 10) {
    case 1:
      date += 'st'
      break
    case 2:
      date += 'nd'
      break
    case 3:
      date += 'rd'
      break
    default:
      date += 'th'
  }
}

console.log(`${date} ${month}, ${year} ${time}`)