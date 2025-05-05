# Colonization Hierarchy Reconstruction

## Problem Description

In a distant future, humanity has begun interstellar colonization, establishing zones of habitation and control on a new planet. Scientists have recorded two types of data regarding how these zones were structured:
- **Survey Order** (analogous to pre-order traversal): This record details how the colonization started, with the first zone established and then expanding into new zones following a systematic approach.
- **Planetary Layout** (analogous to in-order traversal): This document shows how zones were positioned relative to each other on the map, based on territorial boundaries.

Using this information, scientists need to reconstruct the colonization hierarchy (binary tree of zones) and display them level-wise.

### Input Format
- **Line-1:** An integer `N` representing the number of zones colonized.
- **Line-2:** A space-separated list of `N` integers representing the Planetary Layout Order (in-order).
- **Line-3:** A space-separated list of `N` integers representing the Survey Order (pre-order).

### Output Format
- Print all zone IDs in level order.

### Sample Input
```
7
4 2 5 1 6 3 7
1 2 4 5 3 6 7
```

### Sample Output
```
1 2 3 4 5 6 7
```

### Explanation
The given Planetary Layout (in-order) and Survey Order (pre-order) correspond to the following colonization hierarchy:
```
        1
       / \
      2   3
     / \  / \
    4   5 6  7
```
- **Level Order:** `1 2 3 4 5 6 7`

## Solution

```
TBW
```