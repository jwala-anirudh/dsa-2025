package arrays.logic_building;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UnionOfSortedArrays {
    public static int[] unionArrayBrute(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            set.add(num);
        }

        int[] result = new int[set.size()];

        int i = 0;
        for (int num : set) {
            result[i] = num;
            i += 1;
        }

        return result;
    }

    public static int[] unionArray(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int i = 0;
        int j = 0;

        List<Integer> unionArray = new ArrayList<>();

        // compare values at each index of the lists and append the smaller value to result
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                if (!unionArray.contains(nums1[i])) {
                    unionArray.add(nums1[i]);
                }
                i += 1;
            } else {
                if (!unionArray.contains(nums2[j])) {
                    unionArray.add(nums2[j]);
                }
                j += 1;
            }
        }

        // Append rest of the sorted values into union
        while (i < n1) {
            if (!unionArray.contains(nums1[i])) {
                unionArray.add(nums1[i]);
            }
            i += 1;
        }

        while (j < n2) {
            if (!unionArray.contains(nums2[j])) {
                unionArray.add(nums2[j]);
            }
            j += 1;
        }

        return unionArray.stream().mapToInt(val -> val).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 7};

        int[] result = unionArrayBrute(nums1, nums2);
        int[] result2 = unionArray(nums1, nums2);

        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : result2) {
            System.out.print(num + " ");
        }
    }
}
