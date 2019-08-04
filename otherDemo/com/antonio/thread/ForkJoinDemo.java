package com.antonio.thread;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

//计算1-100之和，按规则end-begin<=2拆分并发计算，在汇总结果
public class ForkJoinDemo extends RecursiveTask<Integer> {
    
    private static final long serialVersionUID = 1L;
    private int begin;
    private int end;

    public ForkJoinDemo(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //拆分任务
        if(end-begin<=2){
            //计算
            for(int i=begin;i<=end;i++){
                sum +=i;
            }
            System.out.println(Thread.currentThread().getName()+":计算和为：" + sum);
        }else{//拆分
          ForkJoinDemo d1 = new ForkJoinDemo(begin, (begin+end)/2);
          ForkJoinDemo d2 = new ForkJoinDemo((begin+end)/2+1,end); 
          //执行任务
          d1.fork();
          System.out.println(Thread.currentThread().getName()+":前序拆分计算");
          d2.fork();
          System.out.println(Thread.currentThread().getName()+":后续拆分计算");
          Integer a = d1.join();
          System.out.println(Thread.currentThread().getName()+":前序合并计算和:" + a);
          Integer b = d2.join();
          System.out.println(Thread.currentThread().getName()+":后续合并计算和:" + b);
          sum=a+b;
          System.out.println("总和：" + sum);
        }
        return sum;
    }
    
    public static void main(String[] args) throws Exception {
       ForkJoinPool pool = new ForkJoinPool(3);//指定并行线程数
       
       ForkJoinTask<Integer> future = pool.submit(new ForkJoinDemo(1,100));
       System.out.println("计算的值为：" + future.get());

    }

}
