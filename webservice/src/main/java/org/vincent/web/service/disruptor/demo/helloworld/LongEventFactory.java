package org.vincent.web.service.disruptor.demo.helloworld;

import com.lmax.disruptor.EventFactory;

/**
 * @Package: org.vincent.web.service.disruptor.demo.helloworld <br/>
 * @Description： 事件工厂，用于产生我们需要的事件 <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/8/20 20:52 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/8/20. <br/>
 */

public class LongEventFactory  implements EventFactory<LongEvent>{

		@Override
		public LongEvent newInstance() {
				return new LongEvent();
		}
}
