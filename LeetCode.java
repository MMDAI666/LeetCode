import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num))
            {
                int left=map.getOrDefault(num-1,0);
                int right=map.getOrDefault(num+1,0);
                int len=left+right+1;
                res=Math.max(len,res);
                map.put(num,-1);
                map.put(num-left,len);
                map.put(num+right,len);
            }
        }


        return res;

    }
}