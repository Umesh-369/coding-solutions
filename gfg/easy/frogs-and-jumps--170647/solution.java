class Solution {
    int unvisitedLeaves(int arr[], int k) {
        // code here
       int n=arr.length;
       boolean[] visited=new boolean[k+1];
       
       for(int i=0;i<n;i++){
           int strength=arr[i];    
           if(arr[i]==1)return 0;
           
           if(arr[i]>k)continue;
           
           if(!visited[strength]){
               
               for(int j=strength;j<=k;j+=strength){
                   visited[j]=true;
               }
           }
       }
       
       int unvisited=0;
       for(int leaf=1;leaf<=k;leaf++){
           if(!visited[leaf]){
               unvisited++;
           }
       }
       
       return unvisited;
    }
}