package org;

import java.util.Arrays;
import java.util.Scanner;

public class Bai1{

    public static void bubbleSort(int[] arr, int n){
        for(int i = 0; i < arr.length - 1; i++){
            boolean ok = true;
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    ok = false;
                }
            }
            if(ok) break;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng các phần tử trong mảng: ");
        int n = sc.nextInt();
        System.out.println("Các phần tử của mảng. ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.printf("Phần tử thứ %d: ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println("Mảng đã được sắp xếp. ");
        bubbleSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
