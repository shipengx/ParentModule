package aa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Group Anagrams
 * 
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * [
 *     ["ate", "eat", "tea"],
 *     ["nat", "tan"],
 *     ["bat"]
 * ]
 * 
 * Note: All inputs will be in lower-case.
 * 
 */


public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for (String tmp : strs) {
            char[] charArray = tmp.toCharArray();
            Arrays.sort(charArray);
            String tmpStr = new String(charArray);
            if (map.containsKey(tmpStr)) {
                ArrayList<String> tmpList = map.get(tmpStr);
                tmpList.add(tmp);
                map.put(tmpStr, tmpList);
            }else {
                ArrayList<String> tmpList = new ArrayList<String>();
                tmpList.add(tmp);
                map.put(tmpStr, tmpList);
            }
        }  
        
        for (ArrayList<String> tmp : map.values()) {
            result.add(tmp);
        }
        return result;
        
    }
	
}
