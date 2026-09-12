class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder ans = new StringBuilder();
        int countX = 0, countY = 0;

        for (char c : s.toCharArray()) {
            if (c == x) {
                countX++;
            } else if (c == y) {
                countY++;
            } else {
                ans.append(c);
            }
        }

        while (countY-- > 0) {
            ans.append(y);
        }

        while (countX-- > 0) {
            ans.append(x);
        }

        return ans.toString();
    }
}