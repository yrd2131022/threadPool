package com.yrd;

/**
 * .任务类
 * @ClassName:MyTask
 * @Description:
 *
 * @author:Yrd
 * @date:2021-5-29 10:25:28
 *
 */
public class MyTask implements Runnable {
	
	//任务编号
	private int ID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public MyTask(int iD) {
		ID = iD;
	}

	@Override
	public void run() {
		
		String name = Thread.currentThread().getName();
		System.out.println("线程："+name+" 即将执行任务：");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("线程："+name+" 完成了任务："+ID);
	}

	@Override
	public String toString() {
		return "MyTask {\"ID\"=\"" + ID + "\"}";
	}

}
