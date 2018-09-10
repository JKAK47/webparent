package org.vincent.web.service.disruptor.demo.helloworld;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Package: org.vincent.web.service.disruptor.demo.helloworld <br/>
 * @Description： 因为方法也是lambda表达式的一种，方法名可以直接赋值给注册事件响应方法,但是方法签名必须和lambda实现的接口签名一致。 <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/8/21 0:40 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/8/21. <br/>
 */

public class LongEventMain {
		public static void handleEvent(LongEvent event, long sequence,boolean endOfBatch)
		{
				System.out.println(event);
		}

		public static void translate(LongEvent event, long sequence, ByteBuffer buffer)
		{
				event.setData(buffer.getLong(0));
		}

		public static void main(String[] args) throws Exception
		{
				// Executor that will be used to construct new threads for consumers
				Executor executor = Executors.newCachedThreadPool();

				// Specify the size of the ring buffer, must be power of 2.
				int bufferSize = 1024;

				// Construct the Disruptor
				Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new, bufferSize, executor);

				// Connect the handler， 通过lambda 表达式将定义的事件响应方法注册进去
				disruptor.handleEventsWith(LongEventMain::handleEvent);

				// Start the Disruptor, starts all threads running
				disruptor.start();

				// Get the ring buffer from the Disruptor to be used for publishing.
				RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

				ByteBuffer bb = ByteBuffer.allocate(8);
				for (long l = 0; true; l++)
				{
						bb.putLong(0, l);
						//定义将发布使用的translate, 实现的接口是：EventTranslatorOneArg
						ringBuffer.publishEvent(LongEventMain::translate, bb);
						Thread.sleep(1000);
				}
		}
}
