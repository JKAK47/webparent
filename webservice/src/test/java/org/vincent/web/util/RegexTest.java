package org.vincent.web.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式 测试
 * Created by PengRong on 2018/8/16.
 * [Matcher的replaceAll ()/appendReplacement()/appendTail()详细举例](https://www.cnblogs.com/lchzls/p/6277961.html)
 * [Java正则速成秘籍（一）之招式篇](http://www.cnblogs.com/jingmoxukong/p/6026474.html)
 */
public class RegexTest {
    public static void main(String[] args) {
        /**
         *  正则表达式 ： 文本校验功能
         *  lookingAt方法从输入序列头部开始，检查content字符串是否有子字符串于正则规则匹配。
         *  find方法检查content字符串是否有子字符串于正则规则匹配，不管字符串所在位置。
         *  matches方法检查content字符串整体是否与正则规则匹配。
         */
        System.out.println("----------------Regex 校验功能 begin-----------");
        checkLookingAt("hello", "helloworld");
        checkLookingAt("world", "helloworld");
        checkLookingAt("hell", "helloworld");

        checkFind("hello", "helloworld");
        checkFind("world", "helloworld");


        checkMatches("hello", "helloworld");
        checkMatches("world", "helloworld");
        checkMatches("helloworld", "helloworld");
        System.out.println("----------------Regex 校验功能 begin-----------");

        /**
         * 查找匹配模式串正则规则的文本,并返回匹配位置下标位置。
         * start(), end(),group() 方法
         */

        String regex = "world";
        String content = "helloworld helloworld";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        System.out.println("content: " + content);

        int i = 0;
        while (m.find()) {
            i++;
            System.out.println("[" + i + "th] found");
            /** matcher.start() 返回 当次find 匹配模式串的子序列第一个字符起始下标 */
            System.out.print("start: " + m.start() + ", ");
            /** matcher.end() 返回匹配模式串 子序列最后一个字符偏移后 一个位置。 */
            System.out.print("end: " + m.end() + ", ");
            /** 匹配器 m, 输入字符串 s, m.group() 等价于 s.substring(m.start(),m.end()) 方法执行结果 */
            System.out.print("group: " + m.group() + "\n");
        }
        /**
         * 替换 匹配正则规则的文本
         *
         */
        regex = "can";
        String replace = "can not";
        content = "I can because I think I can.";

        p = Pattern.compile(regex);
        m = p.matcher(content);

        System.out.println("content: " + content);
        /**
         * replaceFirst(String replace) 用replace 字符串替换
         * 模式串匹配输入序列字符串中第一次匹配的子序列。
         * 模式串： can
         * 输入序列： I can because I think I can.
         * 替换字符串 replace: can not
         * 替换后结果：replaceFirst: I can not because I think I can.
         */
        System.out.println("replaceFirst: " + m.replaceFirst(replace));
        /**
         * replaceAll(String replace) 用replace 字符串替换
         * 模式串匹配输入序列字符串中所有匹配的子序列。
         * 模式串： can
         * 输入序列： I can because I think I can.
         * 替换字符串 replace: can not
         * 替换后所有结果：replaceAll: I can not because I think I can not.
         */
        System.out.println("replaceAll: " + m.replaceAll(replace));

        /**
         * 替换文本的一些特殊方法
         * appendReplacement方法
         * appendTail 方法
         */
        regex = "can";
        replace = "can not";
        content = "I can because I think I can.";
        StringBuffer sb = new StringBuffer();
        System.out.println("content: " + content);
        p = Pattern.compile(regex);
        m = p.matcher(content);
        while (m.find()) {
            m.appendReplacement(sb, replace);
        }
        System.out.println("appendReplacement: " + sb);
        m.appendTail(sb);
        System.out.println("appendTail: " + sb);

        /**
         * 匹配模式串：cat
         * 输入字符串： one cat two cats in the yard
         * 字符缓冲区 sb，开始为空串
         * 第一次匹配cat 后调用  appendReplacement方法，StringBuffer sb的内容为 one dog，与输入字符串第一个cat匹配，并将之前的 one字符串添加到sb中。
         * 第二次匹配 cat 后调用 appendReplacement方法 StringBuffer sb的内容为 one dog two dog ,第二次匹配将匹配子串替换为指定字符串，并将上次匹配后到这次匹配
         * 间的字符串都添加到sb 对象里，所以two,添加sb里面
         * 第三次匹配不成功，退出while循环。
         * appendTail() 方法将最后一次匹配工作后到输入字符串结尾 剩余的字符串添加到一个StringBuffer对象里。 把 " in the yard" 添加到sb里面。
         * 最后输出：one dog two dogs in the yard
         */
        p = Pattern.compile("cat");
        m = p.matcher("one cat two cats in the yard");
        sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "dog");
        }
        m.appendTail(sb);
        System.out.println(sb.toString());

        /**
         * Matcher.quoteReplacement 方法将 \,$ 这些特殊字符返回转义后的字面字符串
         */

        regex = "\\$\\{.*?\\}";
        replace = "${product}";
        content = "product is ${productName}.";

        p = Pattern.compile(regex);
        m = p.matcher(content);
        String replaceAll = m.replaceAll(Matcher.quoteReplacement(replace));

        System.out.println("content: " + content);
        System.out.println("replaceAll: " + replaceAll);
    }

    /**
     * lookingAt方法 尝试匹配 content开始序列是否和 regex标识的模式字符串匹配。
     *
     * @param regex   需要匹配字符串 模式字符串
     * @param content 输入字符串，原始字符串
     */
    private static void checkLookingAt(String regex, String content) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        if (m.lookingAt()) {
            System.out.println(content + "\tlookingAt： " + regex);
        } else {
            System.out.println(content + "\tnot lookingAt： " + regex);
        }
    }

    /**
     * find 方法  匹配content 输入字符串序列中任何子字符串序列是否和模式字符串匹配。
     * 相比 lookingAt 方法 ,可以匹配任何位置开始的子字符串序列
     * 如果匹配，返回true，
     * 如果不匹配，返回false
     *
     * @param regex
     * @param content
     */
    private static void checkFind(String regex, String content) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        //标识从输入序列指定下标开始匹配regex模式字符串。
        /*System.out.println(m.find(6));*/
        if (m.find()) {
            System.out.println(content + "\tfind： " + regex);
        } else {
            System.out.println(content + "\tnot find： " + regex);
        }
    }

    /**
     * matches 方法 将模式串和整个输入序列content进行匹配，如果匹配返回true，不匹配返回false。
     *
     * @param regex
     * @param content
     */
    private static void checkMatches(String regex, String content) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        if (m.matches()) {
            System.out.println(content + "\tmatches： " + regex);
        } else {
            System.out.println(content + "\tnot matches： " + regex);
        }
    }

}
