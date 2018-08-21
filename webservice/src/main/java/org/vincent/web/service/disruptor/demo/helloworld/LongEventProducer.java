package org.vincent.web.service.disruptor.demo.helloworld;

import com.lmax.disruptor.RingBuffer;
import java.nio.ByteBuffer;

/**
 * @Package: org.vincent.web.service.disruptor.demo.helloworld <br/>
 * @Description： 事件生产者，不需要继承任何接口或者类，只是需要一个RingBuffer 成员属性 <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/8/20 21:07 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/8/20. <br/>
 */

public class LongEventProducer {
		private final RingBuffer<LongEvent> ringBuffer;

		public LongEventProducer(RingBuffer<LongEvent> ringBuffer)
		{
				this.ringBuffer = ringBuffer;
		}

		/**
		 *  onData用来发布事件，每调用一次就发布一次事件事件
		 * 它的参数会通过事件传递给消费者。这个事件发布接口必须有程序员根据情况
		 * 调用触发这个接口执行。
		 *
		 * 发布事件最少涉及两个步骤：
		 *      1、获取下一个事件槽
		 *      2、使用 ringBuffer.publish(sequence) 发布事件。如果我们使用RingBuffer.next()获取一个事件槽，那么一定要发布对应的事件，同时发布方法
		 *          使用try/finally代码块是必要的如下。
		 *      0、Disruptor 3.0 版本后推荐使用 Lambda-style 风格的API, 使用 Event Publisher或者Event Translator来发布事件。
		 * @param bb
		 */
		public void onData(ByteBuffer bb)
		{
				/** 可以把ringBuffer看做一个事件队列，那么next就是得到下面一个事件槽*/
				// Grab the next sequence
				long sequence = ringBuffer.next();
				try
				{
						/** Get the entry in the Disruptor , RingBuffer调用事件工厂实例化一个事件出来。 */
						LongEvent event = ringBuffer.get(sequence);
						// 给事件填充数据
						event.setData(bb.getLong(0));
				}
				finally
				{
						//发布事件
						ringBuffer.publish(sequence);
				}
		}

}
