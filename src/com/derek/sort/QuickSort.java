package com.derek.sort;

import java.util.Random;

/**
 * Created by Derek on 16/5/12.
 *
 * 原理：
 *      分而治之思想：
 *          Divide：找到基准元素pivot，将数组A[p..r]划分为A[p..pivotpos-1]和A[pivotpos+1...q]，
 *                  左边的元素都比基准小，右边的元素都比基准大;
 *          Conquer：对俩个划分的数组进行递归排序；
 *          Combine：因为基准的作用，使得俩个子数组就地有序，无需合并操作。
 * 性能：
 *      快排的平均时间复杂度为O(NlogN），空间复杂度为O(logN)，但最坏情况下，时间复杂度为O(N^2)，
 *      空间复杂度为O(N)；且排序是不稳定的，但每次都能确定一个元素所在序列中的最终位置，复杂度与初始序列有关。
 * 优化：
 *      当初始序列是非递减序列时，快排性能下降到最坏情况，主要因为基准每次都是从最左边取得，这时每次只能排好一个元素。
 *      所以快排的优化思路如下：
 *          1. 优化基准，不每次都从左边取，可以进行三路划分，分别取最左边，中间和最右边的中间值，
 *              再交换到最左边进行排序；或者进行随机取得待排序数组中的某一个元素，再交换到最左边，进行排序。
 *          2. 在规模较小情况下，采用直接插入排序
 */
public class QuickSort {

    public static void quickSort(int arr[]){
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int arr[], int low, int high){
        if(low<high){
            int pivotpos = partition(arr,low,high);
            quickSort(arr,low,pivotpos-1);
            quickSort(arr,pivotpos+1,high);
        }
    }

    /**
     * 根据基准进行划分，以第一个元素为基准，从两头循环，易理解
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(int arr[], int low, int high){
        int pviot = arr[low];

        while(low<high){
            while(low<high && arr[high] >= pviot)
                high--;
            arr[low] = arr[high];
            while(low<high && arr[low] <= pviot)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = pviot;//基准元素的最终位置
        return low;
    }

    /**
     * 对序列进行划分,以第一个为基准,不易理解
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition_2(int arr[], int left, int right){
        int pivot = arr[left];
        int pivotpos = left;
        for(int i=left+1;i<=right;i++){
            if(arr[i]<pivot){
                pivotpos++;
                if(pivotpos!=i){
                    int temp = arr[i];
                    arr[i]=arr[pivotpos];
                    arr[pivotpos]=temp;
                }
            }
        }
        arr[left]=arr[pivotpos];
        arr[pivotpos]=pivot;

        return pivotpos;
    }

    /**
     * 基准随机选择
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int improve_partition(int arr[], int left, int right){
        Random random = new Random();
        int gap = random.nextInt(right - left);

        int temp = arr[gap];
        arr[gap] = arr[left];
        arr[left] = temp;

        return partition(arr, left, right);
    }
}
