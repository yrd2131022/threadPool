package com.yrd.innerThreadPool.demo;

/**
 * .任务类.包含了商品数量，客户名称，送手机的行为
 * @ClassName:MyTask
 * @Description:
 *
 * @author:Yrd
 * @date:2021-5-29 16:57:54
 *
 */

public class MyTask implements Runnable {

	//设计一个变量，用于表示商品的数量
	private static int id = 10;
	//表示客户名称的变量
	private String userName;
	
	
	public MyTask(String userName) {
		super();
		this.userName = userName;
	}


	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(userName+"正在使用"+name+"参与秒杀任务........");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//这里使用MyTask.class,表示锁的唯一性
		synchronized (MyTask.class) {
			if(id>0) {
				System.out.println(userName+"使用"+name+"秒杀："+id--+"号商品成功啦！");
			}else {
				System.out.println(userName+"使用"+name+"秒杀失败啦！");
			}
		}
	}

}
