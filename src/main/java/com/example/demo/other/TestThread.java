package com.example.demo.other;

import java.util.concurrent.*;

/**
 * @Author: kuaik
 * @Date: 2018-10-10
 * @Description:
 */
/**
 * 假如有Thread1、Thread2、ThreaD3、Thread4四条线程分别统计C、D、E、F四个盘的大小，所有线程都统计完毕交给Thread5线程去做汇总，应当如何实现？
 */
public class TestThread {
    public static void main(String[] args) {
        ThreadCount tc = null;
        ExecutorService es = Executors.newCachedThreadPool();//线程池
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(es);
        for(int i=0;i<4;i++){
            tc = new ThreadCount(i+1);
            cs.submit(tc);
        }

        // 添加结束，及时shutdown，不然主线程不会结束
        es.shutdown();

        int total = 0;
        for(int i=0;i<4;i++){
            try {
                total+=cs.take().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(total);
    }
}

class ThreadCount implements Callable<Integer> {
    private int type;
    ThreadCount(int type){
        this.type = type;
    }
    @Override
    public Integer call() throws Exception {
        if(type==1){
            System.out.println("C盘统计大小");
            return 1;
        }else if(type==2){
            Thread.sleep(20000);
            System.out.println("D盘统计大小");
            return 2;
        }else if(type==3){
            System.out.println("E盘统计大小");
            return 3;
        }else if(type==4){
            System.out.println("F盘统计大小");
            return 4;
        }
        return null;
    }
}
