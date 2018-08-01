package org.vincent.web.facade;

import java.net.URL;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;

/**
 * log4j + slf4j 统一 日志接口
 * web facade组件系统日志组件
 *
 * @Package: org.vincent.web.facade <br/>
 * @Description： TODO <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/8/1 7:55 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/8/1. <br/>
 */

public class LoggerFactory {

		private static Logger logger = null;

		private LoggerFactory() {
		}

		public static Logger getLogger() {
				if (logger == null) {
						synchronized (LoggerFactory.class) {
								if (logger == null) {
										// 读取webfacade 模块下main/java 目录下resources 的log4j.properties文件; 注意使用的文件路径：/log4j.properties
										URL url = LoggerFactory.class.getResource("/log4j.properties");
										PropertyConfigurator.configure(url.getPath());
										logger = org.slf4j.LoggerFactory
														.getLogger(LoggerFactory.class);
								}
						}
				}
				return LoggerFactory.logger;
		}

}

