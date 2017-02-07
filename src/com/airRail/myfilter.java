package com.airRail;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/myfilter")

public class myfilter implements Filter {

    public void destroy() {
	
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("airRail ---- myfilter....!!");
		HttpServletRequest  req = (HttpServletRequest) request;
		HttpServletResponse  res = (HttpServletResponse) response;
		
		String un = (String) req.getSession().getAttribute("un");
		System.out.println(un);
		if(un != null && !un.isEmpty()){
			
		}
		
		else {
			res.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
