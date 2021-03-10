package com.practice;

import java.util.ArrayList;

public class Conversion {

    public String solution(int n) {
        switch(n) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 50:
                return "L";
            case 100:
                return "C";
            case 500:
                return "D";
            case 1000:
                return "M";
            default: //parsing
                int[] arr = converting(n);
                for(int i = 0; i < arr.length; i++){
                    System.out.println(arr[i]);
                }
        }
        return "?";
    }
    private int[] converting(int n){
        int counter = 0;
        int temp = n;
        while(n > 0) {
            n = n / 10;
            counter++;
        }
        int m = temp;
        int a;
        int[] holdDigit = new int[counter];

        while(m > 0) {
            a = m % 10;
            holdDigit[counter-1] = a;
            m = m / 10;
            counter--;
        }
        return holdDigit;
    }
}
