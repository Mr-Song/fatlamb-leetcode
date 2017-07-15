package fatlamb.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 58 on 2017/7/11.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 *
 */
public class MedianOfTwoSortedArray {
    public static void main(String[] args){
        int[] nums1 = {2} ;
        int[] nums2 = {3,4};

        System.out.println(new MedianOfTwoSortedArray().findMedianSortedArrays(nums1 , nums2));
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int size1 = A.length ;
        int size2 = B.length;
        if (size1 > size2){
            return findMedianSortedArrays(B , A);
        }
        if (size1 == 0){
            return (B[(size2-1)/2] + B[size2/2])/2.0 ;
        }
        int begin1 = 0 ;
        int end1 = size1;
        int halfsize = (size1 + size2 + 1) / 2 ;
        while (begin1 <= end1){
            int mid1 = (begin1 + end1) / 2 ;
            int mid2 = halfsize - mid1 ;
            if (mid1 < end1 && B[mid2-1] > A[mid1]){ //mid1右移
                begin1 = mid1 + 1 ;
            }else if (mid1 > 0 && B[mid2] < A[mid1-1]){//mid1左移
                end1 = mid1 - 1 ;
            }else {
                int leftMax = 0 ;
                int rightMin = 0 ;
                if (mid1 == 0){
                    leftMax = B[mid2-1] ;
                }else if (mid2 == 0){
                    leftMax = A[mid1-1] ;
                }else {
                    leftMax = A[mid1-1] > B[mid2-1] ? A[mid1-1] : B[mid2-1] ;
                }
                if ((size1 + size2)%2 == 1){
                    return leftMax ;
                }

                if (mid1 == size1){
                    rightMin = B[mid2] ;
                }else if (mid2 == size2){
                    rightMin = A[mid1] ;
                }else {
                    rightMin = A[mid1] > B[mid2] ? B[mid2] : A[mid1] ;
                }
                return (leftMax + rightMin)/2.0 ;
            }

        }


        return 0 ;
    }
}
