class Solution {
    int minCost(int[] arr) {
      int n=arr.length;
      int[] dp=new int[n];
      
    //   int ans=solve(n-1,height,dp);
    //   return ans;
     dp[0]=0;
     for(int ind=1;ind<n;ind++){
         int onestepdiff=Math.abs(arr[ind]-arr[ind-1]);
         int left=dp[ind-1]+onestepdiff;
         int right=Integer.MAX_VALUE;
         if(ind>1){
             int twostepdiff=Math.abs(arr[ind]-arr[ind-2]);
             right=dp[ind-2]+twostepdiff;
         }
         dp[ind]=Math.min(left,right);
     }
     return dp[n-1];
    }
    
    // static int solve(int ind,int[] arr,int[] dp){
    //     if(ind==0)return 0;
        
    //     if(dp[ind]!=-1)return dp[ind];
        
    //     int onestepdiff=Math.abs(arr[ind]-arr[ind-1]);
    //     int left=solve(ind-1,arr,dp)+onestepdiff;
        
    //     int right=Integer.MAX_VALUE;
    //     if(ind>1){
    //         int twostepdiff=Math.abs(arr[ind]-arr[ind-2]);
    //          right=solve(ind-2,arr,dp)+twostepdiff;
    //     }
        
    //     dp[ind]=Math.min(left,right);
    //     return dp[ind];
    // }
    
}