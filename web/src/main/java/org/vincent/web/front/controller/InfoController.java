package org.vincent.web.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @Package: org.vincent.web.front.controller <br/>
 * @Description： TODO <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/8/7 8:02 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/8/7. <br/>
 */

public class InfoController implements Controller {
		private  static  final Log logger= LogFactory.getLog(InfoController.class);
		/**
		 * Process the request and return a ModelAndView object which the DispatcherServlet
		 * will render. A {@code null} return value is not an error: it indicates that
		 * this object completed request processing itself and that there is therefore no
		 * ModelAndView to render.
		 *
		 * @param request  current HTTP request
		 * @param response current HTTP response
		 * @return a ModelAndView to render, or {@code null} if handled directly
		 * @throws Exception in case of errors
		 */
		@Override
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
				logger.info(" infoController handleRequest method invoke.");
				ModelAndView view=new ModelAndView();
				/** 设置模型数据，可以是任意的POJO对象 */
				view.addObject("msg","info msg: "+ request.getMethod().toString()+"\t"+request.getRemoteHost());
				/* 视图处理器已经配置了前缀和后缀，就只需要配置访问的 */
				view.setViewName("info");
				return view;
		}
}
