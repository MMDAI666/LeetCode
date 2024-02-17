import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hash=new HashMap<>();
        for(String str:strs)
        {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = Arrays.toString(charArray);
            if (!hash.containsKey(key))
            {
                List<String> list=new ArrayList<>();
                hash.put(key,list);
            }
            hash.get(key).add(str);
        }
        return new ArrayList<>(hash.values());
    }
}