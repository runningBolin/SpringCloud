package com.bolin.zuul.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class TokenFilter extends ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(TokenFilter.class);

	/**
	 * 这里可以写逻辑判断，是否要过滤
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString() + "?" + request.getQueryString()));
		
		String token = request.getParameter("token");
		if(token == null) {
			log.warn("token is empty");
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			try {
				context.getResponse().getWriter().write("token is empty");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		log.info("OK");
		return null;
	}

	/**
	 * 在zuul中定义了四种不同生命周期的过滤器类型:
	 * pre：路由之前
	 * routing：路由之时
	 * post： 路由之后
	 * error：发送错误调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤的顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
