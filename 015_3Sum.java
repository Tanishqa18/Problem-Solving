import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        if (a == null || a.length < 3) return res;
        Arrays.sort(a);
        for (int i = 0, n = a.length; i < n - 2; ++i) {
            if (i > 0 && a[i] == a[i - 1]) continue;   
            int l = i + 1, r = n - 1;
            while (l < r) {
                int s = a[i] + a[l] + a[r];
                if (s == 0) {
                    res.add(Arrays.asList(a[i], a[l++], a[r--]));
                    while (l < r && a[l] == a[l - 1]) ++l;   
                    while (l < r && a[r] == a[r + 1]) --r;   
                } else if (s < 0) ++l;
                else --r;
            }
        }
        return res;
    }
}
