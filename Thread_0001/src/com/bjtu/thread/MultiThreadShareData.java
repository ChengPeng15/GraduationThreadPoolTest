package com.bjtu.thread;

public class MultiThreadShareData {
/**
 * 多线程共享的方式
 * 设计4个线程，其中两个线程对j加1，另外两个对j减1
 * @param args
 */
	public static void main(String[] args) {
		final ShareData1 s = new ShareData1();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				s.decrement();
				System.out.println("decrement:"+s.getJ());
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				s.increment();
				System.out.println("increment:"+s.getJ());
			}
		}).start();
	}

}

class ShareData1
{
	private int j = 0;
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public synchronized void increment()
	{
		j++;
	}
	public synchronized void decrement()
	{
		j--;
	}
	
}
