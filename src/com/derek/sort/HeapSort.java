package com.derek.sort;

import com.derek.common.Exchange;

/**
 * Created by Derek on 16/5/12.
 *
 * 堆排序
 *
 * 原理
 *      堆的性质：
 *          1、是一棵完全二叉树
 *          2、每个结点的值都大于或等于其子节点的值，为最大堆；反之，为最小堆
 *      堆排序思想：
 *          1、将待排序的序列构造成一个最大堆，此时序列的最大值为根节点
 *          2、依次将根节点与待排序序列的最后一个元素交换
 *          3、再维护从根节点到该元素的前一个节点为最大堆，如此往复，最终得到一个递增序列
 *
 * 性能
 *      时间复杂度为O(NlogN)，空间复杂度为O(1)，因为利用的排序空间仍然是初始的序列，
 *      并未开辟新空间。算法是不稳定的，与初始序列无关。
 *
 * 使用场景
 *      想知道最大值或最小值时，比如优先级队列，作业调度等场景。
 *
 */
public class HeapSort {

    /**
     * 直观的写法
     * @param arr
     */
    public static void heapSort(int arr[]){

        shiftHeap(arr, arr.length - 1);

        for(int i=arr.length-1;i>=0;i--){
            Exchange.swap(arr, 0, i);
            shiftHeap(arr, i - 1);
        }

        Exchange.swap(arr, 0, 1);
    }

    private static void shiftHeap(int arr[],int end){

        for(int i=(end-1)/2; i>=0;i--){
            int dad = i;
            int son = dad * 2 + 1;

            if((son+1)<=end && arr[son]<arr[son+1]){
                son++;
            }

            if(arr[dad]<arr[son]){
                Exchange.swap(arr, dad, son);
            }
        }

    }

    /**
     *
     * 看到的别人的另外一种写法，感觉有些多余，难以理解，过段时间，试一下
     *
     * arr[] 下标从 0 开始，所以，有如下规律：
     *          arr[leftChild] = arr[parent*2+1]
     *          arr[rightChild] = arr[paraent*2+2]
     * @param arr
     */
    public static void heap_Sort(int arr[]){
        int len = arr.length;

        //先调整为最大堆，再依次与第一个交换，进行调整，最后构成最小堆
        // i=(len-1)/2 为最后一个子结点的父结点
        for(int i=(len-1)/2; i>=0;i--){
            shiftDown(arr, i, len-1);
        }



    }

    private static void shiftDown(int arr[], int start, int end){
        int dad = start;
        int son = dad * 2 + 1;//左孩子

        if((son+1)<=end && arr[son]<arr[son+1]){
            son++;
        }

        if(arr[dad]<arr[son]){
            Exchange.swap(arr, dad, son);
        }
    }



}
