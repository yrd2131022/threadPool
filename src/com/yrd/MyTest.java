package com.yrd;

/**
 * .创建线程池类对象 .提交多个任务
 * 
 * @ClassName:MyTest
 * @Description:
 *
 * @author:Yrd
 * @date:2021-5-29 11:18:59
 *
 */
public class MyTest {
	public static void main(String[] args) {
		//1创建线程池类对象
		MyThreadPool pool = new MyThreadPool(2, 4, 20);
		//2提交多个任务
		for (int i = 0; i < 100; i++) {
			//3创建任务对象，并提交线程池
			MyTask myTask = new MyTask(i);
			pool.submit(myTask);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
