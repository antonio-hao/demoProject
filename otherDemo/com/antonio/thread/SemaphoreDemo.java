package com.antonio.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;

//5个停车位，100辆车抢占车位
public class SemaphoreDemo {

    public static void main(String[] args) {
        BlockingQueue<String> parks = new LinkedBlockingDeque<>(5);
        
        parks.offer("车位一");
        parks.offer("车位二");
        parks.offer("车位三");
        parks.offer("车位四");
        parks.offer("车位五");
        
        Semaphore semaphore = new Semaphore(5);
        
        for(int i=0;i<100;i++){
            
            final int no = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            new Thread(() -> {
                
               try {
                semaphore.acquire();//获取许可
                
                String park = parks.take();
                System.out.println(Thread.currentThread().getName()+":车辆【" + no + "】获取到：" + park);
                Thread.sleep((long) Math.random() * 6000 + 10000);//停车时间
                semaphore.release();//归还许可
                parks.offer(park);//归还车位
                System.out.println(Thread.currentThread().getName()+":车辆【" + no + "】离开：" + park);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }                                            
            }).start();
        }

    }

}
