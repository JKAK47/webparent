package org.vincent.web.facade.ftp;

/**
 * Created by PengRong on 2018/8/9.
 */
public interface Filter<T> {
    /**
     * <p>该接口用于过滤不适配的资源类型 </p>
     * @param target 待匹配过滤的资源
     * @param pattern 多虑模式
     * @return 返回true 说明需要过滤掉，false 说明不需要过滤掉
     * @authro PengRong
     */
    boolean doFilter(T target, String pattern);
}
