package fatlamb.leetcode.problem;

/**
 * Created by 58 on 2017/7/11.
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubString {

    public static void main(String[] args){
        System.out.println(new LongestSubString().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxcount = 0 ;
        int currentcount = 0 ;
        StringBuilder sb = new StringBuilder(s);
        StringBuilder current = new StringBuilder();
        for (int i = 0 ; i < sb.length() ; i++){
            String currentchar = sb.substring(i , i+1) ;
            int index = current.indexOf(sb.substring(i , i+1));
            if (index == -1){
                currentcount++ ;
                maxcount = currentcount > maxcount ? currentcount : maxcount ;
                current.append(currentchar);
            }else {
                current.delete(0 , index+1);
                current.append(currentchar);
                currentcount = current.length();
            }
        }
        return maxcount ;
    }
}
