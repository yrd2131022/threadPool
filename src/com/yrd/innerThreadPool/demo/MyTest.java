package com.yrd.innerThreadPool.demo;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyTest {

	public static void main(String[] args) {

		//1.创建一个线程池对象
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.MINUTES,
				new LinkedBlockingQueue<Runnable>(15));

		//2.创建任务对象
		for (int i = 0; i < 20; i++) {
			MyTask myTask = new MyTask("客户" + i);
			poolExecutor.submit(myTask);
		}
		// 3.关闭线程池
		poolExecutor.shutdown();
	}
}
