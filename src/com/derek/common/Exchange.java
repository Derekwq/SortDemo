package com.derek.common;

/**
 * Created by Derek on 16/5/13.
 */
public class Exchange {
    /**
     * 交换数组arr中的a和b位置的数据
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
