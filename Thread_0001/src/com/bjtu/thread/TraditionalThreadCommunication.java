package com.bjtu.thread;


/**
 * 子线程循环10次，接着主线程循环100，接着又回到子线程循环10次
 * 接着再回到主线程循环100，如此循环50次，请写出程序
 * @author cuijianglin
 *
 */
public class TraditionalThreadCommunication {

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
}


class Business
{
	private boolean bShouldSub = true;
	public synchronized void sub(int j)
	{
		while(!bShouldSub)
		{
			try {
				this.wait();
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
		this.notify();
		
	}
	
	public synchronized void main(int j)
	{
		while(bShouldSub)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		for(int i = 0; i <= 100; i++)
		{
			System.out.println("Main thread sequeue of:"+i+",loop of " + j);
		}
		
		bShouldSub = true;
		this.notify();
		
	}
}
