# Replace O's with X's

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a  **grid[][]** of size  **n*m**, where every element is either 'O' or 'X'. Replace all 'O' or a group of 'O' with 'X' that are surrounded by 'X'.

A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.

 **Examples:** 

```
Input: grid[][] = [['X', 'X', 'X', 'X'], ['X', 'O', 'X', 'X'], ['X', 'O', 'O', 'X'], ['X', 'O', 'X', 'X'], ['X', 'X', 'O', 'O']]

Output: 

Explanation: We only changed those 'O' that are surrounded by 'X'
```

```
Input: grid[][] = [['X', 'O', 'X', 'X'], ['X', 'O', 'X', 'X'], ['X', 'O', 'O', 'X'], ['X', 'O', 'X', 'X'], ['X', 'X', 'O', 'O']]
Output: 

Explanation: There's no 'O' that's surround by 'X'.
```

```
Input: grid[][] = [['X', 'X', 'X'], ['X', 'O', 'X'], ['X', 'X', 'X']]
Output: 
[['X', 'X', 'X'], 
['X', 'X', 'X'], 
['X', 'X', 'X']]
Explanation: There's only one 'O' that's surround by 'X'.
```

 **Constraints:** 
1 ≤ grid.size() ≤ 100
1 ≤ grid[0].size() ≤ 100

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-01T13:53:35.515Z  

```java
class Solution {
    public void fill(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        
        int[][] visited=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    if(grid[i][j]=='O'){
                        dfs(grid,i,j,visited);
                    }
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='O' && visited[i][j]==0){
                    grid[i][j]='X';
                }
            }
        }
        
    }
    
    public void dfs(char[][] grid,int i,int j,int[][] visited){
        
        int m=grid.length;
        int n=grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j]==1 || grid[i][j]=='X'){
            return ;
        }
        
        visited[i][j]=1;
        dfs(grid,i-1,j,visited);
        dfs(grid,i,j+1,visited);
        dfs(grid,i+1,j,visited);
        dfs(grid,i,j-1,visited);
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1)