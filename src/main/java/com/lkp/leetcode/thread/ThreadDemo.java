package com.lkp.leetcode.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 *@className ThreadDemo
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2020/4/16 18:01
 *@Version
 */
public class ThreadDemo {
	
	
	public static void main(String[] args) {
		long l = System.currentTimeMillis();
		Callable<Integer> callable = new Callable() {
			@Override
			public Integer call() throws Exception {
				System.out.println("调用callable");
				Thread.sleep(3000);
				return 1;
			}
		};
		FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
		new Thread(futureTask).start();
		Callable<Integer> callable2 = new Callable() {
			@Override
			public Integer call() throws Exception {
				System.out.println("调用callable");
				Thread.sleep(5000);
				return 1;
			}
		};
		FutureTask<Integer> futureTask2 = new FutureTask<Integer>(callable2);
		new Thread(futureTask2).start();
		System.out.println("22222");
		try {
//			Integer call = callable.call();
			Integer call = futureTask.get();
			Integer call2 = futureTask2.get();
			System.out.println(call);
			System.out.println(call2);
			System.out.println(System.currentTimeMillis()-l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
