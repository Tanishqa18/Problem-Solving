class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Frequency Map
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket Array
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int key : map.keySet()) {

            int freq = map.get(key);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        // Step 3: Collect Top K
        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {

            if (bucket[i] != null) {

                for (int num : bucket[i]) {

                    result[index] = num;
                    index++;

                    if (index == k)
                        break;
                }
            }
        }

        return result;
    }
}
