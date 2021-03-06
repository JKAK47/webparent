package org.vincent.web.service.disruptor.demo.helloworld;

/**
 * @Package: org.vincent.web.service.disruptor.demo <br/>
 * @Description： TODO <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/8/20 20:47 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/8/20. <br/>
 */

public class Info {
		/**
		 * 我们从一个简单的例子开始学习Disruptor：生产者传递一个long类型的值给消费者，而消费者消费这个数据的方式仅仅是把它打印出来：
		 * 第一：首先声明一个Event来包含需要传递的数据，不用继承任务接口和类；LongEvent.java
		 * 第二： 为让Disruptor为我们创建事件，我们同时还声明了一个EventFactory来实例化Event对象； 事件工厂可以不用实现代码，直接使用LongEvent::new  这个 lambda表达式代替 事件工厂。
		 * 第三： 我们还需要一个事件消费者，也就是一个事件处理器。这个事件处理器简单地把事件中存储的数据打印到终端： 如果代码逻辑简单也可以不用实现，只用用简单的lambda表达式代替，省的创建类。
		 * 第四： 还需要一个生成事件的源，事件生产者。 事件生产者主要功能是发布事件，我们通过 disruptor.getRingBuffer()方法获取RingBuffer，然后通过ringBuffer.publishEvent()方法发布事件。
		 * disruptor将创建线程调用事件处理函数处理这个事件。
		 */
}
