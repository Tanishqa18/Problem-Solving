class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            List<String> line = new ArrayList<>();
            int len = 0;

            while (i < words.length && len + words[i].length() + line.size() <= maxWidth) {
                line.add(words[i]);
                len += words[i].length();
                i++;
            }

            if (i == words.length || line.size() == 1) {
                String s = String.join(" ", line);
                s += " ".repeat(maxWidth - s.length());
                ans.add(s);
            } else {
                int spaces = maxWidth - len;
                int gaps = line.size() - 1;
                int space = spaces / gaps;
                int extra = spaces % gaps;

                String s = "";
                for (int j = 0; j < gaps; j++) {
                    s += line.get(j);
                    s += " ".repeat(space + (j < extra ? 1 : 0));
                }
                s += line.get(line.size() - 1);
                ans.add(s);
            }
        }
        return ans;
    }
}
