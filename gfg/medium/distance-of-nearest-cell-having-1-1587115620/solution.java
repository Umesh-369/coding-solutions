class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int[][] visited=new int[n][m];
        
        ArrayList<ArrayList<Integer>> li=new ArrayList<>();
        Queue<int[] > q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            ArrayList<Integer> row=new ArrayList<>();
            for(int j=0;j<m;j++){
                row.add(0);
            }
            li.add(row);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
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
            
            int[] cell=q.poll();
            int row=cell[0];
            int col=cell[1];
            int step=cell[2];
            
            li.get(row).set(col,step);
            for(int i=0;i<4;i++){
                int nr=row+dx[i];
                int nc=col+dy[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==0){
                    q.add(new int[]{nr,nc,step+1});
                    visited[nr][nc]=1;
                }
            }
        }
        return li;
    }
}