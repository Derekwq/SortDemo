package com.derek.sort;

/**
 * Created by Derek on 16/5/12.
 *
 * 计数排序
 *
 * 原理
 *      先把每个元素的出现次数算出来，然后算出该元素所在最终排好序列中的绝对位置(最终位置)，
 *      再依次把初始序列中的元素，根据该元素所在最终的绝对位置移到排序数组中。
 *
 * 性能
 *      时间复杂度为O(N+K)，空间复杂度为O(N+K)，算法是稳定的，与初始序列无关，不需要进行比较就能排好序的算法。
 *
 * 使用场景
 *      算法只能使用在已知序列中的元素在0-k之间，且要求排序的复杂度在线性效率上。
 *
 */
public class CountSort {

    public static void countSort(int arr[]){
        int max = -9999999;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        countSort(arr, max);
    }

    /**
     *
     * @param arr  待排序数组
     * @param k 每个元素的大小为 0~k
     */
    private static void countSort(int arr[],int k){

        //先统计每个数的相对位置，再算出该数所在序列中排序后的绝对位置
        int countArr[] = new int[k+1];
        int sortedArr[] = new int[arr.length];
        for(int i=0;i<=k;i++){
            countArr[i] = 0;
        }

        //每个元素的相对位置
        for(int i=0;i<arr.length;i++){
            countArr[arr[i]]++;
        }

        //每个元素的绝对位置
        for(int i=1;i<=k;i++){
            countArr[i] += countArr[i-1];
        }

        //从后往前，保证排序是稳定的
        for(int i=arr.length-1;i>=0;i--){
            countArr[arr[i]]--;
            sortedArr[countArr[arr[i]]] = arr[i];
        }

        for(int i=0;i<sortedArr.length;i++){
            arr[i] = sortedArr[i];
        }
    }
}
