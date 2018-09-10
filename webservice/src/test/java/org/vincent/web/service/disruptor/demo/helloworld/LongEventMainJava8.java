package org.vincent.web.service.disruptor.demo.helloworld;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Package: org.vincent.web.service.disruptor.demo.helloworld <br/>
 * @Description： 用lambda表达式来注册 EventHandler 和 EventTranslatorOneArg 接口实现 <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/8/20 22:51 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/8/20. <br/>
 */

@SuppressWarnings("deprecation")
public class LongEventMainJava8 {
    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
        int bufferSize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(LongEvent::new, bufferSize, executor);
        /**
         *基于lambda 表达式 注册事件处理函数,并可以定义多个事件处理函数逻辑
         */
        disruptor.handleEventsWith((EventHandler<LongEvent>) (event, sequence, endOfBatch) -> {
            System.out.println("Event: " + event);
            System.out.println("hello vincent");
        });
        disruptor.handleEventsWith((event,sequence,end) -> System.out.println("invoke >> "+Thread.currentThread().getName()+"\t event.data "+event.getData()));
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        //LongEventProducer producer=new LongEventProducer(ringBuffer);
        /**
         * 下面是事件源产生事件代码，并没有事先定义好的 LongEventProducer 生产者，而是使用
         */
        ByteBuffer buffer = ByteBuffer.allocate(8);
        /**
         * 这里直接把 需要传递的参数 buffer 给了 publishEvent 函数。 RingBuffer 回调赋值给了 arg0参数。
         * lambda表达式 实现 EventTranslatorOneArg 接口。
         */
        for (long l = 0; l < 20; l++) {
            buffer.putLong(0, 88);
            ringBuffer.publishEvent((event, sequence, arg0) -> event.setData(arg0.getLong(0)), buffer);
        }

        /**
         *  也可以这样写，但是这段代码中lambda表达式 内部中会获取外部的buffer值，
         *   意味着在lambda表达式生成的内部类中会生成一个对象来存储这个捕获的bb对象。这会增加不必要的GC。
         *   所以在需要较低GC水平的情况下最好把所有需要的参数都通过publishEvent传递。
         *   publishEvent 方法实现 EventTranslator 接口 ，只有Event， sequence，并没有传递的参数，这里使用lambda表达式
         *   直接将外部变量值赋值进去。
         */
        for (long l = 0; l<20; l++) {
            buffer.putLong(0, 66);
            ringBuffer.publishEvent((event, sequence) -> event.setData(buffer.getLong(0)));
        }

        System.out.println("stop ");

    }
}
