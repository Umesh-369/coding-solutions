# Nth Fibonacci Number

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Find the  **n-th**  Fibonacci number for a given non-negative integer **n**.
The Fibonacci sequence is defined as:

- F(0) = 0
- F(1) = 1
- F(n) = F(n - 1) + F(n - 2) for n ≥ 2

 **Examples :** 

```
Input: n = 5
Output: 5
Explanation: The 5th Fibonacci number is 5.
```

```
Input: n = 0
Output: 0 
Explanation: The 0th Fibonacci number is 0.

```

```
Input: n = 1
Output: 1
Explanation: The 1st Fibonacci number is 1.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T13:10:08.400Z  

```java
class Solution {
    static int nthFibonacci(int n) {
        // code here
       int[] dp=new int[n+1];
       Arrays.fill(dp,-1);
       
       return solve(n,dp);
    }
    
    public static int solve(int n,int[] dp){
     if(n<=1)return n;
     
     if(dp[n]!=-1)return dp[n];
     
     return dp[n]=solve(n-1,dp)+solve(n-2,dp);
    }
    
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/nth-fibonacci-number1335/1)