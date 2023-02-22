package org.example;

public class SearchInRotateSortedArray81 {
    /**
     * Wow I cheated on this one.
     *
     * The trick is we are closing in on the search space as we go.
     * The first if statement we determine whether we are in the left increasing portion or the right increasing portion.
     * If we are strictly greater than the left most value by definition we can't be in the right half
     * And if we are smaller than the left most value we are in the right half.
     * And what if we can't determine if we are in the left or right half.
     * Well in that case left == mid == right.
     * And then we can afford to give up one value.
     * l++;
     *
     * wow very interesting
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] < nums[mid]) {
                if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    if (nums[l] <= target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            } else if (nums[mid] < nums[l]) {
                if (nums[mid] < target) {
                    if (nums[r] >= target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    r = mid - 1;
                }
            } else {
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean wow = new SearchInRotateSortedArray81().search(new int[]{1, 0, 1, 1, 1}, 0);
        System.out.println(wow);
        boolean output = new SearchInRotateSortedArray81().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3);
        System.out.println(output);
    }
}
