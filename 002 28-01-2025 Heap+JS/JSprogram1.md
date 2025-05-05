# Profitable Projects Calculator

## Problem Description

You have an array of project objects, each with `name`, `revenue`, and `cost`. Use `filter` to include only projects where revenue is greater than cost (profitable projects), `map` to calculate the profit for each project, and `reduce` to find the total profit from these profitable projects.

### Input Format
- **Line-1:** An integer `N`, the number of projects.
- **Next N lines:** Each line contains a project name, revenue, and cost separated by spaces.

### Output Format
- An integer, the total profit from profitable projects.

### Sample Input
```
5
ProjectA 500 300
ProjectB 200 250
ProjectC 600 400
ProjectD 150 100
ProjectE 300 400
```

### Sample Output
```
450
```

**Explanation:**
Profitable projects are `ProjectA`, `ProjectC`, and `ProjectD`.
Profits for each are: `ProjectA = 200`, `ProjectC = 200`, `ProjectD = 50`.
Total profit = `200 + 200 + 50 = 450`.

## Solution

```javascript
function solution(projects) {
    return projects
        .filter((p) => p.revenue > p.cost)
        .map((p) => p.revenue - p.cost)
        .reduce((totalProfit, profit) => totalProfit + profit, 0);
}
```
