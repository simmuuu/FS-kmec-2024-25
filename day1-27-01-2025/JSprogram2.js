/*
You are given two sorted arrays, arr1 and arr2. 
Your task is to merge these two arrays into a single sorted array. 
Both input arrays are already sorted in non-decreasing order. 
The output should also be a sorted array that contains all elements from 
both arr1 and arr2.

Input Format:
-------------
Line-1: Space separated numbers, represents arr1
Line-2: Space separated numbers, represents arr2

Output Format:
--------------
Line-1 Space separated numbers, represents sorted arr

Sample Input:
-------------
1 3 5
2 4 6

Sample Output:
--------------
1 2 3 4 5 6

Constraints:
-------------
Each array can contain distinct integers.
Both arrays are already sorted.
*/

const mergeSortedArrays = (arr1, arr2) => {
      let mergedArr = []
      let m = 0, n = 0;
      
      while(m < arr1.length && n < arr2.length) {
          if(arr1[m] <= arr2[n]) mergedArr.push(arr1[m++])
          else if (arr1[m] > arr2[n]) mergedArr.push(arr2[n++])
      }
      
      while(m < arr1.length) mergedArr.push(arr1[m++])
      while(n < arr2.length) mergedArr.push(arr2[n++])
      
      return mergedArr
};