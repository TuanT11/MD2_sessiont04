package org;

import java.util.Arrays;
import java.util.Scanner;

public class Bai04{
    public static void insertionSort(int[] arr){
        for(int i = 1; i<arr.length; i++){
            int key = arr[i];
            int index = i;
            if(key % 2 == 0){
                for(int j = i-1; j >= 0; j--){
                    if(arr[j] % 2 != 0){
                        arr[j + 1] = arr[j];
                        index = j;
                    }
                }
                arr[index] = key;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            if(n == 0){
                System.out.println("Mảng không có phần tử. ");
                continue;
            }
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            insertionSort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}

