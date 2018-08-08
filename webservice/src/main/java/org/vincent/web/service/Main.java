package org.vincent.web.service;

import java.io.File;
import java.util.regex.Matcher;

/**
 * Service 入口Main 类
 * Created by PengRong on 2018/7/18.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("begin start web-service...");
        String aa = "sdfsadfasd".replace("sdfsadfasd", "");
        aa = aa.replaceAll("/", Matcher.quoteReplacement(File.separator));
        System.out.println(aa);
        System.out.println(File.separator);
        System.out.println(Matcher.quoteReplacement(File.separator));

        /**
         * String.replace(CharSequence target, CharSequence replacement)方法，
         * 字符串替代: 将字符串中所有出现target 子串的地方都替换为 replacement.
         */
        String s1 = "my name is khan my name is jaisva";
        System.out.println(s1);
        String replaceString = s1.replace("is", "was");//replaces all occurrences of "is" to "was"
        System.out.println(replaceString);

        s1 = "javatpoint is a very good website";
        replaceString = s1.replace('a', 'e');//replaces all occurrences of 'a' to 'e'
        System.out.println(replaceString);

        System.out.println("begin stop web-service...");
    }
}
