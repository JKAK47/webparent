package org.vincent.web.service.disruptor.demo.helloworld;

/**
 * @Package: org.vincent.web.service.disruptor.demo.helloworld <br/>
 * @Description： TODO <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/8/27 21:36 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/8/27. <br/>
 */

public class App {

		public static void main(String[] args) {
				SyncThread syncThread1 = new SyncThread();
				SyncThread syncThread2 = new SyncThread();
				Thread thread1 = new Thread(syncThread1, "SyncThread1");
				Thread thread2 = new Thread(syncThread2, "SyncThread2");
				thread1.start();
				thread2.start();









				/*List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
				System.out.println(list);
				*//** List 转原生类型 int[] ，通过Apache Common-lang *//*
				int[] a=ArrayUtils.toPrimitive(list.toArray(new  Integer[0]));
				System.out.println(a.length);
				*//** int[] 转 List ，自己for循环遍历 *//*
				int[] intArray=new  int[]{1,2,3,4,5,6,7,8};
				list=new ArrayList<>();
				for (int i: intArray){
						list.add(i);
				}*/

		}

}
