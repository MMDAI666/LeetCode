import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LeetCode {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p ="abc";
        System.out.println(Solution.findAnagrams(s,p));

    }
}


/*
*
438. 找到字符串中所有字母异位词
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
*/
class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        int sLen=s.length();
        int pLen=p.length();
        if (sLen<pLen)return res;

        int [] count =new int[26];
        for (int i=0;i<pLen;i++)
        {
            count[s.charAt(i)-'a']++;
            count[p.charAt(i)-'a']--;
        }
        int differ=0;
        for (int i = 0; i < count.length; i++) {
            if (count[i]!=0)differ++;
        }

        if (differ==0)res.add(0);

        for (int i=0;i<sLen-pLen;i++)
        {
            //左边减少
            int less = s.charAt(i) - 'a';
            if (count[less]==1)differ--;
            else if (count[less] == 0)differ++;
            count[less]--;

            //右边增加
            int add = s.charAt(i + pLen) - 'a';
            if (count[add]==-1)differ--;
            else if (count[add] == 0)differ++;
            count[add]++;

            if (differ==0)res.add(i+1);
        }
        return res;
/*        List<Integer> res=new ArrayList<>();
        int n=p.length();
        if (s.length()<p.length())return res;
        char[] pcharArray = p.toCharArray();
        Arrays.sort(pcharArray);
        p= Arrays.toString(pcharArray);
        char[] scharArray = s.toCharArray();


        Set<Character> set=new HashSet<>();
        for (int i = 0; i < p.length(); i++)set.add(p.charAt(i));

        int j=0;
        for (int i = 0; i <scharArray.length; ) {
            if (scharArray.length-i<n)break;
            char[] charArray = s.substring(i, i + n).toCharArray();
            Arrays.sort(charArray);
            if (Arrays.toString(charArray).equals(p))
            {
                res.add(i);
                i++;
                continue;
            }
            for (j=i;j<i+n;j++)
            {
                if (!set.contains(scharArray[i]))
                {
                    i=j;
                    break;
                }
            }
            i++;
        }
        return res;*/
    }
}

