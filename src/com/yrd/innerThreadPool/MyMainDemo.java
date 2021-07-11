package com.yrd.innerThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyMainDemo {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//1.
		Callable call = new MyCallable();
		//2.把Callable任务对象包装成一个未来任务对象,
		//未来任务对象，其实就是runnable对象
		//未来任务对象可以在线程执行完毕之后去得到线程执行结果
		FutureTask<String> task= new FutureTask<>(call);
		//3.
		Thread t = new Thread(task);
		//4.
		t.start();
		
		//5.最后去获取线程执行的结果，如果线程没有结果，让出cpu等线程执行完再来取结果
		String string = task.get();
		System.out.println(string);
	}
}
