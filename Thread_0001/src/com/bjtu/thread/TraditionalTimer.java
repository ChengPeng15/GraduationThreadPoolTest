package com.bjtu.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimer {
	
	private static int count = 0;
	public static void main(String[] args) {
		//10秒之后开始执行
		/*new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("bombing");
			}
		}, 10000); 
		
		//10秒钟之后开始执行，每隔3秒再次执行
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("bombing");
			}
		}, 10000,3000); 
		*/
		/*while(true)
		{
			System.out.println(new Date().getSeconds());
			try
			{
				Thread.sleep(1000);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}*/
		
		//每隔两秒中执行一次
		class MyTimerTask extends TimerTask
		{
			
			@Override
			public void run() {
				count = (count+1) % 2;
				System.out.println("bombing.......");
				new Timer().schedule(new MyTimerTask(), 2000+2000*count);
			}
		}
		
		new Timer().schedule(new MyTimerTask(),2000);
		
		
		
		
	}
}
