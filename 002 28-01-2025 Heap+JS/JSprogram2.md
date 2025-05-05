# High-Selling Products Revenue Calculator

## Problem Description

You have an array of product objects, each with `name`, `price`, and `sold` (number of units sold). Use `map` to calculate the revenue for each product, `filter` to include only products with a revenue of $50 or more, and `reduce` to find the total revenue from these high-selling products.

### Input Format
- **Line-1:** An integer `N`, the number of products.
- **Next N lines:** Each line contains a product name, price, and number of units sold separated by spaces.

### Output Format
- An integer, the total revenue from high-selling products.

### Sample Input
```
5
Shampoo 5 15
Soap 2 20
Toothpaste 3 10
Conditioner 10 2
Lotion 8 10
```

### Sample Output
```
155
```

**Explanation:**
- Shampoo revenue = `5 * 15 = 75`
- Soap revenue = `2 * 20 = 40` (not included, as it’s less than 50)
- Toothpaste revenue = `3 * 10 = 30` (not included)
- Conditioner revenue = `10 * 2 = 20` (not included)
- Lotion revenue = `8 * 10 = 80`

## Solution

```javascript
function solution(products) {
    return products
        .map((p) => p.price * p.sold)
        .filter((p) => p > 50)
        .reduce((total, p) => total + p, 0);
}
```
