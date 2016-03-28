package com.bjtu.thread;

public class TraditionThread {

	public static void main(String[] args) {
		
		
		//第一个线程
		Thread thread = new Thread(){
			@Override
			public void run() {
				while(true)
				{
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//获取当前线程的名字
					System.out.println(Thread.currentThread().getName());
				}
			}
		};
		thread.start();
		
		//第二个线程
		//这种方法更加通用
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
				{
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//获取当前线程的名字
					System.out.println(Thread.currentThread().getName());
				}
				
			}
		});
		thread2.start();
		
		
		//第三个线程
		//运行thread中的
		Thread thread3 = new Thread(new Runnable(){
			@Override
			public void run() {
				while(true)
				{
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//获取当前线程的名字
					System.out.println(Thread.currentThread().getName());
				}
				
			}
		}){
			@Override
			public void run() {
				while(true)
				{
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//获取当前线程的名字
					System.out.println(Thread.currentThread().getName());
				}
				
			}
		};
		thread3.start();
		
	}

}
