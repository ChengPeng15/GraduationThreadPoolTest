package com.bjtu.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier:表示大家彼此等待，大家集合好之后才开始出发，分散后有在指定地点集合碰面
 * @author cuijianglin
 *
 */
public class CyclicBarrierTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		for(int i = 0; i < 3; i++)
		{
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					try
					{
						Thread.sleep((long)(Math.random()*10000));
						System.out.println("线程"+Thread.currentThread().getName()+
								"即将到达集合地点1，当前已有"+
								(cyclicBarrier.getNumberWaiting()+1)+"个已经到达，"+
								(cyclicBarrier.getNumberWaiting()==2? "都到齐了，继续走":"正在等候"));
						cyclicBarrier.await();
						
						Thread.sleep((long)(Math.random()*10000));
						System.out.println("线程"+Thread.currentThread().getName()+
								"即将到达集合地点2，当前已有"+
								(cyclicBarrier.getNumberWaiting()+1)+"个已经到达，"+
								(cyclicBarrier.getNumberWaiting()==2? "都到齐了，继续走":"正在等候"));
						cyclicBarrier.await();
						
						Thread.sleep((long)(Math.random()*10000));
						System.out.println("线程"+Thread.currentThread().getName()+
								"即将到达集合地点3，当前已有"+
								(cyclicBarrier.getNumberWaiting()+1)+"个已经到达，"+
								(cyclicBarrier.getNumberWaiting()==2? "都到齐了，继续走":"正在等候"));
						cyclicBarrier.await();
						
					
					
					
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			};
			executorService.execute(runnable);
			
		}
		executorService.shutdown();
	}
}
