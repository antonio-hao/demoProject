package com.antonio.thread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

//子线程分步计算每行的和，主线程在合并子线程的和
public class CountDownLatchDemo {
    
    private int[] nums;
    
    public CountDownLatchDemo(int line){
        nums = new int[line];
    }
    
    
    public void calc(String line,int index,CountDownLatch latch){//计算第X行数据之和
        
        String[] nus = line.split(",");
        int total = 0;
        for(String num : nus){
            total += Integer.parseInt(num);
        }
        nums[index]=total;
        System.out.println(Thread.currentThread().getName() + ":执行计算任务。。。"+ line + " 结果为：" + total);
        latch.countDown();//计数器减1
    }
    
    public void sum(){//计算总和
        System.out.println("汇总线程开始执行。。。。");
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total +=nums[i];
        }
        System.out.println("最终结果为：" + total);
    }
    

    public static void main(String[] args) {
        
        List<String> contens = readFile("H:\\nums.txt");
        int lineCount = contens.size();
        CountDownLatch latch = new CountDownLatch(lineCount);//初始计数器值
        
       CountDownLatchDemo demo = new CountDownLatchDemo(lineCount);
       
       for(int i=0;i<lineCount;i++){
           final int j=i;
           new Thread(new Runnable() {
            
            @Override
            public void run() {
               demo.calc(contens.get(j), j,latch);
                
            }
        },"线程"+j).start();
       }
       
       try {
        latch.await();//计数器为0前，当前线程等待
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
       demo.sum();

    }
    
    
    //读取文件数据
    public static List<String> readFile(String adress){
        List<String> contens = new ArrayList<>();
        String line = null;
        BufferedReader br = null;
                  
        try {
            br = new BufferedReader(new FileReader(adress));
            while((line = br.readLine()) !=null){
                contens.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }        
        return contens;
    }

}
