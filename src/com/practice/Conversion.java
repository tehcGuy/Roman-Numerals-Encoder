package com.practice;

import java.util.LinkedList;
import java.util.List;

public class Conversion {
    private List<String> holdString = new LinkedList<String>();
    private static int amountDigits;

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
                for(int j : arr) {
                    System.out.print(j);
                }
                System.out.println("\n" + amountDigits);
                System.out.println(patternRecognition(converting(n)));
        }
        return "?";
    }

    private int[] converting(int n) {
        int counter = 0;
        int temp = n;
        while(n > 0) {
            n = n / 10;
            counter++;
        }
        amountDigits = counter;
        int m = temp;
        int a;
        int[] holdDigit = new int[counter];

        while(m > 0) {
            a = m % 10;
            holdDigit[counter - 1] = a;
            m = m / 10;
            counter--;
        }
        return holdDigit;
    }


    private List patternRecognition(int[] arrDigt) {
        for(int i = 0; i < amountDigits; i++) {
            if(amountDigits >= 3) {
                if(arrDigt[0] > 0) {
                    StringBuilder stringBuilder = new StringBuilder(arrDigt.length);
                    while(arrDigt[i] > 0) {
                        stringBuilder.append("M"); //using StringBuilder instead of +=
                        arrDigt[0]--;
                    }
                    this.holdString.add(i, String.valueOf(stringBuilder)); //casting StringBuilder to string
                    continue;
                }
                if(arrDigt[1] == 4) {
                    StringBuilder stringBuilder = new StringBuilder(arrDigt.length);
                    while(arrDigt[i] > 0) {
                        stringBuilder.append("M"); //using StringBuilder instead of +=
                        arrDigt[0]--;
                    }
                    this.holdString.add(i, String.valueOf(stringBuilder)); //casting StringBuilder to string
                    continue;
                }
            }
        }
        return holdString;
    }
}

/*                while(amountDigits > 0){
                    holdChar += "M";
                    amountDigits--;
                }
                System.out.println(holdChar);*/