package com.bjtu.thread;

import java.util.Random;

import com.bjtu.thread.ThreadScopeShareData.A;
import com.bjtu.thread.ThreadScopeShareData.B;

public class ThreadLocalTest {
	//类似于map
	//一个ThreadLocal只能代表一个变量
	//当需要多个变量的时候,需要多个ThreadLocal或者是封装成一个类
	private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
	
	private static ThreadLocal<MyThreadScopeData> myThreadLocal = new ThreadLocal<MyThreadScopeData>();
	
	public static void main(String[] args)
	{
		for(int i = 0; i < 2; i++)
 		{
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int data  = new Random().nextInt(10);
					System.out.println(Thread.currentThread().getName()
							+" has put data :"+data);
					x.set(data);
					
				/*	
					MyThreadScopeData myData = new MyThreadScopeData();
					myData.setAge(data);
					myData.setName("name"+data);*/
					
					MyThreadScopeData myData = MyThreadScopeData.getInstance();
					myData.setAge(data);
					myData.setName("name"+data);
					
					//myThreadLocal.set(myData);
					
					
					new A().get();
					new B().get();
				}
			}).start();
 		}
	}
	
	static class A{
 		public void get()
 		{
 			int data = x.get();
 			
 			System.out.println("A from " + Thread.currentThread()+" get data:"+data);
 			
 			/*MyThreadScopeData myData = myThreadLocal.get();
 			myData.getAge();
 			myData.getName();
 			*/
 			MyThreadScopeData myData = MyThreadScopeData.getInstance();
 			System.out.println("A from "+Thread.currentThread().getName()+" get data:"+myData.getName()+","+myData.getAge());
 				
 		}
 	}
 	
	static class B{
 		public void get()
 		{
 			int data = x.get();
 			System.out.println("B from " + Thread.currentThread()+" get data:"+data);
 			/*MyThreadScopeData myData = myThreadLocal.get();*/
 			MyThreadScopeData myData = MyThreadScopeData.getInstance();
 			System.out.println("A from "+Thread.currentThread().getName()+" get data:"+myData.getName()+","+myData.getAge());
 		}
 	}
}

//单例模式（饥寒模式和饱汉模式）
/*class MyThreadScopeData
{
	private MyThreadScopeData(){}
	//可能会出现线程安全问题，当刚new MyThreadScopeData的时候cpu进行切换，那么会出现有两个instance
	//所以要加上synchronized
	public static synchronized MyThreadScopeData getInstance()
	{
		if(instance == null)
			instance = new MyThreadScopeData();
		return instance;
	}
	private static MyThreadScopeData instance = null;//new MyThreadScopeData();
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}*/

class MyThreadScopeData
{
	private MyThreadScopeData(){}
	//可能会出现线程安全问题，当刚new MyThreadScopeData的时候cpu进行切换，那么会出现有两个instance
	//所以要加上synchronized
	public static  MyThreadScopeData getInstance()
	{
		MyThreadScopeData instance = map.get();
		if(instance == null)
		{
			instance = new MyThreadScopeData();
			map.set(instance);
		}
		return instance;
	}

	private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}