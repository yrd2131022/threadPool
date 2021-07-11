package com.yrd;

import java.util.List;

/**
 * .编写线程类,需要继承Thread类，设计一个属性，用于保存线程的名字
 * .设计一个集合，用于保存所有的任务
 * @ClassName:MyWorker
 * @Description:
 *
 * @author:Yrd
 * @date:2021-5-29 10:32:14
 *
 */
public class MyWorker extends Thread {
	
//	private String name;
	private List<Runnable> tasks;
	
	public MyWorker(String name, List<Runnable> tasks) {
		super(name);
//		this.name = name;
		this.tasks = tasks;
	}


	@Override
	public void run() {
		//判断集合中是否有任务，只要有，就一直执行任务
		while(tasks.size()>0) {
			Runnable r = tasks.remove(0);
			r.run();
		}
		
	}

}
