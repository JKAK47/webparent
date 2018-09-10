package org.vincent.web.service.disruptor.demo.helloworld;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Package: org.vincent.web.service.disruptor.demo <br/>
 * @Description： Disruptor 一般的测试类，一般的原因是这里使用的 producer 手动去发送事件。 <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/8/20 20:46 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/8/20. <br/>
 */

public class helloworld {
    public static void main(String[] args) throws InterruptedException {
        // 用于构建消费者线程进行事件处理。
        Executor executor = Executors.newCachedThreadPool();
        // 用于构建 event factory。
        LongEventFactory factory = new LongEventFactory();

        //指定ringBuffer 的缓冲区大小，必须是2^x方
        int bufferSize = 1024;
        /**
         * r -> {
         Thread t=new Thread();
         t.setName("thread "+r.toString());
         return t;
         }
         构建Disruptor
         executor
         */

        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory, bufferSize, r -> {
            Thread t = new Thread(r);
            t.setName("thread " + r.toString());
            return t;
        });
        // 设置该事件的 事件处理器
        disruptor.handleEventsWith(new LongEventHandler());
        //添加所有事件处理并返回全配置好的 RingBuffer. 只务必调用一次start方法
        disruptor.start();
        // 获取到RingBuffer 用于事件源发布事件
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        LongEventProducer producer = new LongEventProducer(ringBuffer);
        ByteBuffer byteBuffer = ByteBuffer.allocate(88);
        for (long l = 0; l<30; l++) {
            byteBuffer.putLong(0, 32);
            producer.onData(byteBuffer);
            Thread.sleep(100);
        }

        //关闭disruptor
        disruptor.shutdown();

    }
}
