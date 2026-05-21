package org;

import java.util.Arrays;
import java.util.Scanner;

public class Bai3 {
    public static void selectionSort(int[] arr, int n){
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[i] < arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static int binarySearch(int[] arr, int n, int k){
        int i = 0, j = n-1;
        while(i < j){
            int mid = i + (j - i)/2;
            if(arr[mid] == k) return mid;
            else if(arr[mid] > k) i = mid + 1;
            else j = mid - 1;
        }
        return -1;
    }

    public static int linearSearch(int[] arr, int n, int k){
        for(int i = 0 ; i<arr.length; i++){
            if(arr[i] == k) return i;
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        System.out.println("Nhập các phần tử của mảng: ");
        int[] arr = new int[n];
        for(int i = 0; i<n ;i++){
            System.out.printf("Phần tử %d: ", i + 1);
            arr[i] = sc.nextInt();
        }
        selectionSort(arr, n);
        System.out.println("Mảng sau khi được sắp xếp giảm dần: ");
        System.out.println(Arrays.toString(arr));
        System.out.print("Nhập số cần tìm: ");
        int x = sc.nextInt();
        System.out.printf("Tìm kiếm tuyến tính: Số %d tại vị trí thứ %d\n", x, linearSearch(arr, n, x));
        System.out.printf("Tìm kiếm nhị phân: Số %d tại vị trí thứ %d\n", x, binarySearch(arr, n, x));
    }
}
