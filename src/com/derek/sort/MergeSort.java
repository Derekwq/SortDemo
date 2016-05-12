package com.derek.sort;

/**
 * Created by Derek on 16/5/12.
 *
 * 归并排序
 *
 * 原理
 * 分而治之思想:
 *      Divide：将n个元素平均划分为各含n/2个元素的子序列；
 *      Conquer：递归的解决俩个规模为n/2的子问题；
 *      Combine：合并俩个已排序的子序列。
 *
 * 性能
 *      时间复杂度总是为O(NlogN)，空间复杂度也总为为O(N)，算法与初始序列无关，排序是稳定的。
 * 优化
 *   优化思路：
 *          在规模较小时，合并排序可采用直接插入；
 *          在写法上，可以在生成辅助数组时，俩头小，中间大，这时不需要再在后边加俩个while循环进行判断，只需一次比完。
 */
public class MergeSort {
    private static boolean isImporve = false;

    public static void setIsImporve(boolean isImporve) {
        MergeSort.isImporve = isImporve;
    }

    public static void mergerSort(int arr[]){
        int temp_arr[] = new int[arr.length];
        mergerSort(arr,temp_arr,0,arr.length-1);
    }

    private static void mergerSort(int arr[], int temp_arr[], int left, int right){
        if(left<right){
            int mid = left + ((right - left) >> 1);
            mergerSort(arr,temp_arr,left,mid);
            mergerSort(arr, temp_arr, mid + 1, right);

            if(isImporve==true){
                merge_improve(arr,temp_arr,left,mid,right);
            }
            else {
                merge(arr, temp_arr, left, mid, right);
            }
        }
    }

    private static void merge(int arr[], int temp_arr[], int left, int mid, int right){
        //简单归并，先将arr复制到temp_arr,再进行归并
        for(int i=left;i<=right;i++){
            temp_arr[i] = arr[i];
        }
        int pa = left;
        int pb = mid + 1;
        int index = left;

        while(pa<=mid && pb<=right){
            if(temp_arr[pa]<=temp_arr[pb]){
                arr[index++] = temp_arr[pa++];
            }
            else{
                arr[index++] = temp_arr[pb++];
            }
        }
        while(pa<=mid){
            arr[index++] = temp_arr[pa++];
        }
        while(pb<=right){
            arr[index++] = temp_arr[pb++];
        }

    }

    /**
     * 优化:复制时，两头小，中间大，一次比较完
     * @param arr
     * @param temp_arr
     * @param left
     * @param mid
     * @param right
     */
    private static void merge_improve(int arr[], int temp_arr[], int left, int mid, int right){
        for(int i=left;i<=mid;i++){
            temp_arr[i] = arr[i];
        }
        for(int i=mid+1;i<=right;i++){
            temp_arr[i] = arr[right+mid+1-i];
        }
        int pa = left;
        int pb = right;
        int index = left;

        while(index<=right){
            if(temp_arr[pa]<=temp_arr[pb]){
                arr[index++] = temp_arr[pa++];
            }
            else{
                arr[index++] = temp_arr[pb--];
            }
        }
    }


}
