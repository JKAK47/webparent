package org.vincent.web.facade.ftp;

/**
 * Created by PengRong on 2018/8/9.
 */
public interface Filter<T> {
    public  boolean doFilter(T target, String pattern);
}
