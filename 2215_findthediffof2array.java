class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        return Arrays.asList(
            getCommonValues(nums1, nums2),
            getCommonValues(nums2, nums1)
        );
    }

    private List<Integer> getCommonValues(int[] nums1, int[] nums2) {

        Set<Integer> resultSet = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums2) {
            set2.add(num);
        }

        for (int num : nums1) {
            if (!set2.contains(num)) {
                resultSet.add(num);
            }
        }

        return new ArrayList<>(resultSet);
    }
}
