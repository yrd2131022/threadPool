package com.yrd;

import java.util.ArrayList;
import java.util.List;

public class TestVolatile {

	public static void main(String[] args) {
	 List<String>  list = new ArrayList();
		
		list.add("ss");		
		list.clear();
		System.out.println(list);
		
		
		
		
		

		VolatileThread volatileThread = new VolatileThread(list,"小米");
		volatileThread.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		VolatileThread volatileThread1 = new VolatileThread(list,"丽丽");
		volatileThread1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		System.out.println(list.toString());

		while (true) {
			if (volatileThread.isFlag()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("volatileId222:" + volatileThread.getId());
			}
			if (volatileThread1.isFlag()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("volatileId444:" + volatileThread1.getId());
			}

//			volatileThread.getId();
//synchronized ("1") {
//	
//}
			System.out.println("1");
			if(!list.isEmpty()) {
				System.out.println(list.toString());
			}
		}

	}

}

class VolatileThread extends Thread {

	private volatile int id;
	private  boolean flag = false;
	private volatile List<String> list;


	public VolatileThread(List<String> list,String name) {
		super(name);
		this.list = list;
	}



	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (list) {
			
			list.add(Thread.currentThread().getName());
		}
		System.out.println(list.toString());
			
			id++;
			flag = true;
		
		System.out.println("flag=" + flag);

	}

	@Override
	public String toString() {
		return "VolatileThread {\"id\"=\"" + id + "\"}";
	}

}
