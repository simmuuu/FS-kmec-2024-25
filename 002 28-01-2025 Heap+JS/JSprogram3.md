# In-Stock Products Quantity Calculator

## Problem Description

Given an array of product objects, each with `name`, `price`, `quantity`, and `inStock` (boolean). Use `filter` to include only products that are in stock, `map` to get their quantities, and `reduce` to find the total quantity of these in-stock products.

### Input Format
- **Line-1:** An integer `N`, the number of products.
- **Next N lines:** Each line contains a product name, price, quantity, and in-stock status separated by spaces.

### Output Format
- An integer, the total quantity of in-stock products.

### Sample Input
```
5
Laptop 1000 5 true
Phone 500 3 false
Tablet 300 8 true
Monitor 200 6 false
Keyboard 50 12 true
```

### Sample Output
```
25
```

**Explanation:**
- In-stock products are `Laptop`, `Tablet`, and `Keyboard`.
- Quantities are `5`, `8`, and `12`.
- Total quantity = `5 + 8 + 12 = 25`.

## Solution

```javascript
function solution(products) {
    return products
        .filter((p) => p.inStock)
        .map((p) => p.quantity)
        .reduce((total, p) => total + p, 0);
}
```