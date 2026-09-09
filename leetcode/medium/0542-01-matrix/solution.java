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