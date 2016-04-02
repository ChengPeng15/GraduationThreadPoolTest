package com.bjtu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 子线程循环10次，接着主线程循环100，接着又回到子线程循环10次
 * 接着再回到主线程循环100，如此循环50次，请写出程序
 * @author cuijianglin
 *nodify和wait必须在synchronized中写。
 */
/**
 * Condition类似于wait和nodify的功能，也就是解决线程之间的通信问题的
 * @author cuijianglin
 *
 */
public class ConditionCommunication {

	public static void main(String[] args) {
		
		final Business business = new Business();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
					for(int j = 0; j <= 50; j++)
					{
						business.sub(j);
					}
				}
		
		}).start();

		for(int j = 0; j <= 50; j++)
		{
			business.main(j);
		}
	}
	
	
	static class Business
	{
		private boolean bShouldSub = true;
		
		Lock lock = new ReentrantLock();
		//Condition必须在lock的基础之上才能用
		Condition condition = lock.newCondition();
		
		public void sub(int j)
		{
			lock.lock();
			try
			{
				while(!bShouldSub)
				{
					try {
						//condition的特殊的方法
						condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			
				for(int i = 0; i <= 10; i++)
				{
					System.out.println("sub thread sequeue of:"+i+",loop of " + j);
				}
				
				bShouldSub = false;
				//发送信号
				condition.signal();
			}finally
			{
				lock.unlock();
			}
			//this.notify();
		}
		
		public void main(int j)
		{
			lock.lock();
			try
			{
				while(bShouldSub)
				{
					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			
			
				for(int i = 0; i <= 100; i++)
				{
					System.out.println("Main thread sequeue of:"+i+",loop of " + j);
				}
				
				bShouldSub = true;
				//this.notify();
				condition.signal();
			}finally
			{
				lock.unlock();
			}
		}
	}
}



