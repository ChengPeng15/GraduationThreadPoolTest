package com.bjtu.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch就像一个倒计时的计数器一样，调用CountDownLatch对象的countDown方法就将计数器减1
 * 当计数器到达0的时候，所有等待着或者单个等待着开始执行，
 * @author cuijianglin
 *
 */
public class CountDownLatchTest {
	public static void main(String[] args)
	{
		ExecutorService executorService = Executors.newCachedThreadPool();
		final CountDownLatch cdOrder = new CountDownLatch(1);
		final CountDownLatch cdAnswer = new CountDownLatch(3);
		
		for(int i = 0; i < 3; i++)
		{
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					try
					{
						System.out.println("线程："+Thread.currentThread().getName()+"正在准备接受命令");
						cdOrder.await();
						
						System.out.println("线程："+Thread.currentThread().getName()+"已接受命令");
						Thread.sleep((long)(Math.random()*10000));
						
						System.out.println("线程"+Thread.currentThread().getName()+"回应命令处理结果");
						cdAnswer.countDown();
						
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			};
			
			executorService.execute(runnable);
		}
		try
		{
			Thread.sleep((long)(Math.random()*10000));
			System.out.println("线程"+Thread.currentThread().getName()+"即将发布命令");
			cdOrder.countDown();
			System.out.println("线程"+Thread.currentThread().getName()+"已发送命令，正在等待结果");
			cdAnswer.await();
			System.out.println("线程"+Thread.currentThread().getName()+"已收到所有相应结果");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
