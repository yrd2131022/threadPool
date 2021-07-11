package com.yrd.innerThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * .练习Executors获取ExecutorService,然后调用方法，提交任务
 * @ClassName:InnerThreadPool
 * @Description:
 *
 * @author:Yrd
 * @date:2021-5-29 12:04:51
 *
 */
public class InnerThreadPool {
	public static void main(String[] args) {
		//1.使用工厂类获取线程池对象
		ExecutorService es = Executors.newFixedThreadPool(3);
		
//		ExecutorService es = Executors.newCachedThreadPool();
//		ExecutorService es = Executors.newCachedThreadPool(new ThreadFactory() {
//			
//			@Override
//			public Thread newThread(Runnable r) {
//				// TODO Auto-generated method stub
//				//这样写，线程与任务绑定了
//				return new Thread(r);
//			}
//		});
		//2.提交任务
		
		for (int i = 1; i <= 100; i++) {
			Future<?> future = es.submit(new MyRunnable(i));
			
		}
		
		boolean isd = es.isShutdown();
		System.out.println("是否已经shutdown："+isd+"=======================================");
		
		if(isd!=true) {
			System.out.println("开始shutdown。。。");
			//3.关闭线程池
			es.shutdownNow();
			
			boolean isd1 = es.isShutdown();
			System.out.println("是否已经shutdown："+isd1+"=======================================");
		}
		
		
	}

}

class MyRunnable implements Runnable{
	
	private int id;
	
	public MyRunnable(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		//获取线程的名称，打印一句话
		String name = Thread.currentThread().getName();
		System.out.println(name+"执行了任务。。。。"+id);
		for (int i = 0; i < 1000; i++) {
			
		}
	}
	
}
