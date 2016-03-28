package com.bjtu.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ThreadScopeShareData {

	private static Map<Thread, Integer> map = new HashMap<Thread,Integer>();
	
 	public static void main(String[] args)
	{
 		for(int i = 0; i < 2; i++)
 		{
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int data  = new Random().nextInt(10);
					System.out.println(Thread.currentThread().getName()+" has put data :"+data);
					map.put(Thread.currentThread(), data);
					
					new A().get();
					new B().get();
					
					
				}
			}).start();
 		}
	}
 	static class A{
 		public void get()
 		{
 			int data = map.get(Thread.currentThread());
 			System.out.println("A from " + Thread.currentThread()+" get data:"+data);
 		}
 	}
 	
	static class B{
 		public void get()
 		{
 			int data = map.get(Thread.currentThread());
 			System.out.println("B from " + Thread.currentThread()+" get data:"+data);
 		}
 	}
}


