package com.derek.sort;

import com.derek.common.Exchange;

/**
 * Created by Derek on 16/5/12.
 *
 * 冒泡排序
 * 原理：
 *      两两比较相邻记录的排序码，若发生逆序，则交换；有俩种方式进行冒泡，一种是先把小的冒泡到前边去，另一种是把大的元素冒泡到后边。
 * 性能：
 *      时间复杂度为O(N^2)，空间复杂度为O(1)。排序是稳定的，排序比较次数与初始序列无关，但交换次数与初始序列有关。
 *
 */
public class BublleSort {

    public static void bublleSort(int arr[]){

        //每次从后往前冒一个最小值，且每次都能确定一个数在序列中的最终位置
        for(int i=0; i<=arr.length-1; i++){
            boolean exchange = true;
            for(int j=arr.length-1; j>i; j--){
                if(arr[j] < arr[j-1]){
                    Exchange.swap(arr, j, j-1);
                    exchange = false;
                }
            }
            if(exchange == true)
                return;
        }
    }

}
