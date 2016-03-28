package com.bjtu.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	public static void main(String[] args){
		//固定的线程数
		//ExecutorService threadPool = Executors.newFixedThreadPool(3);
		//线程数量是动态改变的
		//ExecutorService threadPool = Executors.newCachedThreadPool();
		//只有一个线程
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		for(int i = 1; i <= 10; i++)
		{
			final int task = i;
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					for(int j = 1; j <= 10; j++)
					{
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+" is looping of "+j+" for task of "+task);
					}
					
				}
			});
		}
		
		//threadPool.shutdown();
		
		//threadPool.shutdownNow();

	}
}
