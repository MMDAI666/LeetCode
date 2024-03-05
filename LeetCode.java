import java.util.*;


public class LeetCode {
    public static void main(String[] args) {


    }
}


/*
*
3. 无重复字符的最长子串
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())return 0;
        if(s.length()==1)return 1;
        int max=1,left=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                left=Math.max(map.get(s.charAt(i))+1,left);//判断重复字符是否在窗口内
            }
            map.put(s.charAt(i),i);
            max=Math.max(max,i-left+1);
        }
        return max;
    }
}

