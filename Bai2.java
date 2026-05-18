package org;

import java.util.Scanner;

public class Bai2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số hàng của mảng: ");
        int row = sc.nextInt();
        System.out.print("Nhập số cột của mảng: ");
        int col = sc.nextInt();
        int[][] arr = new int[row][col];
        System.out.print("Nhập các phần tử của mảng \n");
        int chan = 0, le = 0;
        for(int i = 0 ;i<row; i++){
            for(int j = 0; j < col; j++){
                System.out.printf("Phần tử [%d][%d]: ", i, j);
                arr[i][j] = sc.nextInt();
                if(arr[i][j] % 2 == 0){
                    chan += arr[i][j];
                }
                else{
                    le += arr[i][j];
                }
            }
        }
        System.out.println("Tổng các số chẵn: " + chan);
        System.out.println("Tổng các số lẻ: " + le);
    }
}
