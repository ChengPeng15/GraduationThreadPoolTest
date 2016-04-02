package com.bjtu.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock比传统线程模型中的synchronized方式更加面向对象
 * @author cuijianglin
 *
 */
public class LockTest02 {
	
	public static void main(String[] args)
	{
		new LockTest02().init();
	}
	
	private void init()
	{
		final Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
				{
					try
					{
						Thread.sleep(100);
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					outputer.output("cuijianglin");
					
				}
			}
		}).start();
		
		 
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
				{
					try
					{
						Thread.sleep(100);
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					
					outputer.output("sunhuiying");
				}
			}
		}).start();
		
	}
	
	
	
	static class Outputer
	{
		//new一把锁
		Lock lock = new ReentrantLock();
		public void output(String name)
		{
			int len = name.length();
			
			lock.lock();
			try
			{
				for(int i = 0; i < len; i++)
				{
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}finally
			{
				lock.unlock();
			}
			
		
		}
		
		
	}
}
