package org.vincent.web.service.disruptor.demo.helloworld;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import java.nio.ByteBuffer;

/**
 * @Package: org.vincent.web.service.disruptor.demo.helloworld <br/>
 * @Description： Disruptor 3.0 之后 dirruptor封装了一些接口出来，只要实现对应的接口，
 * 定义了Event 需要处理的时间逻辑，然后传递给RingBuffer即可。具体的发布事情有RingBuffer处理了 <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/8/20 21:27 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/8/20. <br/>
 */

public class LongEventProducerWithTranslator {
		private final RingBuffer<LongEvent> ringBuffer;

		public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
				this.ringBuffer = ringBuffer;
		}
		/**
		 * 一个translator可以看做一个事件初始化器，RingBuffer.publishEvent 方法会调用translatorOneArg填充Event数据。
		 */
		EventTranslatorOneArg<LongEvent,ByteBuffer> translatorOneArg= (event, sequence, arg0) -> event.setData(arg0.getLong(0));
		public  void  onDate(ByteBuffer buffer){
			ringBuffer.publishEvent(translatorOneArg,buffer);
		}

}
