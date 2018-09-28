package org.vincent.web.service.disruptor.demo.helloworld;

/**
 * @Package: org.vincent.web.service.disruptor.demo.helloworld <br/>
 * @Description： TODO <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/9/2 12:34 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/9/2. <br/>
 */

/**
 * 同步线程
 */
class SyncThread implements Runnable {
		private static int count;

		public SyncThread() {
				count = 0;
		}

		public static void method() {
				synchronized (SyncThread.class) {
						for (int i = 0; i < 5; i++) {
								try {
										System.out.println(Thread.currentThread().getName() + ":" + (count++));
										Thread.sleep(100);
								} catch (InterruptedException e) {
										e.printStackTrace();
								}
						}
				}
		}

		public void run() {
				method();
		}

		public int getCount() {
				return count;
		}
}
