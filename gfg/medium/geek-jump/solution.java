class Solution {
    int minCost(int[] height) {
      int n=height.length;
      int[] dp=new int[n+1];
      
      Arrays.fill(dp,-1);
      int ans=solve(n-1,height,dp);
      return ans;
    }
    
    static int solve(int ind,int[] arr,int[] dp){
        if(ind==0)return 0;
        
        if(dp[ind]!=-1)return dp[ind];
        
        int onestepdiff=Math.abs(arr[ind]-arr[ind-1]);
        int left=solve(ind-1,arr,dp)+onestepdiff;
        
        int right=Integer.MAX_VALUE;
        if(ind>1){
            int twostepdiff=Math.abs(arr[ind]-arr[ind-2]);
             right=solve(ind-2,arr,dp)+twostepdiff;
        }
        
        dp[ind]=Math.min(left,right);
        return dp[ind];
    }
    
}