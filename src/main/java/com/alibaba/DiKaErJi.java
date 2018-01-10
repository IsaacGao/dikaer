package com.alibaba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiKaErJi {
    private List<String> firstParam = new ArrayList<String>();
    private List<String> secondParam = new ArrayList<String>();
    private List<String> endParam = new ArrayList<String>();
    private String[] aa = null;
    private String[] bb = null;
    private String[] cc = null;
    private String[][] xyz = null;
    private int counterIndex = 0;
    private int[] counter = {0, 0, 0};

    public DiKaErJi() {
        firstParam.add("@+年");
        firstParam.add("aa2");
        firstParam.add("aa3");

        secondParam.add("bb1");
        secondParam.add("bb2");
        secondParam.add("bb3");

        endParam.add("cc1");
        endParam.add("cc2");
        endParam.add("cc3");

        aa = listToArray(firstParam);
        bb = listToArray(secondParam);
        cc = listToArray(endParam);
        xyz = new String[][]{aa, bb, cc};
        counterIndex = xyz.length - 1;;
    }

    

    public String[] listToArray(List<String> list){
        String[] lines = new String[list.size()];
        for(int i = 0;i<lines.length;i++){
            lines[i] = list.get(i);
        }
        return lines;
    }

    public void startProcess() {
        for (int i = 0; i < aa.length * bb.length * cc.length; i++) {
            System.out.print(aa[counter[0]]);
//            System.out.print("\t");
            System.out.print(bb[counter[1]]);
//            System.out.print("\t");
            System.out.print(cc[counter[2]]);
            System.out.println();

            handle();
        }
    }

    public void handle() {
        counter[counterIndex]++;
        if (counter[counterIndex] >= xyz[counterIndex].length) {
            counter[counterIndex] = 0;
            counterIndex--;
            if (counterIndex >= 0) {
                handle();
            }
            counterIndex = xyz.length - 1;
        }
    }

    public static void main(String[] args) {
        new DiKaErJi().startProcess();
    }

}

