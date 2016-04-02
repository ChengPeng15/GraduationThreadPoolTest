package com.bjtu.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger:两个人之间的数据交换，两个线程想要交换数据，第一个到达的要等待，第二个到达之后交换数据
 * @author cuijianglin
 *
 */
public class ExchangerTest {
	public static void main(String[] args)
	{
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Exchanger exchanger = new Exchanger();
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				try
				{
					String data01 = "cuijianglin";
					System.out.println("线程"+Thread.currentThread().getName()+"正在吧数据"+data01+"交换出去");
					
					Thread.sleep((long)(Math.random()*10000));
					//交换数据
					String data02 = (String)exchanger.exchange(data01);
					
					System.out.println("线程"+Thread.currentThread().getName()+"换回的数据为："+data02);
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				try
				{
					String data01 = "sunhuiying";
					System.out.println("线程"+Thread.currentThread().getName()+"正在吧数据"+data01+"交换出去");
					
					Thread.sleep((long)(Math.random()*10000));
					//交换数据
					String data02 = (String)exchanger.exchange(data01);
					
					System.out.println("线程"+Thread.currentThread().getName()+"换回的数据为："+data02);
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		executorService.shutdown();
	}
}
