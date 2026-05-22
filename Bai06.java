package org;

import java.util.Arrays;
import java.util.Scanner;

public class Bai06 {
    private static Scanner sc = new Scanner(System.in);

    public static int search(double[] arr, double x){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x) return i;
        }
        return -1;
    }
    public static void increaseSort(double[] arr){
        for(int i =0 ;i<arr.length; i++){
            boolean ok = true;
            for(int j = 1; j <= arr.length - i - 1; j++){
                if(arr[j] < arr[j - 1]){
                    double temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    ok = false;
                }
            }
            if(ok) break;
        }
    }
    public static void decreaseSort(double[] arr){
        for(int i =0 ;i<arr.length; i++){
            boolean ok = true;
            for(int j = 1; j <= arr.length - i - 1; j++){
                if(arr[j] > arr[j - 1]){
                    double temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    ok = false;
                }
            }
            if(ok) break;
        }
    }
    public static void showMenu(double[] arr){
        do{
            System.out.println("1. Xem danh sách lương. ");
            System.out.println("2. Sắp xếp lương. ");
            System.out.println("3. Tìm kiếm lương cụ thể. ");
            System.out.println("4. Thống kê lương. ");
            System.out.println("5. Thoát");
            String option = sc.nextLine();
            boolean ok= true;
            switch(option){
                case "1":
                    for(int i = 0; i < arr.length; i++){
                        System.out.printf("Lương nhân viên thứ %d: %.1f\n", i+1, arr[i]);
                    }
                    break;
                case "2":
                    double[] arrA = arr.clone();
                    double[] arrB = arr.clone();
                    while(true){
                        System.out.println("1. Sắp xếp tăng dần. ");
                        System.out.println("2. Sắp xếp giảm dần. ");
                        String opt = sc.nextLine();
                        boolean chk = true;
                        switch(opt){
                            case "1":
                                increaseSort(arrA);
                                System.out.println("Mảng sau khi được sắp xếp: " + Arrays.toString(arrA));
                                chk = false;
                                break;
                            case "2":
                                decreaseSort(arrB);
                                System.out.println("Mảng sau khi được sắp xếp: " + Arrays.toString(arrB));
                                chk = false;
                                break;
                            default:
                                System.out.println("Giá trị nhập vào không hợp lệ. ");
                        }
                        if(!chk) break;
                    }
                    break;
                case "3":
                    String number = sc.nextLine();
                    double x;
                    do{
                        try{
                            x = Double.parseDouble(number);
                            break;
                        } catch(NumberFormatException e){
                            System.out.println("Nhập vào không hợp lệ. ");
                        }
                    } while(true);
                    int idx = search(arr, x);
                    if(idx < 0){
                        System.out.printf("Giá trị %.1f không nằm trong mảng.\n", x);
                    }
                    else{
                        System.out.printf("Giá trị %.1f nằm ở vị trí %d.\n ", x, idx);
                    }
                    break;
                case "4":
                    System.out.print("Tổng lương: ");
                    double sum = 0d;
                    double maxn = Double.MIN_VALUE;
                    double minn =Double.MAX_VALUE;
                    for(var val : arr){
                        sum += val;
                        maxn = Math.max(maxn, val);
                        minn = Math.min(minn, val);
                    }
                    int dem = 0;
                    for(var val : arr){
                        if(val > sum/arr.length) dem++;
                    }
                    System.out.printf("%.1f\n", sum);
                    System.out.println("Lương trung bình: " + String.format("%.1f", sum/arr.length));
                    System.out.println("Lương cao nhất: " + String.format("%.1f", maxn));
                    System.out.println("Lương thấp nhất: " + String.format("%.1f", minn));
                    System.out.println("Số nhân viên có mức lương cao hơn lương trung bình" + " " + dem);
                    break;
                case "5":
                    ok = false;
                    break;
            }
            if(!ok) break;
        } while(true);
    }
    public static void main(String[] args){
        System.out.print("Nhập số lượng nhân viên: ");
        int n = sc.nextInt();
        double[] list = new double[n];
        for(int i =0; i<n;i++){
            System.out.printf("Nhân viên thứ %d: ", i + 1);
            list[i] = sc.nextDouble();
        }
        sc.nextLine();
        showMenu(list);
    }
}
