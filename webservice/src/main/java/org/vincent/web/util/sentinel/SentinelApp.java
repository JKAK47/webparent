package org.vincent.web.util.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/alibaba/Sentinel/wiki/%E4%BB%8B%E7%BB%8D?spm=5176.214990.1146036.2.13bc187fmHea4V
 * Created by PengRong on 2018/8/7.
 */
public class SentinelApp
{
    public  static void  main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println("begin");
        /**
         * ClassLoader 的功能是用于 读取编译好的class文件并转换为Class类的实例，
         * 每个Class类实例代表对应的java 类，然后通过Class类的newInstance()方法创建该
         * java类的一个对象。
         */
        SentinelApp app= SentinelApp.class.newInstance();
        System.out.println(app.toString()+"------------------");
        ClassLoader loader = SentinelApp.class.getClassLoader();
        /**
         * sun.misc.Launcher$AppClassLoader@18b4aac2 系统类加载器
         * sun.misc.Launcher$ExtClassLoader@63e31ee 扩展加载器
         *
         * 第一个输出的是 ClassLoaderTree类的类加载器，即系统类加载器。它是 sun.misc.Launcher$AppClassLoader类的实例；
         * 第二个输出的是扩展类加载器，是 sun.misc.Launcher$ExtClassLoader类的实例。
         * 需要注意的是这里并没有输出引导类加载器，这是由于有些 JDK 的实现对于父类加载器是引导类加载器的情况，getParent()方法返回 null。
         */
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
        /**获取到系统 类加载器*/
        loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);
        initFlowRules();
        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry("HelloWorld");
                System.out.println("hello world");
            } catch (BlockException e1) {
                System.out.println("block!");
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
        }
    }

    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
