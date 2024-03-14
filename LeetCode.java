import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode {
    public static void main(String[] args) {

    }
}




class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())return new ArrayList<>();
        List<String> res=new ArrayList<>();
        Long a= 0L;
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(res,phoneMap,digits,0,new StringBuilder());
        return res;

    }

    private void backtrack(List<String> res, Map<Character, String> phoneMap, String digits, int index, StringBuilder stringBuilder)
    {
        if (index==digits.length())
        {
            res.add(stringBuilder.toString());
            return;
        }
        char c = digits.charAt(index);
        String s = phoneMap.get(c);
        for (int i = 0; i < s.length(); i++)
        {
            stringBuilder.append(s.charAt(i));
            backtrack(res,phoneMap,digits,index+1,stringBuilder);
            stringBuilder.deleteCharAt(index);
        }

    }
}
