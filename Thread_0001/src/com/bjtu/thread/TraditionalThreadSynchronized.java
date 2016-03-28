package com.bjtu.thread;

public class TraditionalThreadSynchronized {
	
	public static void main(String[] args) {
		new TraditionalThreadSynchronized().init();
	}
	
	
	//这里就出现了两个线程打印混乱的问题，即两个线程出现线程安全问题
	//这种问题是小概率事件
	
	/**
	 * 解决方法：
	 * 
	 */
	public void init()
	{
		final OutPutName out = new OutPutName();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
				{
					try
					{
						Thread.sleep(10);
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					out.OutPutName("cuijianglin");
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
						Thread.sleep(10);
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					out.OutPutName("sunhuiying");
				}
			}
		}).start();
	}
	static class OutPutName
	{
		
		public void OutPutName(String name)
		{
			int len = name.length();
			//线程互斥
			//括号中间的必须是独立的，不能使用两个。
			//synchronized (this) {
			
			synchronized (this) {
				for(int i = 0; i < len; i++)
				{
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
			
		}
		//使用synchronized，也是可以的。
		//这里默认使用的就是this对象
		//使用的监视器对象一定要是一样的
		public synchronized void OutPutName2(String name)
		{
			int len = name.length();
			//线程互斥
			//括号中间的必须是独立的，不能使用两个。
				for(int i = 0; i < len; i++)
				{
					System.out.print(name.charAt(i));
				}
				System.out.println();
		
		}
		
		//当使用静态的时候，由于只有一个静态类，没有对象
		//互斥的锁就有问题了，上面的应该改成OutPutName.class才行
		public static synchronized void OutPutName3(String name)
		{
			int len = name.length();
			//线程互斥
			//括号中间的必须是独立的，不能使用两个。
				for(int i = 0; i < len; i++)
				{
					System.out.print(name.charAt(i));
				}
				System.out.println();
		
		}
	}
}
