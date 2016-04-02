package com.bjtu.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore信号量，可以控制资源被线程访问的线程个数
 * 比如一个资源，信号量可以控制线程个数
 * 
 * 
 * Semaphore,一个线程加上锁之后，另一个线程可以释放锁
 * @author cuijianglin
 *
 */
public class SemaphoreTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore sp = new Semaphore(3);
		for(int i = 0; i < 10; i++)
		{
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					try
					{
						//获取信号量
						sp.acquire();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					System.out.println("线程："+Thread.currentThread().getName()+"进入，当前已有"+(3-sp.availablePermits()+"进入"));
					
					try
					{
						Thread.sleep((long)(Math.random()*1000));
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					System.out.println("线程:"+Thread.currentThread().getName()+"即将离开");
					
					
					sp.release();
					
					System.out.println("线程:"+Thread.currentThread().getName()+"已经离开，当前已有"+(3-sp.availablePermits()));
					
				}
				
				
			};
			executorService.execute(runnable);
		}
	}

}
