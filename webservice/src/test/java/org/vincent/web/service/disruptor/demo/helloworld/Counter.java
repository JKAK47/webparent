package org.vincent.web.service.disruptor.demo.helloworld;

/**
 * @Package: org.vincent.web.service.disruptor.demo.helloworld <br/>
 * @Description： TODO <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/9/2 12:59 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/9/2. <br/>
 */

public class Counter implements Runnable{
		private int count;

		public Counter() {
				count = 0;
		}

		public void countAdd() {
				synchronized(this) {
						for (int i = 0; i < 5; i ++) {
								try {
										System.out.println("synchronized method :"+Thread.currentThread().getName() + ":\t" + (count++));
										Thread.sleep(1000);
								} catch (InterruptedException e) {
										e.printStackTrace();
								}
						}
				}
		}

		//非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
		public void printCount() {
				for (int i = 0; i < 5; i ++) {
						try {
								System.out.println(" 非synchronized method: "+Thread.currentThread().getName() + " count:" + count);
								Thread.sleep(100);
						} catch (InterruptedException e) {
								e.printStackTrace();
						}
				}
		}

		/**
		 * 根据线程名执行两个方法，一个方法同步方法，
		 * 一个是非同步方法。
		 */
		public void run() {
				String threadName = Thread.currentThread().getName();
				if (threadName.equals("B")) {
						//非同步方法
						printCount();
				} else   {
						// 执行同步方法
						countAdd();
				}
		}
}
