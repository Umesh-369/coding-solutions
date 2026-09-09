# 01 Matrix

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an `m x n` binary matrix `mat`, return  *the distance of the nearest* `0` *for each cell*.

The distance between two cells sharing a common edge is `1`.

 

 **Example 1:** 

```
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

```

 **Example 2:** 

```
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

```

 

 **Constraints:** 

- m == mat.length
- n == mat[i].length
- 1 <= m, n <= 104
- 1 <= m * n <= 104
- mat[i][j] is either 0 or 1.
- There is at least one 0 in mat.

 

 **Note:**  This question is the same as 1765: https://leetcode.com/problems/map-of-highest-peak/

## Solution

**Language:** Java  
**Runtime:** 14 ms (beats 70.99%)  
**Memory:** 49.1 MB (beats 60.10%)  
**Submitted:** 2026-09-09T13:20:15.712Z  

```java
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] visited=new int[m][n];
        int[][] dist=new int[m][n];

        Queue<int[] > q=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0});
                    visited[i][j]=1;
                }
                else{
                    visited[i][j]=0;
                }
            }
        }

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        while(!q.isEmpty()){
            int[] arr=q.poll();
            int row=arr[0];
            int col=arr[1];
            int step=arr[2];

            dist[row][col]=step;
            for(int i=0;i<4;i++){
                int nr=row+dx[i];
                int nc=col+dy[i];
                
                if(nr>=0 && nr<m && nc>=0 && nc<n && visited[nr][nc]==0 && mat[nr][nc]==1){
                q.add(new int[]{nr,nc,step+1});
                visited[nr][nc]=1;
                }
            }
        }
  
     return dist;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/01-matrix/)