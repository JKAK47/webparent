package org.vincent.web.service.disruptor.demo.helloworld;

/**
 * @Package: org.vincent.web.service.disruptor.demo.helloworld <br/>
 * @Description： 定义一个LongEvent , 将产生的事件。<br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/8/20 20:50 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/8/20. <br/>
 */

public class LongEvent {
		private  long data;

		public long getData() {
				return data;
		}

		public void setData(long data) {
				this.data = data;
		}

		@Override
		public String toString() {
				return "LongEvent{" +
								"data=" + data +
								'}';
		}
}
