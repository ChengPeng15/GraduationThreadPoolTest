package com.bjtu.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;




//Future和Callable可以获得线程的返回值
//这种任务可以返回结果，future来拿结果，
//但是主线程在等待
public class CallableAndFuture {

	public static void main(String[] args)
	{
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		
		Future<String> future = threadPool.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(1000);
				return "hello";
			}
		});
		
		System.out.println("等待结果");
		try
		{
			System.out.println("结果:"+future.get());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
		//CompletionService用于提交一组Callable任务，take方法返回已完成的一个Callable任务对应的Future对象
		ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
		CompletionService<Integer> completionService = new ExecutorCompletionService<>(threadPool2);
		
		for(int i = 1; i <= 10; i++)
		{
			final int seq = i;
			completionService.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(5000));
					return seq;
				}
			});
		}
		
		
		for(int i = 0; i < 10; i++)
		{
			try {
				System.out.println(completionService.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
