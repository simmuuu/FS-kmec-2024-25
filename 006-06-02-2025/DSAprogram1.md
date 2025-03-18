# Relay Network Reconstruction

## Problem Description

In a distant galaxy, an ancient civilization built a hierarchical communication network of interconnected relay stations. The structure of this network can be reconstructed using two ancient data logs:
- **Beacon Activation Order** (analogous to in-order traversal)
- **Final Signal Sent Order** (analogous to post-order traversal)

Using these logs, we can reconstruct the original relay network and process queries about signals reaching specific hierarchical levels.

### Input Format
- **Line-1:** An integer `N` representing the number of relay stations in the network.
- **Line-2:** A space-separated list of `N` integers representing the Beacon Activation Order (similar to in-order traversal).
- **Line-3:** A space-separated list of `N` integers representing the Final Signal Sent Order (similar to post-order traversal).

### Output Format
- A list of integers, level-wise transmission sequence.

### Sample Input
```
7
4 2 5 1 6 3 7
4 5 2 6 7 3 1
```

### Sample Output
```
[1, 2, 3, 4, 5, 6, 7]
```

### Explanation
The logs correspond to the following hierarchical relay network:
```
        1
       / \
      2   3
     / \  / \
    4   5 6  7
```
The level order is: `1 2 3 4 5 6 7`

## Solution

```
TBW
```