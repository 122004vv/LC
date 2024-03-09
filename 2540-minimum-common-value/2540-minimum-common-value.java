class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int pta=0,ptb=0;
        while(pta<nums1.length && ptb<nums2.length){
            if(nums1[pta]==nums2[ptb]){
                return nums1[pta];
            }
            else if(nums1[pta]<nums2[ptb]){
                pta++;
            }         
            else{
                ptb++;
            }
        }
        return -1;
    }
}