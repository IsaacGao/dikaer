package com.alibaba;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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

        initFirstList();
        initSecondList();
        initEndList();

        aa = listToArray(firstParam);
        bb = listToArray(secondParam);
        cc = listToArray(endParam);
        xyz = new String[][]{aa, bb, cc};
        counterIndex = xyz.length - 1;;
    }

    public void initFirstList(){
        firstParam.add("@+年@+月@+日");
        //没有日的情况下默认是1日
        firstParam.add("@+年@+月");
        firstParam.add("明年@+月");
        firstParam.add("明天");
        firstParam.add("后天");
        firstParam.add("大后天");
        firstParam.add("昨天");
        firstParam.add("前天");
        firstParam.add("大前天");
        //处理周末的时候按照两天处理
        firstParam.add("下周@+");
        firstParam.add("这周@+");
    }

    public void initSecondList(){
        secondParam.add("上午");
        secondParam.add("中午");
        secondParam.add("下午");
        secondParam.add("晚上");
        secondParam.add("早上");
        secondParam.add("凌晨");
        //不包含上午下午的
        secondParam.add("");
    }

    public void initEndList(){
        endParam.add("@+时@+分@+秒");
        endParam.add("@+时@+分");
        endParam.add("@+点@+分@+秒");
        endParam.add("@+点@+分");
        //不包含日期的
        secondParam.add("");
    }

    public String[] listToArray(List<String> list){
        String[] lines = new String[list.size()];
        for(int i = 0;i<lines.length;i++){
            lines[i] = list.get(i);
        }
        return lines;
    }

    public void startProcess() throws IOException {
        List<String> writeList = new ArrayList<>();
        for (int i = 0; i < aa.length * bb.length * cc.length; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(aa[counter[0]]);
            sb.append(bb[counter[1]]);
            sb.append(cc[counter[2]]);
            System.out.print(aa[counter[0]]);
//            System.out.print("\t");
            System.out.print(bb[counter[1]]);
//            System.out.print("\t");
            System.out.print(cc[counter[2]]);
            System.out.println();
            writeList.add(sb.toString());
            handle();
        }
        writeToFile(writeList);
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

    public void writeToFile(List<String> list) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("D:\\IDEA\\dikaer\\src\\main\\java\\com\\alibaba\\DateTimeCartesian.txt"));
        for(String line:list){
            if(line!="")
                writer.append(line).append("\r\n");
        }
        writer.close();
    }


    public static void main(String[] args) throws IOException {
        new DiKaErJi().startProcess();
    }

}

