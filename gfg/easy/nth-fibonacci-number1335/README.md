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
**Submitted:** 2026-09-28T14:10:48.686Z  

```java
class Solution {
    static int nthFibonacci(int n) {
        // code here
      if(n<=1){
          return n;
      }   
      int[] dp=new int[n+1];
      dp[0]=0;
      dp[1]=1;
      
      for(int i=2;i<=n;i++){
          dp[i]=dp[i-1]+dp[i-2];
      }
      return dp[n];
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/nth-fibonacci-number1335/1)