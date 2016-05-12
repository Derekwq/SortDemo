package com.derek.sort;

/**
 * Created by Derek on 16/5/12.
 *
 * 选择排序
 * 原理：
 *      每次从未排序的序列中找到最小值，记录并最后存放到已排序序列的末尾
 * 性能：
 *      时间复杂度为O(N^2)，空间复杂度为O(1)，排序是不稳定的（把最小值交换到已排序的末尾导致的），
 *      每次都能确定一个元素所在的最终位置，比较次数与初始序列无关。
 */
public class SelectSort {

    public static void selectSort(int arr[]){
        int len = arr.length;

        //每次从后面选择一个最小值
        for(int i=0;i<len-1;i++){   //只需选择n-1次
            int min = i;
            for(int j=i+1;j<len;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            if(min!=i){
                int temp = arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
    }

}
