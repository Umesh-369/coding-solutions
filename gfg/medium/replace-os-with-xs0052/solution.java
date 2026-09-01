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
