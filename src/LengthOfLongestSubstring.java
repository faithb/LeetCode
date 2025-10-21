import java.util.HashMap;
import java.util.HashSet;

static class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> last = new HashMap<>();
        int ans = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (last.containsKey(c) && last.get(c) >= left) {
                left = last.get(c) + 1;
            }
            last.put(c, right);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

static void main(String[] args) {
    Solution solution = new Solution();
    String s = "jdsa2981ajds";
    int result = solution.lengthOfLongestSubstring(s);
    System.out.println("Length of longest substring without repeating characters: " + result);
}