package com.antonio.thread;

import java.util.concurrent.Exchanger;

//在屏障点交换两个线程的数据,进行数据比对
public class ExchangerDemo {
    
    public void a (Exchanger<String> exch){
        
        System.out.println(Thread.currentThread().getName()+ ":a方法开始执行");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String res = "12345";
        
        try {
            System.out.println(Thread.currentThread().getName()+ "：等待对比结果");
            String value=exch.exchange(res);
            System.out.println(Thread.currentThread().getName()+ "比对结果为：" + value.equals(res));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void b (Exchanger<String> exch){
        System.out.println(Thread.currentThread().getName()+ ":b方法开始执行");
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String res = "12345";
        
        try {
            String value=exch.exchange(res);
            System.out.println(Thread.currentThread().getName()+ "开始进行比对");
            System.out.println(Thread.currentThread().getName()+ "比对结果为：" + value.equals(res));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        ExchangerDemo demo = new ExchangerDemo();
        Exchanger<String> exch = new Exchanger<>();
        
        new Thread(()->{demo.a(exch);}).start();
        new Thread(()->{demo.b(exch);}).start();
    }

}
