class Solution {
    public int maximumProduct(int[] nums, int k) {
        int left = 0;
        int right = 2000001;
        int mid = left+(right-left+1)/2;
        while(right>left){
            if(extraK(nums,k,mid)>=0){//valid guess
                left=mid;
            }else{
                right=mid-1;
            }
            mid = left+(right-left+1)/2;
        }
        int minVal=left;
        int extra = extraK(nums,k,mid);
        long ans = 1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<=minVal){
                if(extra>0){
                    extra--;
                    ans*=minVal+1;
                }else{
                    ans*=minVal;
                }
            }else{
                ans*=nums[i];
            }
            ans%=1000000007L;
        }
        return (int)ans;
    }
    public int extraK(int[]nums,int k,int guess){
        for(int i =0;i<nums.length;i++){
            if(nums[i]<guess){
                k-=guess-nums[i];
            }
            if(k<0){
                return -1;
            }
        }
        return k;
    }
}