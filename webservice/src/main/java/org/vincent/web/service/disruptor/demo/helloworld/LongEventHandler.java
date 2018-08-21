package org.vincent.web.service.disruptor.demo.helloworld;


import com.lmax.disruptor.EventHandler;

/**
 * @Package: org.vincent.web.service.disruptor.demo.helloworld <br/>
 * @Description： 事件处理器，也叫事件消费者,需要实现EventHandler接口 <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/8/20 20:55 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/8/20. <br/>
 */

public class LongEventHandler implements EventHandler<LongEvent> {
		@Override
		public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
				System.out.println("Event : " + event);
		}
}
