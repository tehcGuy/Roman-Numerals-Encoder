package com.practice;

import java.util.LinkedList;
import java.util.List;

public class Conversion {
    private List<String> holdString;
    private int amountDigits;
    private int incrsListIndx;
    private int[] arr;

    private StringBuilder stringBuilder; //StringBuilder helps with appending in the for loop

    public String solution(int n) {
        holdString = new LinkedList<String>();
        convertingDigtToArr(n);

        for(int i = amountDigits; i > 0; i--) {
            switch(i) { //basic
                case 1:
                    parsingOnes();
                    break;
                case 2:
                    parsingTens();
                    break;
                case 3:
                    parsingHundreds();
                    break;
                default:
                    parsingThousands();
            }
        }
        stringBuilder = new StringBuilder();
        for(String s : holdString) {
            stringBuilder.append(s);
        }
        reset();
        return String.valueOf(stringBuilder);
    }

    private void convertingDigtToArr(int n) {
        int counter = 0;
        int temp = n;
        while(n > 0) {
            n = n / 10;
            counter++;
        }
        amountDigits = counter;
        int m = temp;
        int a;
        this.arr = new int[counter];

        while(m > 0) {
            a = m % 10;
            arr[counter - 1] = a;
            m = m / 10;
            counter--;
        }
    }

    private void parsingOnes() {
        stringBuilder = new StringBuilder();
        if(this.arr[incrsListIndx] > 0 && this.arr[incrsListIndx] < 4) {
            for(int j = 0; j < this.arr[incrsListIndx]; j++) {
                stringBuilder.append("I"); //using StringBuilder instead of +=
            }
        } else if(this.arr[incrsListIndx] == 4) {
            stringBuilder.append("IV");
        } else if(this.arr[incrsListIndx] == 5) {
            stringBuilder.append("V");
        } else if(this.arr[incrsListIndx] > 5 && arr[incrsListIndx] < 9) {
            stringBuilder.append("V");
            for(int j = 0; j < (this.arr[incrsListIndx] - 5); j++) {
                stringBuilder.append("I");
            }
        } else if(this.arr[incrsListIndx] == 9) {
            stringBuilder.append("IX");
        }
        this.holdString.add(incrsListIndx, String.valueOf(stringBuilder));
        incrsListIndx++;
    }

    private void parsingTens() {
        stringBuilder = new StringBuilder(this.arr.length);
        if(this.arr[incrsListIndx] > 0 && this.arr[incrsListIndx] < 4) {
            for(int j = 0; j < this.arr[incrsListIndx]; j++) {
                stringBuilder.append("X");
            }
        } else if(this.arr[incrsListIndx] == 4) {
            stringBuilder.append("XL");
        } else if(this.arr[incrsListIndx] == 5) {
            stringBuilder.append("L");
        } else if(this.arr[incrsListIndx] > 5 && arr[incrsListIndx] < 9) {
            stringBuilder.append("L");
            for(int j = 0; j < (this.arr[incrsListIndx] - 5); j++) {
                stringBuilder.append("X");
            }
        } else if(this.arr[incrsListIndx] == 9) {
            stringBuilder.append("XC");
        }
        this.holdString.add(incrsListIndx, String.valueOf(stringBuilder));
        incrsListIndx++;
    }

    private void parsingHundreds() {
        stringBuilder = new StringBuilder(this.arr.length);
        if(this.arr[incrsListIndx] > 0 && this.arr[incrsListIndx] < 4) {
            for(int j = 0; j < this.arr[incrsListIndx]; j++) {
                stringBuilder.append("C");
            }
        } else if(this.arr[incrsListIndx] == 4) {
            stringBuilder.append("CD");
        } else if(this.arr[incrsListIndx] == 5) {
            stringBuilder.append("D");
        } else if(this.arr[incrsListIndx] > 5 && arr[incrsListIndx] < 9) {
            stringBuilder.append("D");
            for(int j = 0; j < (this.arr[incrsListIndx] - 5); j++) {
                stringBuilder.append("C");
            }
        } else if(this.arr[incrsListIndx] == 9) {
            stringBuilder.append("CM");
        }
        this.holdString.add(incrsListIndx, String.valueOf(stringBuilder));
        incrsListIndx++;
    }

    private void parsingThousands() {
        stringBuilder = new StringBuilder(this.arr.length);
        for(int j = 0; j < this.arr[incrsListIndx]; j++) {
            stringBuilder.append("M");
        }
        this.holdString.add(incrsListIndx, String.valueOf(stringBuilder));
        incrsListIndx++;
    }

    private void reset() { //if I use the same object, I need to reset the the fields
        this.holdString = null;
        this.amountDigits = 0;
        this.incrsListIndx = 0;
        this.arr = null;
    }
}
