package com.yrd.innerThreadPool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		int sum=0;
		for (int i = 0; i < 12; i++) {
			System.out.println(Thread.currentThread().getName()+"====>"+i);
			sum+=i;
		}
		return Thread.currentThread().getName()+"执行的结果是："+sum;
	}

}
