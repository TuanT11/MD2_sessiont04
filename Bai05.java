package org;

import java.util.Arrays;
import java.util.Scanner;

public class Bai05 {
    private static Scanner sc = new Scanner(System.in);

    public static int linearSearch(double[] arr, int x){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x) return i;
        }
        return -1;
    }

    public static int binarySearch(double[] arr, int x){
        increaseSort(arr);
        int i = 0, j = arr.length - 1;
        while(i < j){
            int mid = i + (j - i)/2;
            if(arr[mid] == x) return mid;
            else if(arr[mid] < x) i = mid + 1;
            else j = mid - 1;
        }
        return -1;
    }
    public static void increaseSort(double[] arrA){
        for(int i = 0; i<arrA.length; i++){
            boolean ok = true;
            for(int j = 1; j<=arrA.length - i - 1; j++){
                if(arrA[j] < arrA[j - 1]){
                    double temp = arrA[j];
                    arrA[j] = arrA[j - 1];
                    arrA[j- 1] = temp;
                    ok = false;
                }
            }
            if(ok) break;
        }
    }

    public static void decreaseSort(double[] arrB){
        for(int i=0; i<arrB.length; i++){
            boolean ok = true;
            for(int j = 1; j<=arrB.length - i - 1; j++){
                if(arrB[j] > arrB[j - 1]){
                    double temp = arrB[j];
                    arrB[j] = arrB[j - 1];
                    arrB[j - 1] = temp;
                    ok = false;
                }
            }
            if(ok) break;
        }
    }
    public static void showMenu(double[] list){
            do{
                System.out.println("---QUẢN LÝ ĐIỂM SINH VIÊN---");
                System.out.println("1. Xem tất cả điểm. ");
                System.out.println("2. Sắp xếp điểm. ");
                System.out.println("3. Tìm kiếm điểm. ");
                System.out.println("4. Thống kê điểm. ");
                System.out.println("5. Thoát.");
                String option = sc.nextLine();
                boolean ok = true;
                switch(option){
                    case "1":
                        for(int i = 0; i<list.length; i++){
                            System.out.printf("Sinh viên %d:", i + 1);
                            System.out.println(list[i]);
                        }
                        break;
                    case "2":
                        while(true){
                            double[] arrA = list.clone();
                            double[] arrB = list.clone();
                            System.out.println("1. Sắp xếp tăng dần. ");
                            System.out.println("2. Sắp xếp giảm dần. ");
                            System.out.println("3. Thoát. ");
                            String opv2 = sc.nextLine();
                            boolean chk = true;
                            switch(opv2){
                                case "1":
                                    increaseSort(arrA);
                                    System.out.println(Arrays.toString(arrA));
                                    break;
                                case "2":
                                    decreaseSort(arrB);
                                    System.out.println(Arrays.toString(arrB));
                                    break;
                                case "3":
                                    chk = false;
                                    break;
                                default:
                                    System.out.println("Nhập lại định dạng. ");
                            }
                            if(!chk) break;
                        }
                        break;
                    case "3":
                        while(true){
                            double[] arrC = list.clone();
                            System.out.println("1. Tìm kiếm tuyên tính. ");
                            System.out.println("2. Tìm kiếm nhị phân. ");
                            System.out.println("3. Thoát. ");
                            String opt3 = sc.nextLine();
                            boolean chk = false;
                            switch(opt3){
                                case "1":
                                    String num;
                                    int k;
                                    do{
                                        System.out.print("Nhập giá trị tìm kiếm: ");
                                        num = sc.nextLine();
                                        try{
                                            k = Integer.parseInt(num);
                                            break;
                                        } catch(NumberFormatException e){
                                            System.out.println("Nhập không hợp lệ. ");
                                        }
                                    }while (true);
                                    int index = linearSearch(arrC, k);
                                    if(index < 0){
                                        System.out.printf("Không tìm thấy giá trị %d trong mảng.", num);
                                    }
                                    else{
                                        System.out.printf("Giá trị %d trong mảng nằm ở vị trí %d\n", k, index);
                                    }
                                    break;
                                case "2":
                                    String number;
                                    int x;
                                    do{
                                        System.out.println("Nhập giá trị tìm kiếm: ");
                                        number = sc.nextLine();
                                        try{
                                            x = Integer.parseInt(number);
                                            break;
                                        } catch(NumberFormatException e){
                                            System.out.println("Nhập giá trị không hợp lệ.");
                                        }
                                    } while(true);
                                    int idx = binarySearch(arrC, x);
                                    if(idx < 0){
                                        System.out.printf("Không tìm thấy giá trị %d trong mảng.\n", x);
                                    }
                                    else{
                                        System.out.printf("Giá trị %d nằm ở vị trí %d trong mảng.\n", x,idx);
                                    }
                                    break;
                                case "3":
                                    chk = false;
                                    break;
                                default:
                                    System.out.println("Nhập không hợp lệ. ");
                            }
                            if(!chk) break;
                        }
                        break;
                    case "4":
                        double avg = 0d;
                        double maxn = Double.MIN_VALUE;
                        double minn = Double.MAX_VALUE;
                        int dem = 0;
                        for(var x : list){
                            avg += x;
                            maxn = Math.max(maxn, x);
                            minn = Math.min(minn, x);
                        }
                        for(var x : list){
                            if(x > avg) dem++;
                        }
                        System.out.printf("Điểm trung bình: %.1f\n", avg/list.length);
                        System.out.printf("Điểm cao nhất: %.1f\n", maxn);
                        System.out.printf("Điểm thấp nhất: %.1f\n", minn);
                        System.out.printf("Sinh viên có điểm trên trung bình: %d\n", dem);
                        break;
                    case "5":
                        ok = false;
                        break;
                    default:
                        System.out.println("Nhập không hợp lệ. ");
                }
                if(!ok) break;
            } while(true);

    }
    public static void main(String[] args) {
        System.out.print("Nhập số lượng sinh viên: ");
        int n = sc.nextInt();
        double[] list = new double[n];
        for(int i = 0; i<n ;i++){
            System.out.printf("Nhập sinh viên thứ %d :", i);
            list[i] = sc.nextDouble();
        }
        sc.nextLine();
        showMenu(list);
    }
}
