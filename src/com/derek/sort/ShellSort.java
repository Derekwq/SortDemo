package com.derek.sort;

/**
 * Created by Derek on 16/5/12.
 *
 * 希尔排序
 * 原理：
 *      插入排序的改进版，是基于插入排序的以下俩点性质而提出的改进方法：
 *         1. 插入排序对几乎已排好序的数据操作时，效率很高，可以达到线性排序的效率。
 *         2. 但插入排序在每次往前插入时只能将数据移动一位，效率比较低。
 *      所以希尔排序的思想是：
 *         1. 先是取一个合适的gap<n作为间隔，将全部元素分为gap个子序列，所有距离为gap
 *            的元素放入同一个子序列，再对每个子序列进行直接插入排序；
 *         2. 缩小间隔gap，例如去gap=ceil(gap/2)，重复上述子序列划分和排序
 *         3. 直到，最后gap=1时，将所有元素放在同一个序列中进行插入排序为止。
 * 性能：
 *      开始时，gap取值较大，子序列中的元素较少，排序速度快，克服了直接插入排序的缺点；
 *      其次，gap值逐渐变小后，虽然子序列的元素逐渐变多，但大多元素已基本有序，
 *      所以继承了直接插入排序的优点，能以近线性的速度排好序。
 */
public class ShellSort {

    public static void shellSort(int arr[]){
        int len = arr.length;

        // 每次选择一个gap，对相隔gap的数进行插入排序
        for(int gap=len/2; gap>0; gap /= 2){
            for(int i=0;i<len;i+=gap){
                int temp = arr[i];
                int j = i;
                for(;j>=gap && temp<arr[j-gap];j-=gap){
                    arr[j] = arr[j-gap];
                }
                arr[j]=temp;
            }
        }
    }

}
