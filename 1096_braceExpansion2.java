class Solution {
    int index = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parseExpression(expression);

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    private Set<String> parseExpression(String s) {
        Set<String> result = new HashSet<>();

        Set<String> current = parseTerm(s);
        result.addAll(current);

        while (index < s.length() && s.charAt(index) == ',') {
            index++;
            current = parseTerm(s);
            result.addAll(current);
        }

        return result;
    }

    // Handles concatenation
    private Set<String> parseTerm(String s) {
        Set<String> result = new HashSet<>();
        result.add("");

        while (index < s.length()
                && s.charAt(index) != '}'
                && s.charAt(index) != ',') {

            Set<String> part;

            if (s.charAt(index) == '{') {
                index++;

                part = parseExpression(s);

                index++; 
            } else {
                part = new HashSet<>();
                part.add(String.valueOf(s.charAt(index)));
                index++;
            }

            Set<String> next = new HashSet<>();

            for (String a : result) {
                for (String b : part) {
                    next.add(a + b);
                }
            }

            result = next;
        }

        return result;
    }
}
