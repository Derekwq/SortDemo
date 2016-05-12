package com.derek.main;

import com.derek.sort.*;

/**
 * Created by Derek on 16/5/12.
 */
public class Main {

    public static void main(String []args){
        testBublleSort();
        testStraihtInsertSort();
        testBinaryInsertSort();
        testMergeSort();
        testQuickSort();
        testSelectSort();
        testShellSort();
        testHeapSort();
        testCountSort();
    }

    /**
     * 测试 冒泡排序
     */
    private static void testBublleSort(){
        int arr[] = {5,4,6,0,9,8,1,3,2,7};

        System.out.println("冒泡排序 test...");
        System.out.print("排序前: ");
        print(arr);

        BublleSort.bublleSort(arr);

        System.out.print("排序后: ");
        print(arr);
        System.out.println();
    }

    /**
     * 测试 直接插入排序
     */
    private static void testStraihtInsertSort(){
        int arr[] = {5,4,6,0,9,8,1,3,2,7};

        System.out.println("直接插入排序 test...");
        System.out.print("排序前: ");
        print(arr);

        InsertSort.straihtInsertSort(arr);

        System.out.print("排序后: ");
        print(arr);
        System.out.println();
    }

    /**
     * 测试 二分插入排序
     */
    private static void testBinaryInsertSort(){
        int arr[] = {5,4,6,0,9,8,1,3,2,7};

        System.out.println("二分插入排序 test...");
        System.out.print("排序前: ");
        print(arr);

        InsertSort.binaryInsertSort(arr);

        System.out.print("排序后: ");
        print(arr);
        System.out.println();
    }

    /**
     * 测试 归并排序
     */
    private static void testMergeSort(){
        int arr[] = {5,4,6,0,9,8,1,3,2,7};

        System.out.println("归并排序 test...");
        System.out.print("排序前: ");
        print(arr);

        MergeSort.mergerSort(arr);

        System.out.print("排序后: ");
        print(arr);
        System.out.println();

        /***************************************************************/

        int arr2[] = {5,4,6,0,9,8,1,3,2,7};

        System.out.println("优化后的归并排序 test...");
        System.out.print("排序前: ");
        print(arr2);

        MergeSort.setIsImporve(true);
        MergeSort.mergerSort(arr2);

        System.out.print("排序后: ");
        print(arr2);
        System.out.println();
    }

    /**
     * 测试 快速排序
     */
    private static void testQuickSort(){
        int arr[] = {5,4,6,0,9,8,1,3,2,7};

        System.out.println("快速排序 test...");
        System.out.print("排序前: ");
        print(arr);

        QuickSort.quickSort(arr);

        System.out.print("排序后: ");
        print(arr);
        System.out.println();
    }

    /**
     * 测试 选择排序
     */
    private static void testSelectSort(){
        int arr[] = {5,4,6,0,9,8,1,3,2,7};

        System.out.println("选择排序 test...");
        System.out.print("排序前: ");
        print(arr);

        SelectSort.selectSort(arr);

        System.out.print("排序后: ");
        print(arr);
        System.out.println();
    }

    /**
     * 测试 希尔排序
     */
    private static void testShellSort(){
        int arr[] = {5,4,6,0,9,8,1,3,2,7};

        System.out.println("希尔排序 test...");
        System.out.print("排序前: ");
        print(arr);

        ShellSort.shellSort(arr);

        System.out.print("排序后: ");
        print(arr);
        System.out.println();
    }

    /**
     * 测试 堆排序
     */
    private static void testHeapSort(){
        int arr[] = {5,4,6,0,9,8,1,3,2,7};

        System.out.println("堆排序 test...");
        System.out.print("排序前: ");
        print(arr);

        HeapSort.heapSort(arr);

        System.out.print("排序后: ");
        print(arr);
        System.out.println();
    }

    /**
     * 测试 计数排序
     */
    private static void testCountSort(){
        int arr[] = {0,2,1,1,2,3,4,4,3,1};

        System.out.println("计数排序 test...");
        System.out.print("排序前: ");
        print(arr);

        CountSort.countSort(arr);

        System.out.print("排序后: ");
        print(arr);
        System.out.println();
    }

    private static void print(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
