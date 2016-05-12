package com.derek.sort;

/**
 * Created by Derek on 16/5/12.
 *
 * 插入排序
 * 原理：
 *      依次选择一个待排序的数据，插入到前边已排好序的序列中。
 * 性能：
 *      时间复杂度为O(N^2)，空间复杂度为O(1)。算法是稳定的，比较次数和交换次数都与初始序列有关。
 * 优化：
 *      直接插入排序每次往前插入时，是按顺序依次往前找，可在这里进行优化，往前找合适的插入位置时采用二分查找的方式，即折半插入。
 *      折半插入排序相对直接插入排序而言：平均性能更快，时间复杂度降至O(NlogN)，排序是稳定的，但排序的比较次数与初始序列无关，
 *      总是需要foor(log(i))+1次排序比较。
 * 使用场景：
 *      当数据基本有序时，采用插入排序可以明显减少数据交换和数据移动次数，进而提升排序效率。
 */
public class InsertSort {

    /**
     * 直接插入排序
     * @param arr
     */
    public static void straihtInsertSort(int arr[]){
        //每次把当前的数往前插入
        for(int i=1;i<arr.length;i++){
            //发生逆序，往前插入
            if(arr[i]<arr[i-1]){
                int temp = arr[i];
                int j = i-1;
                for(;j>=0 && arr[j]>temp;j--){
                    arr[j+1]=arr[j];//arr[i]之前的元素大于待插入元素，则往后移一位
                }
                arr[j+1]=temp;
            }
        }
    }

    /**
     * 二分插入排序
     * @param arr
     */
    public static void binaryInsertSort(int arr[]){
        //改进的插入排序，往前插入时，进行二分查找
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                int temp = arr[i];
                int low = 0,high = i-1,mid;
                while(low <= high){
                    mid = low + ((high - low) >> 1);// 右移的优先级竟然比+、-还低
                    if(temp < arr[mid]){
                        high = mid - 1;
                    }
                    else{
                        low = mid + 1;
                    }
                }
                for(int j=i;j>low;j--){
                    arr[j] = arr[j-1];
                }
                arr[low] = temp;
            }
        }
    }

}
