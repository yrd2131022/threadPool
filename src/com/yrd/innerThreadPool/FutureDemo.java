package com.yrd.innerThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * .练习异步计算结果
 * @ClassName:FutureDemo
 * @Description:
 *
 * @author:Yrd
 * @date:2021-5-29 16:17:41
 *
 */
public class FutureDemo {

	public static void main(String[] args) {
		//1.获取线程池对象
		ExecutorService es= Executors.newCachedThreadPool();
		//2.创建Callable类型的任务对象
		Future<Integer> future = es.submit(new MyCall(10, 12));
		
	
		
		
//		test1(future);
//		boolean cancel = future.cancel(true);
//		System.out.println("取消任务执行的结果："+cancel);
		
		Integer integer = null;
		try {
			//由于等待时间过短，任务来不及执行完成，会报异常
			integer = future.get(1,TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		System.out.println("任务执行的结果是："+integer);
		
		
	}

	private static void test1(Future<Integer> future) throws Exception {
		//3.判断任务是否完成
		boolean done = future.isDone();
		System.out.println("第一次判断任务是否完成："+done);
		boolean cancelled = future.isCancelled();
		System.out.println("第一次判断任务是否取消："+cancelled);
		
//		Integer integer = future.get();//一直等待任务的执行，直到完成为止
		//由于等待时间过短，任务来不及执行完成，会报异常
		Integer integer = future.get(1,TimeUnit.SECONDS);//
		System.out.println("任务执行的结果是："+integer);
		
		boolean done2 = future.isDone();
		System.out.println("第二次判断任务是否完成："+done2);
		boolean cancelled2 = future.isCancelled();
		System.out.println("第二次判断任务是否取消："+cancelled2);
	}
}

class MyCall implements Callable<Integer>{
	
	private int a;
	private int b;
	
	public MyCall(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}


	@Override
	public Integer call() throws Exception {
		
		String name = Thread.currentThread().getName();
		System.out.println(name+"准备开始计算。。。。");
		Thread.sleep(2000);
		System.out.println(name+"计算完成。。。。");
		return a+b;
	}
	
}
