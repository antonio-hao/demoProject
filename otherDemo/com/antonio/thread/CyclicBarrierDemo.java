package com.antonio.thread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

//10个人开会，必须全部到齐了才能开始开会
public class CyclicBarrierDemo {
    
    public void meeting(CyclicBarrier barrier){
        
        try {
            Thread.sleep(new Random().nextInt(4000));
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        
        System.out.println(Thread.currentThread().getName()+ ":到达会议室，等待开会");
        try {
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(Thread.currentThread().getName()+ ":发言");
        
    }

    public static void main(String[] args) {
        CyclicBarrierDemo demo = new CyclicBarrierDemo();
        
        CyclicBarrier barrier = new CyclicBarrier(10, () ->{
            System.out.println(Thread.currentThread().getName()+ ":人员已到齐，开始开会！");
        });//设置屏障点，达到10后该做什么事
                
        for(int i=0;i<10;i++){
            new Thread(()->{
                demo.meeting(barrier);
            }).start();
        }
    }

}
