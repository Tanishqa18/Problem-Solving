import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];

        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
            numbers.add(i);
        }

        k--;
        StringBuilder result = new StringBuilder();

        for (int i = n; i > 0; i--) {
            int index = k / factorial[i - 1];
            result.append(numbers.get(index));
            numbers.remove(index);
            k = k % factorial[i - 1];
        }

        return result.toString();
    }
}
